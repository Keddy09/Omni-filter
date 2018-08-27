import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.WSBean;

public class WSDAO {
	
public ArrayList<WSBean> getChart(String brand) {
		
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		ArrayList<WSBean> pl = new ArrayList<WSBean>();
		
		try {
		PreparedStatement st = con.prepareStatement("select * from wssizechart where brand = ?");
		st.setString(1, brand);
		rs = st.executeQuery();
		while(rs.next()) {
			WSBean pb = new WSBean(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4));
			System.out.println(rs.getString(1)+ rs.getInt(2)+ rs.getInt(3)+ rs.getFloat(4));
		    pl.add(pb);
		    System.out.println(pb);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pl;
	}

}
