package mq.service;

public interface TopicSendService {

	public void send(String topicName,final String message);
}
