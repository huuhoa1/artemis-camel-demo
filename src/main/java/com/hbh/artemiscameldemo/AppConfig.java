package com.hbh.artemiscameldemo;

import javax.jms.JMSException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
    @Bean
    public JmsComponent jms2() throws JMSException {
        // Create the connectionfactory which will be used to connect to Artemis
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
        cf.setBrokerURL("tcp://localhost:61617");
        cf.setUser("artemis");
        cf.setPassword("artemis");

        // Create the Camel JMS component and wire it to our Artemis connectionfactory
        JmsComponent jms2 = new JmsComponent();
        jms2.setConnectionFactory(cf);
        return jms2;
    }

}
