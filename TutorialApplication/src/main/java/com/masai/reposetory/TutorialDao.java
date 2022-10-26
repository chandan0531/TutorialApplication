package com.masai.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Tutorial;

@Repository
public interface TutorialDao extends JpaRepository<Tutorial, Integer> {

	
//	@Query("select t.title from tutorial t where t.publishedStatus=:publishedStatus")        
//	public String getTutorialTitalByStatus(@Param("publishedStatus") String publishedStatus);
}
