
public class DTO {

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
   //
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//
	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	/////
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/////////
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	/////////////
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	/////
	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	////////////////
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	///
	public String getBuname() {
		return buname;
	}

	public void setBuname(String buname) {
		this.buname = buname;
	}
	////
	public String getJik() {
		return jik;
	}

	public void setJik(String jik) {
		this.jik = jik;
	}
	////////////
	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
	public DTO(String name,
	String jumin,
	String id,
	String pass,
	String tel,
	String tel1,
	String addr,
	String buname,
	String jik,
	String work) {
		this.name = name;
		this.jumin= jumin;
		this.id= id;
		this.pass= pass;
		this.tel= tel;
		this.tel1= tel1;
		this.addr= addr;
		this.buname= buname;
		this.jik= jik;
		this.work= work;
	}

}