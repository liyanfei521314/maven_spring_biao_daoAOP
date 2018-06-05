package com.biao.haveuse;

import com.biao.dao.XitongMapper;
import com.biao.pojo.Permissiontb;
import com.biao.pojo.Systemlogmessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Xitong {

    @Autowired
    private XitongMapper mapper;

    public Integer logmessage(Systemlogmessage systemlogmessage){
        Integer n=mapper.insertsystemlogmessage(systemlogmessage);
        return n;
    }

    public List<String> selectpermissiontb(){
        List<String> p=mapper.selectpermissiontb();
        return p;
    }

    public Integer insertpermissiontb(Permissiontb permissiontb){
        Integer n=mapper.insertpermissiontb(permissiontb);
        return n;
    }

}
