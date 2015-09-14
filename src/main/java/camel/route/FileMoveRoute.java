package camel.route;

import org.apache.camel.builder.RouteBuilder;

public class FileMoveRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:d:/temp/inbox").to("file:d:/temp/outbox");
	}

}
