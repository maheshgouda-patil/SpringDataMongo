package com.mango.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="device")
public class TapDeviceImpl implements TapDevice {

	protected String id;
	
	private String deviceId;

	private String secretKey;

	private boolean active;
	
	protected String storeId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
