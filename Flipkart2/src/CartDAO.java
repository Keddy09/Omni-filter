import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.CartBean;
import beans.OmniBean;

public class CartDAO {

	public ArrayList<CartBean> getCartProducts(String email) {
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		ArrayList<CartBean> cl = new ArrayList<CartBean>();
		
		try {
		PreparedStatement ps = con.prepareStatement("select pid, size from  where email = ?");
		ps.setString(1, email);
		rs = ps.executeQuery();
	//	System.out.println("After Query");
		while(rs.next()) {
			CartBean ob = new CartBean();		
			ob.setFid(rs.getInt(1));
			ob.setName(rs.getString(2));
			cl.add(ob);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	//	for(OmniBean obb : cl)
	    	//System.out.println(obb.getFid());
		return cl;
	}

}
