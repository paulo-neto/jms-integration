package com.pauloneto.jmsintegration.producers;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import com.pauloneto.jmsintegration.models.Product;

@Stateless
public class ProductMessageProducer {

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext context;
	
	@Resource(mappedName = "java:/jboss/exported/jms/queue/TestQ")
	private Queue testeQ;
	
	public void sendMessage(Product product) {
        context.createProducer().send(testeQ, product);		
	}

}
