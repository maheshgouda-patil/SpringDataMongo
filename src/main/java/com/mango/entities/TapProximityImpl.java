package com.mango.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="proximity")
public class TapProximityImpl implements TapProximity {

	private String id;

	protected String major;

	protected String minor;

	protected String txPower;

	protected String uui;

	protected String x;

	protected String y;
	
	protected String storeId;
	
	protected String uniqueId;
	
	protected String deviceId;
	
	protected String layoutId;
	
	protected String alise;

	public String getAlise() {
		return alise;
	}

	public void setAlise(String alise) {
		this.alise = alise;
	}

	public String getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	protected String deviceType;
	
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	
	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getTxPower() {
		return txPower;
	}

	public void setTxPower(String txPower) {
		this.txPower = txPower;
	}

	public String getUui() {
		return uui;
	}

	public void setUui(String uui) {
		this.uui = uui;
	}

//	public String getY() {
//		return y;
//	}
//
//	public void setYcord(String y) {
//		this.y = y;
//	}
//
//	public String getX() {
//		return x;
//	}
//
//	public void setXcord(String x) {
//		this.x= x;
//		
//	}

	

}
