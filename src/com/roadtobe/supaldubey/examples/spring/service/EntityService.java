package com.roadtobe.supaldubey.examples.spring.service;

import org.springframework.transaction.annotation.Transactional;

import com.roadtobe.supaldubey.examples.spring.domain.EntityImpl;

public interface EntityService 
{
	@Transactional
	public abstract void save(EntityImpl imp);

}