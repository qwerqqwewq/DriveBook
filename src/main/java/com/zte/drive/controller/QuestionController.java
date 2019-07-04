package com.zte.drive.controller;

import com.alibaba.fastjson.JSON;
import com.zte.drive.entity.Subject;
import com.zte.drive.entity.Type;
import com.zte.drive.service.QuestionService;
import com.zte.drive.service.TypeService;
import com.zte.drive.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lxj
 * Date:2019-07-04 14:24
 * Description:<描述>
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private TypeService typeService;

    @RequestMapping("/insert/do")
    @ResponseBody
    public Object insertAction(HttpServletRequest request,
                               String content,/*"content" : content,*/
                               @RequestParam("tid[]")Integer[] tid,/*"tid[]" : tid,*/
                               @RequestParam("options[]")String[] options,/*"options[]": options,*/
                               @RequestParam("answers[]")String[] answers,/*"answers[]": answers,*/
                               Integer subjectId,/*"subjectId" : subjectId,*/
                               String resolve/*"resolve" : resolve*/) {
        String msg;
        //封装数据
        QuestionVO questionVO = new QuestionVO();
        questionVO.setContent(content);
        questionVO.setResolve(resolve);
        questionVO.setSubject(new Subject(subjectId,null));
        questionVO.setAnswerList(Arrays.asList(answers));
        questionVO.setOptionList(Arrays.asList(options));
        List<Type> types = new ArrayList<>();
        for (int i = 0; i < tid.length; i++) {
            types.add(new Type(tid[i], null));
        }
        questionVO.setTypes(types);
        //TODO: 判断user是否存在

        //执行插入操作
        Integer status = questionService.addQuestion(questionVO);
        if (status > 0) {
            msg = "插入题目成功！";
        } else {
            msg = "插入题目失败！请验证你的输入合法性！";
        }
        Map map = new HashMap(2);

        //返回数据
        map.put("msg", msg);
        map.put("status", status);

        //回传json格式
        return JSON.toJSONString(map);
    }

    @RequestMapping("/insert")
    String insertPage() {
        return "question/insert";
    }

    @RequestMapping("/all")
    String allPage(Model model) {
        List<QuestionVO> questionVOs = questionService.findAll();
        model.addAttribute("questions",questionVOs);

        return "question/all";
    }

    @RequestMapping("/{id}")
    ModelAndView singlePage(@PathVariable("id") Integer id) {
        QuestionVO questionVO = questionService.findById(id);
        ModelAndView mav = new ModelAndView("question/single");
        mav.addObject("question", questionVO);
        return mav;
    }


    @ModelAttribute("types")
    List<Type> types() {
        return typeService.findAll();
    }

}
