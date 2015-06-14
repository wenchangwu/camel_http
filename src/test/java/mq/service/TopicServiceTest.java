package mq.service;

import javax.annotation.Resource;

import mq.service.TopicSendService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/activeMq_test.xml" })
public class TopicServiceTest {

	@Resource
	private TopicSendService topicSendService;

	@Test
	public void testSend() {
		for(int i=0;i<100;i++){
			topicSendService.send("topic11", "this is just a demo   "+i);
		}
		
	}

}
