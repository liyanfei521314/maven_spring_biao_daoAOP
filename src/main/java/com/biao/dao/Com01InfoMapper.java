package com.biao.dao;

import com.biao.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Com01InfoMapper {

    Usertb selectUsertb(@Param("name") String name,@Param("prw") String prw);

    List<String> selectPermission(Integer id);

    List<Integer> selectroleId(Integer id);

    List<Integer> selectmoduleId(List<Integer> list);

    List<Moduletb> selectmoduletbfathers(@Param("one") Integer one,@Param("list")List<String> list);

    List<Moduletb> selectmoduletbCherchs(Integer id);


}
