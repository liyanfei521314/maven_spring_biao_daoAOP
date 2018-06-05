package com.biao.haveuse;

import com.biao.lanjie.token.Token;
import com.biao.pojo.*;
import com.biao.dao.Com01InfoMapper;
import com.biao.pojo.System.LoginReturn;
import com.biao.until.Zhujie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class Zhixing {

    @Autowired
    private Com01InfoMapper mapper;

    @Zhujie(yan = "开始验证用户登录")
    public Fan login(String name,String prw ){
        Fan fan=new Fan();
        LoginReturn loginReturn=new LoginReturn();
        Usertb u=mapper.selectUsertb(name,prw);
        if(u==null){
            fan.setCode(101);
            fan.setMsg("登录失败");
            return fan;
        }
        //查询用户角色id
        List<Integer> roleId=mapper.selectroleId(Math.toIntExact(u.getUserId()));
        //查询用户模块id
        List<Integer> moduleId=mapper.selectmoduleId(roleId);
        //查询用户所有的权限
        List<String> l=mapper.selectPermission(Math.toIntExact(u.getUserId()));
        Token token=new Token();
        String mi="";
        try {
            mi=token.createToken(l,1*60*60*100);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //数据
        loginReturn.setUserId(Math.toIntExact(u.getUserId()));
        loginReturn.setUsername(u.getUserName());
        loginReturn.setRoleId(roleId);
        loginReturn.setModuleId(moduleId);
        loginReturn.setToken(mi);

        fan.setCode(100);
        fan.setMsg("登录成功");
        fan.setData(loginReturn);
        return fan;
    }

    public Fan info(List<String> moduleIds){
        List<Moduletb> moduletbfathers=mapper.selectmoduletbfathers(0,moduleIds);
        for(Moduletb m:moduletbfathers) {
            moduletbCherchs(m);
        }

        Fan fan=new Fan();
        fan.setCode(100);
        fan.setData(moduletbfathers);
        return fan;
    }
    public void moduletbCherchs(Moduletb m){
        m.setCherch(mapper.selectmoduletbCherchs(Math.toIntExact(m.getModuleId())));
        if(m.getCherch()!=null && m.getCherch().size()>0){
            for(Moduletb m1:m.getCherch()) {
                moduletbCherchs(m1);
            }
        }
    }
}
