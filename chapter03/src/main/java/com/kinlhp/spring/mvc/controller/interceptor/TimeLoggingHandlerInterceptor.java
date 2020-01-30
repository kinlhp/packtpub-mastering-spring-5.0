package com.kinlhp.spring.mvc.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Handler/Controller interceptor.
 */
public class TimeLoggingHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = Logger.getLogger(TimeLoggingHandlerInterceptor.class);

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {
        request.setAttribute("endTime", System.currentTimeMillis());
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {
        final Long startTime = (Long) request.getAttribute("startTime");
        final Long endTime = (Long) request.getAttribute("endTime");
        final Long spentTime = endTime - startTime;
        LOGGER.info("The spent in handler in ms: " + spentTime);
    }
}
