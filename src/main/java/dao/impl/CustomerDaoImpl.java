package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CustomerDao;
import entity.Customer;
import util.ConnectionFactory;

public class CustomerDaoImpl implements CustomerDao {
	
	public boolean query(Customer customer) throws SQLException {
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = cf.makeConnection();
		PreparedStatement ps = conn.prepareCall("select * from customer where first_name = ?");
		ps.setString(1, customer.getName());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return true;
		}else {
			return false;
		}
		
	}

}
