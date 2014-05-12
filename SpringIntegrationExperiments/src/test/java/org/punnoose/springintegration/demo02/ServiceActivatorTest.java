package org.punnoose.springintegration.demo02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public class ServiceActivatorTest {

	@Autowired
	private MessageChannel flightDelayInput;
	@Autowired
	private PollableChannel statusUpdates;

	@Test
	public void testTransfom() {
		Message<String> message = MessageBuilder.withPayload("SI77+0130")
				.build();
		flightDelayInput.send(message);
		Message<?> status = statusUpdates.receive();
		assertNotNull(status);
		Object payload = status.getPayload();
		assertNotNull(payload);
		assertEquals(FlightStatus.class, payload.getClass());
	}
}