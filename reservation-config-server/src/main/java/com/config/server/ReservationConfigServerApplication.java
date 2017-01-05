package com.config.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableConfigServer
//@EnableWebSecurity
public class ReservationConfigServerApplication /*extends WebSecurityConfigurerAdapter*/{

	/*@Autowired
	public void configureUser(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("user").password("password").roles("User");
		
	}*/
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().addHeaderWriter(new StaticHeadersWriter("my-custom-header", "1234556"));
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(ReservationConfigServerApplication.class, args);

	}
}

@Configuration
class WebMvcConf extends WebMvcConfigurerAdapter {
	
	
	@Autowired
	public HeaderInterceptor headerInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerInterceptor);
	}
	
	
	@Bean
	public HeaderInterceptor getInterceptor(){
		return new HeaderInterceptor();
	}
	
}

@Configuration
class MyNativEnv extends MultipleJGitEnvironmentRepository {

	StandardServletEnvironment environment;

	private List<String> customFiles;

	public List<String> getCustomFiles() {
		return customFiles;
	}

	public void setCustomFiles(List<String> customFiles) {
		this.customFiles = customFiles;
	}

	public MyNativEnv(ConfigurableEnvironment environment) {
		super(environment);
		this.environment = (StandardServletEnvironment) environment;
	}

	@Override
	public Environment findOne(String application, String profile, String label) {
		Environment env = super.findOne(application, profile, label);
		String path = StringUtils
				.cleanPath(getWorkingDirectory() + "/" + getSearchPaths()[0] + "/" + "email-conf.properties");
		File file = new File(path);
		Properties p = new Properties();
		if (file.exists()) {
			try {
				p.load(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		env.add(new PropertySource("email-conf.properties", p));
		return env;
	}
}
