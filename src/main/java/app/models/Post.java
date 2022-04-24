package app.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//need to have user tags

@Entity
@Table(name = "Posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;

	@Column(columnDefinition = "text")
	private String imageSorce;

	private String description;
	private Date date;

	private double x_Position;
	private double y_Position;
	private double z_Position;

	@OneToMany
	@JoinColumn(name = "post_id")
	private Set<Like> likes;

	@OneToMany
	@JoinColumn(name = "post_id")
	private Set<Comment> comments;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "PostHashtagMapping", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
	@Column(name = "tags")
	private Set<Hashtag> tags;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "PostUsertagMapping", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "user_name"))
	@Column(name = "usertags")
	private Set<User> userTaggedPost;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false) // tells
	// hibernate to ignore the user object
	// field when performing insert and update
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

	public double getX_Position() {
		return x_Position;
	}

	public void setX_Position(double x_Position) {
		this.x_Position = x_Position;
	}

	public double getY_Position() {
		return y_Position;
	}

	public void setY_Position(double y_Position) {
		this.y_Position = y_Position;
	}

	public double getZ_Position() {
		return z_Position;
	}

	public void setZ_Position(double z_Position) {
		this.z_Position = z_Position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Hashtag> getTags() {
		return tags;
	}

	public void setTags(Set<Hashtag> tags) {
		this.tags = tags;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<User> getUserTaggedPost() {
		return userTaggedPost;
	}

	public void setUserTaggedPost(Set<User> userTaggedPost) {
		this.userTaggedPost = userTaggedPost;
	}

}
