package com.job2.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.job2.entity.Organization;
import com.job2.entity.Staff;
@Component
public interface OrganizationDao extends PagingAndSortingRepository<Organization, Long>{
	public Organization findByName(String s);
	public Organization findByNameLike(String s);
	
}
