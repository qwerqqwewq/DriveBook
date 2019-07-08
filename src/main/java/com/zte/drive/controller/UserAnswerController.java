package com.zte.drive.controller;

import com.alibaba.fastjson.JSON;
import com.zte.drive.entity.*;
import com.zte.drive.service.*;
import com.zte.drive.utils.CurrentDate;
import com.zte.drive.utils.OptionUtil;
import com.zte.drive.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private MistakeService mistakeService;

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

    @RequestMapping("getUserInfo")
    private String userInfo() {
        return "question/getUserInfo";
    }

    @RequestMapping("getUserInfo/do")
    @ResponseBody
    private String getUserInfo(HttpServletRequest req) {
        Map map = new HashMap<>(3);
        String finished;
        double rate = 0.0;
        int lastAnswer;
        // 获取用户ID和科目ID
        Integer uid = Integer.parseInt(req.getParameter("uid"));
        Integer sid = Integer.parseInt(req.getParameter("sid"));
        User user = userService.findById(uid);
        Subject subject = subjectService.findById(sid);

        // 查询该用户的答题数
        int questionNum = userAnswerService.findQuestionNum(user);
        int sum = questionService.findBySubject(subject).size();
        finished = "当前进度：" + questionNum + " / " + sum;

        // 查询该用户的所有答案
        List<UserAnswer> userAnswers = userAnswerService.findByUser(user);
        UserAnswer u;
        Question question;
        String answers;
        int correctNum = 0;
        int length = userAnswers.size();
        for ( int i = 0; i < length; i++ ) {
            u = userAnswers.get(i);
            question = u.getQuestion();
            answers = u.getAnswers();
            List<String> answerList = new ArrayList<String>();
            answerList.add(answers);
            boolean isCorrect = questionService.checkAnswer(question.getId(), answerList);
            if (isCorrect) {
                correctNum++;
            } else {
                Mistake mistake = new Mistake();
                mistake.setUser(user);
                mistake.setCreateDate(CurrentDate.getCurrentDate());
                mistake.setQuestion(question);
                int qid = question.getId();
                if (mistakeService.findByqid(user, qid) == null) {
                    int result = mistakeService.add(mistake);
                }
            }
        }
        System.out.println("correctNum = " + correctNum);
        System.out.println("sum = "+ sum);

        if (sum != 0) {
            rate = (double) correctNum / sum;
        }

        UserAnswer userAnswer = userAnswerService.findLast(user);
        lastAnswer = userAnswer.getId();
        map.put("finished", finished);
        map.put("rate", rate);
        map.put("lastAnswer", lastAnswer);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/answer")
    @ResponseBody
    private Object answer(HttpServletRequest req, Integer uid, Integer qid,
                          @RequestParam("answers[]")String[] answers ) {
        UserAnswer userAnswer = new UserAnswer();
        User user = userService.findById(uid);
        Question question = questionService.findById(qid);
        userAnswer.setUser(user);
        userAnswer.setQuestion(question);
        String answerConn = OptionUtil.combineOptions(Arrays.asList(answers));
        userAnswer.setAnswers(answerConn);

        int status = userAnswerService.add(userAnswer);
        Map map = new HashMap<>(1);
        map.put("status", status);
        return JSON.toJSONString(map);
    }
}