# jms-integration
Projeto que exemplifica o uso da API JMS do Java para integração entre sistemas

# Container JavaEE
Esse exemplo usa como conyainer JavaEE o Jboss EAP 7.1, usando o arquivo standalone.xml

# Configurar uma fila(Queue)
No arquivo ``standalone.xml``  procure o subsystem ``urn:jboss:domain:ejb3:5.0`` e adicione:
<pre>
<code>
<mdb>
	<resource-adapter-ref resource-adapter-name="${ejb.resource-adapter-name:activemq-ra.rar}"/>
	<bean-instance-pool-ref pool-name="mdb-strict-max-pool"/>
</mdb>
</code>
</pre>
No arquivo ``standalone.xml``  procure o subsystem ``urn:jboss:domain:messaging-activemq:`` e adicone:

``<jms-queue name="TestQ" entries="java:/jboss/exported/jms/queue/TestQ"/>``

