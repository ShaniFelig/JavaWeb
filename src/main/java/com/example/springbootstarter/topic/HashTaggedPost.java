package com.example.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HashTaggedPosts")
public class HashTaggedPost {

	@Id
	private int postId;
	private int hashTagId;

}
