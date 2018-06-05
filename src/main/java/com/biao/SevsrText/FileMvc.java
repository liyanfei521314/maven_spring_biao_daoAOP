package com.biao.SevsrText;

import com.biao.haveuse.Zhixing;
import com.biao.pojo.Fan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping(value = "/filer", name = "文件系统")
public class FileMvc {

    @Autowired
    Zhixing zhixing;

    @Autowired
    Fan fan;

    @RequestMapping(value = "/selectfile",method = RequestMethod.POST,name = "文件查看权限")
    public Fan selectfile(String page,String limit){
        Integer page1= Integer.valueOf(page);
        Integer limit1= Integer.valueOf(limit);

        //fan=zhixing .selectfile(page1,limit1);

        fan.setCode(100);
        return fan;
    }

    @RequestMapping(value = "/setfile",method = RequestMethod.POST,name = "文件上传权限")
    public Fan setfile(MultipartFile file){
        if(file.isEmpty()){
            fan.setCode(101);
            return fan;
        }else {
            //fan=zhixing.setfile(file);
            return fan;
        }
    }

    @RequestMapping(value = "/xiazai",method = RequestMethod.GET,name = "文件下载权限")
    public ResponseEntity<byte[]> xiazai(String id){
        Integer id1= Integer.valueOf(id);
        ResponseEntity<byte[]> l=null;
//        try {
//            l= zhixing.xiazai(id1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return l;
    }
}
