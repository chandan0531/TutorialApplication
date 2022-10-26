package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Tutorial;
import com.masai.service.TutorialService;

@RestController
public class TutorialController {

	
	@Autowired
	private TutorialService tService;
	
	
	
	@PostMapping("/tutorial")
	public ResponseEntity<Tutorial> addTutorialHandller(@RequestBody Tutorial tutorial){
		
		Tutorial newTutorial =  tService.saveTutorialDetails(tutorial);
		
		return new ResponseEntity<Tutorial>(newTutorial, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/tutorial")
	public ResponseEntity<List<Tutorial>> getAllTutorialHandller(){
		
		List<Tutorial> tutorials = tService.getAllTutorialDetails();
		
		return new ResponseEntity<List<Tutorial>>(tutorials,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/tutorial/{id}")
	public ResponseEntity<Tutorial> getTutorialByIdHandller(@PathVariable("id") Integer id ){
		
		Tutorial tuto = tService.getTutorialDetailsById(id);
		
		return new ResponseEntity<Tutorial>(tuto, HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/tutorial/{id}")
	public ResponseEntity<Tutorial> deleteTutorialByIdHandller(@PathVariable("id") Integer id ){
		
		Tutorial tuto = tService.deleteTutorialDetailsById(id);
		
		return new ResponseEntity<Tutorial>(tuto, HttpStatus.ACCEPTED);
	}
	
	
	
	
	@PutMapping("tutorial/{id}")
	public ResponseEntity<Tutorial> updateTutorialStatusHandler(@PathVariable("id") Integer id, 
			@RequestParam("status") String status){
		
		
		Tutorial updatedTutorial= tService.updateTutorialDetailsById(id, status);
		
		return new ResponseEntity<Tutorial>(updatedTutorial,HttpStatus.ACCEPTED);	
	}
	
	
	
	@DeleteMapping("/tutorial")
	public  String deleteAllTutorialdHandller(){
		
		String tuto = tService.deleteAllTutorialDetails();
		
		return tuto;
	}
	
	
	
	
}
