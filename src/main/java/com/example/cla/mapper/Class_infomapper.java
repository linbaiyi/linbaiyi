package com.example.cla.mapper;

import com.example.cla.entity.Class_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface Class_infomapper {
    List<Class_Info> getclassList(@Param("field_name") String field_name,
                                          @Param("start") int start,
                                          @Param("page_size") int page_size);
    void  geteditclass(@Param("c_id") String c_id,
                           @Param("cname") String cdy_name,
                           @Param("cinfo") String cinfo,
                           @Param("cad") String cname,
                           @Param("cty") String cty,
                           @Param("cap") int cap);
    void deleteclass(@Param("c_id") String c_id);
    void addclass(@Param("c_id") String c_id,
                  @Param("cname") String cdy_name,
                  @Param("cinfo") String cinfo,
                  @Param("cad") String cname,
                  @Param("cty") String cty,
                  @Param("cap") int cap);
    List<Class_Info> getAllClassList();

}
