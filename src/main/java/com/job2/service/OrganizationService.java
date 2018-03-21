package com.job2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.job2.dao.OrganizationDao;
import com.job2.entity.Organization;
@Service
@Transactional
public class OrganizationService implements IOrganizationService {
	@Autowired
	private OrganizationDao organizationDao;
	@Override
	public com.job2.entity.Organization findByName(String s) {
		// TODO Auto-generated method stub
		return organizationDao.findByName(s);
	}
	@Override
	public Organization findOne(Long id) {
		// TODO Auto-generated method stub
		return organizationDao.findOne(id);
	}
	@Override
	public <S extends Organization> Organization save(Organization entity) {
		// TODO Auto-generated method stub
		return organizationDao.save(entity);
	}
	
}
