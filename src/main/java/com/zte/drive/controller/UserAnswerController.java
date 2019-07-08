package com.zte.drive.controller;

import com.zte.drive.entity.Question;
import com.zte.drive.entity.User;
import com.zte.drive.entity.UserAnswer;
import com.zte.drive.service.QuestionService;
import com.zte.drive.service.UserAnswerService;
import com.zte.drive.service.UserService;
import com.zte.drive.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-03 17:31
 * Description:<描述>
 */
@Controller
@RequestMapping("/userAnswer")
@SessionAttributes("userAnswer")
public class UserAnswerController {
    @Autowired
    private UserAnswerService userAnswerService;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/addUserAnswer")
    private String index() {
        return "question/addUserAnswer";
    }

    @RequestMapping("/addUserAnswer/do")
    private String addUserAnswer(HttpServletRequest req, Model model) {
        Integer uid = Integer.parseInt(req.getParameter("uid"));
        Integer qid = Integer.parseInt(req.getParameter("qid"));
        String content = req.getParameter("content");
//        System.out.println(uid + " " + qid + " " + content);

        User user = userService.findById(uid);
        QuestionVO question = questionService.findById(qid);
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setQuestion(question);
        userAnswer.setAnswers(content);

        int result = userAnswerService.add(userAnswer);
        model.addAttribute("userAnswer", userAnswer);
        return "question/success";
    }

    @RequestMapping("/find")
    private String findByUser() {
        return "question/find";
    }

    @RequestMapping("/findByUser/do")
    private String doFindByUser(HttpServletRequest req, Model model) {
        Integer uid = Integer.parseInt(req.getParameter("uid"));
        User user = userService.findById(uid);
        List<UserAnswer> list = userAnswerService.findByUser(user);
        model.addAttribute("list", list);
        return "question/showUser";
    }

    @RequestMapping("findByQuestion/do")
    private String doFindByQuestion(HttpServletRequest req, Model model) {
        Integer qid = Integer.parseInt(req.getParameter("qid"));
        Question question = questionService.findById(qid);
        List<UserAnswer> list = userAnswerService.findByQuesiton(question);
        model.addAttribute("list", list);

        // 获取正确率
        Integer totalNum = question.getTotalNum();
        Integer correctNum = question.getCorrectNum();
        double rate;
        try {
            rate = correctNum / totalNum;
        } catch (Exception e) {
            rate = 0;
        }
        model.addAttribute("rate", rate);
        return "question/showQuestion";
    }
}