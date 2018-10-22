package com.Json.Mongo.ThriftConfig;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.Json.Mongo.ThriftConfig.*;
import com.Json.Mongo.handelers.*;
import com.Json.Mongo.services.*;;


@Configuration
@SpringBootApplication(exclude=DispatcherServletAutoConfiguration.class)
@ComponentScan
public class ThriftConfig {

	@Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }
	
	@Bean
    public ServletRegistrationBean thriftInsertServlet(TProtocolFactory protocolFactory, InsertServiceHandler handler) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();   
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(InsertConfig.class);
        dispatcherServlet.setApplicationContext(applicationContext);
        TServlet tServlet = new TServlet(new InsertService.Processor<>(handler), protocolFactory);
        ServletRegistrationBean srb = new ServletRegistrationBean(tServlet, "/insertservice");
        srb.setName("InsertService");
        return srb;
	}
	
	
	@Bean
    public ServletRegistrationBean thriftGetServlet(TProtocolFactory protocolFactory, GetServiceHandler handler) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();   
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(GetConfig.class);
        dispatcherServlet.setApplicationContext(applicationContext);
        TServlet tServlet = new TServlet(new GetService.Processor<>(handler), protocolFactory);
        ServletRegistrationBean srb = new ServletRegistrationBean(tServlet, "/getjsonfile");
        srb.setName("GetService");
        return srb;
	}
	
	
	
	
}
