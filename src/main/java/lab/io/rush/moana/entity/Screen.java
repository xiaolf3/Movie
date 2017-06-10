package lab.io.rush.moana.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(table = "screen")
public class Screen implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Integer screen_id;
	private Date date;
	private Date start_time;
	private Date end_time;
	private String version;
	private int seat;
	private int hall;
	@Column(name = "movie_id")
	private Integer movie_id;
	private float price;

	public Integer getScreen_id() {
		return screen_id;
	}

	public void setScreen_id(Integer screen_id) {
		this.screen_id = screen_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public Integer getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getHall() {
		return hall;
	}

	public void setHall(int hall) {
		this.hall = hall;
	}

	@Override
	public String toString() {
		return "Screen [screen_id=" + screen_id + ", date=" + date + ", start_time=" + start_time + ", end_time="
				+ end_time + ", version=" + version + ", seat=" + seat + ", hall=" + hall + ", movie_id=" + movie_id
				+ ", price=" + price + "]";
	}

}
