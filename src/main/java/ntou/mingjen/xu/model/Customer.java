package ntou.mingjen.xu.model;

import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "test1") //你的DB_TABLENAME
public class Customer implements Serializable {
 
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue
	private Long id;
	
	private int serialnumber;
	
	private String userid;
 
	private String time;
 
	private int sumprice;
	
	private String mealtype;
	
	private String mealname;
	
	private String mealnumber;
 
	protected Customer() {
	}
 
	public Customer(int serialnumber, String userid, String time, int sumprice, String mealname, String mealnumber) {
		this.serialnumber = serialnumber;
		this.userid = userid;
		this.time = time;
		this.sumprice = sumprice;
		this.mealname = mealname;
		this.mealnumber = mealnumber;
	}
	
	public int getSerialnumber() {
		return serialnumber;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public String getTime() {
		return time;
	}
	
	public int getSumprice() {
		return sumprice;
	}
	
	public String getMealtype() {
		return mealtype;
	}
	
	public String getMealname() {
		return mealname;
	}
	
	public String getMealnumber() {
		return mealnumber;
	}
	//@Override
	//public String toString() {
	//	return String.format("[客戶id = '%s',價錢 = '%d']",userid,sumprice);
	//}
}