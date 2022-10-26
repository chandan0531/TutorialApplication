package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.TutorialException;
import com.masai.model.Tutorial;
import com.masai.reposetory.TutorialDao;

@Service
public class TutorialServiceImpl implements TutorialService{

	@Autowired
	private TutorialDao tDao;

	@Override
	public List<Tutorial> getAllTutorialDetails() throws TutorialException {
		
		List<Tutorial> tutorials = tDao.findAll();
			
			if(tutorials.size() > 0)
			{
				return tutorials;
			}
			else
			{
				throw new TutorialException("No Tutorialare find");
			}
	}

	@Override
	public Tutorial saveTutorialDetails(Tutorial totorial) throws TutorialException {
		
		int id = totorial.gettId();
		
		Optional<Tutorial> opt = tDao.findById(id);
		
		if(!opt.isPresent())
		{
			Tutorial savedTutorial= tDao.save(totorial);
			return savedTutorial;
		}
		
		else
		{
			throw new TutorialException("Totorial details already avaiable");
		}
		
	}

	@Override
	public Tutorial getTutorialDetailsById(Integer id) throws TutorialException {
		
		
		Optional<Tutorial> opt = tDao.findById(id);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new TutorialException("Tutorial does not exist with Id " + id);
		}

	}

	@Override
	public Tutorial deleteTutorialDetailsById(Integer id) throws TutorialException {

		Tutorial existingTutorial= tDao.findById(id).orElseThrow(() -> new TutorialException("Tutorial does not exist with Id "+id));
			
		tDao.delete(existingTutorial);
	
		return existingTutorial;
		
		
	}

	@Override
	public Tutorial updateTutorialDetailsById(Integer id, String status) throws TutorialException {

		Optional<Tutorial> opt= tDao.findById(id);
		
		
		if(opt.isPresent())
		{

			Tutorial existingTutorial= opt.get();
			

			existingTutorial.setPublishedStatus(status);
			return tDao.save(existingTutorial);
		}
		else
		{
			
			throw new TutorialException("Tutorial does not exist with Id :"+id);
		}

	}

	@Override
	public String  deleteAllTutorialDetails() throws TutorialException {
		
		
		List<Tutorial> tutorials = tDao.findAll();
		
		if(tutorials.size() > 0)
		{
			tDao.deleteAll(tutorials);
			return "Delete all the details";
		}
		else
		{
			throw new TutorialException("No Tutorialare find");
		}
		
	}

//	@Override
//	public String getTutorialTitalByStatus(String publishedStatus) throws TutorialException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	
	
	
	
}
