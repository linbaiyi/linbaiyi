package com.example.cla.service;

import com.example.cla.entity.Class_Info;
import com.example.cla.mapper.Class_infomapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Class_InfoService {
    @Autowired
    private Class_infomapper class_infoMapper;

    public List<Class_Info> getclass_infoList(String field_name, int start_page, int page_size){
        int start = (start_page - 1) * page_size;
        if (start < 0)
            start = 0;
        List<Class_Info> list=null;
        list=class_infoMapper.getclassList(field_name,start,page_size);
        return list;
    }
    public void  geteditclass(String c_id,String cname,String cinfo,String cad,String cty,int cap){
        class_infoMapper.geteditclass(c_id,cname,cinfo,cad,cty,cap);
    }
    public void deleteclass(String c_id){
        class_infoMapper.deleteclass(c_id);
    }
    public void addclass(String c_id,String cname,String cinfo,String cad,String cty,int cap){
        class_infoMapper.addclass(c_id,cname,cinfo,cad,cty,cap);
    }
    public List<Class_Info> getAllclass_infoList(){
        List<Class_Info> list=null;
        list=class_infoMapper.getAllClassList();
        return list;
    }
}
