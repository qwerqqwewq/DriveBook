package com.zte.drive.vo;

import com.zte.drive.entity.Question;
import com.zte.drive.utils.OptionUtil;

import java.util.List;

/**
 * @author helloboy
 * Date:2019-07-03 17:36
 * Description:<描述>
 */
public class QuestionVO extends Question {
    private List<String> optionList;
    private List<String> answerList;

    public QuestionVO() {
    }

    public QuestionVO(Question question) {
        super(question);
        optionList = OptionUtil.separateOptions(question.getOptions());
        answerList = OptionUtil.separateOptions(question.getAnswers());
    }

    @Override
    public String toString() {
        return "QuestionVO{" +
                "optionList=" + optionList +
                ", answerList=" + answerList +
                super.toString() +
                '}';
    }

    public List<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<String> optionList) {
        this.optionList = optionList;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }
}
