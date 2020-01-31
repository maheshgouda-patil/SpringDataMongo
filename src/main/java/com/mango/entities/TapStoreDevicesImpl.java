/**
 * 
 */
package com.mango.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author adarsh.k
 * 
 */

@Document(collection = "store_devices")
public class TapStoreDevicesImpl implements TapStoreDevices{

	@Id
	private String id;

	List<TapDeviceImpl> devices = new ArrayList<TapDeviceImpl>();
	
	List<TapProximityImpl> proximityDevices = new ArrayList<TapProximityImpl>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<TapDeviceImpl> getDevices() {
		return devices;
	}

	public void setDevices(List<TapDeviceImpl> devices) {
		this.devices = devices;
	}

	public List<TapProximityImpl> getProximityDevices() {
		return proximityDevices;
	}

	public void setProximityDevices(List<TapProximityImpl> proximityDevices) {
		this.proximityDevices = proximityDevices;
	}



}
