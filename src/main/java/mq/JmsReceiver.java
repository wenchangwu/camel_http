package mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsReceiver {
	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("topic11");
		MessageConsumer consumer = session.createConsumer(topic);
		   while (true) {
               TextMessage message = (TextMessage) consumer.receive(1000);
               if (null != message)
                       System.out.println("收到消息：" + message.getText());
               else
                       break;
       } 
		session.close();
		connection.stop();
		connection.close();
	}

}
