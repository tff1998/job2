package com.job2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.job2.dao.StaffDao;
import com.job2.entity.Staff;
import com.job2.util.SexEnum;

@Service
@Transactional
public class StaffService implements IStaffService {
	@Autowired
	private StaffDao staffDao;

	@Override
	public Staff save(Staff entity) {
		// TODO Auto-generated method stub
		return staffDao.save(entity);
	}

	@Override
	public Staff findOne(Long id) {
		// TODO Auto-generated method stub
		return staffDao.findOne(id);
	}

	@Override
	public Page<Staff> findAll(String userName, Pageable pageable) {
		return staffDao.findAll(userName, pageable);
	}

	@Override
	public Page<Staff> findBySex(SexEnum sex, Pageable pageable) {
		// TODO Auto-generated method stub
		return staffDao.findBySex(sex, pageable);
	}

	@Override
	public Page<Staff> findByOrganizationName(String name,Pageable pageable) {
		// TODO Auto-generated method stub
		return staffDao.findByOrganizationName(name, pageable);
	}

	@Override
	public Page<Staff> findAll(Specification<Staff> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return staffDao.findAll(spec, pageable);
	}
	
}
