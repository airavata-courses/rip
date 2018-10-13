package sga.JSONParser.Configs;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.google.gson.Gson;

import sga.JSONParser.Handlers.GetJSONFileHandler;
import sga.JSONParser.Services.GetJSONService;

@Configuration
@SpringBootApplication(exclude=DispatcherServletAutoConfiguration.class)
@ComponentScan
public class ThriftServerConfig {
	@Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }
	
	@Bean
    public ServletRegistrationBean thriftGetJSONFileServlet(TProtocolFactory protocolFactory, GetJSONFileHandler handler) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();   
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(GetJSONFileConfigs.class);
        dispatcherServlet.setApplicationContext(applicationContext);
        TServlet tServlet = new TServlet(new GetJSONService.Processor<>(handler), protocolFactory);
        ServletRegistrationBean srb = new ServletRegistrationBean(tServlet, "/getjsonfile");
        srb.setName("getjsonfile");
        return srb;
	}
	
	@Bean
	public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson) {
	        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
	        converter.setGson(gson);
	        return converter;
	    }

}
