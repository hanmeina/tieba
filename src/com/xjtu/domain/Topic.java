package com.xjtu.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//帖子
public class Topic {
	private Integer tid;
	private String title;			//标题
	private String topicContent;	//内容
	private String ipAddr;			//ip地址（作者）
	private Date lastReplyDate;		//最后回复时间
	private Date createDate;		//发帖时间（创建时间）
	
	
	//一对多： 一个主题 可以拥有 【多个回复】

	private Set<Reply> replySet = new HashSet<Reply>();


	public Integer getTid() {
		return tid;
	}


	public void setTid(Integer tid) {
		this.tid = tid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIpAddr() {
		return ipAddr;
	}


	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}


	public Date getLastReplyDate() {
		return lastReplyDate;
	}


	public void setLastReplyDate(Date lastReplyDate) {
		this.lastReplyDate = lastReplyDate;
	}


	public String getTopicContent() {
		return topicContent;
	}


	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Set<Reply> getReplySet() {
		return replySet;
	}


	public void setReplySet(Set<Reply> replySet) {
		this.replySet = replySet;
	}

	
}