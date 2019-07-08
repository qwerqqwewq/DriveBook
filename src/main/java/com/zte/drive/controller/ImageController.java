package com.zte.drive.controller;

import com.zte.drive.entity.Image;
import com.zte.drive.service.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:helloboy
 * Date:2019-07-03 11:17
 * Description:<描述>
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping(value="/newupload",method=RequestMethod.POST)
    @ResponseBody
        public String upload(HttpServletRequest request,String content){
            String html = request.getParameter("editorValue");
            request.setAttribute("edit", html);
            //System.out.println(content);

           //试题选项说明，试题解析
            String qct=request.getParameter("qct");
            String qso=request.getParameter("qso");

            //图片url
            String url = content.split("src=")[1].split("\"")[1];
            //System.out.println(url);
        if(!url.equals("")) {
            String regex="<p.*?>(.*?)</p>";
            Pattern p=Pattern.compile(regex);
            Matcher m=p.matcher(content);

            while(m.find()) {
                String s1=m.group(1);
                String s2=s1.substring(s1.indexOf("<"),s1.indexOf(">")+1).substring(0);
                String text=s1.replace(s2,"");
                //System.out.print(text);
            }

            Image image = new Image();
            image.setSrc(url);
            imageService.add(image);
        }
            return "success";
        }

    //查询所有图片
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Image> list= imageService.findAll();
        model.addAttribute("list",list);
        return "findAllImage";
    }

    //根据id查询某张图片
    @RequestMapping("/findById")
    public String findById(Model model, Integer id) {
        Image mm = imageService.findById(id);
        model.addAttribute("mm", mm);
        return "findById";
    }

    //增加一张图片
    @RequestMapping("/addImage")
    public String addImage(Image image) {
        imageService.add(image);
        return "redirect:findAll";
    }

    //根据id删除某张图片
    @RequestMapping("/removeById")
    public String removeById(Integer id) {
        imageService.remove(id);
        return "redirect:findAll";
    }

    //修改某张图片
    @RequestMapping("/modify")
    public String modify(Image image) {
        imageService.modify(image);
        return "redirect:findAll";
    }

    @RequestMapping("/upload")
    private String uploadPage() {

        return "image/upload";
    }

    @RequestMapping("/upload/do")
    @ResponseBody
    private String uploadAction(@RequestParam("uploadFile") MultipartFile file,
                                HttpServletRequest request) {
        String dirpath = request.getServletContext().getRealPath("fileupload");
        dirpath = dirpath + "/image";
        String filename = file.getOriginalFilename();
        String msg = imageService.uploadImage(dirpath,filename,file);
        System.out.println(msg);
        return msg;
    }



}

