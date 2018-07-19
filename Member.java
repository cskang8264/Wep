import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Member extends JFrame implements ActionListener {
 // 디자인에 필요한 녀석들~!!
 JLabel m_label, l_name, l_age, l_addr, l_phone, l_phone1, l_phone2, l_email, l_email1, l_gender;
 JTextField txt_name, txt_age, txt_addr, txt_phone1, txt_phone2, txt_phone3, txt_email_id, txt_email_addr, txt_keyword;
 CheckboxGroup gender;
 Checkbox female, male;
 Choice ch_email, ch_category;
 JTable table;
 JScrollPane scroll;
 JButton bt_regist, bt_edit, bt_delete, bt_select, bt_getListAll, bt_exit;
 JPanel south, north, center, p1, p2, p3, p4, p5, p6, p7;

 // 1.JDBC 접속에 필요한 녀석들~
 String driver = "com.mysql.jdbc.Driver";
 String url = "jdbc:mysql://localhost:3306/sys";
 // String url =
 // "jdbc:mysql://localhost:3306/bitna?useUnicode=true&characterEncoding=utf8";

 String userid = "root";
 String passwd = "dlstkrhksfl";
 Connection con;// 접속 정보를 가진 객체
 PreparedStatement pstmt;
 ResultSet rs;

 // 라디오 버튼으로 부터 성별을 전달 받을 스트링
 String g ;
 String sql;
 
 String category;

 // 만들어 놓은 회원 리스트 백터 가져갈 모델을 지정해주자.
 MemberModel model = new MemberModel();
 int selRow; // 마우스 이벤트. 어떤 레코드를 선택했는지 알수 있는 변수명.
 int idx; // 마우스를 누를때마다 idx값을 넣어주자~!

 public Member() {
  super("인사관리");
  m_label = new JLabel("인사관리");
  Font f1 = new Font("serif", Font.BOLD, 20);
  m_label.setFont(f1);
  m_label.setForeground(Color.WHITE);

  l_name = new JLabel("이    름");
  l_age = new JLabel(" 나   이");
  l_addr = new JLabel("주    소");
  l_phone = new JLabel("연락처");
  l_phone1 = new JLabel("-");
  l_phone2 = new JLabel("-");
  l_email = new JLabel("이메일");
  l_email1 = new JLabel("@");
  l_gender = new JLabel(" 성   별");

  txt_name = new JTextField(8);
  txt_age = new JTextField(3);
  txt_addr = new JTextField(30);
  txt_phone1 = new JTextField(9);
  txt_phone2 = new JTextField(9);
  txt_phone3 = new JTextField(9);
  txt_email_id = new JTextField(9);
  txt_email_addr = new JTextField(10);
  txt_keyword = new JTextField(10);

  
  ch_email = new Choice();
  ch_email.add("직접입력");
  ch_email.add("naver.com");
  ch_email.add("google.com");
  ch_email.add("nate.com");
  ch_email.add("paran.com");
  ch_email.add("hanmail.net");
  
  ch_category=new Choice();
  ch_category.add("검색할 카테고리를 선택하세요");
  ch_category.add("name");
  ch_category.add("age");
  ch_category.add("gender");
  ch_category.add("addr");
  ch_category.add("phone");
  ch_category.add("email");

  gender = new CheckboxGroup();
  male = new Checkbox("Male", gender, false);
  female = new Checkbox("Female", gender, false);

  bt_regist = new JButton("등록");
  bt_edit = new JButton("수정");
  bt_delete = new JButton("삭제");
  bt_select = new JButton("조회");
  bt_getListAll = new JButton("전체조회");
  bt_exit = new JButton("종료");

  table = new JTable(model);
  scroll = new JScrollPane(table);

  south = new JPanel();
  north = new JPanel();
  center = new JPanel();
  p1 = new JPanel();
  p2 = new JPanel();
  p3 = new JPanel();
  p4 = new JPanel();
  p5 = new JPanel();
  p6= new JPanel();
  
  north.setPreferredSize(new Dimension(600, 200));
  center.setPreferredSize(new Dimension(600, 400));
  south.setPreferredSize(new Dimension(600, 50));

  add(north, BorderLayout.NORTH);
  add(center, BorderLayout.CENTER);
  add(south, BorderLayout.SOUTH);

  north.setLayout(new GridLayout(6, 1));
  north.add(p1);
  north.add(p2);
  north.add(p3);
  north.add(p4);
  north.add(p5);
  north.add(p6);

  p1.setBackground(Color.BLACK);
  p1.add(m_label);
  p2.add(l_name);
  p2.add(txt_name);
  p2.add(l_age);
  p2.add(txt_age);
  p2.add(l_gender);
  p2.add(male);
  p2.add(female);
  p3.add(l_addr);
  p3.add(txt_addr);
  p4.add(l_phone);
  p4.add(txt_phone1);
  p4.add(l_phone1);
  p4.add(txt_phone2);
  p4.add(l_phone2);
  p4.add(txt_phone3);
  p5.add(l_email);
  p5.add(txt_email_id);
  p5.add(l_email1);
  p5.add(txt_email_addr);
  p5.add(ch_email);

  p6.setLayout(new FlowLayout(FlowLayout.RIGHT));
  p6.setBackground(Color.pink);
  p6.add(ch_category);
  p6.add(txt_keyword);
  p6.add(bt_select);
  p6.add(bt_getListAll);
  // 메일주소 초이스 박스 리스너 구현..
  ch_email.addItemListener(new ItemListener() {
   public void itemStateChanged(ItemEvent ie) {
    Object obj = ie.getSource();
    if (obj.equals(ch_email)) {
     if (ch_email.getSelectedIndex() == 0) {
      txt_email_addr.setText("");
     } else {
      // txt_email_addr.setText(ch_email.getSelectedItem());
      txt_email_addr.setText((String) ie.getItem());
     }
    }
   }
  });
  
  // 검색 카테고리 초이스 박스 리스너 구현..
    ch_category.addItemListener(new ItemListener() {
     public void itemStateChanged(ItemEvent ie) {
      Object obj = ie.getSource();
      category=(String)ie.getItem();
     }
    });

  // 성별 checkbox 리스너 구현
  male.addItemListener(new ItemListener() {
   public void itemStateChanged(ItemEvent e) {
    g = (String) e.getItem();
    // g = gender.getSelectedCheckbox().getLabel();
   }
  });

  female.addItemListener(new ItemListener() {
   public void itemStateChanged(ItemEvent e) {
    g = (String) e.getItem();
    // g = gender.getSelectedCheckbox().getLabel();
   }
  }); // 성별 checkbox 리스너 구현 끝

  center.setLayout(new GridLayout(1, 1));
  center.add(scroll);

  south.setLayout(new GridLayout(1, 4));
  south.add(bt_regist);
  south.add(bt_edit);
  south.add(bt_delete);
  south.add(bt_exit);
  

  // 버튼에 액션 리스너 달아주기
  bt_regist.addActionListener(this);
  bt_edit.addActionListener(this);
  bt_delete.addActionListener(this);
  bt_select.addActionListener(this);
  bt_getListAll.addActionListener(this);
  bt_exit.addActionListener(this);

  // 테이블 관련하여 마우스 이벤트 정의하자
  // 어느 row를 선택했을지 판단.
  table.addMouseListener(new MouseAdapter() {
   public void mouseClicked(MouseEvent e) {
    selRow = table.getSelectedRow();
    System.out.println(selRow);

    /*선택시 내용을 위에 텍스트 상자들에게 넣어주자~! 오브젝트 형이니 형변환~~*/
    String name = (String) table.getValueAt(selRow, 0);
    String age = table.getValueAt(selRow, 1).toString();
    String gender = (String) table.getValueAt(selRow, 2);
    String addr = (String) table.getValueAt(selRow, 3);
    String phone = (String) table.getValueAt(selRow, 4);
    String email = (String) table.getValueAt(selRow, 5);

    // idx는 테이블에 없고. 모델에는 있죠? 살포시 rs돌릴때 넣어줬으니.. model에서 가져오자!!
    idx = (Integer) model.getValueAt(selRow, 6);
    System.out.println(idx);

    txt_name.setText(name);
    txt_age.setText(age);
    txt_addr.setText(addr);
    System.out.println(gender);
    if(gender==null){
     male.setState(false);
     female.setState(false);
    }else {
      if (gender.equals("Male")){
       male.setState(true);
      }else if (gender.equals("Female")) {
       female.setState(true);
      }
    }    
    txt_phone1.setText(phone.substring(0, phone.indexOf("-")));
    txt_phone2.setText(phone.substring(phone.indexOf("-") + 1, phone.lastIndexOf("-")));
    txt_phone3.setText(phone.substring(phone.lastIndexOf("-") + 1));
    txt_email_id.setText(email.substring(0, email.indexOf("@")));
    txt_email_addr.setText(email.substring(email.lastIndexOf("@")+1));
   }
  });

  // 윈도우 창 닫을때 DB와 연관된 모든 자원을 닫자!!
  this.addWindowListener(new WindowAdapter() {
   public void windowClosing(WindowEvent e) {
    closeDB();
    System.exit(0);
   }
  }); // end windowListner

  // 접속
  connect();
  // 리스트 가져오기
  getListAll();

  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  // setSize(600, 650);
  pack();
  setVisible(true);
 }// end 생성자
 
 

 // 접속시도 메소드
 public boolean connect() {
  boolean isConnect = false;
  try {
   // 접속 드라이버 로드
   Class.forName(driver);
   // 접속 시도
   con = DriverManager.getConnection(url, userid, passwd);
   isConnect = true;
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
  return isConnect;
 }
//안녕 조현재 또 담배피러갔니?
 // 리스트 가져오기
 public void getListAll() {
  String sql = "select * from memberr order by idx desc";
  try {
   pstmt = con.prepareStatement(sql);
   rs = pstmt.executeQuery();
   /* 테이블 모델에게 데이터 전달해주기 
    * 1) vector로 형변환 
    * 2)list 정보를 담을수 있는 백터(세로~~사람들 정보가 되겠넹)*/
   Vector list = new Vector();
   while (rs.next()) {
    // 한사람 정보를 담을 vector를 만들자!(가로백터) 지렁이 쭉쭉~!
    Vector record = new Vector();
    record.add(rs.getString("name"));
    record.add(rs.getInt("age"));
    record.add(rs.getString("gender"));
    record.add(rs.getString("addr"));
    record.add(rs.getString("phone"));
    record.add(rs.getString("email"));
    record.add(rs.getInt("idx")); // 참고값 idx는 숨겨서~~!
    // 한사람의 정보를 가진 백터를 더 큰 백터에 담고 있다.
    list.add(record);
   }
   // 테이블 모델에 방금 제조된 큰 백터를 넘기자!!
   model.setList(list);
   this.repaint();
  } catch (SQLException e) {
   e.printStackTrace();
  } 
 } 
 
 // 레코드 등록
 public int regist() {
  int result = 0;
  sql = "Insert into memberr(name,age,gender,addr,phone,email)";
  sql = sql + "Value(?,?,?,?,?,?)";
  try {
   pstmt = con.prepareStatement(sql);
   pstmt.setString(1, txt_name.getText());
   // pstmt.setString(1, new String(txt_name.getText().getBytes(), "euc-kr"));
   pstmt.setInt(2, Integer.parseInt(txt_age.getText()));
   pstmt.setString(3, g);
   // pstmt.setString(4, new String(txt_addr.getText().getBytes(), "ISO-8859-1"));
   pstmt.setString(4, txt_addr.getText());
   pstmt.setString(5, txt_phone1.getText()+"-"+ txt_phone2.getText()+"-"+txt_phone3.getText());
   pstmt.setString(6,txt_email_id.getText()+"@"+txt_email_addr.getText());
   result = pstmt.executeUpdate();
   // System.out.println(new String(txt_addr.getText().getBytes("euc-kr"),"utf-8"));
  } catch (SQLException e) {
   e.printStackTrace();
  } 
  return result;
 }

 // 삭제 메서드 정의
 public int delete() {
  int result = 0;
  String sql = "Delete from memberr where idx=?";

  try {
   pstmt = con.prepareStatement(sql);
   pstmt.setInt(1, idx);
   result = pstmt.executeUpdate();
  } catch (SQLException e) {
   e.printStackTrace();
  } 
  return result;
 }
 
 public int edit(){
  int result =0;
  String sql = "Update memberr set name=?, age=?, gender=?, addr=?, phone=?, email=? where idx=?";
  try {
   pstmt = con.prepareStatement(sql);   
   pstmt.setString(1, txt_name.getText());
   pstmt.setInt(2, Integer.parseInt(txt_age.getText()));
   pstmt.setString(3, g);
   pstmt.setString(4, txt_addr.getText());
   pstmt.setString(5, txt_phone1.getText() + "-" + txt_phone2.getText() +"-"+ txt_phone3.getText());
   pstmt.setString(6, txt_email_id.getText() + "@" + txt_email_addr.getText());
   pstmt.setInt(7, idx);
   result = pstmt.executeUpdate();
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return result;
 }
 
 public boolean select(String category, String keyword){
  boolean result = false;
  String sql ="select * from memberr where "+category+" like '%"+keyword+"%' order by idx desc";  
  System.out.println(sql);
  try {
   pstmt=con.prepareStatement(sql);
   rs = pstmt.executeQuery();   
   Vector list = new Vector();
   while (rs.next()) {
    // 한사람 정보를 담을 vector를 만들자!(가로백터) 지렁이 쭉쭉~!
    Vector record = new Vector();
    record.add(rs.getString("name"));
    record.add(rs.getInt("age"));
    record.add(rs.getString("gender"));
    record.add(rs.getString("addr"));
    record.add(rs.getString("phone"));
    record.add(rs.getString("email"));
    record.add(rs.getInt("idx")); 
    list.add(record);
   }
   // 테이블 모델에 방금 제조된 큰 백터를 넘기자!!
   model.setList(list);
   this.repaint();
   
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return result;
 }

 //텍스트 상자 초기화 하는 메서드
 public void clear(){  
  txt_name.setText("");
  txt_age.setText(""); 
  male.setState(false);
  female.setState(false);
  txt_addr.setText(""); 
  txt_phone1.setText(""); txt_phone2.setText(""); txt_phone3.setText("");
  txt_email_id.setText(""); txt_email_addr.setText("");
  txt_name.requestFocus();
 }
 
 // 데이터베이스 접속해제 메서드 정의!!
 public void closeDB() {
  if (rs != null)
   try {
    rs.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  if (pstmt != null)
   try {
    pstmt.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  if (con != null)
   try {
    con.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
 }

 // 버튼 액션 이벤트 구현
 public void actionPerformed(ActionEvent e) {
  Object obj = e.getSource();
  // 등록버튼
  if (obj.equals(bt_regist)) {
   // 등록메서드 수행~
   int result = regist();
   if (result != 0) {
    JOptionPane.showMessageDialog(getParent(), "등록성공");
    getListAll();
    clear();
    table.updateUI();
   } else {
    JOptionPane.showMessageDialog(getParent(), "등록실패");
   }
  }

  // 수정버튼
  if (obj.equals(bt_edit)) {
   if(JOptionPane.showConfirmDialog(getParent(), (String)table.getValueAt(selRow, 0)+ "님의 정보를 수정 하시겠습니까?")==0){
    int result = edit();
    if(result !=0){
     getListAll();
     clear();
     table.updateUI();
    }
   }
  }

  // 삭제버튼
  if (obj.equals(bt_delete)) {
   if(JOptionPane.showConfirmDialog(getParent(), (String) table.getValueAt(selRow, 0)+ "님의 정보를 삭제 하시겠습니까?")==0){
    int result = delete();
    if (result != 0) {
     getListAll();
     clear();
     table.updateUI();   
    }
   }
  }

  // 조회버튼
  if (obj.equals(bt_select)) {
   select(category, txt_keyword.getText());
  }
  // 전체 조회버튼
  if (obj.equals(bt_getListAll)) {
   getListAll();
  }

  // 종료버튼
  if (obj.equals(bt_exit)) {
   closeDB();
   System.exit(0);

  }// end exit버튼 action구현
 }// end action이벤트 구현

 // 실행 메서드
 public static void main(String[] args) {
  Member m = new Member();

 }

}// end class

 
