package com.zte.drive.controller;

import com.zte.drive.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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


    @RequestMapping("/upload")
    private String uploadPage() {

        return "video/upload";
    }

    @RequestMapping("/upload/do")
    @ResponseBody
    private String uploadAction(@RequestParam("uploadFile")MultipartFile file,
                                HttpServletRequest request) {
        String dirpath = request.getServletContext().getRealPath("fileupload");
        dirpath = dirpath + "/video";
        String filename = file.getOriginalFilename();
        String msg = videoService.uploadVideo(dirpath,filename,file);
        System.out.println(msg);
        return msg;
    }
}
