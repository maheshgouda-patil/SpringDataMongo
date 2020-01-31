package com.mango.entities;

import java.util.List;

public interface TapStoreDevices {

	public String getId();

	public void setId(String id);

	public List<TapDeviceImpl> getDevices() ;

	public void setDevices(List<TapDeviceImpl> devices);

	public List<TapProximityImpl> getProximityDevices();

	public void setProximityDevices(List<TapProximityImpl> proximityDevices);
}
