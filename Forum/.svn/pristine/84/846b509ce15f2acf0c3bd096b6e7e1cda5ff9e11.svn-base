package Servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener,ServletRequestListener {
	
	private HttpServletRequest request;
	
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("Session");
		Cookie[] cookies = request.getCookies();
		Cookie RM = null;
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if("RM".equals(cookie.getName())){
					RM=cookie;
				}
			}
		}
		if(RM!=null){
			arg0.getSession().setAttribute("loginName", RM);
		}

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {}

	public void requestDestroyed(ServletRequestEvent arg0) {}

	public void requestInitialized(ServletRequestEvent arg0) {
		this.request=(HttpServletRequest) arg0.getServletRequest();
	}

}
