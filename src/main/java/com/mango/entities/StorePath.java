/**
 * 
 */
package com.mango.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author adarsh.k
 * @since  Feb 20, 2015 
 */
@Document(collection="path_data")
public class StorePath {
	
	@Id
	private String storeId;
	
	private String startingPath;
	
	private List<PathDeviceConfig> pathConfig;
	
	private List<PathCoordinate> pathCoordinates;
	
	public String getStartingPath() {
		return startingPath;
	}

	public void setStartingPath(String startingPath) {
		this.startingPath = startingPath;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public List<PathDeviceConfig> getPathConfig() {
		return pathConfig;
	}

	public void setPathConfig(List<PathDeviceConfig> pathConfig) {
		this.pathConfig = pathConfig;
	}

	
	public List<PathCoordinate> getPathCoordinates() {
		return pathCoordinates;
	}

	public void setPathCoordinates(List<PathCoordinate> pathCoordinates) {
		this.pathCoordinates = pathCoordinates;
	}

	@Override
	public String toString() {
		return "StorePath [storeId=" + storeId + ", startingPath=" + startingPath+ ", pathConfig=" + pathConfig+ "]";
	}

	
	
}
