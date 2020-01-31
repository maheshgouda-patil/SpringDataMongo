/**
 * 
 */
package com.mango.entities;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author adarsh.k
 *
 */

@Document(collection="map_data")
public class TapStoreMapImpl {
	
	protected String id;
	
	protected TapStoreLayoutImpl layout;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TapStoreLayoutImpl getLayout() {
		return layout;
	}
	public void setLayout(TapStoreLayoutImpl layout) {
		this.layout = layout;
	}

	
}
