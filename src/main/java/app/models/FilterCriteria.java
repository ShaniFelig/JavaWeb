package app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilterCriteria {

	private User[] publishers;
	private Date startingDate;
	private Date endingDate;
	private List<String> hashtags;

	public User[] getPublishers() {
		return publishers;
	}

	public void setPublishers(User[] publishers) {
		this.publishers = publishers;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public List<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}

	public List<Integer> getUserIds() {
		List<Integer> ids = new ArrayList<>();

		if (publishers != null) {
			for (User user : publishers) {
				ids.add(user.getUserId());
			}
		}
		return ids;
	}

}
