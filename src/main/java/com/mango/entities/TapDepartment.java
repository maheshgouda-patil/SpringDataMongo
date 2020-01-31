package com.mango.entities;

import java.util.List;


public interface TapDepartment {
	
	public Long getId() ;
	public void setId(Long id) ;

	public String getDepartmentName();
	public void setDepartmentName(String departmentName);

	public String getArea();

	public void setArea(String area);

	public String getDepartmentColor();

	public void setDepartmentColor(String departmentColor) ;

	public long getCategoryId() ;
	public void setCategoryId(long categoryId) ;

	public String getFontColor() ;

	public void setFontColor(String fontColor) ;

	public List<TapDeptDimensionImpl> getDimensions();

	public Long getParentDepartmentId();

	public void setParentDepartmentId(Long parentDepartmentId) ;
	

}
