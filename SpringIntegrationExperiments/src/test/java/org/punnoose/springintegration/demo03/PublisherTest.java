package org.punnoose.springintegration.demo03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.punnoose.springintegrationdemo.vo.FlightDelayEvent;
import org.punnoose.springintegrationdemo.vo.FlightStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Transformer Demo
 * @author "Punnoose Pullolickal"
 *
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PublisherTest {

	@Autowired
	private MessageChannel flightDelayInput;
	@Autowired
	private PollableChannel statisticsChannel;

	@Test
	public void testTransfom() {
		Message<String> message = MessageBuilder.withPayload("SI77+0130")
				.build();
		flightDelayInput.send(message);
		Message<?> flightDelayEvent = statisticsChannel.receive();
		assertNotNull(flightDelayEvent);
		Object payload = flightDelayEvent.getPayload();
		assertNotNull(payload);
		assertEquals(FlightDelayEvent.class, payload.getClass());
	}
}