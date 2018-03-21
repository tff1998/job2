package com.job2.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @param a)机构名称、机构编号,子机构，员工
 * @author acer-pc
 *
 */
@Entity
@Table(name="t_organization")
public class Organization extends BaseEntity{
	private String name;
	private String number;
	private Organization pOrganization;
	private Set<Organization> cOrganizations = new HashSet<Organization>();
	private Set<Staff> staffs = new HashSet<Staff>();
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	@OneToMany(mappedBy="pOrganization",cascade=CascadeType.ALL)
	public Set<Organization> getcOrganizations() {
		return cOrganizations;
	}
	@ManyToOne
	public Organization getpOrganization() {
		return pOrganization;
	}
	@OneToMany(mappedBy="organization")
	public Set<Staff> getStaffs() {
		return staffs;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setcOrganizations(Set<Organization> cOrganizations) {
		this.cOrganizations = cOrganizations;
	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
	public void setpOrganization(Organization pOrganization) {
		this.pOrganization = pOrganization;
	}
	
}
