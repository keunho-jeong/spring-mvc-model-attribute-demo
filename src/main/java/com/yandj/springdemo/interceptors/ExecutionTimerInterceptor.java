package com.yandj.springdemo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yandj.springdemo.util.CalendarUtils;

@Service
public class ExecutionTimerInterceptor implements HandlerInterceptor {

	private static Logger log = Logger.getLogger(ExecutionTimerInterceptor.class);
	
	long PREHANDLE_TIME = 0;
	long POSTHANDLE_TIME = 0;
	long AFTER_COMPLETION_TIME = 0;
	
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		log.debug("afterCompletion start");
		AFTER_COMPLETION_TIME = System.currentTimeMillis();
		long HANDLER_EXECUTION_TIME = PREHANDLE_TIME -PREHANDLE_TIME;
		long TOTAL_EXECUTION_TIME = AFTER_COMPLETION_TIME -PREHANDLE_TIME;
		
		log.debug("AFTER_COMPLETION_TIME =" + CalendarUtils.getFormattedDate("yyyy/MM/dd HH:mm:ss", AFTER_COMPLETION_TIME));
		log.debug("HANDLER_EXECUTION_TIME =" + CalendarUtils.getFormattedDate("yyyy/MM/dd HH:mm:ss", HANDLER_EXECUTION_TIME));
		log.debug("TOTAL_EXECUTION_TIME =" + CalendarUtils.getFormattedDate("yyyy/MM/dd HH:mm:ss", TOTAL_EXECUTION_TIME));
		log.debug("afterCompletion end");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		log.debug("postHandle start");
		POSTHANDLE_TIME = System.currentTimeMillis();
		log.debug("POSTHANDLE_TIME =" + CalendarUtils.getFormattedDate("yyyy/MM/dd HH:mm:ss", POSTHANDLE_TIME));
		log.debug("postHandle end");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		log.debug("preHandle start");
		PREHANDLE_TIME = System.currentTimeMillis();
		log.debug("PREHANDLE_TIME =" + CalendarUtils.getFormattedDate("yyyy/MM/dd HH:mm:ss", PREHANDLE_TIME));
		log.debug("preHandle end");
		
		return true;
	}

}
