package com.demo.assessment.controller;

import com.demo.assessment.entity.Institute;
import com.demo.assessment.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class InstitutionController {

    @Autowired
    private InstituteService instituteService;

    @PostMapping("/register")
    public ResponseEntity<String> registerInstitute(@RequestBody Institute institute){
        instituteService.registerInstitute(institute);
        return ResponseEntity.status(HttpStatus.CREATED).body("Institute registered successfully");
    }

    @GetMapping("/register")
    public ResponseEntity<?> getAllInstitute(){
        List<Institute>institutes = instituteService.getAllInstitute();
        if (institutes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No institutes found");
        }
        return ResponseEntity.ok(institutes);
    }

    @GetMapping("/register/{id}")
    public ResponseEntity<?> getInstitute(@PathVariable("id") Long instituteId){
        Optional<Institute> institute = instituteService.getInstitute(instituteId);
        if(institute.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No institutes found");
        }
        return ResponseEntity.ok(institute);
    }

    @PutMapping("/register/{id}")
    public Institute updateInstitute(@PathVariable("id") Long instituteId, @RequestBody Institute institute){
        return instituteService.updateInstitute(instituteId, institute);
    }
}
