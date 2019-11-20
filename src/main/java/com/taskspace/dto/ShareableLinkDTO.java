package com.taskspace.dto;

public class ShareableLinkDTO {

	private int linkId;
	private String link;
	private boolean hasLink;
	
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public boolean getHasLink() {
		return hasLink;
	}
	public void setLinkId(boolean hasLink) {
		this.hasLink = hasLink;
	}
	
}
