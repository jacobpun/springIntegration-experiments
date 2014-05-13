package org.punnoose.springintegration.demo05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.punnoose.springintegrationdemo.domain.FlightStatus;
import org.punnoose.springintegrationdemo.domain.cancell.CancellationRequest;
import org.punnoose.springintegrationdemo.domain.cancell.CancellationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Transformer Demo
 * 
 * @author "Punnoose Pullolickal"
 *
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class FilterTest {

	@Autowired
	private MessageChannel input;
	@Autowired
	private PollableChannel rejected;
	@Autowired
	private PollableChannel confirmed;

	@Test
	public void testFilterForRejection() {
		Message<CancellationRequest> message = MessageBuilder.withPayload(
				new CancellationRequest("SILVER000001")).build();
		input.send(message);
		Message<?> rejectedMessage = rejected.receive(100);
		assertNotNull(rejectedMessage);
		Object payload = rejectedMessage.getPayload();
		assertNotNull(payload);
		assertEquals(CancellationRequest.class, payload.getClass());
	}

	@Test
	public void testFilterForAccept() {
		Message<CancellationRequest> message = MessageBuilder.withPayload(
				new CancellationRequest("GOLD000001")).build();
		input.send(message);
		Message<?> confirmedMessage = confirmed.receive(100);
		assertNotNull(confirmedMessage);
		Object payload = confirmedMessage.getPayload();
		assertNotNull(payload);
		assertEquals(CancellationStatus.class, payload.getClass());
	}
}