package com.zte.drive.controller;

import com.zte.drive.service.QuestionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:helloboy
 * Date:2019-07-03 17:31
 * Description:<描述>
 */
@Controller
@RequestMapping("/questionComment")
public class QuestionCommentController {
    @Autowired
    private QuestionCommentService questionCommentService;
}