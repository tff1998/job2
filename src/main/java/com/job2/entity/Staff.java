package com.job2.entity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.job2.util.SexEnum;
/**
 * @param 员工编号、员工姓名、性别、年龄、家庭地址、电话，所属机构
 * @author acer-pc
 *
 */
@Entity
@Table(name="t_Staff")
public class Staff extends BaseEntity{
	private String number;
	private String name;
	private SexEnum sex;
	private Integer age;
	private String address;
	private String tel;
	private Organization organization;
	@ManyToOne
	public Organization getOrganization() {
		return organization;
	}
	
	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public SexEnum getSex() {
		return sex;
	}
	public Integer getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getTel() {
		return tel;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}