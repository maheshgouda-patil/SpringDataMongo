package com.mango.entities;

import java.util.List;

public interface TapStoreLayout {
	public Long getId();
	public void setId(Long id);

	public String getArea() ;

	public void setArea(String area) ;

	public String getWidth();

	public void setWidth(String width) ;

	public String getHeight() ;

	public void setHeight(String height) ;

	public List<TapDepartmentImpl> getDepartments();

	public void setDepartments(List<TapDepartmentImpl> departments) ;
	
}
