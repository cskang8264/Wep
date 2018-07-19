import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel {

 // 데이터 담기..
 Vector column = new Vector();// 컬럼정보를 가진 백터
 Vector list = new Vector(); // 레코드를 담을 백터(사람들의 정보를 담을 백터 )세로백터

 public MemberModel() {
  column.add("이름");
  column.add("나이");
  column.add("성별");
  column.add("주소");
  column.add("연락처");
  column.add("이메일");
 }

 // 컬럼명을 넣어주자!!
 public String getColumnName(int index) {
  return String.valueOf(column.get(index));
 }
 
 public void setList(Vector list) {
  this.list = list;
 }

 @Override
 public int getColumnCount() {
  // 컬럼 사이즈 현재 add 6개했으니까!! 6이겠죠!
  
  return column.size(); 
 }

 @Override
 public int getRowCount() {
  
  return list.size(); // 레코드 사이즈..
  
 }

 @Override
 public Object getValueAt(int row, int col) {
  Vector vec = (Vector) list.get(row);
  return vec.get(col);
 }
}

