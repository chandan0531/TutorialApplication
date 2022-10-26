package com.masai.service;

import java.util.List;

import com.masai.exceptions.TutorialException;
import com.masai.model.Tutorial;

public interface TutorialService {

	

	public List<Tutorial> getAllTutorialDetails() throws TutorialException;
	
	public Tutorial saveTutorialDetails(Tutorial totorial) throws TutorialException;
	
	public Tutorial getTutorialDetailsById(Integer id) throws TutorialException;
	
	public Tutorial deleteTutorialDetailsById(Integer id) throws TutorialException;
	
	public Tutorial updateTutorialDetailsById(Integer id, String status) throws TutorialException;

	public String deleteAllTutorialDetails() throws TutorialException;
	
	//	public String getTutorialTitalByStatus(String publishedStatus)throws TutorialException;
}
