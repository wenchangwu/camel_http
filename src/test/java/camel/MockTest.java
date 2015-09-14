/*package camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MockTest extends CamelTestSupport{

	
	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("jms:topic:quote").to("mock:quote");
			}
		};
	}
	
	@Test
	public void testQuote() throws Exception{
		MockEndpoint quote=getMockEndpoint("mock:quote");
		quote.setExpectedMessageCount(1);
		template.sendBody("jms:topic:quote","camel rocks");
		quote.assertIsSatisfied();
	}
}
*/