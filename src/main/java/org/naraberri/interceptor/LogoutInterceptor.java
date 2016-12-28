package org.naraberri.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.naraberri.web.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogoutInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (request.getMethod().equals("GET")) {
			return;
		}

		Cookie[] cookie = request.getCookies();

		logger.info("로그아웃");
		String id = cookie[0].getValue();
		logger.info(id);

		Cookie logoutCookie = new Cookie("value", id);
		logoutCookie.setMaxAge(0);
		logger.info("쿠키값확인......");
		logger.info(cookie[0].toString());
		logger.info(logoutCookie.getValue());
		logger.info("쿠키삭제............");

		response.addCookie(logoutCookie);
	}
}
