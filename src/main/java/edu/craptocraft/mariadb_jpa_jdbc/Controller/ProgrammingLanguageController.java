package edu.craptocraft.mariadb_jpa_jdbc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;

import edu.craptocraft.mariadb_jpa_jdbc.service.Implementation.PLIMPL;

@RestController
@RequestMapping("/programmingLanguages")
public class ProgrammingLanguageController {

    @Autowired
    private PLIMPL impl;

    @PostMapping
    @RequestMapping(value = "createLanguage", method = RequestMethod.POST)
    public ResponseEntity<?> createLanguage(@RequestBody ProgrammingLanguage language) {
        ProgrammingLanguage createdLanguage = this.impl.createData(language);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLanguage);
    }

    @GetMapping
    @RequestMapping(value = "readLanguages", method = RequestMethod.GET)
    public ResponseEntity<?> readLanguage() {
        List<ProgrammingLanguage> listLanguage = this.impl.readData();
        return ResponseEntity.ok(listLanguage);
    }

    @GetMapping
    @RequestMapping(value = "readLanguage/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> readLanguage(@PathVariable int id) {
        ProgrammingLanguage singleLanguage = this.impl.readData(id);
        return ResponseEntity.ok(singleLanguage);
    }

    @PutMapping
    @RequestMapping(value = "updateLanguage", method = RequestMethod.PUT)
    public ResponseEntity<?> updateLanguage(@RequestBody ProgrammingLanguage language) {
        ProgrammingLanguage updatedLanguage = this.impl.updateData(language);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedLanguage);
    }

    @DeleteMapping
    @RequestMapping(value = "deleteLanguage/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletedLanguage(@PathVariable int id) {
        this.impl.deleteData(id);
        return ResponseEntity.ok().build();
    }

}
