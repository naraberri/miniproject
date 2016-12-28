package org.naraberri.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.naraberri.web.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("Check ....");

		HttpSession session = request.getSession();
		logger.info("Check session....");
		String referer = request.getRequestURI();
		logger.info("Check referer....");

		logger.info("====================");
		logger.info(referer.toString());
		logger.info("====================");

		// Cookie[] arr = request.getCookies();

		/*
		 * Object obj = "gonoble"; String id = arr[0].getValue();
		 * 
		 * if (obj.equals(id)) {
		 * 
		 * return true; }
		 * 
		 * logger.info("===========쿠키가 없습니다=========");
		 * session.setAttribute("referer", referer);
		 * response.sendRedirect("login");
		 * 
		 * return false;
		 */
		logger.info("확인지점1입니다.......");
		String id = "";
		logger.info("확인지점2입니다......." + id);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			logger.info("확인지점3입니다......." + cookies);
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("value")) {
					id = cookies[i].getValue();
					logger.info("확인지점4입니다......." + id);
					return true;

				}

				/*
				 * if (id.equals("")) { response.sendRedirect("login");
				 * logger.info("===========쿠키가 없습니다========="); return false; }
				 */
			}
		}
		logger.info("확인지점5입니다........");
		response.sendRedirect("login");
		return false;
	}

}
