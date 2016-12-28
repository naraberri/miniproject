package org.naraberri.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.naraberri.web.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (request.getMethod().equals("GET")) {
			return;
		}

		HttpSession session = request.getSession();
/*		String referer = "/web/member/Page";
		logger.info("너도  null인거니?" + referer);*/
		String referer = (String) session.getAttribute("referer");
		logger.info("어디서 null인거니?" + referer);
		
		if(modelAndView.getModel() == null){
			return;
		}
		
		Object value = modelAndView.getModel().get("value");

		logger.info("referer....." + referer);

		if (value != null) {
			
			logger.info("인터셉터...");

			session.setAttribute("LOGIN", value);

			Cookie[] cookie = request.getCookies();

			Cookie loginCookie = new Cookie("value", (String) value);
			loginCookie.setMaxAge(60 * 60 * 24);
			
			logger.info(cookie.toString());
			logger.info("쿠키생성.....");

			logger.info("레퍼러 확인지점입니다");
			response.addCookie(loginCookie);
			if(referer == null){
				referer = "/web/member/Page?page=1";
				response.sendRedirect(referer);
			}
		}
	}

}
