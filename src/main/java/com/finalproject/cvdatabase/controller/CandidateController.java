package com.finalproject.cvdatabase.controller;

import com.finalproject.cvdatabase.model.Candidate;
import com.finalproject.cvdatabase.service.CandidateService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/candidate")
@CrossOrigin
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping("/add")
    public String add(@RequestBody Candidate candidate){
        candidateService.saveCandidate(candidate);
        return "New candidate is added";
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@RequestParam MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String path = "C:\\Users\\Sonia\\Desktop\\cvmanagement-react\\public\\images\\" + filename;
        File localFile = new File(path);
        file.transferTo(localFile);
        System.out.println("File uploaded " + filename + " to " + path);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAll")
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }
    @Transactional
    @DeleteMapping("/{id}")
    public void deleteCandidates(@PathVariable int id){
        candidateService.deleteCandidate(id);
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable int id) {
        return candidateService.getCandidateById(id);
    }

    @PutMapping("/{id}")
    public String updateCandidate(@PathVariable int id, @RequestBody Candidate updatedCandidate) {
        Candidate candidate = candidateService.getCandidateById(id);
        if (candidate == null) {
            return "Candidate not found";
        }

        // Update the candidate's details
        if (updatedCandidate.getFirstName() != null) {
            candidate.setFirstName(updatedCandidate.getFirstName());
        }
        if (updatedCandidate.getLastName() != null) {
            candidate.setLastName(updatedCandidate.getLastName());
        }
        if (updatedCandidate.getRole() != null) {
            candidate.setRole(updatedCandidate.getRole());
        }
        if (updatedCandidate.getCandDescription() != null) {
            candidate.setCandDescription(updatedCandidate.getCandDescription());
        }
        if (updatedCandidate.getExperience() != null) {
            candidate.setExperience(updatedCandidate.getExperience());
        }
        if (updatedCandidate.getPhone() != null) {
            candidate.setPhone(updatedCandidate.getPhone());
        }
        if (updatedCandidate.getEmail() != null) {
            candidate.setEmail(updatedCandidate.getEmail());
        }
        if (updatedCandidate.getAddress() != null) {
            candidate.setAddress(updatedCandidate.getAddress());
        }
        if (updatedCandidate.getEducation() != null) {
            candidate.setEducation(updatedCandidate.getEducation());
        }
        if (updatedCandidate.getSkills() != null) {
            candidate.setSkills(updatedCandidate.getSkills());
        }
        if (updatedCandidate.getPortfolio() != null) {
            candidate.setPortfolio(updatedCandidate.getPortfolio());
        }
        if (updatedCandidate.getLanguages() != null) {
            candidate.setLanguages(updatedCandidate.getLanguages());
        }
        if (updatedCandidate.getGender() != null) {
            candidate.setGender(updatedCandidate.getGender());
        }
        if (updatedCandidate.getTemplate() != null) {
            candidate.setTemplate(updatedCandidate.getTemplate());
        }
        if (updatedCandidate.getImage() != null) {
            candidate.setImage(updatedCandidate.getImage());
        }

        candidateService.saveCandidate(candidate);
        return "Candidate updated successfully";
    }


}
