package com.jspider.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.phone.connection.PhoneConnection;
import com.jspider.phone.dto.Contact;

public class ContactDao {
    Connection connection = PhoneConnection.getDirectoryConnection();

    public boolean saveContact(Contact contact) {
        String insertQry = "INSERT INTO contact(name, email, phone, about, userId) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(insertQry);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getPhone_no());
            ps.setString(4, contact.getAbout());
            ps.setInt(5, contact.getUserId());

            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Contact> getAllContactDetails(int userId) {
        String selectQry = "SELECT * FROM Contact WHERE userId=?";
        try {
            List<Contact> list = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(selectQry);
            ps.setInt(1, userId);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
            	int cId=result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String phoneNo = result.getString("phone");
                String about = result.getString("about");
                int userId1 = result.getInt("userId");

                Contact contact = new Contact(cId, name, email, phoneNo, about, userId1);
                list.add(contact);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Contact getContactDetail(int userId) {
        String selectQry = "SELECT * FROM Contact WHERE id=?";
      
        try {
            PreparedStatement ps = connection.prepareStatement(selectQry);
            ps.setInt(1, userId);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
            	int cId=result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String phoneNo = result.getString("phone");
                String about = result.getString("about");
                int userId1 = result.getInt("userId");

                return new Contact(cId, name, email, phoneNo, about, userId1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateContactDetails(Contact c) {
        String updateQry = "UPDATE contact SET name=?, email=?, phone=?, about=? WHERE Id=?";
        System.out.println(c);
        try {
            PreparedStatement ps = connection.prepareStatement(updateQry);
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhone_no());
            ps.setString(4, c.getAbout());
            ps.setInt(5, c.getId());
            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteContactDetails(int cId) {
		String deleteQry="Delete from contact where id=?";
		try {
			PreparedStatement ps =connection.prepareStatement(deleteQry);
			ps.setInt(1, cId);
		    System.out.println(cId);
			int result=ps.executeUpdate();
			 if (result > 0) {
	                return true;
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
