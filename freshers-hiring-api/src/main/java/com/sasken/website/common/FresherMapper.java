package com.sasken.website.common;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sasken.website.career.entity.Fresher;
import com.sasken.website.career.model.FresherDetails;

import freemarker.core.ParseException;

@Component
public class FresherMapper {

	public FresherDetails convertToDto(Fresher fresher) throws ParseException {

		ModelMapper modelMapper = new ModelMapper();

		FresherDetails fresherDetails = modelMapper.map(fresher, FresherDetails.class);

		return fresherDetails;
	}

	public Fresher convertToEntity(FresherDetails fresherDetails) throws ParseException {

		ModelMapper modelMapper = new ModelMapper();

		Fresher fresher = modelMapper.map(fresherDetails, Fresher.class);

		return fresher;
	}
	

}
