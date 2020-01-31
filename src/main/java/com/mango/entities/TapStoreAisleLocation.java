package com.mango.entities;

public interface TapStoreAisleLocation {
	
	public String getId();

	public void setId(String id) ;

	public String getAisle() ;

	public void setAisle(String aisle) ;

	public String getTapdepartmentName();

	public void setTapdepartmentName(String tapdepartmentName);

	public Long getSubDepartmentId();

	public void setSubDepartmentId(Long subDepartmentId);

	public String getSubDepartmentName() ;

	public void setSubDepartmentName(String subDepartmentName) ;

	public String getCoordinateX();

	public void setCoordinateX(String coordinateX) ;

	public String getCoordinateY() ;

	public void setCoordinateY(String coordinateY) ;

	public String getTaproductId() ;

	public void setTaproductId(String taproductId);

	public String getProxitryMajor();

	public void setProxitryMajor(String proxitryMajor) ;

	public String getProxitryMinor() ;

	public void setProxitryMinor(String proxitryMinor);

	public String getProxitryuuid();
	public void setProxitryuuid(String proxitryuuid);

	public String getProxitryTxpower();

	public void setProxitryTxpower(String proxitryTxpower);

	public String getProximityXCord();

	public void setProximityXCord(String proximityXCord) ;

	public String getProximityYCord() ;

	public void setProximityYCord(String proximityYCord) ;

	public Long getTapdepartmentId();

	public void setTapdepartmentId(Long tapdepartmentId) ;
	
	public String getStoreId();

	public void setStoreId(String storeId);
	

}
