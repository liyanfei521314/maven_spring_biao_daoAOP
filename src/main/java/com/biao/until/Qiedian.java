package com.biao.until;

import com.biao.haveuse.Xitong;
import com.biao.pojo.Fan;
import com.biao.pojo.Systemlogmessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Aspect
@Component
@Order(1)
public class Qiedian {

    @Autowired
    private Xitong xitong;

    @Around("@annotation(com.biao.until.Zhujie)")
    public Object up(ProceedingJoinPoint joinPoint) {
        Object object=null;
        String str="";
        boolean iswrite=true;
        Object[] o = joinPoint.getArgs();
        String zhiname = joinPoint.getSignature().getName();
        try {
            Class clazz=Class.forName("com.biao.haveuse.Zhixing");
            Method[] methods=clazz.getMethods();
            for (Method m:methods) {
                if (m.getName().equals(zhiname)) {
                    if (m.getParameterTypes().length == o.length) {
                        Zhujie zhujie = m.getAnnotation(Zhujie.class);
                        str=zhujie.yan();
                        iswrite=zhujie.iswrite();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Systemlogmessage systemlogmessage=new Systemlogmessage();
        long starttime=System.currentTimeMillis();
        try {
            object=joinPoint.proceed(o);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            systemlogmessage.setSystemLogMessage_Exception(throwable.toString());
        }
        long endtime = System.currentTimeMillis();
        long time = endtime - starttime;
        String argus = "";
        if(iswrite) {
            for (Object ob : o) {
                argus += (ob + ",");
            }
        }else{
            for (Object ob : o) {
                argus += ob.getClass().getTypeName() + ",";
            }
        }

        //时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        systemlogmessage.setSystemLogMessage_Name("root");
        systemlogmessage.setSystemLogMessage_Roles("人");
        systemlogmessage.setSystemLogMessag_Method(zhiname);
        systemlogmessage.setSystemLogMessage_Description(str);
        systemlogmessage.setSystemLogMessage_Params(argus);
        systemlogmessage.setSystemLogMessage_StartTime(Date.valueOf(formatter.format(starttime)));
        systemlogmessage.setSystemLogMessage_Time(String.valueOf(time));
        Object fan=(Fan)object;
        if (((Fan) fan).getCode()==100) {
            systemlogmessage.setSystemLogMessage_Successful("成功");
        }else{
            systemlogmessage.setSystemLogMessage_Successful("失败");
        }

        Integer n= xitong.logmessage(systemlogmessage);

        return object;
    }


}
