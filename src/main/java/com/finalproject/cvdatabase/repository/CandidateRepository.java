package com.finalproject.cvdatabase.repository;

import com.finalproject.cvdatabase.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    List<Candidate> findByName(String name);

    void deleteById(int id);


//    @Modifying
//    @Query("UPDATE Candidate c SET c.name = :name, c.education = :education, c.experience = :experience, c.address = :address WHERE c.id = :id")
//    void updateCandidate(@Param("id") int id, @Param("name") String name, @Param("education") String education, @Param("experience") String experience, @Param("address") String address);
}
