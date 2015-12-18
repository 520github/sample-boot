package com.me.springboot.sample.velocity;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleVelocityApplication.class)
public class SampleVelocityApplicationTests {
	@ClassRule
	public static OutputCapture output = new OutputCapture();
	
	@Test
	public void testVelocityTemplate() throws Exception {
		String result = SampleVelocityApplicationTests.output.toString();
		assertTrue("Wrong output: " + result, result.contains("Hello, Andy"));
	}
}
