package com.sasken.website.career.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sasken.website.career.entity.Fresher;
import com.sasken.website.career.model.AppConfigurations;
import com.sasken.website.career.model.FresherDetails;
import com.sasken.website.career.model.ResponseDataBo;
import com.sasken.website.career.service.FresherHiringService;

@RestController
@RequestMapping("/career")
public class FresherHiringController {

	private static Logger log = LoggerFactory.getLogger(FresherHiringController.class);

	@Autowired
	FresherHiringService fresherService;

	@PostMapping(value = "/fresher")
	public ResponseDataBo processFresherDetails(@RequestPart("file") MultipartFile file,
			@Valid @RequestPart("fresherDetails") FresherDetails fresher) {

		log.info("add fresher details api called..");
		fresher.setUploadedResume(file);
		return fresherService.processFresherDetails(fresher);
	}

	@GetMapping("/freshers")
	public List<Fresher> findAllFreshers() {
		return fresherService.findAllFreshers();
	}

	@GetMapping("/configurations")
	public AppConfigurations getConfiguration() {
		return fresherService.getConfigurations();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
