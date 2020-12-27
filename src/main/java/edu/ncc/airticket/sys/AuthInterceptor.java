package edu.ncc.airticket.sys;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 *通过验证seesion中是否有principal对象，来验证是否登录，登录就放行，返回true，否则返回fale
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、拿session
        HttpSession session=request.getSession();
        //2、获取principal对象
        Object principal=session.getAttribute("principal");
        //3、判断principal是否为空，为空代表未登录，返回false，否则返回true
        if(principal!=null)
            return true;
        //设置状态码403，然后返回false
        response.setStatus(403);
        return false;
    }
}
