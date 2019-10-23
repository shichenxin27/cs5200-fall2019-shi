package edu.northeastern.cs5200.daos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Website;

public class WebsiteDao implements WebsiteImpl {

	private static WebsiteDao instance = null;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;
	
	private WebsiteDao() {}
	
	public static WebsiteDao getInstance() {
	    if (instance == null)
	      instance = new WebsiteDao();
	    return instance;
	}
	
	private final String CREATE_WEBSITE = "INSERT INTO `website` (`id`, `name`, `description`, `created`, `updated`, `visits`) VALUES (?, ?, ?, ?, ?, ?)";
	private final String FIND_ALL_WEBSITES = "SELECT * FROM `website`";
	private final String FIND_WEBSITES_FOR_DEVELOPER = "SELECT * FROM `website` WHERE (`id` IN (SELECT `website` FROM `website_role` WHERE(`developer`=?));";
	private final String FIND_WEBSITE_BY_ID = "SELECT * FROM `website` WHERE id=?";
	private final String UPDATE_WEBSITE = "UPDATE `website` SET `name`=?, `description`=?, `created`=?, `updated`=?, `visits`=? WHERE `id`=?";
	private final String DELETE_WEBSITE = "DELETE FROM `website` WHERE `id`=?";
	
	@Override
	public void createWebsiteForDeveloper(int developerId, Website website) {
		try {
			conn = edu.northeastern.cs5200.Connection.getConnection();
			pStatement = conn.prepareStatement(CREATE_WEBSITE);
			pStatement.setInt(1, website.getId());
			pStatement.setString(2, website.getName());
			pStatement.setString(3, website.getDescription());
			pStatement.setDate(4, website.getCreated());
			pStatement.setDate(5, website.getUpdated());
			pStatement.setInt(6, website.getVisits());
			pStatement.executeUpdate();
	    } catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
		finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	  }
	
	@Override
	public Collection<Website> findAllWebsites() {
		Collection<Website> websites = new ArrayList<>();
		try {
			conn = edu.northeastern.cs5200.Connection.getConnection();
			statement = conn.createStatement();
            rSet = statement.executeQuery(FIND_ALL_WEBSITES);
            while(rSet.next()) {
		    	int id = rSet.getInt("id");
		    	String name = rSet.getString("name");
		    	String description = rSet.getString("description");
		    	Date created = rSet.getDate("created");
		    	Date updated = rSet.getDate("updated");
		    	int  visits = rSet.getInt("visits");
		    	Website website=new Website(id, name, description, created, updated, visits);
		    	websites.add(website);
            }
		} catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
		finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	      return websites;
	}
	
	@Override
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		Collection<Website> websites = new ArrayList<>();
		try {
			conn = edu.northeastern.cs5200.Connection.getConnection();
			pStatement = conn.prepareStatement(FIND_WEBSITES_FOR_DEVELOPER);
            pStatement.setInt(1, developerId);
            rSet = pStatement.executeQuery(FIND_ALL_WEBSITES);
            while(rSet.next()) {
		    	int id = rSet.getInt("id");
		    	String name = rSet.getString("name");
		    	String description = rSet.getString("description");
		    	Date created = rSet.getDate("created");
		    	Date updated = rSet.getDate("updated");
		    	int  visits = rSet.getInt("visits");
		    	Website website=new Website(id, name, description, created, updated, visits);
		    	websites.add(website);
            }
		} catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
		finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	      return websites;
		
	}
	
	@Override
	  public Website findWebsiteById(int websiteId) {
	    Website website = null;
	    try {
	    	conn = edu.northeastern.cs5200.Connection.getConnection();
	    	pStatement = this.conn.prepareStatement(FIND_WEBSITE_BY_ID);
	    	pStatement.setInt(1, websiteId);
	    	rSet = pStatement.executeQuery();
	    	while(rSet.next()) {
		    	int id = rSet.getInt("id");
		    	String name = rSet.getString("name");
		    	String description = rSet.getString("description");
		    	Date created = rSet.getDate("created");
		    	Date updated = rSet.getDate("updated");
		    	int  visits = rSet.getInt("visits");
		    	website=new Website(id, name, description, created, updated, visits);
            }
	    } catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
	    finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	      return website;
	}
	
	@Override
	public int updateWebsite(int websiteId, Website website) {
		int res = 0;
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
	    	pStatement = this.conn.prepareStatement(UPDATE_WEBSITE);
	    	pStatement.setString(1, website.getName());
            pStatement.setString(2, website.getDescription());
            pStatement.setDate(3, website.getCreated());
            pStatement.setDate(4, website.getUpdated());
            pStatement.setInt(5, website.getVisits());
            pStatement.setInt(6, websiteId);
            res = pStatement.executeUpdate();
    	} catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
    	finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	      return res;
	}
	
	@Override
	public int deleteWebsite(int websiteId) {
		int res = 0;
		try {
			conn = edu.northeastern.cs5200.Connection.getConnection();
	    	pStatement = this.conn.prepareStatement(DELETE_WEBSITE);
	    	pStatement.setInt(1, websiteId);
	    	res = pStatement.executeUpdate();
	    	
		} catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
		finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	      return res;
	}
	
}
