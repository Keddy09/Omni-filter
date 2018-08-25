import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import beans.OmniBean;
import beans.ProductBean;

public class OmniDAO {

	public boolean saveFilter(OmniBean ob) {
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into OmniFilter(email, name, gender, shoulder, bust, waist, hip, shoe) values(?, ?, ?, ?, ?, ?, ?, ? )");
			ps.setString(1, ob.getEmail());
			ps.setString(2, ob.getName());
			ps.setString(3, ob.getGender());
			ps.setInt(4, ob.getShoulder());
			ps.setInt(5, ob.getBust());
			ps.setInt(6, ob.getWaist());
			ps.setInt(7, ob.getHip());
			ps.setFloat(8, ob.getShoe());
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

	public ArrayList<OmniBean> getFilters(String email) {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			ResultSet rs;
			ArrayList<OmniBean> ol = new ArrayList<OmniBean>();
			
			try {
			PreparedStatement ps = con.prepareStatement("select fid, name from OmniFilter where email = ?");
			ps.setString(1, email);
			rs = ps.executeQuery();
		//	System.out.println("After Query");
			while(rs.next()) {
				OmniBean ob = new OmniBean();		
				ob.setFid(rs.getInt(1));
				ob.setName(rs.getString(2));
				ol.add(ob);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		//	for(OmniBean obb : ol)
		    	//System.out.println(obb.getFid());
			return ol;
	}

	public OmniBean getFilter(int fid) {
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		OmniBean ob = new OmniBean();
		System.out.println("! filter chosen");
		try {
		PreparedStatement ps = con.prepareStatement("select * from OmniFilter where fid = ?");
		ps.setInt(1, fid);
		rs = ps.executeQuery();
		System.out.println("After Query");
		if(rs.next()) {
			ob.setEmail(rs.getString(1));
			ob.setName(rs.getString(2));
			ob.setGender(rs.getString(3));
			ob.setShoulder(rs.getInt(4));
			ob.setBust(rs.getInt(5));
			ob.setWaist(rs.getInt(6));
			ob.setHip(rs.getInt(7));
			ob.setShoe(rs.getFloat(8));
			ob.setFid(rs.getInt(9));
		    System.out.println(ob);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ob;
		
	}

		public boolean deleteFilter(int fid){
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from OmniBean where fid = ?");
			ps.setInt(1, fid);
			
			if(ps.executeUpdate() == 1)
				return true;
			else 
				return false;
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public ArrayList<OmniBean> showFilters( String email){
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		ArrayList<OmniBean> ol = new ArrayList<OmniBean>();
		
		try {
		PreparedStatement ps = con.prepareStatement("select * from OmniFilter where email = ?");
		ps.setString(1, email);
		rs = ps.executeQuery();
	
		while(rs.next()) {
			OmniBean ob = new OmniBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getFloat(8), rs.getInt(9));		
			ol.add(ob);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ol;

		
	}

	

}
