package cn.qipeicheng.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepetor extends HandlerInterceptorAdapter {

	 	@Override    
	    public boolean preHandle(HttpServletRequest request,    
	            HttpServletResponse response, Object handler) throws Exception {
		return true;
	    }    

	    @Override    
	    public void postHandle(HttpServletRequest request,    
	            HttpServletResponse response, Object handler,    
	            ModelAndView modelAndView) throws Exception {     
	    
	    }      
	    
	    /**  
	     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等   
	     *   
	     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()  
	     */    
	    @Override    
	    public void afterCompletion(HttpServletRequest request,    
	            HttpServletResponse response, Object handler, Exception ex)    
	            throws Exception {      
	  
	    }
}
