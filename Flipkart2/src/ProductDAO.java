import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.ProductBean;

public class ProductDAO {
	public ArrayList<ProductBean> getWTopWear(){
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		ArrayList<ProductBean> pl = new ArrayList<ProductBean>();
		
		try {
		Statement st = con.createStatement();
		rs = st.executeQuery("select * from Products where gender = 'F'");
		System.out.println("After Query");
		while(rs.next()) {
			ProductBean pb = new ProductBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6) + rs.getString(7) + rs.getString(8) + rs.getString(9));
		    pl.add(pb);
		    System.out.println(pb);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pl;
		
	}

	public ArrayList<ProductBean> getProduct(String cat) {
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		ArrayList<ProductBean> pl = new ArrayList<ProductBean>();
		
		try {
		Statement st = con.createStatement();
		rs = st.executeQuery("select * from Products where gender = 'F' and category ='" + cat + "'");
		System.out.println("After Query");
		while(rs.next()) {
			ProductBean pb = new ProductBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6) + rs.getString(7) + rs.getString(8) + rs.getString(9));
		    pl.add(pb);
		    System.out.println(pb);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pl;
	}

	public ArrayList<ProductBean> getOmniProducts(String cat, String fil, String db, int val) {
				
		DBConnection dbb = new DBConnection();
		Connection con = dbb.getConnection();
		ResultSet rs;
		ArrayList<ProductBean> pl = new ArrayList<ProductBean>();
		
		try {
		PreparedStatement st = con.prepareStatement("select * from products where pid in(select stock.pid from stock, "+ db + " " + "where (stock.brand, stock.size) in (select " + db +".brand, " + db + ".size from " + db + " where " + fil + " in(?,?,?)) and stock.stock > 0)");
		st.setInt(1, val - 1);
		st.setInt(2, val);
		st.setInt(3, val + 1);
		
		rs = st.executeQuery();
		System.out.println("After Query");
		while(rs.next()) {
			ProductBean pb = new ProductBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6) + rs.getString(7) + rs.getString(8) + rs.getString(9));
		    pl.add(pb);
		    System.out.println(pb);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pl;
	}

	public ProductBean getSingleProduct(int pid) {
		DBConnection dbb = new DBConnection();
		Connection con = dbb.getConnection();
		ResultSet rs;
		ProductBean pb = new ProductBean();
		
		try {
		PreparedStatement ps = con.prepareStatement("select * from Products where pid=?");
		ps.setInt((1), pid);
		rs = ps.executeQuery();
		System.out.println("After Query");
		if(rs.next()) {
			pb.setPid(rs.getInt(1));
			pb.setGender(rs.getString(2));
			pb.setBrand(rs.getString(3));
			pb.setCategory(rs.getString(4));
			pb.setType(rs.getString(5));
			pb.setDescription(rs.getString(6));
			pb.setColor(rs.getString(7));
			pb.setPrice(rs.getString(8));
			pb.setImage(rs.getString(9));
			System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6) + rs.getString(7) + rs.getString(8) + rs.getString(9));
		    
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pb;
		
	}

	public ArrayList<String> getSizes(int pid) {
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		ArrayList<String> sizes  = new ArrayList<String>();
		try {
		PreparedStatement ps = con.prepareStatement("select size from Stock where pid=? and stock > 0");
		ps.setInt((1), pid);
		 
		rs = ps.executeQuery();
		while(rs.next()) {
			sizes.add(rs.getString(1));		
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sizes;
	}

	public ArrayList<ProductBean> getOmniShoeProducts(String cat, String fil, String db, Float val) {
		DBConnection dbb = new DBConnection();
		Connection con = dbb.getConnection();
		ResultSet rs;
		ArrayList<ProductBean> pl = new ArrayList<ProductBean>();
		
		try {
		PreparedStatement st = con.prepareStatement("select * from products where pid in(select stock.pid from stock, "+ db + " " + "where (stock.brand, stock.size) in (select " + db +".brand, " + db + ".size from " + db + " where " + fil + " - " + val + "between -0.2 and 0.2 and stock.stock > 0)");
		rs = st.executeQuery();
		System.out.println("After Query");
		while(rs.next()) {
			ProductBean pb = new ProductBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6) + rs.getString(7) + rs.getString(8) + rs.getString(9));
		    pl.add(pb);
		    System.out.println(pb);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pl;
	}
	}
	
	
	


