package com.config.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HeaderInterceptor implements HandlerInterceptor{

	/*@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		HttpHeaders headers = request.getHeaders();
		
		
		return execution.execute(request, body);
	}*/
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		Enumeration<String> headers = request.getHeaderNames();
		/*if (StringUtils.isEmpty(request.getHeader("custome-header"))) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		} else {
			response.setHeader("my-header", "my header");
			return true;
		}*/
		
		return true;
		
		// TODO Auto-generated method stub
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setHeader("my-header-cros", "my header-cros");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	

}
