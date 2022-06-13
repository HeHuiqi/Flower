package com.hhq.hq.HqConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhq.hq.HqData.HqUser;
import com.hhq.hq.HqUtils.HqResponseEntity;
import com.hhq.hq.HqUtils.HqToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HqUserTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头中的token: token: xxxxxxxxxxxxxx
        String token = request.getHeader("token");


        HqResponseEntity responseData = HqResponseEntity.ok();
        System.out.println("token=="+token);
        //token存在
        if (token != null) {
            HqUser user = HqToken.unsign(token, HqUser.class);
            System.out.println("user=="+user);

            //解密token后的userId不为0，大多是因为token过期
            if (user != null && user.getUserId()!=0) {

                System.out.println("token通过");
                return true;
            }
        }

        responseData = HqResponseEntity.forbidden();
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(responseData);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
