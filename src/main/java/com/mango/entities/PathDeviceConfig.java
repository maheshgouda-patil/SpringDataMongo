/**
 * 
 */
package com.mango.entities;

/**
 * @author adarsh.k
 * @since  Feb 20, 2015 
 */
public class PathDeviceConfig {
	
	private String name;
	
	private String position;
	
	private String hpath;
	
	private String vpath;
	
	private String aisle;
	
	private String aisleseq;
	
	private String id;
	
	private String store;
	
	private String pathType;
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getHpath() {
		return hpath;
	}
	public void setHpath(String hpath) {
		this.hpath = hpath;
	}
	public String getVpath() {
		return vpath;
	}
	public void setVpath(String vpath) {
		this.vpath = vpath;
	}

	public String getAisle() {
		return aisle;
	}
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	public String getAisleseq() {
		return aisleseq;
	}
	public void setAisleseq(String aisleseq) {
		this.aisleseq = aisleseq;
	}
	public String getPathType() {
		return pathType;
	}
	public void setPathType(String pathType) {
		this.pathType = pathType;
	}
	
	
}
