package com.zte.drive.controller;

import com.alibaba.fastjson.JSON;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.QuestionComment;
import com.zte.drive.entity.User;
import com.zte.drive.service.QuestionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxj
 * Date:2019-07-03 17:31
 * Description:问题评论服务
 */
@Controller
@RequestMapping("/questionComment")
public class QuestionCommentController {
    @Autowired
    private QuestionCommentService questionCommentService;

    @RequestMapping("/insert/do")
    @ResponseBody
    Object insertAction(
            @RequestParam("uid")Integer uid,
            @RequestParam("qid")Integer qid,
            @RequestParam(value = "pid",required = false)Integer parentId,
            String content) {
        Map map = new HashMap(2);
        //没有用户
        if (uid == null) {
            map.put("status", 0);
            map.put("msg", "用户没有登录！");
            return JSON.toJSONString(map);
        }
        //没有问题
        if (qid == null) {
            map.put("status", -1);
            map.put("msg", "非法操作！");
            return JSON.toJSONString(map);
        }

        QuestionComment questionComment = new QuestionComment();

        //设置qid
        Question question = new Question();
        question.setId(qid);
        questionComment.setQuestion(question);

        //设置uid
        User user = new User();
        user.setId(uid);
        questionComment.setUser(user);

        //设置parentId
        QuestionComment parent = new QuestionComment();
        parent.setId(parentId);
        questionComment.setQuestionComment(parent);

        //设置内容content
        questionComment.setContent(content);

        int status = questionCommentService.add(questionComment);
        map.put("status", status);
        if (status > 0) {
            map.put("msg", "插入成功");
        } else {
            map.put("msg", "插入失败");
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/all/{id}")
    @ResponseBody
    Object findByQuestion(@PathVariable("id") Integer qid) {
        Question question = new Question();
        question.setId(qid);
        List<QuestionComment> questionComments = questionCommentService.findByQuestion(question,0);
        int status = questionComments.size();
        Map map = new HashMap(2);
        map.put("status", status);
        if (status > 0) {
            map.put("msg", "查找成功！");
            map.put("comments", questionComments);
        } else {
            map.put("msg", "暂无评论");
        }
        return JSON.toJSONString(map);

    }

    @RequestMapping("/detail/{id}")
    @ResponseBody
    Object findByComment(@PathVariable("id") Integer pid) {
        QuestionComment parent = new QuestionComment();
        parent.setId(pid);
        List<QuestionComment> questionComments = questionCommentService.findByComment(parent);
        int status = questionComments.size();
        Map map = new HashMap(2);
        map.put("status", status);
        if (status > 0) {
            map.put("msg", "查找成功！");
            map.put("comments", questionComments);
        } else {
            map.put("msg", "暂无评论");
        }
        return JSON.toJSONString(map);

    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    Object deleteAction(@PathVariable("id") Integer id) {
        Map map = new HashMap(2);
        int status = questionCommentService.removeById(id);
        map.put("status", status);
        String msg;
        if (status > 0) {
            msg = "删除成功！";
        } else {
            msg = "删除失败!";
        }
        map.put("msg", msg);
        return JSON.toJSONString(map);

    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    Object findByUserAction(@PathVariable("id") Integer uid) {
        User user = new User();
        user.setId(uid);
        List<QuestionComment> comments = questionCommentService.findByUser(user);
        int status = comments.size();
        String msg;
        if (status > 0) {
            msg = "查找成功!";
        } else {
            msg = "该用户暂无评论";
        }

        Map map = new HashMap(2);
        map.put("status", status);
        map.put("msg", msg);
        map.put("comments", comments);
        return JSON.toJSONString(map);
    }
}