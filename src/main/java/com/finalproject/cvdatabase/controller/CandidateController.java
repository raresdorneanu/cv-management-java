package com.finalproject.cvdatabase.controller;

import com.finalproject.cvdatabase.model.Candidate;
import com.finalproject.cvdatabase.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAll")
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }
    @Transactional
    @DeleteMapping("/{id}")
    public void deleteCandidates(@PathVariable int id){
        candidateService.deleteCandidate(id);
    }

    @GetMapping("/{name}")
    public List<Candidate> getCandidatesByName(@PathVariable String name){
        return candidateService.getCandidatesByName(name);
    }

    @PutMapping("/{id}")
    public String updateCandidate(@PathVariable int id, @RequestBody Candidate updatedCandidate) {
        Candidate candidate = candidateService.getCandidateById(id);
        if (candidate == null) {
            return "Candidate not found";
        }

        // Update the candidate's details
        if (updatedCandidate.getName() != null) {
            candidate.setName(updatedCandidate.getName());
        }
        if (updatedCandidate.getEmail() != null) {
            candidate.setEmail(updatedCandidate.getEmail());
        }
        if (updatedCandidate.getEducation() != null) {
            candidate.setEducation(updatedCandidate.getEducation());
        }
        if (updatedCandidate.getExperience() != null) {
            candidate.setExperience(updatedCandidate.getExperience());
        }
        if (updatedCandidate.getAddress() != null) {
            candidate.setAddress(updatedCandidate.getAddress());
        }



        candidateService.saveCandidate(candidate);
        return "Candidate updated successfully";
    }


}
