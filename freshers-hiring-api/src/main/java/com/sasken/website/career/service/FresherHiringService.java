package com.sasken.website.career.service;

import java.util.List;

import com.sasken.website.career.entity.Fresher;
import com.sasken.website.career.model.AppConfigurations;
import com.sasken.website.career.model.FresherDetails;
import com.sasken.website.career.model.ResponseDataBo;

public interface FresherHiringService {

	ResponseDataBo processFresherDetails(FresherDetails fresherDetails);

	Fresher addFresher(Fresher fresher);

	List<Fresher> findAllFreshers();

	AppConfigurations getConfigurations();

}
