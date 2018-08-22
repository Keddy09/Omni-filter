import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.CustomerBean;

public class CustomerDAO {

	public boolean register(CustomerBean cb) {
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Customer values(?, ?, ?, ?, ?)");
			ps.setString(1, cb.getEmail());
			ps.setString(2, cb.getFname());
			ps.setString(3, cb.getLname());
			ps.setString(4, cb.getPhone());
			ps.setString(5, cb.getPwd());
			System.out.println("Query made");
			if(ps.executeUpdate() == 1) {
				System.out.println("Query executed");
				return true;				
			}else
				return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public boolean exists(CustomerBean cb) {
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("select email from Customer where email = ?");
			ps.setString(1, cb.getEmail());
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getString(1).equals(null))
				return false;
			else 
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean isValid(CustomerBean cb) {
		
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Customer where email = ? and pwd = ?");
			ps.setString(1, cb.getEmail());
			ps.setString(2,cb.getPwd());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getString(1).equals(null))
				return false;
			else 
				return true;
		}catch(Exception e) {}
		return false;
	}

	public CustomerBean getProfile(String email) {
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("select fname, lname, phone from Customer where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
		    rs.next();
		    CustomerBean cb = new CustomerBean(email, rs.getString(1), rs.getString(2), rs.getString(3));
				return cb;
		}catch(Exception e) {}
		return null;
		
	}
	
	
	

}
