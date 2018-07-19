import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class updateDAO {
	public static void main(String[] args) {

	}

	public static boolean update(DTO dto) {
		System.out.println("dto=" + dto.toString());
		boolean ok = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = DriverManager.getConnection(

					"jdbc:mysql://192.168.63.58:3306/pm?useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&useSSL=false", "root", "dlstkrhksfl");

			String sql = "update pm set name=?, jumin=?, pass=?, tel=?, tel1=?, addr=?, buname=? ,jik=? ,work=? where id=?";

			pstmt = con.prepareStatement(sql);
			
			System.out.println(dto.getName());
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJumin());
			pstmt.setString(3, dto.getPass());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getTel1());
			pstmt.setString(6, dto.getAddr());
			pstmt.setString(7, dto.getBuname());
			pstmt.setString(8, dto.getJik());
			pstmt.setString(9, dto.getWork());
			pstmt.setString(10, dto.getId());
			System.out.println(pstmt);
			//con.commit(); // 커밋
			int r = pstmt.executeUpdate(); // 실행 -> 수정
			// 1~n: 성공 , 0 : 실패
				
			if (r > 0)
				ok = true; // 수정이 성공되면 ok값을 true로 변경

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}
}
