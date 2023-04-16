package edu.craptocraft.mariadb_jpa_jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.craptocraft.mariadb_jpa_jdbc.entity.ProgrammingLanguage;
import edu.craptocraft.mariadb_jpa_jdbc.service.springboot.implementation.ProgLangIMPL;

@RestController
@RequestMapping("/programming-languages")
public class ProgrammingLanguageController {

    @Autowired
    private ProgLangIMPL impl;

    @PostMapping
    @RequestMapping(value = "create/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> createLanguage(@PathVariable int id, @RequestBody ProgrammingLanguage language) {
        ProgrammingLanguage existingLanguage = this.impl.readData(id);
        if (existingLanguage != null) {
            return ResponseEntity.badRequest().body("Invalid ID: a ProgrammingLanguage object with ID " + id + " already exists.");
        }
        ProgrammingLanguage createdLanguage = this.impl.createData(language);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLanguage);
    }

    @GetMapping
    @RequestMapping(value = "get/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllLanguages() {
        List<ProgrammingLanguage> listLanguage = this.impl.readData();
        return ResponseEntity.ok(listLanguage);
    }

    @GetMapping
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> readOneLanguage(@PathVariable int id) {
        ProgrammingLanguage singleLanguage = this.impl.readData(id);
        return ResponseEntity.ok(singleLanguage);
    }

    @PutMapping
    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateLanguage(@PathVariable int id, @RequestBody ProgrammingLanguage language) {
        ProgrammingLanguage updatedLanguage = this.impl.updateData(id, language);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedLanguage);
    }

    @DeleteMapping
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteLanguage(@PathVariable int id) {
        this.impl.deleteData(id);
        return ResponseEntity.ok().build();
    }

}
