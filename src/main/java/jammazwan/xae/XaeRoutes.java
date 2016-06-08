package jammazwan.xae;

import org.apache.camel.builder.RouteBuilder;

public class XaeRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:../jammazwan.shared/src/main/resources/data/csv/?noop=true&fileName=name.csv")
				.unmarshal("nameDataFormat").to("mock:names");
		;
	}
}
