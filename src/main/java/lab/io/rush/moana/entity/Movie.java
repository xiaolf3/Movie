package lab.io.rush.moana.entity;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(table="movie")
public class Movie implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	private Integer movie_id;
	private String title;
	private String directors;
	private String casts;
	private String pubdates;
	private String countries;
	private String version;
	private String genres;
	private float price;
	private String summary;
	private String poster;
	private int status;
	
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirectors() {
		return directors;
	}
	public void setDirectors(String directors) {
		this.directors = directors;
	}
	public String getCasts() {
		return casts;
	}
	public void setCasts(String casts) {
		this.casts = casts;
	}
	
	public String getPubdates() {
		return pubdates;
	}
	public void setPubdates(String pubdates) {
		this.pubdates = pubdates;
	}
	public String getCountries() {
		return countries;
	}
	public void setCountries(String countries) {
		this.countries = countries;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", title=" + title + ", directors=" + directors + ", casts=" + casts
				+ ", pubdates=" + pubdates + ", countries=" + countries + ", version=" + version + ", genres=" + genres
				+ ", price=" + price + ", summary=" + summary + ", poster=" + poster + ", status=" + status + "]";
	}
	
	
	
}
