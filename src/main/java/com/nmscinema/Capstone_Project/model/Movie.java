package com.nmscinema.Capstone_Project.model;

public class Movie {
	Integer mid;
	String name;
	String genre;
	String releaseDate;
	String showTime;

	public Movie() {
	}

	public Movie(Integer mid, String name, String genre, String releaseDate, String showTime) {
		this.mid = mid;
		this.name = name;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.showTime = showTime;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", name=" + name + ", genre=" + genre + ", releaseDate=" + releaseDate
				+ ", showTime=" + showTime + "]";
	}
}
