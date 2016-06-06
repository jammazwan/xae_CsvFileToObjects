package jammazwan.xae;

import java.util.List;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.entity.Name;
import jammazwan.util.HoldContextOpenUntilDone;

public class XaeTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testXae() throws Exception {
		MockEndpoint mock = getMockEndpoint("mock:names");
		mock.expectedMessageCount(1);
		assertMockEndpointsSatisfied();
		List<Name> names = mock.getReceivedExchanges().get(0).getIn().getBody(List.class);
		assertEquals("Ezra", names.get(0).getFemale());
	}

}
