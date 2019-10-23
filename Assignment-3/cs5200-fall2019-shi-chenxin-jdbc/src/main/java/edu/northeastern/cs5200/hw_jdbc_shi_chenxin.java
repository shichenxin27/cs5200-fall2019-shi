package edu.northeastern.cs5200;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import edu.northeastern.cs5200.daos.*;
import edu.northeastern.cs5200.models.*;

public class hw_jdbc_shi_chenxin {

    public static void main(String[] args) {
    	DeveloperDao developerdao = DeveloperDao.getInstance();
	    UserDao userdao = UserDao.getInstance();
	    RoleDao roledao = RoleDao.getInstance();
	    WebsiteDao webdao = WebsiteDao.getInstance();
	    PageDao pagedao = PageDao.getInstance();
	    WidgetDao widgetdao = WidgetDao.getInstance();
	    
//    	CREATE DEVELOPERS AND USERS
    	Developer alice = new Developer("4321rewq", 12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", null);    	
    	Developer bob=new Developer("5432trew", 23, "Bod", "Marley", "bob", "bob", "bob@marley.com", null);
        Developer charlie=new Developer("6543ytre", 34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com", null);    	
        User dan = new User(45, "Dan", "Martin", "dan", "dan", "dan@martin.com", null);
        User ed = new User(56, "Ed", "Karaz", "ed", "ed", "ed@kar.com", null);
        
//        developerdao.createDeveloper(alice);
//        developerdao.createDeveloper(bob);
//        developerdao.createDeveloper(charlie);
//        userdao.createUser(dan);
//        userdao.createUser(ed);
        
//        //CREATE WEBSITES
        Website facebook = new Website(123, "Facebook", "an online social media and social networking service", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 1234234);
        Website twitter = new Website(234, "Twitter", "an online news and social networking service", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 4321543);
        Website wikipedia = new Website(345, "Wikipedia", "a free online encyclopedia", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 3456654);
        Website cnn = new Website(456, "CNN", "an American basic cable and satellite television news channe", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 6543345);
        Website cnet = new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",
				new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 5433455);
        Website gizmodo = new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics",
				new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 4322345);
        
//        webdao.createWebsiteForDeveloper(12, facebook);
//        webdao.createWebsiteForDeveloper(23, twitter);
//        webdao.createWebsiteForDeveloper(34, wikipedia);
//        webdao.createWebsiteForDeveloper(12, cnn);
//        webdao.createWebsiteForDeveloper(23, cnet);
//        webdao.createWebsiteForDeveloper(34, gizmodo);
//        
//        roledao.assignWebsiteRole(12, 123, "owner");
//        roledao.assignWebsiteRole(23, 123, "editor");
//        roledao.assignWebsiteRole(34, 123, "admin");
//        roledao.assignWebsiteRole(23, 234, "owner");
//        roledao.assignWebsiteRole(34, 234, "editor");
//        roledao.assignWebsiteRole(12, 234, "admin");
//        roledao.assignWebsiteRole(34, 345, "owner");
//        roledao.assignWebsiteRole(12, 345, "editor");
//        roledao.assignWebsiteRole(23, 345, "admin");
//        roledao.assignWebsiteRole(12, 456, "owner");
//        roledao.assignWebsiteRole(23, 456, "editor");
//        roledao.assignWebsiteRole(34, 456, "admin");
//        roledao.assignWebsiteRole(23, 567, "owner");
//        roledao.assignWebsiteRole(34, 567, "editor");
//        roledao.assignWebsiteRole(12, 567, "admin");
//        roledao.assignWebsiteRole(34, 678, "owner");
//        roledao.assignWebsiteRole(12, 678, "editor");
//        roledao.assignWebsiteRole(23, 678, "admin");
        
        
//        //CREATE PAGES
        Date semester = Date.valueOf("2019-09-04");
        Date assignment = Date.valueOf("2019-10-20");
        Page home = new Page(123, "Home", "Landing page", semester, assignment, 123434);
        Page about = new Page(234, "About", "Website description", semester, assignment, 234545);
        Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", semester, assignment, 345656);
        Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", semester, assignment, 456776);
        Page profile = new Page(567, "Profile", "Users can configure their personal information", semester, assignment, 567878);
//        
//        pagedao.createPageForWebsite(567, home);
//        pagedao.createPageForWebsite(678, about);
//        pagedao.createPageForWebsite(345, contact);
//        pagedao.createPageForWebsite(456, preferences);
//        pagedao.createPageForWebsite(567, profile);
//        
//        roledao.assignPageRole(12, 123, "editor");
//        roledao.assignPageRole(23, 123, "reviewer");
//        roledao.assignPageRole(34, 123, "writer");
//        roledao.assignPageRole(23, 234, "editor");
//        roledao.assignPageRole(34, 234, "reviewer");
//        roledao.assignPageRole(12, 234, "writer");
//        roledao.assignPageRole(34, 345, "editor");
//        roledao.assignPageRole(12, 345, "reviewer");
//        roledao.assignPageRole(23, 345, "writer");
//        roledao.assignPageRole(12, 456, "editor");
//        roledao.assignPageRole(23, 456, "reviewer");
//        roledao.assignPageRole(34, 456, "writer");
//        roledao.assignPageRole(23, 567, "editor");
//        roledao.assignPageRole(34, 567, "reviewer");
//        roledao.assignPageRole(12, 567, "writer");
    
//        //CREATE WIDGETS
        Widget head123 = new HeadingWidget(1, "head123", 0, 0, null, null, "Welcome", 0);
        Widget post234 = new HtmlWidget(2, "post234", 0, 0, null, null, "<p>Lorem</p>", 0);
        Widget head345 = new HeadingWidget(3, "head345", 0, 0, null, null, "Hi", 1);
        Widget intro456 = new HtmlWidget(4, "intro456", 0, 0, null, null, "<h1>Hi</h1>", 2);
        Widget image345 = new ImageWidget(5, "image345", 50, 100, null, null, null, 3, null, "/img/567.png");
        Widget video456 = new YouTubeWidget(6, "video456", 400, 300, null, null, null, 0, "https://youtube.be/h67VX51QXIQ");

//        widgetdao.createWidgetForPage(123, head123);
//        widgetdao.createWidgetForPage(234, post234);
//        widgetdao.createWidgetForPage(345, head345);
//        widgetdao.createWidgetForPage(345, intro456);
//        widgetdao.createWidgetForPage(345, image345);
//        widgetdao.createWidgetForPage(456, video456);
        
//        //UPDATES
//        //update developer
//        charlie = developerdao.findDeveloperByUsername("charlie");
//        Collection<Phone> phones = charlie.getPhones();
//        Collection<Phone> new_phones = new ArrayList<>();
//        if(phones != null) {
//        	for(Phone phone:phones)
//        	{  
//        	if(phone.getPrimary())
//        	   phone.setPhone("333-444-5555");
//        	new_phones.add(phone);
//        	}
//        }
//        else {
//        	Phone phone1 = new Phone("333-444-5555", true);
//        	new_phones.add(phone1);
//        }
//        charlie.setPhones(new_phones);
//        developerdao.updateDeveloper(charlie.getId(), charlie);
        
//        //update widget
//        Collection<Widget> update_widgets = widgetdao.findAllWidgets();
//        for (Widget widget : update_widgets) {
//        	if (widget.getOrder() != 0) {
//        		widget.setOrder(widget.getOrder() - 1);
//        		widgetdao.updateWidget(widget.getId(), widget);
//        	}
//        }
//        head345 = widgetdao.findWidgetById(head345.getId());
//        head345.setOrder(3);
//        widgetdao.updateWidget(head345.getId(), head345);
//        
        //update page
//        Collection<Page> pages = pagedao.findPagesForWebsite(cnet.getId());
//        for (Page page : pages) {
//            page.setTitle("CNET - " + page.getTitle());
//            pagedao.updatePage(page.getId(), page);
//          }
//        
//        //update roles
//        int charlieID = developerdao.findDeveloperByUsername("charlie").getId();
//		int bobID = developerdao.findDeveloperByUsername("bob").getId();
//		int cnetID = cnet.getId();
//		int pageID = home.getId();
//		roledao.deletePageRole(charlieID, pageID, "writer");
//		roledao.deletePageRole(bobID, pageID, "reviewer");
//		roledao.assignPageRole(charlieID, pageID, "reviewer");
//		roledao.assignPageRole(bobID, pageID, "writer");
//		
//		//DELETES
//		//delete developer
//		alice = developerdao.findDeveloperByUsername("alice");
//		Collection<Address> addresses = alice.getAddresses();
//		if (addresses != null) {
//			for (Address address : addresses) {
//				if (address.getPrimary()) {
//					addresses.remove(address);
//				}
//			}
//		alice.setAddresses(addresses);
//		developerdao.updateDeveloper(alice.getId(), alice);			
//		}
//		
//		//delete widget
		int page_ID = contact.getId();
		Collection<Widget> contact_widgets = widgetdao.findWidgetsForPage(page_ID);
		int latest_order = 0;
		Widget res = null;
		for (Widget c_widget : contact_widgets) {
			int c_order = c_widget.getOrder();
			if (c_order > latest_order) {
				latest_order = c_order;
				res = c_widget;
			}
			
		}
		widgetdao.deleteWidget(res.getId());
//		
//		//delete page
//		int wikiID = wikipedia.getId();
//		Collection<Page> wikiPages = pagedao.findPagesForWebsite(wikiID);
//		Iterator<Page> iter = wikiPages.iterator();
//		Page lastWiki = (Page) iter.next();
//		Date lastTime = lastWiki.getUpdated();
//		
//		for (Page wiki : wikiPages) {
//			Date updatedTime = wiki.getUpdated();
//			if (updatedTime.getTime() > lastTime.getTime()) {
//				lastTime = updatedTime;
//				lastWiki = wiki;
//			}
//		}
//		pagedao.deletePage(lastWiki.getId());
//		
//		//delete website
//		int webID = cnet.getId();
//		roledao.deleteWebsiteRoleByWebsiteID(webID);
//		webdao.deleteWebsite(webID);
//		//triggers and cascade foreign keys applied
//		
		
		
    }	
}
