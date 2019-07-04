package com.zte.drive.test;

import com.zte.drive.dao.QuestionDao;
import com.zte.drive.entity.Question;
import com.zte.drive.entity.Subject;
import com.zte.drive.entity.Type;
import com.zte.drive.vo.QuestionVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxj
 * Date:2019-07-04 9:27
 * Description:对questionServiceImpl的测试
 */
public class QuestionServiceTest {
    private static QuestionDao questionDao;

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
//        questionDao = (QuestionDao) context.getBean("questionDao");
        //成功
//        addTest();
//        updateTest();

        //成功
//        deleteTest();
        //成功
//        selectById();
//        selectByTypeTest();
//        selectAllTest();
//        selectBySubjectTest();

        //成功
//        checkAnswerTest();

        Question question = new Question();
        List<Type> types = new ArrayList<>();
        types.add(new Type(1, null));
        types.add(new Type(3, null));
        types.add(new Type(4, null));
        question.setTypes(types);
        Subject subject = new Subject();
        subject.setId(4);
        question.setSubject(subject);
        question.setContent("ServiceTest");
        question.setOptions("A 1#B 1#");
        question.setAnswers("A#B#");
        question.setResolve("TestResolve");

        QuestionVO questionVO = new QuestionVO(question);
        System.out.println(questionVO);

    }

    private static void selectBySubjectTest() {
        Subject subject = new Subject();
        subject.setId(4);
        List<Question> questions = questionDao.selectBySubject(subject);
        System.out.println("测试根据subject查询");
        for (Question question : questions) {
            System.out.println("----"+question);
        }
        System.out.println("--------------");
    }

    private static void checkAnswerTest() {
        Integer id = 1;
        List<String> answers = new ArrayList<>();
        answers.add("A");
        answers.add("B");
        System.out.println("测试正确答案检查" + questionDao.getAnswerCheck(id,answers));
        answers.clear();
        answers.add("A");
        System.out.println("测试错误答案检查" + questionDao.getAnswerCheck(id,answers));



    }

    private static void selectAllTest() {
        List<Question> questions = questionDao.selectAll();
        System.out.println("测试所有查询");
        for (Question question : questions) {
            System.out.println("----"+question);
        }
        System.out.println("--------------");
    }

    private static void selectByTypeTest() {
        Type type = new Type();
        type.setId(2);
        List<Question> questions = questionDao.selectByType(type);
        System.out.println("测试根据type查询");
        for (Question question : questions) {
            System.out.println("----"+question);
        }
        System.out.println("--------------");



    }

    private static void selectById() {
        Integer id = 1;
        Question question = questionDao.selectById(id);
        System.out.println("测试id查询: " + question);
        System.out.println("--------------");

    }


    private static void deleteTest() {
        Integer id = 2;

        int row = questionDao.deleteQuestion(id);
        System.out.println("测试删除----结果" + row);
    }

    private static void addTest() {
        Question question = new Question();
        List<Type> types = new ArrayList<>();
        types.add(new Type(1, null));
        types.add(new Type(3, null));
        types.add(new Type(4, null));
        question.setTypes(types);
        Subject subject = new Subject();
        subject.setId(4);
        question.setSubject(subject);
        question.setContent("ServiceTest");
        question.setOptions("A 1#B 1#");
        question.setAnswers("A#B#");
        question.setResolve("TestResolve");

        int row = questionDao.insertQuestion(question);
        System.out.println("测试插入----结果" + row);
    }

    private static void updateTest() {
        Question question = new Question();
        question.setId(1);
        List<Type> types = new ArrayList<>();
        types.add(new Type(1, null));
        types.add(new Type(2, null));
        question.setTypes(types);
        Subject subject = new Subject();
        subject.setId(4);
        question.setSubject(subject);
        question.setContent("ServiceTest修改");
        question.setOptions("A 1#B 1#");
        question.setAnswers("A#B#");
        question.setResolve("TestResolve修改");

        int row = questionDao.updateQuestion(question);
        System.out.println("测试修改题目----结果" + row);

        row = questionDao.updateCorrectNum(1);
        System.out.println("测试修改正答数----结果" + row);

        row = questionDao.updateTotalNum(1);
        System.out.println("测试修改总答数----结果" + row);

    }
}
