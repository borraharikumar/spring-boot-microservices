package com.mvc.mp.interceptor;

import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.err.println("TimeCheckInterceptor.preHandle()");
		LocalDateTime ldt = LocalDateTime.now();
		if(ldt.getHour()<9 || ldt.getHour()>17) {
			RequestDispatcher rd = request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request, response);
			return true;
		}
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.err.println("TimeCheckInterceptor.postHandle()");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.err.println("TimeCheckInterceptor.afterCompletion()");
	}

}
