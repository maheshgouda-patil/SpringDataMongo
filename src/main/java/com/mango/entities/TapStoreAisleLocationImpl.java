package com.mango.entities;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="aisle_location")
public class TapStoreAisleLocationImpl implements TapStoreAisleLocation{

   @Id
	protected String id;	
	
	protected String aisle;
	
	protected Long tapdepartmentId;
	
    protected String tapdepartmentName ;
	
	protected Long subDepartmentId;
	
	protected String subDepartmentName;
	
	protected String coordinateX;
	
	protected String coordinateY;
	
    protected String taproductId;
	
	protected String proxitryMajor;
	
	protected String proxitryMinor;

	protected String proxitryuuid;
	
	protected String proxitryTxpower;
	
	protected String proximityXCord;
	
	protected String proximityYCord;
	
	protected String storeId;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getTapdepartmentName() {
		return tapdepartmentName;
	}

	public void setTapdepartmentName(String tapdepartmentName) {
		this.tapdepartmentName = tapdepartmentName;
	}

	public Long getSubDepartmentId() {
		return subDepartmentId;
	}

	public void setSubDepartmentId(Long subDepartmentId) {
		this.subDepartmentId = subDepartmentId;
	}

	public String getSubDepartmentName() {
		return subDepartmentName;
	}

	public void setSubDepartmentName(String subDepartmentName) {
		this.subDepartmentName = subDepartmentName;
	}

	public String getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(String coordinateX) {
		this.coordinateX = coordinateX;
	}

	public String getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(String coordinateY) {
		this.coordinateY = coordinateY;
	}

	public String getTaproductId() {
		return taproductId;
	}

	public void setTaproductId(String taproductId) {
		this.taproductId = taproductId;
	}

	public String getProxitryMajor() {
		return proxitryMajor;
	}

	public void setProxitryMajor(String proxitryMajor) {
		this.proxitryMajor = proxitryMajor;
	}

	public String getProxitryMinor() {
		return proxitryMinor;
	}

	public void setProxitryMinor(String proxitryMinor) {
		this.proxitryMinor = proxitryMinor;
	}

	public String getProxitryuuid() {
		return proxitryuuid;
	}

	public void setProxitryuuid(String proxitryuuid) {
		this.proxitryuuid = proxitryuuid;
	}

	public String getProxitryTxpower() {
		return proxitryTxpower;
	}

	public void setProxitryTxpower(String proxitryTxpower) {
		this.proxitryTxpower = proxitryTxpower;
	}

	public String getProximityXCord() {
		return proximityXCord;
	}

	public void setProximityXCord(String proximityXCord) {
		this.proximityXCord = proximityXCord;
	}

	public String getProximityYCord() {
		return proximityYCord;
	}

	public void setProximityYCord(String proximityYCord) {
		this.proximityYCord = proximityYCord;
	}

	public Long getTapdepartmentId() {
		return tapdepartmentId;
	}

	public void setTapdepartmentId(Long tapdepartmentId) {
		this.tapdepartmentId = tapdepartmentId;
	}
	


}
