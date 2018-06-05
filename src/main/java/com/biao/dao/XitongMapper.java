package com.biao.dao;

import com.biao.pojo.Permissiontb;
import com.biao.pojo.Systemlogmessage;
import com.biao.pojo.Usertb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XitongMapper {

    Integer insertsystemlogmessage(Systemlogmessage insertsystemlogmessage);

    List<String> selectpermissiontb();
    Integer insertpermissiontb(Permissiontb permissiontb);

}
