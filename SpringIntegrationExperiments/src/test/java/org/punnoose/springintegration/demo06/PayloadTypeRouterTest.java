package org.punnoose.springintegration.demo06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.punnoose.springintegrationdemo.domain.FlightStatus;
import org.punnoose.springintegrationdemo.domain.cancell.CancellationRequest;
import org.punnoose.springintegrationdemo.domain.cancell.CancellationStatus;
import org.punnoose.springintegrationdemo.domain.payment.CreditCardPayment;
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
public class PayloadTypeRouterTest {

	@Autowired
	private MessageChannel payments;
	@Autowired
	private PollableChannel creditCardPayments;

	@Test
	public void testPayloadTypeRouter() {
		Message<CreditCardPayment> message = MessageBuilder.withPayload(
				new CreditCardPayment()).build();
		payments.send(message);
		Message<?> paymentMessage = creditCardPayments.receive(100);
		assertNotNull(paymentMessage);
		Object payload = paymentMessage.getPayload();
		assertNotNull(payload);
		assertEquals(CreditCardPayment.class, payload.getClass());
	}
}