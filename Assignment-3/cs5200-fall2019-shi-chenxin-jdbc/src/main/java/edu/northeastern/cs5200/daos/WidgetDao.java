package edu.northeastern.cs5200.daos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.YouTubeWidget;

public class WidgetDao implements WidgetImpl {

	private static WidgetDao instance = null;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;
	
	private WidgetDao() {}
	
	public static WidgetDao getInstance() {
	    if (instance == null)
	      instance = new WidgetDao();
	    return instance;
	}
	
	private final String CREATE_WIDGET = "INSERT INTO `widget` (`id`, `name`, `width`, `height`, `css_class`, `css_style`, `text`, `order`, "
			+ " `size`, `html`, `src`, `url`, `shareble`, `expandable`, `dtype`, `page`) VALUES (?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String FIND_ALL_WIDGETS = "SELECT * FROM `widget`;";
	private final String FIND_WIDGET_BY_ID = "SELECT * FROM `widget` WHERE `id`=?;";
	private final String FIND_WIDGETS_FOR_PAGE = "SELECT * FROM `widget` WHERE `page`=?;";
	private final String UPDATE_WIDGET = "UPDATE `widget` SET `name`=?, `width`=?, `height`=?, `css_class`=?, `css_style`=?, `text`=?, `order`=?, "
			+ " `size`=?, `html`=?, `src`=?, `url`=?, `shareble`=?, `expandable`=?, `dtype`=?, `page`=? WHERE `id`=?";
	private final String DELETE_WIDGET = "DELETE FROM widget WHERE id=?";

	private Widget GetWidget() throws SQLException {
		int id = rSet.getInt("id");
        String name = rSet.getString("name");
        int width = rSet.getInt("width");
        int height = rSet.getInt("height");
        String cssClass = rSet.getString("css_class");
        String cssStyle = rSet.getString("css_style");
        String text = rSet.getString("text");
        int order = rSet.getInt("order");        				
		String dtype = rSet.getString("dtype");
        int pageId = rSet.getInt("page");
        Widget widget = null;
        //System.out.println(dtype);
        
        if (dtype.equals("youtube")) {
        	String url = rSet.getString("url");
        	boolean shareble = rSet.getBoolean("shareble");
        	boolean expandable = rSet.getBoolean("expandable");
        	widget = new YouTubeWidget(id, name, width, height, cssClass, cssStyle, text, order, url, shareble, expandable, pageId);
        }
        else if (dtype.equals("image")) {
        	String src = rSet.getString("src");
        	widget = new ImageWidget(id, name, width, height, cssClass, cssStyle, text, order, src, pageId);
        }
        else if (dtype.equals("heading")) {
        	int size = rSet.getInt("size");
        	widget = new HeadingWidget(id, name, width, height, cssClass, cssStyle, text, order, size, pageId);
        }
        else if (dtype.equals("html")) {
        	String html = rSet.getString("html");
        	widget = new HtmlWidget(id, name, width, height, cssClass, cssStyle, text, order, html, pageId);
        }
        return widget;
	}
	
	@Override
	public void createWidgetForPage(int pageId, Widget widget) {
        try {
        	conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(CREATE_WIDGET);
            pStatement.setInt(1, widget.getId());
            pStatement.setString(2, widget.getName());
            pStatement.setInt(3, widget.getWidth());
            pStatement.setInt(4, widget.getHeight());
            pStatement.setString(5, widget.getCssClass());
            pStatement.setString(6, widget.getCssStyle());
            pStatement.setString(7, widget.getText());
            pStatement.setInt(8, widget.getOrder());			
            pStatement.setInt(9, widget.getSize());
            pStatement.setString(10, widget.getHtml());
            pStatement.setString(11, widget.getSrc());
			pStatement.setString(12, widget.getUrl());
            pStatement.setBoolean(13, widget.getShareble());
            pStatement.setBoolean(14, widget.getExpandable());
			pStatement.setString(15, widget.getDtype());
            pStatement.setInt(16, pageId);
            
            pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
        finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }

    }
	
	@Override
	  public Collection<Widget> findAllWidgets() {
		  Collection<Widget> widgets = new ArrayList<>();
	      try {
	    	  conn = edu.northeastern.cs5200.Connection.getConnection();
	          statement = conn.createStatement();
	          rSet = statement.executeQuery(FIND_ALL_WIDGETS);
	        while (rSet.next()) {
	        	Widget widget = GetWidget();
	            widgets.add(widget);
	        }
	      } catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
	      finally {
	        	edu.northeastern.cs5200.Connection.closeConnection();
	          }
	      return widgets;
	  }
	
	@Override
	  public Widget findWidgetById(int widgetId) {
	    Widget widget = null;
	    try {
	    	conn = edu.northeastern.cs5200.Connection.getConnection();
	        pStatement = conn.prepareStatement(FIND_WIDGET_BY_ID);
	        pStatement.setInt(1, widgetId);
	        rSet = pStatement.executeQuery();
	        while (rSet.next()) {
	        	widget = GetWidget();
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
	    finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }  
	    return widget;
	  }

	@Override
	  public Collection<Widget> findWidgetsForPage(int pageId) {
	    Collection<Widget> widgets = new ArrayList<>();
	    try {
	    	conn = edu.northeastern.cs5200.Connection.getConnection();
	        pStatement = this.conn.prepareStatement(FIND_WIDGETS_FOR_PAGE);
	        pStatement.setInt(1, pageId);
	        rSet = this.pStatement.executeQuery();
	        while (rSet.next()) {
	          Widget widget = GetWidget();
	          widgets.add(widget);
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	           e.printStackTrace();
	           } 
	    finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
	    return widgets;
	  }

	@Override
	public int updateWidget(int widgetId, Widget widget) {
        int res = 0;
		try {
			conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(UPDATE_WIDGET);
            
            pStatement.setString(1, widget.getName());
            pStatement.setInt(2, widget.getWidth());
            pStatement.setInt(3, widget.getHeight());
            pStatement.setString(4, widget.getCssClass());
            pStatement.setString(5, widget.getCssStyle());
            pStatement.setString(6, widget.getText());
            pStatement.setInt(7, widget.getOrder());			
            pStatement.setInt(8, widget.getSize());
            pStatement.setString(9, widget.getHtml());
            pStatement.setString(10, widget.getSrc());
			pStatement.setString(11, widget.getUrl());
            pStatement.setBoolean(12, widget.getShareble());
            pStatement.setBoolean(13, widget.getExpandable());
			pStatement.setString(14, widget.getDtype());
            pStatement.setInt(15, widget.getPageId());
            pStatement.setInt(16, widgetId);
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
	public int deleteWidget(int widgetId) {
		int res = 0;
        try {
        	conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(DELETE_WIDGET);
            pStatement.setInt(1, widgetId);
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
