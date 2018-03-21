package com.job2.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.job2.entity.Organization;
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
	public void save3(){
		Organization o2=new Organization();
		o2.setName("公安部");
		o2.setNumber("A002");
		Organization o21=new Organization();
		o21.setName("纪检监察局");
		o21.setNumber("A0021");
		Organization o22=new Organization();
		o22.setName("治安管理局");
		o22.setNumber("A0022");
		Organization o23=new Organization();
		o23.setName("禁毒局");
		o23.setNumber("A0023");
		o21.setpOrganization(o2);
		o22.setpOrganization(o2);
		o23.setpOrganization(o2);
		o2.getcOrganizations().add(o21);
		o2.getcOrganizations().add(o22);
		o2.getcOrganizations().add(o23);
		organizationService.save(o2);
	}
	@Test
	public void saveAll(){
		save1();
		save2();
		save3();
	}
}
