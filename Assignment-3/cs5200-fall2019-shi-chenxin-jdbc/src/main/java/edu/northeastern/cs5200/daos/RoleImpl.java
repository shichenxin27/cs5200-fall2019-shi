package edu.northeastern.cs5200.daos;

public interface RoleImpl {
	  void assignWebsiteRole(int developerId, int websiteId, String roleId);
	  void assignPageRole(int developerId, int pageId, String roleId);
	  void deleteWebsiteRole(int developerId, int websiteId, String roleId);
	  void deletePageRole(int developerId, int pageId, String roleId);
	  void deleteWebsiteRoleByWebsiteID(int websiteId);
	}