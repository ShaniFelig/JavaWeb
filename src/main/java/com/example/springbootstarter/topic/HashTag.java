package com.example.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HashTags")
public class HashTag {

	@Id
	private int hashTagId;
	private String content;

}
