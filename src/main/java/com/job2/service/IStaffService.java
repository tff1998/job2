package com.job2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.job2.entity.Staff;
import com.job2.util.SexEnum;

public interface IStaffService{
	
	Staff findOne(Long id);
	<S extends Staff> Staff save(Staff entity);
	void delete(Staff entity);
	//自定义分页查询
	public Page<Staff> findAll(String userName ,Pageable pageable);
	//通过性别来查询员工
	public Page<Staff> findBySex(SexEnum sex,Pageable pageable);
	//通过所属组织机构的名字查询
	public Page<Staff> findByOrganizationName(String name, Pageable pageable1);
	//动态条件分页查询
	Page<Staff> findAll(Specification<Staff> spec, Pageable pageable);
}
