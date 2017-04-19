package com.xjtu.dao;

import java.util.List;

import com.xjtu.domain.Reply;
import com.xjtu.domain.Topic;

public interface TopicDao {
	//��������
	void save(Topic t);
	//����������ѯ�����б�
	List<Topic> getAll(String key);
	//����id��ѯ����
	Topic findTopicById(Integer tid);
	//�������
	void saveReply(Reply reply);
}
