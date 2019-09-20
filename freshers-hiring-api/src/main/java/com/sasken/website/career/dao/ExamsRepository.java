package com.sasken.website.career.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sasken.website.career.entity.ExamEntity;

@Repository
public interface ExamsRepository extends BaseRepository<ExamEntity, Integer>{

	@Override
	@Cacheable("exams")
	public List<ExamEntity> findAll();

}
