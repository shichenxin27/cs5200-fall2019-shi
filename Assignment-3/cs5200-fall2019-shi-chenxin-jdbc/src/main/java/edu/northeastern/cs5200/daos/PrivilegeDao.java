package edu.northeastern.cs5200.daos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Privilege;

public class PrivilegeDao implements PrivilegeImpl {

	private static PrivilegeDao instance = null;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;
	
	private PrivilegeDao() {}
	
	public static PrivilegeDao getInstance() {
	    if (instance == null)
	      instance = new PrivilegeDao();
	    return instance;
	}
	
	private final String ASSIGN_WEBSITE_PRIVILEGE = "INSERT INTO `website_privilege`(privilege, developer, website) VALUES (?, ?, ?)";
	private final String ASSIGN_PAGE_PRIVILEGE = "INSERT INTO `page_privilege`(privilege, developer, page) VALUES (?, ?, ?)";
	private final String DELETE_WEBSITE_PRIVILEGE = "DELETE FROM `website_privilege` WHERE privilege = ? AND developer = ? AND website = ?";
    private final String DELETE_PAGE_PRIVILEGE = "DELETE FROM `page_privilege` WHERE privilege = ? AND developer = ? AND page = ?";
	
    @Override
    public void assignWebsitePrivilege(int developerId, int websiteId, String privilege) {
        try {
        	conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(ASSIGN_WEBSITE_PRIVILEGE);
            pStatement.setString(1, privilege);
            pStatement.setInt(2, developerId);
            pStatement.setInt(3, websiteId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
          }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
    }
    
    @Override
    public void assignPagePrivilege(int developerId, int pageId, String privilege) {
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(ASSIGN_PAGE_PRIVILEGE);
            pStatement.setString(1, privilege);
            pStatement.setInt(2, developerId);
            pStatement.setInt(3, pageId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
          }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
    }
    
    @Override
    public void deleteWebsitePrivilege(int developerId, int websiteId, String privilege) {
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(DELETE_WEBSITE_PRIVILEGE);
            pStatement.setString(1, privilege);
            pStatement.setInt(2, developerId);
            pStatement.setInt(3, websiteId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
          }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
    }
    
    @Override
    public void deletePagePrivilege(int developerId, int pageId, String privilege) {
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(DELETE_PAGE_PRIVILEGE);
            pStatement.setString(1, privilege);
            pStatement.setInt(2, developerId);
            pStatement.setInt(3, pageId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
          }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
    }
    
}
