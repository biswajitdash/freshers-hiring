package com.sasken.website.career.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sasken.website.career.entity.CompetitiveExamEntity;

@Repository
public interface CompetitivesRepository extends BaseRepository<CompetitiveExamEntity, Integer>{

	@Override
	@Cacheable("competitives")
	public List<CompetitiveExamEntity> findAll();

}
