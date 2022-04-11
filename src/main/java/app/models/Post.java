package app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;

	private String content;

	@OneToMany
	@JoinColumn(name = "post_id")
	private Set<Like> likes;

	/*
	 * @OneToOne(targetEntity = User.class)
	 * 
	 * @JoinColumn(name = "userId") private int userId;// How to specify this is a
	 * foreign key? private String description; private String imageSorce; private
	 * int x_Position; private int y_Position; private int z_Position; private Date
	 * date;
	 * 
	 * 
	 * private User user; private Comment comments; private Tag[] tags; private
	 * UserTaggedPost[] userTaggedPost;
	 */

	public Set<Like> getLikes() {
		return likes;
	}

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int id) {
		this.postId = id;
	}
	/*
	 * public int getUserId() { return userId; }
	 * 
	 * public List<Integer> getLikes() { List<Integer> likeIds = new ArrayList<>();
	 * for (int i = 0; i < likes.size(); i++) {
	 * likeIds.add(likes.get(i).getLikeId()); } return likeIds; }
	 */
}
