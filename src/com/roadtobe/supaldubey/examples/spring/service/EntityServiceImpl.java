/**
 * 
 */
package com.roadtobe.supaldubey.examples.spring.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roadtobe.supaldubey.examples.spring.domain.EntityImpl;

/**
 * @author Supal
 *
 */
@Repository
public class EntityServiceImpl implements EntityService 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void save(EntityImpl imp)
	{
		sessionFactory.getCurrentSession().save(imp);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
