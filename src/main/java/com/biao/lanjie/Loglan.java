package com.biao.lanjie;

import com.biao.lanjie.token.Token;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Loglan extends HandlerInterceptorAdapter {

    // 必须实现的方法,该方法决定是否对某些请求放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       String path= request.getServletPath();
        if(path.matches(SystemUtils.STATIC_NO_PERMISSION_PATH)){
            return true;
        }

        //得到用户的token
        String token=request.getParameter("token");
        //解密得到用户拥有的权限
        List l=null;
        try {
            l=new Token().unCreateToken(List.class,token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("拦截："+String.valueOf(l));

        List<String> userPermission = l;
        if(userPermission==null){
            throw new SystemException();
        }

        if(handler instanceof HandlerMethod){
            String permissionURL = SystemUtils.getMethodOfPermission((HandlerMethod) handler);
            if(!userPermission.contains(permissionURL)){
                throw new Exception("您没有权限！");
            }
        }

        return true;
    }

}
