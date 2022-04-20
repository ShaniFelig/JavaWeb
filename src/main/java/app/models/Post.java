package app.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;

	@Column(columnDefinition = "text")
	private String imageSorce;

	private Date date;

	private long x_position;
	private long y_position;
	private long z_position;

	@OneToMany
	@JoinColumn(name = "post_id")
	private Set<Like> likes;

	@OneToMany
	@JoinColumn(name = "post_id")
	private Set<Comment> comments;

	@Column(name = "user_id")
	private int userId;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Like> getLikes() {
		return likes;
	}

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int id) {
		this.postId = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImageSorce() {
		return imageSorce;
	}

	public void setImageSorce(String imgSorce) {
		this.imageSorce = imgSorce;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getX_Position() {
		return x_position;
	}

	public void setX_Position(long x_position) {
		this.x_position = x_position;
	}

	public long getY_Position() {
		return y_position;
	}

	public void setY_position(long y_position) {
		this.y_position = y_position;
	}

	public long getZ_position() {
		return z_position;
	}

	public void setZ_position(long z_position) {
		this.z_position = z_position;
	}

}
