package com.zte.drive.service.impl;

import com.zte.drive.dao.QuestionDao;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.Subject;
import com.zte.drive.entity.Type;
import com.zte.drive.service.QuestionService;
import com.zte.drive.utils.OptionUtil;
import com.zte.drive.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxj
 * Date:2019-07-04 8:14
 * Description:QuestionService实现
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;


    /**
     * 将questionVo转化为父类
     * @param questionVO
     * @return
     */
    private static Question devolve(QuestionVO questionVO) {
        //将传入的answer化整
        questionVO.setAnswers(OptionUtil.combineOptions(questionVO.getAnswerList()));
        //将传入的选项化整
        questionVO.setOptions(OptionUtil.combineOptions(questionVO.getOptionList()));

        return (Question) questionVO;
    }

    /**
     * 将列表转化为子类
     * @param questions
     * @return
     */
    private static List<QuestionVO> envolve(List<Question> questions) {
        List<QuestionVO> questionVOs = new ArrayList<>();
        for (Question question : questions) {
            questionVOs.add(envolve(question));
        }
        return questionVOs;
    }

    /**
     * 将question转化为子类
     * @param question
     * @return
     */
    private static QuestionVO envolve(Question question) {
        return new QuestionVO(question);
    }


    @Override
    public int addQuestion(QuestionVO questionVO) {
        return questionDao.insertQuestion(devolve(questionVO));
    }


    @Override
    public int modifyQuestion(QuestionVO questionVO) {
        return questionDao.updateQuestion(devolve(questionVO));
    }

    @Override
    public int removeQuestion(Integer id) {
        return questionDao.deleteQuestion(id);
    }

    @Override
    public QuestionVO findById(Integer id) {
        Question question = questionDao.selectById(id);

        return envolve(question);
    }

    @Override
    public List<QuestionVO> findByType(Type type) {


        return envolve(questionDao.selectByType(type));
    }

    @Override
    public List<QuestionVO> findBySubject(Subject subject) {
        return envolve(questionDao.selectBySubject(subject));
    }

    @Override
    public List<QuestionVO> findAll() {
        return envolve(questionDao.selectAll());
    }

    @Override
    public boolean checkAnswer(Integer id, List<String> answerList) {
        boolean flag = questionDao.getAnswerCheck(id, answerList);
        questionDao.updateTotalNum(id);
        if (flag) {
            questionDao.updateCorrectNum(id);
        }
        return flag;
    }


}
