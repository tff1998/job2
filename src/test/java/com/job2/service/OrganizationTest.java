package com.job2.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.job2.entity.Organization;
import com.job2.entity.Staff;
import com.job2.service.IOrganizationService;
import com.job2.util.BaseTest;

public class OrganizationTest extends BaseTest {
	@Autowired
	private IOrganizationService organizationService;
	@Test
	public void save1(){
		Organization o1=new Organization();
		o1.setName("国务院");
		o1.setNumber("SSS");
		organizationService.save(o1);
	}
	@Test
	public void save2(){
		Organization o1=new Organization();
		o1.setName("教育部");
		o1.setNumber("A001");
		Organization o11=new Organization();
		o11.setName("湖南教育厅");
		o11.setNumber("A0011");
		Organization o12=new Organization();
		o12.setName("广东教育厅");
		o12.setNumber("A0012");
		o11.setpOrganization(o1);
		o12.setpOrganization(o1);
		o1.getcOrganizations().add(o11);
		o1.getcOrganizations().add(o12);
		organizationService.save(o1);
	}
	@Test
	@Transactional
	@Rollback(false)
	public void update(){
		Organization organization = organizationService.findByName("国务院");
		Organization organization2 = organizationService.findByName("教育部");
		organization2.setpOrganization(organization);
		organizationService.save(organization2);
	}

	@Test
	public void saveAll(){
		save1();
		save2();
		//save3();
	}
	//测试删除和更新
	@Test
	@Transactional
	@Rollback(false)
	public void delete(){
		Organization entity = organizationService.findByName("教育部");
		/*for(Organization o : entity.getcOrganizations()){
			o.setpOrganization(entity.getpOrganization());
		}
		for(Staff s : entity.getStaffs()){
			s.setOrganization(null);
		}
		entity.setpOrganization(null);
		organizationService.save(entity);*/
		organizationService.delete(entity);
	}
}
