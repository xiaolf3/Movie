package lab.io.rush.moana.entity;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(table="customer")
public class Customer implements Serializable{
	@PrimaryKey
	@Persistent
	private String customer_id;
	private String password;
	private int status;
	private Long activateTime;
	private String token;
	private Date createDate;
	private String nickname;
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public Long getActivateTime() {
		return activateTime;
	}

	public void setActivateTime(Long activateTime) {
		this.activateTime = activateTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", password=" + password + ", status=" + status
				+ ", activateTime=" + activateTime + ", token=" + token + ", createDate=" + createDate + ", nickname="
				+ nickname + "]";
	}
	
	
	
	
}
