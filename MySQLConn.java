import java.sql.*;

public class MySQLConn{
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://192.168.63.58:3306/project?verifyServerCertificate=false&useSSL=true";
	
	private final String USER_NAME = "root";
	private final String PASSWORD = "dlstkrhksfl";
	private PreparedStatement ps = null;
	
	public MySQLConn() {
		// TODO Auto-generated constructor stub
		Connection conn = null;
		Statement state = null;
		/*public void submit(UserDTO userDTO) {
	        System.out.println("Submit");

	        try {

	            String sql = "INSERT INTO user (userid, password) VALUES (?, ?)";

	            ps = conn.prepareStatement(sql);

	            ps.setString(1, userDTO.getUserid());
	            ps.setString(2, new String(userDTO.getPassword()));

	            int result = ps.executeUpdate();

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }*/
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
			System.out.println("연결됨.");
			state = conn.createStatement();
			
			String sql;
			sql = "INSERT INTO `project`.`data` (`Id`, `Name`, `age`, `password`, `address`, `phone_number1`, `phone_number2`, `departure`, `position`, `feedback`) VALUES ('1', 'S', '2', '1111', 'SEOUL', '123', '123', 'ZZ', 'GG', 'DFDFSF')";

			if (sql.charAt(0)=='S'||sql.charAt(0)=='s') { //데이터베이스 읽어오는 부분
				ResultSet rs = state.executeQuery(sql);
				
				while (rs.next()) {
					int id = rs.getInt("id");
					String Name = rs.getString("Name");
					
					System.out.println(id+" "+Name);
				}
				
				rs.close();
				state.close();
				conn.close();
			}else {// 데이터베이스 갱신부분

	            ps = conn.prepareStatement(sql);

	            int result = ps.executeUpdate();
	           
				
				conn.close();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		} finally {
			try {
				if (state!=null) {
					state.close();
				}
			} catch (SQLException e1) {
				// TODO: handle exception
			}
			
			try {
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		System.out.println("연결 종료");
	}
	
	public static void main(String[] args) {
		new MySQLConn();
	}
}