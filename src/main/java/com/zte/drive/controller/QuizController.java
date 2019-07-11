package com.zte.drive.controller;

import com.zte.drive.entity.Type;
import com.zte.drive.service.QuestionService;
import com.zte.drive.service.UserAnswerService;
import com.zte.drive.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lxj
 * Date:2019-07-10 13:41
 * Description:<描述>
 */
@Controller
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuestionService questionService;
    @Autowired
    UserAnswerService userAnswerService;
    /**
     * 跳转到答题界面
     * @param qid 题目id
     * @param num 当前题目标号 第num题
     * @return mav
     */
    @RequestMapping("/{id}")
    ModelAndView startQuiz(@PathVariable("id") Integer qid,
                           Integer num) {
        ModelAndView mav = new ModelAndView("user/quiz");
        QuestionVO question = questionService.findById(qid);
        mav.addObject("question", question);
        mav.addObject("num", num);
        for (Type type : question.getTypes()) {
            if ("单选题".equals(type.getType())) {
                mav.addObject("isSingle", true);
                break;
            }else if ("多选题".equals(type.getType())) {
                mav.addObject("isSingle", false);
                break;
            }
        }
        return mav;
    }

}
