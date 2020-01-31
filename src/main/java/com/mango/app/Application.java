/**
 * 
 */
package com.mango.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mango.entities.PathCoordinate;
import com.mango.entities.PathDeviceConfig;
import com.mango.entities.StorePath;
import com.mango.entities.TapDepartment;
import com.mango.entities.TapDepartmentImpl;
import com.mango.entities.TapDeptDimension;
import com.mango.entities.TapDeptDimensionImpl;
import com.mango.entities.TapDevice;
import com.mango.entities.TapDeviceImpl;
import com.mango.entities.TapProximity;
import com.mango.entities.TapProximityImpl;
import com.mango.entities.TapStore;
import com.mango.entities.TapStoreAisleLocation;
import com.mango.entities.TapStoreAisleLocationImpl;
import com.mango.entities.TapStoreDevicesImpl;
import com.mango.entities.TapStoreImpl;
import com.mango.entities.TapStoreLayout;
import com.mango.entities.TapStoreLayoutImpl;
import com.mango.entities.TapStoreMapImpl;
import com.mongodb.WriteResult;

/**
 * @author adarsh.k
 *
 */
public class Application {
	
	public static void main(String[] args) throws IOException {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MongoOperations mongoOperations = context.getBean(MongoOperations.class);
		BufferedReader reader = null;
	/*	File file = new File("D:/Source/InStore/InStore_Store.csv");
		BufferedReader reader = new BufferedReader(new FileReader(file));*/
		
		Application ap = new Application();
	
		/*// Store
		ArrayList<TapStore> stores = ap.saveStore(reader);
		mongoOperations.insert(stores, "store");	*/
		
		
		// Aisle
		reader = new BufferedReader(new FileReader("D:/Source/InStore/StoreAisle.csv"));
		ArrayList<TapStoreAisleLocation> aisle = ap.saveStoreAisle(reader);
		System.out.println("Inserting into aisle_location");
		//mongoOperations.insert(aisle, "aisle_location");
		java.util.Iterator<TapStoreAisleLocation> iterator = aisle.iterator();
		while (iterator.hasNext()) {
			TapStoreAisleLocation aisleLocation = iterator.next();
			//List<StorePath> foudObjects = mongoOperations.find(ap.getQuery(storePath),  StorePath.class, "path_data");
			WriteResult ws = mongoOperations.upsert(ap.getQuery(aisleLocation), ap.getUpdate(aisleLocation), TapStoreAisleLocation.class, "aisle_location");
			System.out.println("Mongo update: " + ws.getN());
			System.out.println("Update done for Aisle ID: " + aisleLocation.getId());
		}
		
		System.out.println("Insertion into aisle_location done");
		
		/*// Device & Proximity
		reader = new BufferedReader(new FileReader("D:/Source/InStore/StoreDevice.csv"));
		ArrayList<TapDeviceImpl> device =		ap.saveDevice(reader);
		System.out.println("Inserting into device");
		//mongoOperations.insert(device, "device");
		java.util.Iterator<TapDeviceImpl> deviceiterator = device.iterator();
		while (deviceiterator.hasNext()) {
			TapDeviceImpl tapDevice = deviceiterator.next();
			mongoOperations.upsert(ap.getQuery(tapDevice), ap.getUpdate(tapDevice), TapDeviceImpl.class, "device");
			System.out.println("Update done for Device ID: " + tapDevice.getId());
		}
		System.out.println("Inserting into device done");*/
		
		
		/*reader = new BufferedReader(new FileReader("D:/Source/InStore/StoreProximity.csv"));
		ArrayList<TapProximityImpl>		proximity =	ap.saveProximity(reader);
		System.out.println("Inserting into proximity");
		//mongoOperations.insert(proximity, "proximity");
		java.util.Iterator<TapProximityImpl> proximityiterator = proximity.iterator();
		while (proximityiterator.hasNext()) {
			TapProximityImpl tapProximty = proximityiterator.next();
			mongoOperations.upsert(ap.getQuery(tapProximty), ap.getUpdate(tapProximty), TapProximityImpl.class, "proximity");
			System.out.println("Update done for Proximty ID: " + tapProximty.getId());
		}
		
		System.out.println("Inserting into proximity done");*/
		
		/*reader = new BufferedReader(new FileReader("D:/Source/InStore/StoreMap.csv"));
		ArrayList<TapProximityImpl>		mapdata =	ap.saveMap(reader);
		System.out.println("Inserting into proximity");
		mongoOperations.insert(proximity, "proximity");
		System.out.println("Inserting into proximity done");*/
		
		/*reader = new BufferedReader(new FileReader("D:/Source/InStore/StorePath.csv"));
		ArrayList<StorePath> pathdata =	ap.savePath(reader);
		//mongoOperations.insert(pathdata, "path_data");
		java.util.Iterator<StorePath> iterator = pathdata.iterator();
		System.out.println("Inserting into path_data: ");
		while (iterator.hasNext()) {
			System.out.println("Inside Loop");
			StorePath storePath = iterator.next();
			
			//List<StorePath> foudObjects = mongoOperations.find(ap.getQuery(storePath),  StorePath.class, "path_data");
			
			WriteResult rs= mongoOperations.upsert(ap.getQuery(storePath), ap.getUpdate(storePath), StorePath.class);
			System.out.println(rs.getN());
			System.out.println(rs.getUpsertedId());
			System.out.println(rs.getLastConcern());
			System.out.println("Update done for co-ordinate ID: " + storePath.getPathCoordinates().get(0).getId());
		}
		
		System.out.println("Inserting into path_data done");*/
		
		//System.out.println("Aisle " + aisle.size() + " :: " + aisle.size());
		//System.out.println("Device " + device.size() + " :: " + device.size());
		//System.out.println("proximity " + proximity.size() + " :: " + proximity.size());
		//System.out.println("pathdata " + pathdata.size() + " :: " + pathdata.size());
		
		
		
		/*ArrayList<TapStoreDevicesImpl> proxDevice =			ap.saveStoreDevices(proximity, device);
		System.out.println(proxDevice.size());
		mongoOperations.insert(proxDevice, "store_devices");
		
		// Layout, Department & Dimension
		
		reader = new BufferedReader(new FileReader("D:/Source/InStore/StoreDept_Dimen.csv"));
		// Long storeId, Long layoutId, String area, String width, String height
		
		TapStoreMapImpl map =	ap.saveMap(reader, "1L", 1L, "0.0", "541", "622");
		mongoOperations.insert(map, "map_data");*/
		
	}
	
	
	private Update getUpdate(TapProximityImpl tapProximty) {
		// TODO Auto-generated method stub
		Update update = new Update();
		//instore_atg
		//update.set("_class","com.tap.entities.TapProximityImpl");
		//AWS Stagging
		update.set("_class","com.tap.instore.layout.mongo.entities.TapProximityImpl");
		update.set("major", tapProximty.getMajor());
		update.set("minor",tapProximty.getMinor());
		update.set("txPower", tapProximty.getTxPower());
		update.set("uui",tapProximty.getUui());
		update.set("x", tapProximty.getX());
		update.set("y",tapProximty.getY());
		update.set("storeId", tapProximty.getStoreId());
		update.set("layoutId", tapProximty.getLayoutId());
		update.set("aisle", tapProximty.getAlise());
		update.set("uniqueId",tapProximty.getUniqueId());
		update.set("deviceId", tapProximty.getDeviceId());
		update.set("deviceType",tapProximty.getDeviceType());
		
		return update;
	}


	private Query getQuery(TapProximityImpl tapProximty) {
		// TODO Auto-generated method stub
		Query query = new Query();
		
		query.addCriteria(Criteria.where("id").is(tapProximty.getId()));
				
		return query;
	}


	private Query getQuery(TapDevice tapDevice) {
		// TODO Auto-generated method stub
		Query query = new Query();
		
		query.addCriteria(Criteria.where("id").is(tapDevice.getId()));
				
		return query;
	}


	private Update getUpdate(TapDeviceImpl tapDevice) {
		// TODO Auto-generated method stub
		Update update = new Update();
		//instore_atg
		update.set("_class","com.tap.entities.TapDeviceImpl");
		//AWS Stagging
		//update.set("_class","com.tap.instore.layout.mongo.entities.TapDeviceImpl");
		update.set("deviceId", tapDevice.getDeviceId());
		update.set("secretKey",tapDevice.getSecretKey());
		update.set("active", tapDevice.isActive());
		update.set("storeId",tapDevice.getStoreId());
		return update;
	}


	private Update getUpdate(TapStoreAisleLocation aisleLocation) {
		// TODO Auto-generated method stub
		Update update = new Update();
		//instore_atg
		//update.set("_class","com.tap.entities.TapStoreAisleLocationImpl");
		//AWS Stagging
		update.set("_class","com.tap.instore.layout.mongo.entities.TapStoreAisleLocationImpl");
		update.set("aisle", aisleLocation.getAisle());
		update.set("tapdepartmentId",aisleLocation.getTapdepartmentId());
		update.set("tapdepartmentName", aisleLocation.getTapdepartmentName());
		update.set("subDepartmentId",aisleLocation.getSubDepartmentId());
		update.set("subDepartmentName", aisleLocation.getSubDepartmentName());
		update.set("coordinateX",aisleLocation.getCoordinateX());
		update.set("coordinateY", aisleLocation.getCoordinateY());
		update.set("taproductId",aisleLocation.getTaproductId());
		update.set("proxitryMajor", aisleLocation.getProxitryMajor());
		update.set("proxitryMinor",aisleLocation.getProxitryMinor());
		update.set("proxitryuuid", aisleLocation.getProxitryuuid());
		update.set("proxitryTxpower",aisleLocation.getProxitryTxpower());
		update.set("proximityXCord", aisleLocation.getProximityXCord());
		update.set("proximityYCord",aisleLocation.getProximityYCord());
		update.set("storeId",aisleLocation.getStoreId());
		return update;
	}

	private Query getQuery(TapStoreAisleLocation aisleLocation) {
		// TODO Auto-generated method stub
		Query query = new Query();
		
		query.addCriteria(Criteria.where("id").is(aisleLocation.getId()));
				
		return query;
	}
	
	private Update getUpdate(StorePath storePath) {
		// TODO Auto-generated method stub
		Update update = new Update();
		
		update.set("pathCoordinates", storePath.getPathCoordinates().get(0));
		update.set("pathConfig", storePath.getPathConfig().get(0));
		update.set("storeId", storePath.getStoreId());
		update.set("startingPath", storePath.getStartingPath());
		
		return update;
	}


	private Query getQuery(StorePath storePath) {
		// TODO Auto-generated method stub
		Query query = new Query();
		
		query.addCriteria(Criteria.where("pathCoordinates.id").is(storePath.getPathCoordinates().get(0).getId()));
				
		return query;
	}


	private ArrayList<StorePath> savePath(BufferedReader reader) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<StorePath> pathdata = new ArrayList<StorePath>();
		ArrayList<PathCoordinate> pathCoordinates = null;;
		ArrayList<PathDeviceConfig> pathDevice = null;
		StorePath storePath = null;
		String st;
		while((st = reader.readLine()) != null)
		{		
		
		String[] fields = 	st.split(",");
		System.out.println(fields + " : " + fields.length);
		
		//0-7 Path co-ordinate fields 		
		PathCoordinate pathCoordinate = new PathCoordinate();
		pathCoordinates = new ArrayList<PathCoordinate>();
		pathCoordinate.setId(fields[0].trim());
		pathCoordinate.setEndpointOneX(fields[1].trim());
		pathCoordinate.setEndpointOneY(fields[2].trim());
		pathCoordinate.setEndpointTwoX(fields[3].trim());
		pathCoordinate.setEndpointTwoY(fields[4].trim());
		pathCoordinate.setPathid(fields[5].trim());
		pathCoordinate.setStore(fields[6].trim());
		pathCoordinate.setPathType(fields[7].trim());
		
		//From 8-14 Path config fields
		PathDeviceConfig deviceConfig = new PathDeviceConfig();
		pathDevice = new ArrayList<PathDeviceConfig>();
		deviceConfig.setId(fields[8].trim());
		deviceConfig.setAisle(fields[9].trim());
		deviceConfig.setAisleseq(fields[10].trim());
		deviceConfig.setHpath(fields[11].trim());
		deviceConfig.setName(fields[12].trim());
		deviceConfig.setPosition(fields[13].trim());
		deviceConfig.setVpath(fields[14].trim());
		deviceConfig.setStore(fields[6].trim());
		deviceConfig.setPathType(fields[7].trim());
		 storePath = new StorePath();
		storePath.setPathCoordinates(pathCoordinates);
		storePath.setPathConfig(pathDevice);
		storePath.setStoreId(fields[6].trim());
		
		pathDevice.add(deviceConfig);
		pathCoordinates.add(pathCoordinate);
		pathdata.add(storePath);
		
		}
		
		return pathdata;
	}


	public ArrayList<TapStore> saveStore(BufferedReader reader) throws NumberFormatException, IOException{
		String st;
		ArrayList<TapStore> stores = new ArrayList<TapStore>();
	
		while((st = reader.readLine()) != null)
		{		
		
		String[] fields = 	st.split(",");
		System.out.println(fields + " : " + fields.length);
						
		TapStore store = new TapStoreImpl();
		
		//store.setId(new Long(fields[0].trim()));
		store.setId(fields[0].trim());
		store.setAddress1(fields[1].trim());
		store.setAddress2(fields[2].trim());
		store.setCity(fields[3].trim());
		store.setCountry(fields[4].trim());
		store.setStoreActive(new Boolean(fields[5].trim()));
		store.setLatitude(new Double(fields[6].trim()));
		store.setLongitude(new Double(fields[7].trim()));
		store.setName(fields[8].trim());
		store.setPhone(fields[9].trim());
		store.setState(fields[10].trim());
		store.setZip(fields[11].trim());
		stores.add(store);
		}
		return stores;
		}
	
	
	public ArrayList<TapStoreAisleLocation> saveStoreAisle(BufferedReader reader) throws NumberFormatException, IOException{

		ArrayList<TapStoreAisleLocation> aisles = new ArrayList<TapStoreAisleLocation>();
		String st;
		int count = 1;
		while((st = reader.readLine()) != null)
		{		
		
			
		String[] fields = 	st.split(",");
		System.out.println(fields + " : " + fields.length + " Line :" + count++);
						
		TapStoreAisleLocation aisle = new TapStoreAisleLocationImpl();
		
		//aisle.setId(new Long(fields[0].trim()));
		aisle.setId(fields[0].trim());
		System.out.println("*****" + fields[1].trim());
		aisle.setAisle(fields[1].trim());
		aisle.setCoordinateX(fields[2].trim());
		aisle.setCoordinateY(fields[3].trim());
		aisle.setProximityXCord(fields[4].trim());
		aisle.setProximityYCord(fields[5].trim());
		aisle.setProxitryMajor(fields[6].trim());
		aisle.setProxitryMinor(fields[7].trim());
		aisle.setProxitryTxpower(fields[8].trim());
		aisle.setProxitryuuid(fields[9].trim());
		
		String data = fields[10].trim();
		
		if(!(data.equals(""))) { 
			aisle.setSubDepartmentId(new Long(data.trim()));
		}
		
		aisle.setSubDepartmentName(fields[11].trim());
		aisle.setTapdepartmentName(fields[12].trim());
		
		
		/*String data = fields[9].trim();
		
		if(!(data.equals(""))) { 
			aisle.setTapdepartmentId(new Long(fields[9].trim()));  	
		}*/
		
		//aisle.setTaproductId(new Long(fields[10].trim()));
		aisle.setTaproductId(fields[13].trim());
		aisle.setTapdepartmentId(new Long(fields[14].trim()));
		aisle.setStoreId(fields[15].trim());
		
		/*String data = fields[14].trim();
		System.out.println("data ******:" + data);
		if(!(data.equals(""))) {
			aisle.setSubDepartmentId(new Long(fields[11].trim())); 
		}*/
		
		/*aisle.setTapdepartmentName(fields[12].trim());
		aisle.setProximityXCord(fields[13].trim());
		aisle.setProximityYCord(fields[14].trim());
		*/
		aisles.add(aisle);
		}
		return aisles;
		}
	
	
	public ArrayList<TapDeviceImpl> saveDevice(BufferedReader reader) throws NumberFormatException, IOException{
		ArrayList<TapDeviceImpl> devices = new ArrayList<TapDeviceImpl>();
		String st;
		
		while((st = reader.readLine()) != null)
		{		
		
		String[] fields = 	st.split(",");
		System.out.println(fields + " : " + fields.length);
		TapDevice device = new TapDeviceImpl();
		//device.setId(new Long(fields[0].trim()));
		device.setId(fields[0].trim());
		device.setActive(new Boolean(fields[1].trim()));
		device.setDeviceId(fields[2].trim());
		System.out.println(":"+ fields[3].trim() + ":");
		device.setSecretKey(fields[3].trim());
		device.setStoreId(fields[4].trim());
		devices.add((TapDeviceImpl) device);
		}
		
		return devices;
	}
	
	
	
	public ArrayList<TapProximityImpl> saveProximity(BufferedReader reader) throws NumberFormatException, IOException{
		ArrayList<TapProximityImpl> proximities = new ArrayList<TapProximityImpl>();
		String st;
		
		while((st = reader.readLine()) != null)
		{		
		String[] fields = 	st.split(",");
		System.out.println(fields + " : " + fields.length);
		TapProximity proximity = new TapProximityImpl();
		//proximity.setId(new Long(fields[0]));
		proximity.setId(fields[0]);
		proximity.setMajor(fields[1].trim());
		proximity.setMinor(fields[2].trim());
		proximity.setTxPower(fields[3].trim());
		proximity.setUui(fields[4].trim());
		//proximity.setXcord(fields[5]);
		//proximity.setYcord(fields[6]);
		proximity.setX(fields[5]);
		proximity.setY(fields[6]);
		proximity.setStoreId(fields[7]);
		proximity.setDeviceId(fields[8]);
		proximity.setDeviceType(fields[9]);
		proximity.setUniqueId(fields[10]);
		proximity.setLayoutId(fields[11]);
		if(!fields[12].isEmpty()) {
			proximity.setAlise(fields[12]);
		}
		proximities.add((TapProximityImpl) proximity);
		}
		
		return proximities;
	}
	
	// Currently Storing for StoreID 1 only
	public ArrayList<TapStoreDevicesImpl> saveStoreDevices(ArrayList<TapProximityImpl> proximity, ArrayList<TapDeviceImpl> device) throws NumberFormatException, IOException{
		ArrayList<TapStoreDevicesImpl> storeDevices = new ArrayList<TapStoreDevicesImpl>();
		
		TapStoreDevicesImpl storeDevice = new TapStoreDevicesImpl();
		//storeDevice.setId(new Long("1"));
		storeDevice.setId("4");
		//storeDevice.setDevices(device);
		//storeDevice.setProximityDevices(proximity);
		storeDevice.setDevices(device);
		storeDevice.setProximityDevices(proximity);
		
		storeDevices.add(storeDevice);
		
		return storeDevices;
	}
	
	
	
	
	
// ------------ Map <-- Layout <-- Department <-- Dimension
	
	public ArrayList<TapDeptDimension> saveDimension(BufferedReader reader) throws IOException {
		
		ArrayList<TapDeptDimension> dimensions = new ArrayList<TapDeptDimension>();
		String st;
		
		while((st = reader.readLine()) != null)
		{		
			String[] fields = 	st.split(",");
			System.out.println(fields + " : " + fields.length);
			TapDeptDimension dimension = new TapDeptDimensionImpl();
			
			dimension.setId(new Long(fields[0].trim()));
			dimension.setDimensionHeight(fields[1].trim());
			dimension.setDimensionLength(fields[2].trim());
			dimension.setDimensionPositionX(fields[3].trim());
			dimension.setDimensionPositionY(fields[4].trim());
			dimension.setDimensionRadius(fields[5].trim());
			dimension.setDimensionWidth(fields[6].trim());
			dimension.setDimensionshape(fields[7].trim());
			dimension.setDimensiontype(fields[8].trim());
			
			dimensions.add(dimension);
		}
		
		return dimensions;
	}
	
//#DEPARTMENT_ID|AREA|CATEGORY_ID|DEPARTMENT_COLOR|DEPARTMENT_NAME|FONT_COLOR	 LAYOUT_ID	 PARENT_DEPARTMENT_ID	 categoryId	 DIMENSION_ID	 DIMENSION_GROUP	 DIMENSION_HEIGHT	 DIMENSION_LENGTH	 DIMENSION_POSITION_X	 DIMENSION_POSITION_Y	 DIMENSION_RADIUS	 DIMENSION_WIDTH	 DIMENSION_SHAPE	 DIMENSION_TYPE	 SEQUENCE_NUMBER	 DEPARTMENT_ID	 DIMENSION_ID

	public ArrayList<TapDepartmentImpl> saveDepartment(BufferedReader reader) throws IOException {
		
		Map<String, TapDepartment> backup = new HashMap<String, TapDepartment>(); 
		String st;
		
		while((st = reader.readLine()) != null)
		{		
			String[] fields = 	st.split(",");
			System.out.println(fields + " : " + fields.length);
			String deptId = fields[0].trim();
			TapDepartment department = backup.get(deptId);
			
			if(department==null){
				department = new TapDepartmentImpl();
				department.setId(new Long(deptId));
				department.setArea(fields[1].trim());
				department.setCategoryId(new Long(fields[2].trim()));
				department.setDepartmentColor(fields[3].trim());
				department.setDepartmentName(fields[4].trim());
				department.setFontColor(fields[5].trim());
				String parent = fields[7].trim();
				if(!parent.equals("")) {	department.setParentDepartmentId(new Long(parent)); }
			}
			
			//List<TapDeptDimension> dimension = department.getDimensions();
			List<TapDeptDimensionImpl> dimension = department.getDimensions();
				TapDeptDimension dimen = new TapDeptDimensionImpl();
				dimen.setId(new Long(fields[9].trim()));
				dimen.setDimensionHeight(fields[11].trim());
				dimen.setDimensionLength(fields[12].trim());
				dimen.setDimensionPositionX(fields[13].trim());
				dimen.setDimensionPositionY(fields[14].trim());
				dimen.setDimensionRadius(fields[15].trim());
				dimen.setDimensionWidth(fields[16].trim());
				dimen.setDimensionshape(fields[17].trim());
				dimen.setDimensiontype(fields[18].trim());
				
				if(dimension==null){
					dimension = new ArrayList<TapDeptDimensionImpl>();
					dimension.add((TapDeptDimensionImpl) dimen);
					((TapDepartmentImpl) department).setDimensions(dimension);
				}
				else {
					if(!dimension.contains(dimen)){
						dimension.add((TapDeptDimensionImpl) dimen);
						((TapDepartmentImpl) department).setDimensions(dimension);
					}
				}
				
			backup.put(deptId, department);
		}
		
		ArrayList<TapDepartmentImpl>	depts = new ArrayList<TapDepartmentImpl>((Collection<? extends TapDepartmentImpl>) backup.values());
		
		return depts;
	}
	
	
	public TapStoreLayout saveLayout(BufferedReader reader, Long layoutId, String area, String width, String height) throws IOException {
		TapStoreLayout layout = new TapStoreLayoutImpl();
		layout.setId(layoutId);
		layout.setArea(area);
		layout.setHeight(height);
		layout.setWidth(width);
		
		ArrayList<TapDepartmentImpl> departments = saveDepartment(reader);
		
		//layout.setDepartments(departments);
		layout.setDepartments(departments);
		
		return layout;
	}
	
	
	
	
	
	public TapStoreMapImpl saveMap(BufferedReader reader, String storeId, Long layoutId, String area, String width, String height) throws NumberFormatException, IOException{
		
		TapStoreMapImpl map = new TapStoreMapImpl();
		//map.setId(storeId);											
		map.setId(storeId);
		
		TapStoreLayoutImpl layout = (TapStoreLayoutImpl) saveLayout(reader, layoutId, area, width, height);
		
		map.setLayout(layout);		
		
		return map;
	}

	
	
	}
