package org.jana.securityservice.service.extra.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @Component
public class CustomHandlerInterceptor implements HandlerInterceptor {

    public CustomHandlerInterceptor() {
        super();
    }

    /*
            Authentication and authorization:
                Interceptors can be used to enforce authentication and authorization rules before allowing requests to be processed by the controller.
                For example, an interceptor can check if a user is logged in and has the required permissions
                before allowing access to a protected resource.

            Logging and auditing:
                Interceptors can be used to log incoming requests and outgoing responses, as well as perform auditing tasks
                such as tracking user activity and changes to data.

            Request and response modification:
                Interceptors can be used to modify incoming requests or outgoing responses. For example, an interceptor can add a custom header to an incoming request, or modify the body of an outgoing response.

            Caching:
                Interceptors can be used to cache responses for faster processing of subsequent requests.
                For example, an interceptor can check if a response has already been cached and return the cached response
                instead of processing the request again.


            Interceptors can be registered in Spring Boot using the addInterceptor() method of the WebMvcConfigurer interface.
            Interceptors can be configured to apply to all requests, or to specific requests based on URL patterns or other criteria.
    * */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // check jwt authorization
        //     restricted api, header present, jwt valid
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        return;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        return;
    }



}
