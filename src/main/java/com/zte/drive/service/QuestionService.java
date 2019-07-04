package com.zte.drive.service;

import com.zte.drive.entity.Question;
import com.zte.drive.entity.Subject;
import com.zte.drive.entity.Type;
import com.zte.drive.vo.QuestionVO;

import java.util.List;

/**
 * @author lxj
 * Date:2019-07-03 17:36
 * Description:问题服务层接口
 */
public interface QuestionService {
    int addQuestion(QuestionVO questionVO);

    int modifyQuestion(QuestionVO questionVO);

    int removeQuestion(Integer id);

    QuestionVO findById(Integer id);

    List<QuestionVO> findByType(Type type);

    List<QuestionVO> findBySubject(Subject subject);

    void checkAnswer(Integer id,List<String> answerList);

    QuestionVO popFrom(Question question);
}
