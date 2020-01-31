package com.mango.entities;

import java.util.ArrayList;
import java.util.List;



public class TapDepartmentImpl implements TapDepartment {

	protected Long id;

	protected String departmentName;

	protected String area;

	protected String departmentColor;

	protected long categoryId;

	protected String fontColor;

	protected List<TapDeptDimensionImpl> dimensions = new ArrayList<TapDeptDimensionImpl>();

	protected Long parentDepartmentId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDepartmentColor() {
		return departmentColor;
	}

	public void setDepartmentColor(String departmentColor) {
		this.departmentColor = departmentColor;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public List<TapDeptDimensionImpl> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<TapDeptDimensionImpl> dimensions) {
		this.dimensions = dimensions;
	}

	public Long getParentDepartmentId() {
		return parentDepartmentId;
	}

	public void setParentDepartmentId(Long parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	
}
