package edu.northeastern.cs5200.daos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;

public class PageDao implements PageImpl {

	private static PageDao instance = null;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;
	
	private PageDao() {}
	
	public static PageDao getInstance() {
	    if (instance == null)
	      instance = new PageDao();
	    return instance;
	}
	
	private final String CREATE_PAGE = "INSERT INTO `page` (id, title, description, created, updated, views, website) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String FIND_ALL_PAGES = "SELECT * FROM `page`";
	private final String FIND_PAGE_BY_ID = "SELECT * FROM `page` WHERE id=?";
	private final String FIND_PAGES_FOR_WEBSITE = "SELECT * FROM `page` WHERE website=?";
	private final String UPDATE_PAGE = "UPDATE `page` set id=?, title=?, description=?, created=?, updated=?, views=? WHERE id=?";
	private final String DELETE_PAGE = "DELETE FROM `page` WHERE id=?";
	
	@Override
	public void createPageForWebsite(int websiteId, Page page) {
        try {
        	conn = edu.northeastern.cs5200.Connection.getConnection();
			pStatement = conn.prepareStatement(CREATE_PAGE);
			pStatement.setInt(1, page.getId());
		    pStatement.setString(2, page.getTitle());
		    pStatement.setString(3, page.getDescription());
		    pStatement.setDate(4, page.getCreated());
		    pStatement.setDate(5, page.getUpdated());
		    pStatement.setInt(6, page.getViews());
		    pStatement.setInt(7, websiteId);
		    pStatement.executeUpdate();
        	
        } catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
        finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	}
	
	@Override
	public Collection<Page> findAllPages() {
        Collection<Page> pages = new ArrayList<>();
        try {
        	conn = edu.northeastern.cs5200.Connection.getConnection();
            statement = conn.createStatement();
            rSet = statement.executeQuery(FIND_ALL_PAGES);
            while (rSet.next()) {
            	int id = rSet.getInt("id");
                String title = rSet.getString("title");
                String description = rSet.getString("description");
                Date created = rSet.getDate("created");
                Date updated = rSet.getDate("updated");
                int views = rSet.getInt("views");
                Page page = new Page(id, title, description, created, updated, views);
                pages.add(page);
              }
        } catch (SQLException e) {
	           e.printStackTrace();
	           } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	      return pages;
    }
	
	@Override
	public Page findPageById(int pageId) {
	    Page page = null;
	    try {
	    	conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(FIND_PAGE_BY_ID);
            pStatement.setInt(1, pageId);
            rSet = pStatement.executeQuery();
	    	while (rSet.next()) {
                int id = rSet.getInt("id");
                String title = rSet.getString("title");
                String description = rSet.getString("description");
                Date created = rSet.getDate("created");
                Date updated = rSet.getDate("updated");
                int views = rSet.getInt("views");
                page = new Page(id, title, description, created, updated, views);
	    	}
	    }catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
	    finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	      return page;
	}
	
	@Override
	  public Collection<Page> findPagesForWebsite(int websiteId) {
		  Collection<Page> pages = new ArrayList<>();
	      try {
	    	  conn = edu.northeastern.cs5200.Connection.getConnection();
	      	  pStatement = conn.prepareStatement(FIND_PAGES_FOR_WEBSITE);
	          pStatement.setInt(1, websiteId);
	          rSet = pStatement.executeQuery();
	          while (rSet.next()) {
	        	  int id = rSet.getInt("id");
	        	  String title = rSet.getString("title");
	        	  String description = rSet.getString("description");
	        	  Date created = rSet.getDate("created");
	        	  Date updated = rSet.getDate("updated");
	        	  int views = rSet.getInt("views");
	        	  Page page = new Page(id, title, description, created, updated, views);
	        	  pages.add(page);
	          }
	      }catch (SQLException | ClassNotFoundException e) {
	    	  e.printStackTrace();
           } 
	      finally {
	        	edu.northeastern.cs5200.Connection.closeConnection();
	          }
      return pages;
	}

	@Override
	public int updatePage(int pageId, Page page) {
		int res = 0;
    	try {
    		conn = edu.northeastern.cs5200.Connection.getConnection();
	      	pStatement = conn.prepareStatement(UPDATE_PAGE);
		    pStatement.setInt(1, page.getId());
		    pStatement.setString(2, page.getTitle());
		    pStatement.setString(3, page.getDescription());
		    pStatement.setDate(4, page.getCreated());
		    pStatement.setDate(5, page.getUpdated());
		    pStatement.setInt(6, page.getViews());
		    pStatement.setInt(7, pageId);		    
		    res=pStatement.executeUpdate();		    		    
    	} catch (SQLException | ClassNotFoundException e) {
	    	  e.printStackTrace();
          } 
    	finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	      return res;
	}
	
	@Override
	public int deletePage(int pageId) {
		int res = 0;
        try {
        	conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(DELETE_PAGE);
            pStatement.setInt(1, pageId);
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
