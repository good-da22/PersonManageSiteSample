package com.person.sample.dto;

public class PersonDto {
	
	private String id;
	private String name;
	private String departmentName;
	private String pay;
	
	public PersonDto() {}

	public PersonDto(String id, String name, String departmentName, String pay) {
		this.id = id;
		this.name = name;
		this.departmentName = departmentName;
		this.pay = pay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PsersonDto [id=").append(id).append(", name=").append(name).append(", departmentName=")
				.append(departmentName).append(", pay=").append(pay).append("]");
		return builder.toString();
	}
}
