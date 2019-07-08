package com.zte.drive.service;

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
    /**
     * 根据一条题目信息插入数据
     * @param questionVO 题目信息，typeList中的Type只有id有值
     * @return 影响行数
     */
    int addQuestion(QuestionVO questionVO);

    /**
     * 根据一条题目信息修改一个题目
     * @param questionVO 题目信息，回答与正答数应回归为0
     * @return 影响行数
     */
    int modifyQuestion(QuestionVO questionVO);

    /**
     * 根据id删除一个题目
     * @param id 题目id
     * @return 影响行数
     */
    int removeQuestion(Integer id);

    /**
     * 根据id查找题目信息
     * @param id 题目id
     * @return 题目信息
     */
    QuestionVO findById(Integer id);

    /**
     * 根据题目类型查找题目
     * @param type 题目类型bean
     * @return 题目List
     */
    List<QuestionVO> findByType(Type type);

    /**
     * 根据科目查找题目
     * @param subject 科目bean
     * @return 题目List
     */
    List<QuestionVO> findBySubject(Subject subject);

    /**
     * 查找所有
     * @return
     */
    List<QuestionVO> findAll();

    /**
     * 判断题目是否正确
     * @param id 题目id
     * @param answerList 答案List
     * @return true--正确 false--不正确
     */
    boolean checkAnswer(Integer id,List<String> answerList);
}
