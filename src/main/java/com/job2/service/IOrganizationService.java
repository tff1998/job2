package com.job2.service;

import com.job2.entity.Organization;

public interface IOrganizationService {
	public Organization findByName(String s);
	Organization findOne(Long id);
	<S extends Organization> Organization save(Organization entity);
}
