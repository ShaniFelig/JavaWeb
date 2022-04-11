package com.example.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comment {

	@Id
	private int commentId;
	private int userId;
	private int postId;
	private String content;
	private HashTag[] tags;
	/* private UserTaggedComment userTaggedComment; */
}
