package dao;
import java.sql.SQLException;
import entity.Customer;

public interface CustomerDao {
	boolean query(Customer customer)throws SQLException;
}
