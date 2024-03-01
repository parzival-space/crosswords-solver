package de.mmbbs.cwmeteor.db.repositories;

import de.mmbbs.cwmeteor.db.entities.Solution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SolutionRepository extends CrudRepository<Solution, UUID> {
    // TODO: make this less exclusive
    @Query("SELECT s FROM #{#entityName} s WHERE s.question LIKE %:question%")
    List<Solution> findByQuestion(@Param("question") String question);


    @Query("SELECT s FROM #{#entityName} s WHERE s.question LIKE %:question% AND LENGTH(s.answer) = :charCount")
    List<Solution> findByQuestionAndCharacterCount(@Param("question") String question, @Param("charCount") int charCount);
}
