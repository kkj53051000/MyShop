package com.myshop.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myshop.dto.UserSession;
import com.myshop.vo.UnAuthorizedResponse;

public class AuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		HttpSession session = httpRequest.getSession();
		UserSession userSession = (UserSession)session.getAttribute("user");
		
		
		if(userSession == null) {
			// 응답헤더설정
			httpResponse.setHeader("Content-Type", "application/json");
			httpResponse.setCharacterEncoding("UTF-8");
			httpResponse.setStatus(403);
			// httpResponse.sendRedirect("/need_login");
			
			// 응답데이터제이슨화
			UnAuthorizedResponse unAuthorizedResponse = new UnAuthorizedResponse();
			ObjectMapper mapper = new ObjectMapper();
			String jsonResponseString = mapper.writeValueAsString(unAuthorizedResponse);
			
			// 출력
			PrintWriter out = httpResponse.getWriter();
			out.write(jsonResponseString);
			
			return false;
		}else {
			return true;
		}
		
		
		
	}
}
