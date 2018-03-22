package com.job2.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.job2.entity.Organization;
import com.job2.entity.Staff;

public class StaffQueryDTO {
	private String name;
	private String orgnizationnName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgnizationnName() {
		return orgnizationnName;
	}
	public void setOrgnizationnName(String orgnizationnName) {
		this.orgnizationnName = orgnizationnName;
	}
	public static Specification<Staff> getSpecification(StaffQueryDTO StaffDTO){
		Specification<Staff> spec = new Specification<Staff>() {
			@Override
			public Predicate toPredicate(Root<Staff> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(StaffDTO!=null&&!org.springframework.util.StringUtils.isEmpty(StaffDTO.getName())){
					Predicate p1 = cb. like(root.get("name").as(String.class),"%"+StaffDTO.getName()+"%");
					list.add(p1);
				}
				return cb.and(list.get(0));
			}
		};
		return spec;
	}
}
