import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class deleteDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static boolean deleteMember(String id){
        
        boolean ok =false ;
        Connection con =null;
        PreparedStatement ps =null;
        int r=0;
        try {
        	con = DriverManager.getConnection(

					"jdbc:mysql://192.168.63.58:3306/pm?useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8", "root", "dlstkrhksfl");

            String sql = "delete from pm where id=? ";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, id);

            r = ps.executeUpdate(); // 실행 -> 삭제
        	
            if (r > 0)
				ok = true; // 수정이 성공되면 ok값을 true로 변경
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }      
        return ok;
    }
   

}
