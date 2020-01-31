package com.mango.entities;


/**
 * @author adarsh.k
 * 
 */
public interface TapDevice {
	
	public void setActive(boolean activateDevice);

	public boolean isActive();

	public void setSecretKey(String secretKey);

	public String getSecretKey();

	public void setDeviceId(String deviceId);

	public String getDeviceId();
	
	public String getStoreId() ;

	public void setStoreId(String storeId);
	
	public String getId();

	public void setId(String id) ;
	

}
