import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.xml.ws.soap.AddressingFeature;






class pmFrame extends JFrame implements ActionListener, FocusListener, ChangeListener {
	String name;
	String jumin;
	String id;
	String pass;
	String tel;
	String tel1;
	String addr;
	String buname;
	String jik;
	String work;
	
	DTO dto = new DTO("","","","","","","","","","");
	 
	private JRootPane jrp;
	private Container con;
	// 전체 화면의 North
	private JLabel jl = new JLabel("<인사 관리>", JLabel.CENTER);
	// 전체 화면의 Center
	private JSplitPane jsp = new JSplitPane();
	// 전체 화면의 South
	private JPanel jp = new JPanel(new GridLayout(2, 1));
	private JPanel jp1 = new JPanel(new BorderLayout());
	private JPanel jp2 = new JPanel(new GridLayout(1, 2));
	private JPanel jp3 = new JPanel(new GridLayout(1, 2));
	private JPanel jp4 = new JPanel(new GridLayout(1, 2));
	private JTextField jtf = new JTextField();

	private JButton jbt3 = new JButton("불러오기");
	private JButton jbt4 = new JButton("종료");

	// Center의 West
	private JPanel jpjp0 = new JPanel(new BorderLayout());
	private JLabel jljl = new JLabel("등록인원", JLabel.CENTER);


	// Center의 Center
	private JTabbedPane jtb = new JTabbedPane();
	private JPanel jpjp = new JPanel(new BorderLayout());
	private JPanel jpjp1 = new JPanel(new BorderLayout());
	private JPanel jpjp2 = new JPanel(new BorderLayout());
	private JPanel jpjp3 = new JPanel(new BorderLayout());

	// 사용자 등록...
	private JLabel namelb = new JLabel("이름 : ", JLabel.RIGHT);
	private JLabel juminlb = new JLabel("주민번호 : ", JLabel.RIGHT);
	private JLabel idlb = new JLabel("ID : ", JLabel.RIGHT);
	private JLabel passlb = new JLabel("비밀번호 : ", JLabel.RIGHT);
	private JLabel pass1lb = new JLabel("비밀번호 확인 : ", JLabel.RIGHT);
	private JLabel tellb = new JLabel("전화번호 : ", JLabel.RIGHT);
	private JLabel tel1lb = new JLabel("휴대폰 : ", JLabel.RIGHT);
	private JLabel addrlb = new JLabel("주소 : ", JLabel.RIGHT);
	private JLabel bulb = new JLabel("부서 : ", JLabel.RIGHT);
	private JLabel jiklb = new JLabel("직책 : ", JLabel.RIGHT);
	private JLabel worklb = new JLabel("업무내용 작성 : ", JLabel.RIGHT);
	private JButton regbt = new JButton("등록");
	private JButton clearbt = new JButton("Clear");
	private JTextField nametf = new JTextField();
	private JTextField jumintf = new JTextField();
	private JTextField jumin1tf = new JTextField();

	private JTextField idtf = new JTextField();

	private JPasswordField passtf = new JPasswordField();
	private JPasswordField pass1tf = new JPasswordField();
	private Vector telvc = new Vector();
	private JComboBox teltf = new JComboBox(telvc);
	private JTextField tel1tf = new JTextField();
	private JTextField tel2tf = new JTextField();
	private Vector tel1vc = new Vector();
	private JComboBox tel11tf = new JComboBox(tel1vc);
	private JTextField tel12tf = new JTextField();
	private JTextField tel13tf = new JTextField();
	private JTextField addrtf = new JTextField();
	private Vector buvc = new Vector();
	private JComboBox butf = new JComboBox(buvc);
	private Vector jikvc = new Vector();
	private JComboBox jiktf = new JComboBox(jikvc);
	private JTextArea worktf = new JTextArea(5, 20);
	private JScrollPane workjsp = new JScrollPane(worktf);

	// 정보수정...
	private JLabel namelb1 = new JLabel("이름 : ", JLabel.RIGHT);
	private JLabel juminlb1 = new JLabel("주민번호 : ", JLabel.RIGHT);
	private JLabel idlb1 = new JLabel("ID : ", JLabel.RIGHT);
	private JLabel passlb1 = new JLabel("비밀번호 : ", JLabel.RIGHT);
	private JLabel pass1lb1 = new JLabel("비밀번호 확인 : ", JLabel.RIGHT);
	private JLabel tellb1 = new JLabel("전화번호 : ", JLabel.RIGHT);
	private JLabel tel1lb1 = new JLabel("휴대폰 : ", JLabel.RIGHT);
	private JLabel addrlb1 = new JLabel("주소 : ", JLabel.RIGHT);
	private JLabel bulb1 = new JLabel("부서 : ", JLabel.RIGHT);
	private JLabel jiklb1 = new JLabel("직책 : ", JLabel.RIGHT);
	private JLabel worklb1 = new JLabel("업무내용 작성 : ", JLabel.RIGHT);
	private JButton regbt1 = new JButton("수정");
	private JButton clearbt1 = new JButton("Clear");
	private JLabel nametf1 = new JLabel("Guest");
	private JLabel jumintf1 = new JLabel("******-*******");


	private JLabel idtf1 = new JLabel("Guest");

	private JPasswordField passtf1 = new JPasswordField("*****************************");
	private JPasswordField pass1tf1 = new JPasswordField("*****************************");
	private Vector telvc1 = new Vector();
	private JComboBox teltf1 = new JComboBox(telvc1);
	private JTextField tel1tf1 = new JTextField();
	private JTextField tel2tf1 = new JTextField();
	private Vector tel1vc1 = new Vector();
	private JComboBox tel11tf1 = new JComboBox(tel1vc1);
	private JTextField tel12tf1 = new JTextField();
	private JTextField tel13tf1 = new JTextField();
	private JTextField addrtf1 = new JTextField();
	private Vector buvc1 = new Vector();
	private JComboBox butf1 = new JComboBox(buvc1);
	private Vector jikvc1 = new Vector();
	private JComboBox jiktf1 = new JComboBox(jikvc1);
	private JTextArea worktf1 = new JTextArea(5, 20);
	private JScrollPane workjsp1 = new JScrollPane(worktf1);

	// 검색...
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton namerb = new JRadioButton("이름으로 검색", true);
	private JRadioButton juminrb = new JRadioButton("주민번호로 검색");
	private JRadioButton telrb = new JRadioButton("전화번호으로 검색");
	private JRadioButton tel1rb = new JRadioButton("휴대폰으로 검색");
	private JRadioButton idrb = new JRadioButton("ID로 검색");
	private JLabel searchlb = new JLabel("검색 필드 : ", JLabel.RIGHT);
	private JTextField searchtf = new JTextField();
	private JButton searchbt = new JButton("검색");
	private JLabel viewlb = new JLabel("결과 표시 : ", JLabel.RIGHT);
	private Vector viewvc = new Vector();
	private JList viewli = new JList(viewvc);
	private JScrollPane viewjsp = new JScrollPane(viewli);
	private JButton changebt = new JButton("해당 사용자 정보 변경 및 상세보기");

	// 삭제...
	private JLabel dellb = new JLabel("삭제할 대상을 체크하시오.");
	private JButton delbt = new JButton("체크된 사용자 삭제");
	private JButton delclearbt = new JButton("Check Clear");
	private String[] headername = { "번호", "삭제", "ID", "이름", "주민번호", "전화번호", "휴대폰번호", "주소", "부서", "직위", "업무내용" };
	private DefaultTableModel dtm = new DefaultTableModel(headername, 10);
	private DefaultTableColumnModel dtcm = new DefaultTableColumnModel();
	private DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
	private JTable jt = new JTable(dtm, dtcm, dlsm);
	private JScrollPane tablejsp = new JScrollPane(jt);
	private TableColumn[] tc = new TableColumn[11];
	private DefaultTableCellRenderer[] dtcr = new DefaultTableCellRenderer[11];
	private DefaultCellEditor[] dce = new DefaultCellEditor[11];
	private JTableHeader jth = new JTableHeader(dtcm);

	// 부서 셋팅 관련 멤버
	private static int busetnum = 0;
	private Vector busetvc = new Vector();

	// 사용자 저장 멤버
	private Vector personvc = new Vector();
	Vector redata = null;


	public pmFrame(String str) {
		super(str);
		this.init();
		this.start();
		this.setSize(600, 500);
		Dimension di = Toolkit.getDefaultToolkit().getScreenSize();//현재 크기 반환
		Dimension di1 = this.getSize();
		this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));
		this.setVisible(true);
	}
	
	//전체화면
	public void init() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout(5, 5));
		jl.setFont(new Font("휴먼옛체", Font.BOLD, 20));

		// 전체의 North
		con.add("North", jl);

		// 전체의 Center

		this.initjpjp();
		this.initjpjp1();
		this.initjpjp2();
		this.initjpjp3();
		jtb.addTab("사용자등록", jpjp);
		jtb.addTab("검색", jpjp1);
		jtb.addTab("삭제", jpjp2);
		jtb.addTab("정보수정", jpjp3);
		jsp.setRightComponent(jtb);
		jsp.setLeftComponent(null);  //왼쪽버튼 날리기
		jsp.setOneTouchExpandable(true);// 화살표를 누르면 한번에 줄어드는 기능
		jsp.setDividerSize(20);
		jsp.setDividerLocation(120);//divider 사이즈 위치지정
		con.add("Center", jsp);

		// 전체의 South

		jp.add(jp1);

		jp3.add(jbt3);
		jp2.add(jp3);
		jp4.add(new JLabel());
		jp4.add(jbt4);
		jp2.add(jp4);
		jp.add(jp2);
		con.add("South", jp);

		jtb.setEnabledAt(3, true);//정보수정 끄고 켜기
	}
	
	
//사용자등록
	private void initjpjp() {
		JPanel p = new JPanel(new GridLayout(10, 1));
		JPanel p1 = new JPanel(new GridLayout(10, 1));
		JPanel p2 = new JPanel(new BorderLayout(0, 10));
		p.add(namelb);
		p.add(juminlb);
		p.add(idlb);
		p.add(passlb);
		p.add(pass1lb);
		p.add(tellb);
		p.add(tel1lb);
		p.add(addrlb);
		p.add(bulb);
		p.add(jiklb);
		jpjp.add("West", p);

		p1.add(nametf);
		JPanel p4 = new JPanel(new BorderLayout(10, 0));
		JPanel p5 = new JPanel(new GridLayout(1, 2, 5, 0));
		p5.add(jumintf);
		p5.add(jumin1tf);
		p4.add("Center", p5);

		p1.add(p4);
		JPanel p6 = new JPanel(new BorderLayout(10, 0));
		p6.add("Center", idtf);

		p1.add(p6);
		p1.add(passtf);
		p1.add(pass1tf);
		JPanel p7 = new JPanel(new BorderLayout(5, 0));
		telvc.addElement("02");
		telvc.addElement("031");
		telvc.addElement("030");
		p7.add("West", teltf);
		JPanel jp8 = new JPanel(new GridLayout(1, 2, 5, 0));
		jp8.add(tel1tf);
		jp8.add(tel2tf);
		p7.add("Center", jp8);
		p1.add(p7);
		JPanel p9 = new JPanel(new BorderLayout(5, 0));
		tel1vc.addElement("010");
		tel1vc.addElement("011");
		p9.add("West", tel11tf);
		JPanel p10 = new JPanel(new GridLayout(1, 2, 5, 0));
		p10.add(tel12tf);
		p10.add(tel13tf);
		p9.add("Center", p10);
		p1.add(p9);
		p1.add(addrtf);
		p1.add(butf);

		buvc.addElement("인사과");
		buvc.addElement("영업과");
		buvc.addElement("회계과");
		buvc.addElement("광고과");
		buvc.addElement("마케팅과");

		p1.add(jiktf);
		
		jikvc.addElement("부장");
		jikvc.addElement("과장");
		jikvc.addElement("차장");
		jikvc.addElement("대리");
		jikvc.addElement("사원");
		
		jpjp.add("Center", p1);

		p2.add("West", worklb);
		p2.add("Center", workjsp);
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(regbt);
		p3.add(clearbt);
		p2.add("South", p3);
		jpjp.add("South", p2);
	}
	
	   public Vector getSeltedMemberList(String a){
	       
	        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
	       
	           
	        Connection con = null;       //연결
	        PreparedStatement ps = null; //명령
	        ResultSet rs = null;         //결과
	       
	        try{
	           
	        	con = DriverManager.getConnection(

						"jdbc:mysql://192.168.63.58:3306/pm?useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&useSSL=false", "root", "dlstkrhksfl");

	            String sql = "select * from pm where"+a;
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	           
	            while(rs.next()){
	                String name = rs.getString("name");
	                String jumin = rs.getString("jumin");
	                String id = rs.getString("id");
	                String pass = rs.getString("pass");
	                String tel = rs.getString("tel");
	                String tel1 = rs.getString("tel1");
	                String addr = rs.getString("addr");
	                String buname = rs.getString("buname");
	                String jik = rs.getString("jik");
	                String work = rs.getString("work");
	               
	                Vector row = new Vector();
	                row.add(name);
	                row.add(jumin);
	                row.add(id);
	                row.add(pass);
	                row.add(tel);
	                row.add(tel1);
	                row.add(addr);
	                row.add(buname);
	                row.add(jik);
	                row.add(work);
	               
	                data.add(row);             
	            }//while
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return data;
	    }

//검색
	private void initjpjp1() {
		JPanel p1 = new JPanel(new GridLayout(5, 1));
	//	namerb.addItemListener(new ItemListener() {});
	
		jpjp1.add("North", p1);
		JPanel p2 = new JPanel(new BorderLayout());
		JPanel p3 = new JPanel(new BorderLayout());
		p3.add("West", searchlb);
		p3.add("Center", searchtf);
		
		
		p3.add("East", searchbt);
		searchbt.addActionListener(new ActionListener() {
			
			@Override
			public  void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource()==searchbt) {
					System.out.println("z");
					String a = searchtf.getText();
					Vector data =getSeltedMemberList(a);
					viewli.setListData(data);
				    }
				
			}
		});
		
		p2.add("North", p3);
		
		JPanel p4 = new JPanel(new BorderLayout());
		p4.add("West", viewlb);
		
		p4.add("Center", viewjsp);
		p2.add("Center", p4);
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p5.add(changebt);
		p2.add("South", p5);
		jpjp1.add("Center", p2);
	}


    /**멤버리스트 출력*/
    public Vector getMemberList(){
       
        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
       
           
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try{
           
        	con = DriverManager.getConnection(

					"jdbc:mysql://192.168.63.58:3306/pm?useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&useSSL=false", "root", "dlstkrhksfl");

            String sql = "select * from pm order by id asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                String name = rs.getString("name");
                String jumin = rs.getString("jumin");
                String id = rs.getString("id");
                String pass = rs.getString("pass");
                String tel = rs.getString("tel");
                String tel1 = rs.getString("tel1");
                String addr = rs.getString("addr");
                String buname = rs.getString("buname");
                String jik = rs.getString("jik");
                String work = rs.getString("work");
               
                Vector row = new Vector();
                row.add(name);
                row.add(jumin);
                row.add(id);
                row.add(pass);
                row.add(tel);
                row.add(tel1);
                row.add(addr);
                row.add(buname);
                row.add(jik);
                row.add(work);
               
                data.add(row);             
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getMemberList()
	//삭제
	private void initjpjp2() {
		jpjp2.add("North", dellb);
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(delbt);
		p.add(delclearbt);
		//String [] title = {"이름","주민번호","아이디","비밀번호","전화번호1","전화번호2","주소","부서","직급","업무내용"};
		Vector data = getMemberList();
		DefaultTableModel model = new DefaultTableModel() {
			Class[] types = new Class[] {
					java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,
					java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.Boolean.class};
			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		};
		model.addColumn("이름");
		model.addColumn("주민번호");
		model.addColumn("아이디");
		model.addColumn("비밀번호");
		model.addColumn("전화번호1");
		model.addColumn("전화번호2");
		model.addColumn("주소");
		model.addColumn("부서");
		model.addColumn("직급");
		model.addColumn("업무내용");
		model.addColumn("check");
		
		delbt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource()==delbt) {
					int numberOfRaw = model.getRowCount();
					 for (int i = 0; i < numberOfRaw; i++) {
		                    boolean b = Boolean.parseBoolean(model.getValueAt(i, 10).toString());
		                    if (b) { 
		                    	deleteDAO.deleteMember((String) model.getValueAt(i, 2));
		                    }
		                }
				}
				
			}
		});
		
		
		
	    System.out.println(data.size());
			for (int i = 0; i < data.size(); i++) {
				model.addRow((Vector) data.get(i));
				
			}
		
		JButton reset = new JButton("갱신");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource()==reset) {
					
					model.setRowCount(0);
					Vector data = getMemberList();
					for (int i = 0; i < data.size(); i++) {
						model.addRow((Vector) data.get(i));
						
					}

				}
				
			}
		});
		p.add(reset);
		jpjp2.add("South",p);
		
		
		JTable table  = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		jpjp2.add(scrollPane);
		

	}

	
	//수정
	private void initjpjp3() {
		JLabel a = new JLabel("수정할 대상을 체크하고 수정한다음 수정버튼을 눌러주세요.");
		JButton b = new JButton("수정");
		jpjp3.add("North", a);
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(b);
		
	
	
		//String [] title = {"이름","주민번호","아이디","비밀번호","전화번호1","전화번호2","주소","부서","직급","업무내용"};
		Vector data = getMemberList();
		DefaultTableModel model = new DefaultTableModel() {
			Class[] types = new Class[] {
					java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,
					java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.Boolean.class};
			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		};
		model.addColumn("이름");
		model.addColumn("주민번호");
		model.addColumn("아이디");
		model.addColumn("비밀번호");
		model.addColumn("전화번호1");
		model.addColumn("전화번호2");
		model.addColumn("주소");
		model.addColumn("부서");
		model.addColumn("직급");
		model.addColumn("업무내용");
		model.addColumn("check");
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource()==b) {
					int numberOfRaw = model.getRowCount();
					 for (int i = 0; i < numberOfRaw; i++) {
		                    boolean b = Boolean.parseBoolean(model.getValueAt(i, 10).toString());
		                    if (b) { 
		                    	//deleteDAO.deleteMember((String) model.getValueAt(i, 2));
		                    	
		                    	 DTO ud = new DTO((String)model.getValueAt(i, 0),(String)model.getValueAt(i, 1),(String)model.getValueAt(i, 2),(String)model.getValueAt(i, 3),(String)model.getValueAt(i, 4),(String)model.getValueAt(i, 5),(String)model.getValueAt(i, 6),(String)model.getValueAt(i, 7),(String)model.getValueAt(i, 8),(String)model.getValueAt(i, 9));
		                    	 System.out.println(ud.getName());
		                    	 updateDAO.update(ud);

		                    
		                    }
		                }
				}
				
			}
		});
		
		
		
	    System.out.println(data.size());
			for (int i = 0; i < data.size(); i++) {
				model.addRow((Vector) data.get(i));
				
			}
		
		JButton reset = new JButton("갱신");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource()==reset) {
					
					model.setRowCount(0);
					Vector data = getMemberList();
					for (int i = 0; i < data.size(); i++) {
						model.addRow((Vector) data.get(i));
						
					}

				}
				
			}
		});
		p.add(reset);
		jpjp3.add("South",p);
		
		
		JTable table  = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		jpjp3.add(scrollPane);
		/*JPanel p = new JPanel(new GridLayout(10, 1));
		JPanel p1 = new JPanel(new GridLayout(10, 1));
		JPanel p2 = new JPanel(new BorderLayout(0, 10));
		p.add(namelb1);
		p.add(juminlb1);
		p.add(idlb1);
		p.add(passlb1);
		p.add(pass1lb1);
		p.add(tellb1);
		p.add(tel1lb1);
		p.add(addrlb1);
		p.add(bulb1);
		p.add(jiklb1);
		jpjp3.add("West", p);

		p1.add(nametf1);

		p1.add(jumintf1);

		
		p1.add(idtf1);
		p1.add(passtf1);
		p1.add(pass1tf1);
		JPanel p7 = new JPanel(new BorderLayout(5, 0));
		telvc1.addElement("02");
		telvc1.addElement("031");
		telvc1.addElement("030");
		p7.add("West", teltf1);
		JPanel jp8 = new JPanel(new GridLayout(1, 2, 5, 0));
		jp8.add(tel1tf1);
		jp8.add(tel2tf1);
		p7.add("Center", jp8);
		p1.add(p7);
		JPanel p9 = new JPanel(new BorderLayout(5, 0));
		tel1vc1.addElement("010");
		tel1vc1.addElement("011");

		p9.add("West", tel11tf1);
		JPanel p10 = new JPanel(new GridLayout(1, 2, 5, 0));
		p10.add(tel12tf1);
		p10.add(tel13tf1);
		p9.add("Center", p10);
		p1.add(p9);
		p1.add(addrtf1);
		p1.add(butf1);
		
		buvc1.addElement("인사과");
		buvc1.addElement("영업과");
		buvc1.addElement("회계과");
		buvc1.addElement("광고과");
		buvc1.addElement("마케팅과");
		
		p1.add(jiktf1);
		
		jikvc1.addElement("부장");
		jikvc1.addElement("과장");
		jikvc1.addElement("차장");
		jikvc1.addElement("대리");
		jikvc1.addElement("사원");
		
		jpjp3.add("Center", p1);

		p2.add("West", worklb1);
		p2.add("Center", workjsp1);
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(regbt1);
		p3.add(clearbt1);
		p2.add("South", p3);
		jpjp3.add("South", p2);*/
	}

	//이벤트처리 등록
	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbt4.addActionListener(this);
		jtf.addActionListener(this);

		nametf.addFocusListener(this);
		regbt.addActionListener(this);
		clearbt.addActionListener(this);

		searchtf.addActionListener(this);
		searchbt.addActionListener(this);
		changebt.addActionListener(this);
		regbt1.addActionListener(this);
		jtb.addChangeListener(this);
		delbt.addActionListener(this);
		delclearbt.addActionListener(this);
		jbt3.addActionListener(this);
	}

	
	
	public void actionPerformed(ActionEvent e) {

		//종료 버튼
		if (e.getSource() == jbt4) {
			System.exit(0);
		} 
		
		

		


		 

		  //아이디 체크버튼 눌렀을 떄

		else if (e.getSource() == regbt) { // 등록 버튼
			
			
			
			  String pas=new String(passtf.getPassword());
			   dto.setId(idtf.getText().trim());
			   dto.setName(nametf.getText());
			   dto.setJumin(jumintf.getText()+"-"+jumin1tf.getText());
			   dto.setPass(pas);
			   dto.setTel((String) teltf.getSelectedItem() + "-" + 
						tel1tf.getText() + "-" + tel2tf.getText());
			   dto.setTel1((String) tel11tf.getSelectedItem() + "-" + tel12tf.getText().trim() + "-"
						+ tel13tf.getText().trim());
			   dto.setAddr(addrtf.getText().trim());
			   dto.setBuname((String) butf.getSelectedItem());
			   dto.setJik((String) jiktf.getSelectedItem());
			   dto.setWork(worktf.getText());
			   
			   

			   

			   

			   try {

			    insertDAO.create(dto);  //dto를 DAO에 넘겨준다.

			   } catch (Exception e1) {

			    // TODO Auto-generated catch block

			    e1.printStackTrace();

			   }
		}

		//클리어 버튼
		else if (e.getSource() == clearbt) {
			nametf.setText("");
			jumintf.setText("");
			jumin1tf.setText("");
			idtf.setText("");
			passtf.setText("");
			pass1tf.setText("");
			teltf.setSelectedIndex(0);
			tel1tf.setText("");
			tel2tf.setText("");
			tel11tf.setSelectedIndex(0);
			tel12tf.setText("");
			tel13tf.setText("");
			addrtf.setText("");
			butf.setSelectedIndex(0);
			jiktf.setSelectedIndex(0);
			worktf.setText("");
			nametf.requestFocus();
		} 
		


		//해당사용자 정보 상세보기
		else if (e.getSource() == changebt) {
			String str = (String) viewli.getSelectedValue();// 이름:주민번호:아이디
			str = str.substring(str.indexOf(":") + 1, str.lastIndexOf(":"));
			jtb.setSelectedIndex(3);
			jikvc1.clear();
			jikvc1.add("부장");
			jikvc1.add("과장");
			jikvc1.add("차장");
			jikvc1.add("대리");
			jikvc1.add("사원");
			buvc1.clear();
			buvc1.clear();
			buvc1.add("인사과");
			buvc1.add("영업과");
			buvc1.add("회계과");
			buvc1.add("광고과");
			buvc1.add("마케팅과");

		} 
		//수정버튼
		else if (e.getSource() == regbt1) {
			  String pas=new String(passtf.getPassword());
			   dto.setId(idtf.getText().trim());
			   dto.setName(nametf.getText());
			   dto.setJumin(jumintf.getText()+"-"+jumin1tf.getText());
			   dto.setPass(pas);
			   dto.setTel((String) teltf.getSelectedItem() + "-" + 
						tel1tf.getText() + "-" + tel2tf.getText());
			   dto.setTel1((String) tel11tf.getSelectedItem() + "-" + tel12tf.getText().trim() + "-"
						+ tel13tf.getText().trim());
			   dto.setAddr(addrtf.getText().trim());
			   dto.setBuname((String) butf.getSelectedItem());
			   dto.setJik((String) jiktf.getSelectedItem());
			   dto.setWork(worktf.getText());
			   
			   

			   

			   

			   try {

			    updateDAO.update(dto);  //dto를 DAO에 넘겨준다.

			   } catch (Exception e1) {

			    // TODO Auto-generated catch block

			    e1.printStackTrace();

			   }
		}

	

		//체크 올 클리어
		else if (e.getSource() == delclearbt) {
			for (int i = 0; i < personvc.size(); i++) {
				jt.setValueAt(new Boolean(false), i, 1);
			}
		} 
		

	}


	

	public void focusGained(FocusEvent e) {
		if (e.getSource() == nametf) {
			jikvc.clear();
			jikvc.add("부장");
			jikvc.add("과장");
			jikvc.add("차장");
			jikvc.add("대리");
			jikvc.add("사원");
			
			buvc.clear();
			buvc.add("인사과");
			buvc.add("영업과");
			buvc.add("회계과");
			buvc.add("광고과");
			buvc.add("마케팅과");

		}
	}

	public void focusLost(FocusEvent e) {

	}

	public void stateChanged(ChangeEvent e) {

		
	}
}
