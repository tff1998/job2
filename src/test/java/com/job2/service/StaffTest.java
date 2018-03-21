package com.job2.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;

import com.job2.dao.OrganizationDao;
import com.job2.dao.StaffDao;
import com.job2.entity.Organization;
import com.job2.entity.Staff;
import com.job2.entity.dto.StaffQueryDTO;
import com.job2.service.IOrganizationService;
import com.job2.service.IStaffService;
import com.job2.util.BaseTest;
import com.job2.util.SexEnum;
/**
 * 欧蓝逞

柯掩澈

谢钟绣

安雨沫

安若素

安恋熙

斯凡

凡筱若

于霏

安知晓

安念莲

安瑾凉

杨语菲

杨兮诺

杨伈

夏璃沫

叶梓潼

尹梦竹

莫熙慈

顾一

温诩言

夏梓晗

云轻

夏天

挽歌

弱水

王语焉

程灵素

霍青桐

木婉清

雅绿

冰蓝

浅浅

花不迟

苏唯

白素

齐无真

叶蓁

 * @author acer-pc
 *
 */
@Service
public class StaffTest extends BaseTest{
	@Autowired
	IStaffService staffService;
	@Autowired
	IOrganizationService organizationService;
	@Test
	//保存国务院员工
	public void save1(){
		Organization organization = organizationService.findByName("国务院");
		Staff staff = new Staff();
		staff.setAddress("中南海");
		staff.setName("温诩言");
		staff.setAge(68);
		staff.setNumber("G01");
		staff.setSex(SexEnum.MALE);
		staff.setTel("10086");
		staff.setOrganization(organization);
		staffService.save(staff);
	}
	@Test
	@Transactional
	@Rollback(false)
	public void update(){
		Organization organization = organizationService.findByName("国务院");
		Organization organization2 = organizationService.findByName("教育部");
		organization2.setpOrganization(organization);
		//organization.getcOrganizations().add(organization2);
		organizationService.save(organization2);
		//organizationService.save(organization);
	}
	@Test
	//保存教育部员工,及下属部门员工
	public void save2(){
		Organization organization = organizationService.findByName("教育部");
		Staff staff = new Staff();
		staff.setAddress("北京市王府井120号");
		staff.setName("杨兮诺");
		staff.setAge(17);
		staff.setNumber("J001");
		staff.setSex(SexEnum.FEMALE);
		staff.setTel("10086");
		staff.setOrganization(organization);
		Staff staff2 = new Staff();
		staff2.setAddress("北京市王府井20号");
		staff2.setName("安若素");
		staff2.setAge(19);
		staff2.setNumber("J002");
		staff2.setSex(SexEnum.MALE);
		staff2.setTel("10086");
		staff2.setOrganization(organization);
		staffService.save(staff);
		staffService.save(staff2);

		Organization organization2 = organizationService.findByName("广东教育厅");
		Staff staff3 = new Staff();
		staff3.setAddress("广州塔下");
		staff3.setName("谢钟绣");
		staff3.setAge(27);
		staff3.setNumber("g001");
		staff3.setSex(SexEnum.MALE);
		staff3.setTel("10086");
		staff3.setOrganization(organization2);
		staffService.save(staff3);
		
		Organization organization3 = organizationService.findByName("湖南教育厅");
		Staff staff4 = new Staff();
		staff4.setAddress("长沙橘子洲");
		staff4.setName("程灵素");
		staff4.setAge(21);
		staff4.setNumber("H001");
		staff4.setSex(SexEnum.FEMALE);
		staff4.setTel("10086");
		staff4.setOrganization(organization3);
		staffService.save(staff4);
	}
	
	//测试分页查询
	@Test
	public void findPage(){
		Pageable pageable = new PageRequest(0, 3);
		Page<Staff> page = staffService.findAll("灵", pageable);
		System.out.println(page.getContent().get(0).getSex());
	}
	//测试根据方法名分页查询
	@Test
	public void findStaffBySex(){
		Sort sort = new Sort(Direction.ASC, "age").and(new Sort(Direction.DESC,"number"));
		Pageable pageable1 = new PageRequest(0, 2,sort);;
		Page<Staff> page = staffService.findBySex(SexEnum.MALE, pageable1);
		for(Staff s : page.getContent()){
			System.out.println(s.getName());
		}
	}
	////通过所属组织机构的名字查询员工（包括子机构，使用HQL）
	@Test
	public void findByOrganizationName(){
		Sort sort = new Sort(Direction.ASC, "age").and(new Sort(Direction.DESC,"number"));
		Pageable pageable1 = new PageRequest(0, 10,sort);
		Page<Staff> page = staffService.findByOrganizationName("国务院",pageable1);
		for(Staff s : page.getContent()){
			System.out.println(s.getName());
		}
	}
	//动态分页查询员工
	@Test
	public void findBySpecification(){
		StaffQueryDTO staffDTO = new StaffQueryDTO();
		staffDTO.setName("程灵素");
		System.out.println("------------------------");
		Page<Staff> page =  staffService.findAll(StaffQueryDTO.getSpecification(staffDTO), new PageRequest(0, 10));
		System.out.println(page.getContent().get(0).getAddress());
	}
}
