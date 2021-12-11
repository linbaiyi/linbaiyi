package com.example.cla.controller;

import com.example.cla.entity.Class_Info;
import com.example.cla.service.Class_InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class Class_InfoController {
    @Autowired
    private Class_InfoService class_infoService;
    @RequestMapping("show_class_main")
    public String show_class_main(HttpServletRequest request, Model model){
        String field_name="";
        if (request.getParameter("field_name")!=null){
            field_name=request.getParameter("field_name");
        }
        //int start_page=Integer.parseInt(request.getParameter("start_page"));
        int start_page=1;
        if(start_page<=1){
            start_page=1;
        }
        //int page_size=Integer.parseInt(request.getParameter("page_size"));
        int page_size=10;
        List<Class_Info> class_infoList=class_infoService.getclass_infoList(field_name,start_page,page_size);
        Class_Info class_info=class_infoList.get(0);
        System.out.println(class_info.getCname());
        model.addAttribute("field_name",field_name);
        model.addAttribute("class_list",class_infoList);
        model.addAttribute("start_page", start_page);
        model.addAttribute("page_size", page_size);
        return "class";
    }
    @RequestMapping("edit_class_info")
    public String edit_commodity_info(HttpServletRequest request,Model model){
        String c_id=request.getParameter("c_id");
        String cname=request.getParameter("cname");
        String cinfo=request.getParameter("cinfo");
        String cad=request.getParameter("cad");
        String cty=request.getParameter("cty");
        int cap=Integer.parseInt(request.getParameter("cap"));
        String start_page=(request.getParameter("start_page"));
        String page_size=(request.getParameter("page_size"));
        System.out.println(cinfo);
        model.addAttribute("c_id",c_id);
        model.addAttribute("cname",cname);
        model.addAttribute("cinfo",cinfo);
        model.addAttribute("cad",cad);
        model.addAttribute("cty",cty);
        model.addAttribute("cap",cap);
        model.addAttribute("start_page",start_page);
        model.addAttribute("page_size",page_size);
        return "class_edit";
    }
    @RequestMapping("save_edit_class_info")
    public String save_edit_commodity_info(HttpServletRequest request, RedirectAttributes attributes){
        String c_id=request.getParameter("c_id");
        String cname=request.getParameter("cname");
        String cinfo=request.getParameter("cinfo");
        String cad=request.getParameter("cad");
        String cty=request.getParameter("cty");
        int cap=Integer.parseInt(request.getParameter("cap"));
        String start_page=(request.getParameter("start_page"));
        String page_size=(request.getParameter("page_size"));
        class_infoService.geteditclass(c_id,cname,cinfo,cad,cty,cap);
        attributes.addAttribute("c_id",c_id);
        attributes.addAttribute("cname",cname);
        attributes.addAttribute("cinfo",cinfo);
        attributes.addAttribute("cad",cad);
        attributes.addAttribute("cty",cty);
        attributes.addAttribute("lap",cap);
        attributes.addAttribute("start_page",start_page);
        attributes.addAttribute("page_size",page_size);
        return "redirect:show_class_main";
    }
    @RequestMapping("delete_class_info")
    public String delete_commodity_info(HttpServletRequest request,RedirectAttributes attributes){
        String c_id=request.getParameter("c_id");
        int start_page=Integer.parseInt(request.getParameter("start_page"));
        int page_size=Integer.parseInt(request.getParameter("page_size"));
        class_infoService.deleteclass(c_id);
        attributes.addAttribute("start_page",start_page);
        attributes.addAttribute("page_size",page_size);
        return "redirect:show_class_main";
    }
    @RequestMapping("add_class_info")
    public String add_class_info(HttpServletRequest request,Model model){
        String start_page=(request.getParameter("start_page"));
        String page_size=(request.getParameter("page_size"));
        List<Class_Info> commodity_List=class_infoService.getAllclass_infoList();
        //int cdy_num=commodity_List.get(commodity_List.size()-1).get()+1;
        //model.addAttribute("cdy_num",cdy_num);
        //model.addAttribute("category_list",category_list);
        model.addAttribute("start_page",start_page);
        model.addAttribute("page_size",page_size);
        return "class_add";
    }
    @RequestMapping("save_add_class_info")
    public String save_commodity_info(HttpServletRequest request,RedirectAttributes attributes){
        String c_id=request.getParameter("c_id");
        String cname=request.getParameter("cname");
        String cinfo=request.getParameter("cinfo");
        String cad=request.getParameter("cad");
        String cty=request.getParameter("cty");
        int cap=Integer.parseInt(request.getParameter("cap"));
        String start_page=(request.getParameter("start_page"));
        String page_size=(request.getParameter("page_size"));
        class_infoService.addclass(c_id,cname,cinfo,cad,cty,cap);
        attributes.addAttribute("start_page",start_page);
        attributes.addAttribute("page_size",page_size);
        return "redirect:show_class_main";
    }

}
