package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Likes")
public class Like {

	@Id
	@Column(name = "like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int likeId;

	@Column(name = "user_id")
	private int userId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "post_id")
	private int postId; // direct reference in the Like object to the post_id column that appears in the
						// likes table

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "post_id", insertable = false, updatable = false) // which column in likes tables holds the
																			// primary key or id of the posts table
	// insertable and updatable tell hibernate to ignore this class field when
	// submitting update and save request. This way we can add or update a Like
	// without sending the full Post object but rather using the postId field
	// directly
	private Post post;

	public Like() {
	}

	// needed for the newLike endpoint. Will probably remove
	public Like(boolean isActive, Post post, User user) {
		this.setActive(isActive);
		this.setPost(post);
		this.setPostId(post.getPostId());
		this.setUser(user);
		this.setUserId(user.getUserId());
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
