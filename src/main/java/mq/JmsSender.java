package mq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsSender {

	public static void main(String[] args)throws Exception {

		
	
		 ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		 Connection connection = factory.createConnection();
		 	connection.start();
		 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 	Topic topic = session.createTopic("1521");
		 	MessageProducer producer = session.createProducer(topic);
		 	producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		 	TextMessage message =  session.createTextMessage();
		 	
			//String msg="{\"ammount\":300,\"enabled\":true,\"type\":7,\"userid\":57975}";
			String msg="{\"type\":2,\"userId\":4400003713}";
		 	message.setText(msg);
		 	producer.send(message);			

		 	session.close();
		 	connection.stop();
		 	connection.close();
		

		 	
		 	
		 	
	}

}
