package com.sasken.website.career.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sasken.website.career.entity.QualificationWeightage;

@Repository
public interface WeightageRepository extends BaseRepository<QualificationWeightage, Integer>{

	@Override
	@Cacheable("qualificationWeightages")
	public List<QualificationWeightage> findAll();
}
