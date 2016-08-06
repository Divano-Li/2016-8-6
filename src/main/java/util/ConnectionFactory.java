package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private Connection conn;
	
	//创建单例模式的factory
	private static final ConnectionFactory factory = new ConnectionFactory();
	private ConnectionFactory(){
		
	}
	public  static ConnectionFactory getInstance(){
		return factory; 
	}
	//静态代码块 可以初始化类，为类的属性赋值。当jvm加载类的时候，静态代码块被执行，因为是在加载类时候被执行，所以只执行一次
	static {
		try {
			Properties prop  = new Properties();
			InputStream in = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			prop.load(in);
			driver = prop.getProperty("driver");
			dburl  =prop.getProperty("dburl");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("=====配置文件错误====");
		}
				
	}
	//获取数据库连接的方法
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,user,password);
		} catch (SQLException e) {
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
}
