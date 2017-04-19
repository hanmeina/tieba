package com.xjtu.dao;

import java.util.List;

import com.xjtu.domain.Reply;
import com.xjtu.domain.Topic;

public interface TopicDao {
	//保存帖子
	void save(Topic t);
	//根据条件查询帖子列表
	List<Topic> getAll(String key);
	//根据id查询帖子
	Topic findTopicById(Integer tid);
	//保存回帖
	void saveReply(Reply reply);
}
