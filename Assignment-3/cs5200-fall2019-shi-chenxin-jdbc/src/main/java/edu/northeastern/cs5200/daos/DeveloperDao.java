package edu.northeastern.cs5200.daos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Phone;

public class DeveloperDao implements DeveloperImpl {
	
	private static DeveloperDao instance = null;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;
	
	private DeveloperDao() {}
	
	public static DeveloperDao getInstance() {
	    if (instance == null)
	      instance = new DeveloperDao();
	    return instance;
	}
	
    private final String CREATE_PERSON = "INSERT INTO `person` (`id`, `first_name`, `last_name`, `usr_name`, `password`, `email`, `dob`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String CREATE_PHONE = "INSERT INTO `phone`(`phone`, `primary`, `person`) VALUES (?, ?, ?);";
    private final String CREATE_ADDRESS = "INSERT INTO `address`(`street1`,`street2`,`city`,`state`,`zip`,`primary`,`person`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String CREATE_DEVELOPER = "INSERT INTO `developer`(`id`, `developer_key`, `person`) VALUES (?, ?, ?);";
    
    private final String FIND_ALL_DEVELOPERS = "SELECT * FROM `person` JOIN `developer` ON person.id=developer.person";
    private final String FIND_DEVELOPER_BY_ID = "SELECT * FROM `person` JOIN `developer` ON person.id=developer.person AND person.id=?";
    private final String FIND_DEVELOPER_BY_USERNAME = "SELECT * FROM `person` JOIN `developer` ON person.id=developer.person AND person.usr_name=?";
    
    private final String UPDATE_DEVELOPER = "UPDATE `developer` SET developer_key=? WHERE person=?";
    private final String UPDATE_PERSON = "UPDATE `person` SET first_name=?, last_name=?, usr_name=?, password=?, email=?, dob=? WHERE id=?";
    
    private final String DELETE_PERSON = "DELETE FROM `person` WHERE `id`=?";
    private final String DELETE_PHONE = "DELETE FROM `phone` WHERE `person`=?";
    private final String DELETE_ADDRESS = "DELETE FROM `address` WHERE `person`=?";
    private final String DELETE_DEVELOPER = "DELETE FROM `developer` WHERE `person`=?";
    
    @Override
    public void createDeveloper(Developer developer) {
        try {
//            connection = Connection.getConnection();
        	conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(CREATE_PERSON);
            pStatement.setInt(1, developer.getId());           
            pStatement.setString(2, developer.getFirstName());
            pStatement.setString(3, developer.getLastName());
            pStatement.setString(4, developer.getUsername());
            pStatement.setString(5, developer.getPassword());
            pStatement.setString(6, developer.getEmail());
            pStatement.setDate(7, developer.getDob());
            pStatement.executeUpdate();
            
            Collection<Phone> phones = developer.getPhones();
            if (phones != null) {
                for (Phone phone : phones) {
                  pStatement = conn.prepareStatement(CREATE_PHONE);
                  pStatement.setString(1, phone.getPhone());
                  pStatement.setBoolean(2, phone.getPrimary());
                  pStatement.setInt(3, developer.getId());
                  pStatement.executeUpdate();
                }
              }

            Collection<Address> addresses = developer.getAddresses();
            if (addresses != null) {
                for (Address address : addresses) {
                  pStatement = conn.prepareStatement(CREATE_ADDRESS);
                  pStatement.setInt(1, developer.getId());
                  pStatement.setString(2, address.getStreet1());
                  pStatement.setString(3, address.getStreet2());
                  pStatement.setString(4, address.getCity());
                  pStatement.setString(5, address.getState());
                  pStatement.setString(6, address.getZip());
                  pStatement.setBoolean(7, address.getPrimary());
                  pStatement.executeUpdate();
                }
              }

            pStatement = conn.prepareStatement(CREATE_DEVELOPER);
            pStatement.setInt(1, developer.getId());
            pStatement.setString(2, developer.getDeveloperKey());
            pStatement.setInt(3, developer.getId());
            pStatement.executeUpdate();
            
        } 
           catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
           } 
        finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
    }

    @Override
    public Collection<Developer> findAllDevelopers() {
    	Collection<Developer> developers = new ArrayList<>();
        try {
        	conn = edu.northeastern.cs5200.Connection.getConnection();
            statement = conn.createStatement();
            rSet = statement.executeQuery(FIND_ALL_DEVELOPERS);
        while (rSet.next()) {
        	int id = rSet.getInt("person");
	    	String firstName = rSet.getString("first_name");
	    	String lastName = rSet.getString("last_name");
	    	String username = rSet.getString("usr_name");
	    	String password = rSet.getString("password");
	    	String email = rSet.getString("email");
	    	Date dob = rSet.getDate("dob");
	    	String developer_key = rSet.getString("developer_key");
	    	Developer developer = new Developer(developer_key, id, firstName, lastName, username, password, email, dob);
	    	developers.add(developer);
          }
        } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        } 
        finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
      return developers;
    }
    
    @Override
    public Developer findDeveloperById(int developerId) {
      Developer developer = null;
      try {
    	  conn = edu.northeastern.cs5200.Connection.getConnection();
          pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_ID);
          pStatement.setInt(1, developerId);
          rSet = pStatement.executeQuery();
          if (rSet.next()) {
        	  String firstName = rSet.getString("first_name");
        	  String lastName = rSet.getString("last_name");
        	  String username = rSet.getString("usr_name");
        	  String password = rSet.getString("password");
        	  String email = rSet.getString("email");
        	  Date dob = rSet.getDate("dob");
        	  String developer_key = rSet.getString("developer_key");
        	  developer = new Developer(developer_key, developerId, firstName, lastName, username, password, email, dob);
          }
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      } 
      finally {
      	edu.northeastern.cs5200.Connection.closeConnection();
        }
      return developer;
    }
    
    @Override
    public Developer findDeveloperByUsername(String username) {
      Developer developer = null;
      try {
    	  conn = edu.northeastern.cs5200.Connection.getConnection();
          pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_USERNAME);
          pStatement.setString(1, username);
          rSet = pStatement.executeQuery();
          if (rSet.next()) {
        	  int id = rSet.getInt("person");
        	  String firstName = rSet.getString("first_name");
        	  String lastName = rSet.getString("last_name");
        	  String password = rSet.getString("password");
        	  String email = rSet.getString("email");
        	  Date dob = rSet.getDate("dob");
        	  String developer_key = rSet.getString("developer_key");
        	  developer = new Developer(developer_key, id, firstName, lastName, username, password, email, dob);
          }
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      } 
      finally {
      	edu.northeastern.cs5200.Connection.closeConnection();
        }
      return developer;
    }
    
    @Override
    public Developer findDeveloperByCredentials(String username, String password) {
      Developer developer = null;
      try {
    	  conn = edu.northeastern.cs5200.Connection.getConnection();
          pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_USERNAME);
          pStatement.setString(1, username);
          pStatement.setString(2, password);
          rSet = pStatement.executeQuery();
          if (rSet.next()) {
        	  int id = rSet.getInt("person");
        	  String firstName = rSet.getString("first_name");
        	  String lastName = rSet.getString("last_name");
        	  String email = rSet.getString("email");
        	  Date dob = rSet.getDate("dob");
        	  String developer_key = rSet.getString("developer_key");
        	  developer = new Developer(developer_key, id, firstName, lastName, username, password, email, dob);
          }
      } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        } 
      finally {
      	edu.northeastern.cs5200.Connection.closeConnection();
        }
      return developer;
    }
    
    
    public int updateDeveloper(int developerId, Developer developer) {
        int res = 0;
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(UPDATE_PERSON);
            pStatement.setString(1, developer.getFirstName());
            pStatement.setString(2, developer.getLastName());
            pStatement.setString(3, developer.getUsername());
            pStatement.setString(4, developer.getPassword());
            pStatement.setString(5, developer.getEmail());
            pStatement.setDate(6, developer.getDob());
            pStatement.setInt(7, developerId);
            res = pStatement.executeUpdate();
            
            pStatement = conn.prepareStatement(UPDATE_DEVELOPER);
            pStatement.setString(1, developer.getDeveloperKey());
            pStatement.setInt(2, developerId);
            res = pStatement.executeUpdate();
            
            Collection<Phone> phones = developer.getPhones();
            pStatement = conn.prepareStatement(DELETE_PHONE);
            pStatement.setInt(1, developer.getId());
            pStatement.executeUpdate();
            if (phones != null) {
                for (Phone phone : phones) {
                  pStatement = conn.prepareStatement(CREATE_PHONE);
                  pStatement.setString(1, phone.getPhone());
                  pStatement.setBoolean(2, phone.getPrimary());
                  pStatement.setInt(3, developer.getId());
                  pStatement.executeUpdate();
                }
              }
            
            Collection<Address> addresses = developer.getAddresses();
            pStatement = conn.prepareStatement(DELETE_ADDRESS);
            pStatement.setInt(1, developer.getId());
            pStatement.executeUpdate();
            if (addresses != null) {
                for (Address address : addresses) {
                  pStatement = conn.prepareStatement(CREATE_ADDRESS);
                  pStatement.setString(1, address.getStreet1());
                  pStatement.setString(2, address.getStreet2());
                  pStatement.setString(3, address.getCity());
                  pStatement.setString(4, address.getState());
                  pStatement.setString(5, address.getZip());
                  pStatement.setBoolean(6, address.getPrimary());
                  pStatement.setInt(7, developer.getId());                
                  pStatement.executeUpdate();
                }
              }
            
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
          } 
    	finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
          return res;
    }
    
    @Override
    public int deleteDeveloper(int developerId) {
      int res = 0;
      try {
    	  conn = edu.northeastern.cs5200.Connection.getConnection();
          pStatement = conn.prepareStatement(DELETE_DEVELOPER);
          pStatement.setInt(1, developerId);
          res = pStatement.executeUpdate();         
          pStatement = conn.prepareStatement(DELETE_PHONE);
          pStatement.setInt(1, developerId);
          pStatement.executeUpdate();
          pStatement = conn.prepareStatement(DELETE_ADDRESS);
          pStatement.setInt(1, developerId);
          pStatement.executeUpdate();
          pStatement = conn.prepareStatement(DELETE_PERSON);
		  pStatement.setInt(1, developerId);
		  pStatement.executeUpdate();
      } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        } 
      finally {
      	edu.northeastern.cs5200.Connection.closeConnection();
        }
        return res;
    }
    
}
