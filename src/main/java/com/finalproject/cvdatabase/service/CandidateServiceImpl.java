package com.finalproject.cvdatabase.service;

import com.finalproject.cvdatabase.model.Candidate;
import com.finalproject.cvdatabase.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
    @Override
    public Candidate getCandidateById(int id) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(id);
        if (optionalCandidate.isPresent()) {
            return optionalCandidate.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public void deleteCandidate(int id) {
        candidateRepository.deleteById(id);
    }



    @Override
    public List<Candidate> getCandidatesByName(String name) {
        return candidateRepository.findByName(name);
    }
}
