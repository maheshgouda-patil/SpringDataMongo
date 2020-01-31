package com.mango.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class SpringMapColorUpdate {

	private final static String GROUP_COLOR_NEW = "group.color.new";
	private final static String GROUP_COLOR_OLD = "group.color.old";
	private final static String GROUP_ID = "group.id";
	
	private final static String JDBC_URL = "jdbc.url";
	private final static String JDBC_USERNAME = "jdbc.username";
	private final static String JDBC_PASSWORD = "jdbc.pass";
	private final static String COMMA = ",";
	
	private final static String PROP_FILE_PATH = "D:/DS/Properties/UpdateMapColor.properties";
	static JdbcTemplate jdbcTemplate = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Properties config= new Properties();
		try {
			
			config.load(new FileInputStream(PROP_FILE_PATH));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 System.out.println("********* Properties loaded *********");
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        try {
			dataSource.setDriver(new com.mysql.jdbc.Driver());
			dataSource.setUrl(config.getProperty(JDBC_URL));
	        dataSource.setUsername(config.getProperty(JDBC_USERNAME));
	        dataSource.setPassword(config.getProperty(JDBC_PASSWORD));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("********* Data source loaded *********");
        
        jdbcTemplate = new JdbcTemplate(dataSource);
        
        
        //Check for multiple updates - having comma separated
        String groupId = (String) config.get(GROUP_ID);
        String groupColorNew = (String) config.get(GROUP_COLOR_NEW);
        String groupColorOld = (String) config.get(GROUP_COLOR_OLD);
        
        if(!groupId.isEmpty() && !groupColorNew.isEmpty() && !groupColorOld.isEmpty()) {
        	
        	if(groupId.contains(COMMA) && groupColorNew.contains(COMMA) && groupColorOld.contains(COMMA)) {
        		//Multiple groups
        		System.out.println("********* Multiple groups *********");
        		
        		String[] groupIds = groupId.split(COMMA);
        		System.out.println(" Group IDs : " + groupIds);
        		String[] groupColorsNew = groupColorNew.split(COMMA);
        		System.out.println(" Group Colors New : " + groupColorsNew);
        		String[] groupColorsOld = groupColorOld.split(COMMA);
        		System.out.println(" Group Colors Old : " + groupColorsOld);

        		for (int i=0; i <groupIds.length; i ++) {
        			updaetMapColor(groupIds[i],groupColorsNew[i],groupColorsOld[i]);
        		}
        	} else {
        		//Single group 
        		System.out.println("********* Single groups *********");
        		
        		updaetMapColor(groupId,groupColorNew,groupColorOld);
        	}
        }
        else {
        	System.out.println("********* Invalid/Null property inputs *********");
        }
        
        
         
        
        
       
        
        /*String sqlSelect = "SELECT * FROM tap_department where GROUP_ID=?";
        jdbcTemplate.update(sqlUpdate, config.get(GROUP_ID));
        
        List<TapDepartmentEntity> listContact = jdbcTemplate.query(sqlSelect, new RowMapper<TapDepartmentEntity>() {
 
            public TapDepartmentEntity mapRow(ResultSet result, int rowNum) throws SQLException {
            	TapDepartmentEntity dept = new TapDepartmentEntity();
            	dept.setId(result.getLong("DEPARTMENT_ID"));
            	dept.setDepartmentName(result.getString("DEPARTMENT_NAME"));
            	dept.setDepartmentColor(result.getString("DEPARTMENT_COLOR"));
            	dept.setGroupId(result.getString("GROUP_ID"));
                 
                return dept;
            }
             
        });
         
        for (TapDepartmentEntity aContact : listContact) {
        	System.out.println(aContact);
        }*/
    }

	private static void updaetMapColor(String groupId, String groupColorNew, String groupColorOld) {
		// TODO Auto-generated method stub
		System.out.println("GID :" + groupId + " New Color :" + groupColorNew + " Old Color :" + groupColorOld);
		
	        //System.out.println(" Changing Group Color");
	        
	        String sqlUpdate = "UPDATE tap_store_layout_dept_group set GROUP_COLOR=? where GROUP_ID=? AND GROUP_COLOR=?";
	        jdbcTemplate.update(sqlUpdate, groupColorNew, groupId, groupColorOld);
	        
	        //System.out.println(" Changing Departments Color of a Group");
	        
	        sqlUpdate = "UPDATE tap_department set DEPARTMENT_COLOR=? WHERE GROUP_ID=?";
	        jdbcTemplate.update(sqlUpdate, groupColorNew, groupId);
	        
	        System.out.println("Update Done : - " + groupId);
	}

}
