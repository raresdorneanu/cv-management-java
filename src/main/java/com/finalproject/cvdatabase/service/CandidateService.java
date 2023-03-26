package com.finalproject.cvdatabase.service;

import com.finalproject.cvdatabase.model.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate getCandidateById(int id);
    public Candidate saveCandidate(Candidate candidate);
    public List<Candidate> getAllCandidates();

    void deleteCandidate(int id);

    List<Candidate> getCandidatesByName(String name);
}
