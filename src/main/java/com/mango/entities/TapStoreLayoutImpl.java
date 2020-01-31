package com.mango.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "store_layout")
public class TapStoreLayoutImpl implements TapStoreLayout {

	protected Long id;

	protected String area;

	protected String width;

	protected String height;

	List<TapDepartmentImpl> departments = new ArrayList<TapDepartmentImpl>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public List<TapDepartmentImpl> getDepartments() {
		return departments;
	}

	public void setDepartments(List<TapDepartmentImpl> departments) {
		this.departments = departments;
	}
	
	
}
