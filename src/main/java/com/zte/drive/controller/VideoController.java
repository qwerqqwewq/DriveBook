package com.zte.drive.controller;

import com.alibaba.fastjson.JSON;
import com.zte.drive.entity.Subject;
import com.zte.drive.entity.Video;
import com.zte.drive.service.SubjectService;
import com.zte.drive.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxj
 * Date:2019-07-03 14:20
 * Description:<描述>
 */
@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/upload")
    private String uploadPage() {

        return "video/upload";
    }

    @ModelAttribute("subjects")
    List<Subject> getTypes() {
        return subjectService.findAll();
    }

    @RequestMapping("/all")
    @ResponseBody
    Object getAll() {
        Map map = new HashMap(1);
        List<Video> videos = videoService.findAll();
        map.put("videos", videos);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    Object getOne(@PathVariable("id") Integer id) {
        Map map = new HashMap(1);
        Video video = videoService.findById(id);
        map.put("video", video);
        return JSON.toJSONString(map);
    }


    @RequestMapping("/upload/do")
    @ResponseBody
    private String uploadAction(@RequestParam("uploadFile") MultipartFile file,
                                @RequestParam("intro") String intro,
                                @RequestParam("context") String context,
                                @RequestParam("title") String title,
                                @RequestParam("sid") Integer sid,
                                HttpServletRequest request) {

        String dirpath = request.getServletContext().getRealPath("fileupload");
        dirpath = dirpath + "/video";
        String subdir = new SimpleDateFormat("/yyyy/MM/dd").format(Calendar.getInstance().getTime());
        String suf = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf("."));
        String pre = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename = suf + Calendar.getInstance().getTimeInMillis() + pre;
        System.out.println(filename);
        Integer status = videoService.uploadVideo(dirpath + subdir, filename, file);
        Map map = new HashMap(1);
        map.put("status", status);
        if (status==0) {
            map.put("msg", "文件上传失败!");
            return JSON.toJSONString(map);
        }
        Video video = new Video();
        video.setSubject(new Subject(sid,null));
        video.setIntro(intro);
        video.setContext(context);
        video.setTitle(title);
        String src = "/drive/fileupload/video" + subdir +"/" +  filename;

        video.setSrc(src);
        status = videoService.addVideo(video);
        map.put("status", status);

        if (status > 0) {
            map.put("msg", "文件上传成功!");
        } else {
            map.put("msg", "文件上传失败!");
        }

        return JSON.toJSONString(map);
    }

    @RequestMapping("/{sid}")
    ModelAndView getVideoBySubject(@PathVariable("sid") Integer sid) {
        ModelAndView mav = new ModelAndView("video/subject");
        mav.addObject("videos", videoService.findBySubject(new Subject(sid, null)));
        return mav;
    }

}
