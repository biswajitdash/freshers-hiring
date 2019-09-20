package com.sasken.website.career.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sasken.website.career.entity.PercentageRules;

@Repository
public interface PercentageRuleRepository extends BaseRepository<PercentageRules, Integer> {

	@Override
	@Cacheable("percentageRules")
	public List<PercentageRules> findAll();
}
