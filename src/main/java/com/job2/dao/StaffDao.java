package com.job2.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.job2.entity.Staff;
import com.job2.util.SexEnum;
@Component
public interface StaffDao extends PagingAndSortingRepository<Staff, Long>,JpaSpecificationExecutor<Staff>{
	@Query(value="from Staff s where name like %?1%")
	public Page<Staff> findAll(String name,Pageable pageable);
	public Page<Staff> findBySex(SexEnum sex,Pageable pageable);
	@Query(value="from Staff s where s.organization.name=?1 or "
			+ "s.organization.name in ("
			+ "select o.name from Organization o where o.pOrganization.name = ?1 )")
	public Page<Staff> findByOrganizationName(String name,Pageable pageable);
}
