package com.demo.assessment.service;

import com.demo.assessment.entity.Institute;
import com.demo.assessment.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Optional;

@Service
public class InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;
    public void registerInstitute(Institute institute) {
        if (institute.getName() == null || institute.getName().isEmpty()) {
            throw new IllegalArgumentException("Institute name cannot be empty");
        }
        institute.setName(HtmlUtils.htmlEscape(institute.getName()));
        institute.setLocation(HtmlUtils.htmlEscape(institute.getLocation()));
        institute.setContact(HtmlUtils.htmlEscape(institute.getContact()));
        instituteRepository.save(institute);
    }

    public Optional<Institute> getInstitute(Long instituteId) {
        return instituteRepository.findById(instituteId);
    }

    public List<Institute> getAllInstitute() {
        return instituteRepository.findAll();
    }

    public Institute updateInstitute(Long instituteId, Institute institute) {
        Optional<Institute> institutedb = instituteRepository.findById(instituteId);
        if(institutedb.isPresent() && institute.getName() != null && !"".equalsIgnoreCase(institute.getName())){
            institutedb.get().setName(HtmlUtils.htmlEscape(institute.getName()));
        }
        if(institutedb.isPresent() && institute.getLocation() != null && !"".equalsIgnoreCase(institute.getLocation())){
            institutedb.get().setLocation(HtmlUtils.htmlEscape(institute.getLocation()));
        }
        if(institutedb.isPresent() && institute.getContact() != null && !"".equalsIgnoreCase(institute.getContact())){
            institutedb.get().setContact(HtmlUtils.htmlEscape(institute.getContact()));
        }
        instituteRepository.save(institutedb.get());
        return institutedb.get();
    }
}
