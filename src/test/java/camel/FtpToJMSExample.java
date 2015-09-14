package camel;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class FtpToJMSExample {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");

		context.addComponent("jms",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("ftp://127.0.0.1?username=dingo&password=12345").process(new Processor() {
					
					@Override
					public void process(Exchange arg0) throws Exception {
						System.out.println("wu just download:"+arg0.getIn().getHeader("CamelFileName"));
					}
				}).to(
						"jms:orderincoming");
			}

		});
		context.start();
		boolean loop=true;
		while(loop){
			Thread.sleep(1000);
		}
		context.stop();
	}
}
