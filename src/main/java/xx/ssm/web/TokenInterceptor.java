package xx.ssm.web;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TokenInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
	 
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
        if (handler instanceof HandlerMethod) {  
            HandlerMethod handlerMethod = (HandlerMethod) handler;  
            Method method = handlerMethod.getMethod();  
            WebToken annotation = method.getAnnotation(WebToken.class);  
            if (annotation != null) {  
                boolean needSaveSession = annotation.save();  
                if (needSaveSession) {  
                    request.getSession(true).setAttribute("token", UUID.randomUUID().toString());  
                }  
                boolean needRemoveSession = annotation.remove();  
                if (needRemoveSession) {  
                    if (isRepeatSubmit(request)) {  
                    	logger.warn("please don't repeat submit,url:"+ request.getServletPath());
                    	request.setAttribute("model_path", request.getServletPath().replace("save", "list") + "?" + request.getQueryString());
                    	request.getRequestDispatcher("/manager/repeat.jsp").forward(request, response);  
                        return false;  
                    }  
                    request.getSession(true).removeAttribute("token");  
                }  
            }  
            return true;  
        } else {  
            return super.preHandle(request, response, handler);  
        }  
    }  
	  
    private boolean isRepeatSubmit(HttpServletRequest request) {  
        String serverToken = (String) request.getSession(true).getAttribute("token");  
        if (serverToken == null) {  
            return true;  
        }  
        String clinetToken = request.getParameter("token");  
        if (clinetToken == null) {  
            return true;  
        }  
        if (!serverToken.equals(clinetToken)) {  
            return true;  
        }  
        return false;  
    }  
}
