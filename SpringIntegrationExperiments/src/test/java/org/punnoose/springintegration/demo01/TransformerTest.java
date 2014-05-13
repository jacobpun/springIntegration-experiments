package org.punnoose.springintegration.demo01;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.punnoose.springintegrationdemo.domain.FlightDelayEvent;
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
public class TransformerTest {

	@Autowired
	private MessageChannel flightDelayInput;
	@Autowired
	private PollableChannel delayEvents;

	@Test
	public void testTransfom() {
		long currentTime = System.currentTimeMillis();
		Message<String> message = MessageBuilder.withPayload("SI77+0130")
				.build();
		flightDelayInput.send(message);
		Message<?> transformed = delayEvents.receive();
		assertNotNull(transformed);
		Object payload = transformed.getPayload();
		assertNotNull(payload);
		assertEquals(FlightDelayEvent.class, payload.getClass());
		Date estimatedDeparture = ((FlightDelayEvent) payload)
				.getEstimatedDeparture();
		long secondsFor1hr30min = 90 * 60;
		long delay = estimatedDeparture.getTime() - currentTime;
		assertEquals(secondsFor1hr30min, delay / 1000);
	}
}