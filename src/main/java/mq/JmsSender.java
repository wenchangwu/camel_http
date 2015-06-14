package mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import jpa.domain.User;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsSender {

	public static void main(String[] args)throws Exception {

		    
		 ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		 Connection connection = factory.createConnection();
		 	connection.start();
		 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 	Topic topic = session.createTopic("topic11");
		 	MessageProducer producer = session.createProducer(topic);
		 	producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		 	TextMessage message =  session.createTextMessage();
		 	message.setText("{\"type\": \"1\", \"userSeq\", \"12345678\"}");
		 	producer.send(message);			

		 	session.close();
		 	connection.stop();
		 	connection.close();

	}

}
