package com.pauloneto.jmsintegration.consumers;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import com.pauloneto.jmsintegration.models.Product;

@Stateless
public class ProductMessageConsumer {
	
	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext context;
 
    @Resource(mappedName = "java:/jboss/exported/jms/queue/TestQ")
    private Queue testQ;
	
	public Product onMessage() {
        Product product = context.createConsumer(testQ).receiveBody(Product.class, 1000);
		if(product != null)
			return product;
        
		System.out.println("No Product receiver!!!");
        return null;
	}
}
