package com.example.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HashTaggedComments")
public class HashTaggedComment {

	@Id
	private int commentId;
	private int hashTagId;

}
