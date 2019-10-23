package edu.northeastern.cs5200.daos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Role;

public class RoleDao implements RoleImpl {
	
	private static RoleDao instance = null;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;
	
	private RoleDao() {}
	
	public static RoleDao getInstance() {
	    if (instance == null)
	      instance = new RoleDao();
	    return instance;
	}
	
	private final String ASSIGN_WEBSITE_ROLE = "INSERT INTO `website_role` (`developer`, `website`, `role`) VALUE (?, ?, ?)";
	private final String ASSIGN_PAGE_ROLE = "INSERT INTO `page_role`(`developer`, `page`, `role`) VALUES (?, ?, ?)";
	private final String DELETE_WEBSITE_ROLE = "DELETE FROM `website_role` WHERE `developer` = ? AND `website` = ? AND `role` = ?";
    private final String DELETE_PAGE_ROLE = "DELETE FROM `page_role` WHERE `developer` = ? AND `page` = ? AND `role` = ?";
    private final String DELETE_WEBSITE_ROLE_BY_WEBID = "DELETE FROM `website_role` WHERE `website` = ?"; 
    
    @Override
    public void assignWebsiteRole(int developerId, int websiteId, String roleId) {
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(ASSIGN_WEBSITE_ROLE);          
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, websiteId);
            pStatement.setString(3, roleId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
        }
    }
    
    @Override
    public void assignPageRole(int developerId, int pageId, String roleId) {	
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(ASSIGN_PAGE_ROLE);          
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, pageId);
            pStatement.setString(3, roleId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
        }
    }
    
    @Override
    public void deleteWebsiteRole(int developerId, int websiteId, String roleId) {
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(DELETE_WEBSITE_ROLE);          
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, websiteId);
            pStatement.setString(3, roleId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
        }
    }
    
    @Override
    public void deletePageRole(int developerId, int pageId, String roleId) {
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(DELETE_PAGE_ROLE);          
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, pageId);
            pStatement.setString(3, roleId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
        }
    }
    
    @Override
    public void deleteWebsiteRoleByWebsiteID(int websiteId) {
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(DELETE_WEBSITE_ROLE_BY_WEBID);          
            pStatement.setInt(1, websiteId);
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
        }
    }
}
