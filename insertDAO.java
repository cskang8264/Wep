import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertDAO {

	public static void main(String[] args) {

	}

	public static boolean create(DTO dto) throws Exception {

		boolean flag = false;

		Connection con = null;

		PreparedStatement pstmt = null; // 데이터를 전송하는 객체

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(

					"jdbc:mysql://192.168.63.58:3306/pm?useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8", "root", "dlstkrhksfl");

			String sql = "INSERT INTO pm VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getJumin());
			pstmt.setString(4, dto.getPass());
			pstmt.setString(5, dto.getTel());
			pstmt.setString(6, dto.getTel1());
			pstmt.setString(7, dto.getAddr());
			pstmt.setString(8, dto.getBuname());
			pstmt.setString(9, dto.getJik());
			pstmt.setString(10, dto.getWork());

			pstmt.executeUpdate();

			flag = true;

		} catch (Exception e) {

			System.out.println(e);

			flag = false;

		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				} // PreparedStatement 객체 해제

			if (con != null)
				try {
					con.close();
				} catch (SQLException sqle) {
				} // Connection 해제

		}

		return flag;

	}

}