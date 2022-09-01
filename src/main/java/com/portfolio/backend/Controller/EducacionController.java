package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoEducacion;
import com.portfolio.backend.Entity.Educacion;
import com.portfolio.backend.Entity.Experiencia;
import com.portfolio.backend.Security.Controller.Mensaje;
import com.portfolio.backend.Service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://frontend-ap-3ff43.web.app")
public class EducacionController{

    @Autowired
    EducacionService educacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        educacionService.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getSchool())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (educacionService.existsBySchool(dtoedu.getSchool())) {
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoedu.getSchool(), dtoedu.getTitle(),
                dtoedu.getUrl_img(), dtoedu.getScore(), dtoedu.getStart(), dtoedu.getEnd());
        educacionService.saveEducacion(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu) {
        //Validamos si existe el ID
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if (educacionService.existsBySchool(dtoedu.getSchool()) && educacionService.getBySchool(dtoedu.getSchool()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoedu.getSchool())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();
        educacion.setSchool(dtoedu.getSchool());
        educacion.setTitle(dtoedu.getTitle());
        educacion.setUrl_img(dtoedu.getUrl_img());
        educacion.setScore(dtoedu.getScore());
        educacion.setStart(dtoedu.getStart());
        educacion.setEnd(dtoedu.getEnd());
        educacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);

    }

}
