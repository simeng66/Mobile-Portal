package util;
import java.sql.*;

public class DBHelper {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/simeng1";
	private static final String username="root";
	private static final String password="root";
	private static Connection con=null;
	
	//静态代码块负责加载驱动
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static Connection getConnection(){
		if(con==null){
				try {
					con=DriverManager.getConnection(url,username,password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return con;			
		}
		else{
			return con;
		}
	}
	
	
	
}
