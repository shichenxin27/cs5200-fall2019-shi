package edu.northeastern.cs5200.daos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Phone;

public class UserDao implements UserImpl {

	private static UserDao instance = null;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;
	
	private UserDao() {}
	
	public static UserDao getInstance() {
	    if (instance == null)
	      instance = new UserDao();
	    return instance;
	}
	
	private final String CREATE_PERSON = "INSERT INTO `person` (`id`, `first_name`, `last_name`, `usr_name`, `password`, `email`, `dob`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String CREATE_PHONE = "INSERT INTO `phone`(`phone`, `primary`, `person`) VALUES (?, ?, ?);";
    private final String CREATE_ADDRESS = "INSERT INTO `address`(`street1`,`street2`,`city`,`state`,`zip`,`primary`,`person`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String CREATE_USER = "INSERT INTO `user`(`id`, `user_agreement`, `person`) VALUES (?, ?, ?);";
    
    @Override
    public void createUser(User user) {
        try {
        	conn = edu.northeastern.cs5200.Connection.getConnection();
            pStatement = conn.prepareStatement(CREATE_PERSON);
            pStatement.setInt(1, user.getId());
            pStatement.setString(2, user.getFirstName());
            pStatement.setString(3, user.getLastName());
            pStatement.setString(4, user.getUsername());
            pStatement.setString(5, user.getPassword());
            pStatement.setString(6, user.getEmail());
            pStatement.setDate(7, user.getDob());
            pStatement.executeUpdate();
            
            Collection<Phone> phones = user.getPhones();
            if (phones != null) {
                for (Phone phone : phones) {
                  pStatement = conn.prepareStatement(CREATE_PHONE);
                  pStatement.setString(1, phone.getPhone());
                  pStatement.setBoolean(2, phone.getPrimary());
                  pStatement.setInt(3, user.getId());
                  pStatement.executeUpdate();
                }
              }

            Collection<Address> addresses = user.getAddresses();
            if (addresses != null) {
                for (Address address : addresses) {
                  pStatement = conn.prepareStatement(CREATE_ADDRESS);
                  pStatement.setInt(1, user.getId());
                  pStatement.setString(2, address.getStreet1());
                  pStatement.setString(3, address.getCity());
                  pStatement.setString(4, address.getZip());
                  pStatement.setBoolean(5, address.getPrimary());
                  pStatement.executeUpdate();
                }
              }

            pStatement = conn.prepareStatement(CREATE_USER);
            pStatement.setInt(1, user.getId());
            pStatement.setBoolean(2, user.getUserAgreement());
            pStatement.setInt(3, user.getId());
            pStatement.executeUpdate();
            
        } 
           catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
           } 
        finally {
        	edu.northeastern.cs5200.Connection.closeConnection();
          }
    }

    
	
	
}
