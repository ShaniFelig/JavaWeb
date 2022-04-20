package app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilterCriteria {

	private User[] users;
	private Date startDate;
	private Date endDate;
	private HashTag[] hashTags;

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public HashTag[] getHashTags() {
		return hashTags;
	}

	public void setHashTags(HashTag[] hashTags) {
		this.hashTags = hashTags;
	}

	public List<Integer> getUserIds() {
		List<Integer> ids = new ArrayList<>();
		for (User user : users) {
			ids.add(user.getUserId());
		}
		return ids;
	}

}
