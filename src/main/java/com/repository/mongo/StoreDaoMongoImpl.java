package com.repository.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.mango.entities.TapStore;
import com.mango.entities.TapStoreImpl;



@Repository
public class StoreDaoMongoImpl {

	@Autowired
	MongoOperations mongoOps;
	
	public void createStore(com.mango.entities.TapStore store){
		mongoOps.insert(store);
	}
	
	public com.mango.entities.TapStore findById(Long id){
		return mongoOps.findById(id, TapStoreImpl.class);
	} 
	
	public void deleteStore(TapStore store){
		mongoOps.remove(store);
	}
	
	public void saveStore(TapStore store){
		mongoOps.save(store);
	}
	
	public TapStore findStoreByName(String name){
		return mongoOps.findOne(query(where("name").is(name)), TapStoreImpl.class);
	}
	
	public List<TapStoreImpl> findAll(){
		return mongoOps.findAll(TapStoreImpl.class);
	}
}
