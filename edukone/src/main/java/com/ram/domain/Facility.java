package com.ram.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "facility")
public class Facility{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String desc;

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getDesc(){
		return desc;
	}

	public void setDesc(String desc){
		this.desc=desc;
	}
}
