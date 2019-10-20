package com.pauloneto.jmsintegration.consumers;

import javax.annotation.security.PermitAll;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.pauloneto.jmsintegration.models.Product;

@MessageDriven(name = "ProductMessageConsumerMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jboss/exported/jms/queue/TestQ"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class ProductMessageConsumerMDB implements MessageListener{
	

	@Override @PermitAll
	public void onMessage(Message message) {
		Product product;
		try {
			product = message.getBody(Product.class);
			if(product != null)
				System.out.println(product);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
}
