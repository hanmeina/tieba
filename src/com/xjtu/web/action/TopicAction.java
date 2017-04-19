package com.xjtu.web.action;

import java.util.Date;

import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xjtu.dao.TopicDao;
import com.xjtu.dao.TopicDaoImpl;
import com.xjtu.domain.Reply;
import com.xjtu.domain.Topic;

public class TopicAction extends ActionSupport {

	private TopicDao ud = new TopicDaoImpl();
	private Topic topic;
	private String key;
	private Integer tid;
	private Reply reply;
	


	//帖子列表
	public String list(){
		//1调用dao获得帖子列表
		List<Topic> list = ud.getAll(key);
		//2 将帖子列表放入ActionContext中
		ActionContext.getContext().put("list", list);
		
		return "list";
	}
	


	//------------------------------------------------------
	//发帖
	public String add(){
		
		//1 ip
		topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		//2 创建/回帖时间
		topic.setCreateDate(new Date());
		topic.setLastReplyDate(topic.getCreateDate());
		//3保存
		ud .save(topic);
		
		return "toList";
	}
//---------------------------------------------------------------
	public String  showTopic(){
		System.out.println("tid:---"+topic.getTid());
		Topic findTopic = ud.findTopicById(topic.getTid());
		ActionContext.getContext().put("findTopic", findTopic);
		return "findTopicSuccess";
	}
	   
	//回帖
	public String addReply(){
		//topic.setTid(tid);
		System.out.println("tid:"+topic.getTid());
		reply.setTopic(topic);
		reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		reply.setCreateDate(new Date());
		topic.setLastReplyDate(reply.getCreateDate());
		ud.saveReply(reply);
		return "addReplySuccess";  
		  
	}

	
	public Topic getTopic() {		
		return topic;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}



	public Integer getTid() {
		return tid;
	}



	public void setTid(Integer tid) {
		this.tid = tid;
	}



	public Reply getReply() {
		return reply;
	}



	public void setReply(Reply reply) {
		this.reply = reply;
	}
	
}
