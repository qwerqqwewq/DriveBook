package com.zte.drive.vo;

import com.zte.drive.entity.Question;
import com.zte.drive.utils.OptionUtil;

import java.util.List;

/**
 * @author helloboy
 * Date:2019-07-03 17:36
 * Description:<描述>
 */
public class QuestionVO extends Question implements Comparable<QuestionVO>{
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QuestionVO that = (QuestionVO) o;

        if (getOptionList() != null ? !getOptionList().equals(that.getOptionList()) : that.getOptionList() != null) {
            return false;
        }
        return !(getAnswerList() != null ? !getAnswerList().equals(that.getAnswerList()) : that.getAnswerList() != null);

    }

    @Override
    public int hashCode() {
        int result = getOptionList() != null ? getOptionList().hashCode() : 0;
        result = 31 * result + (getAnswerList() != null ? getAnswerList().hashCode() : 0);
        return result;
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


    @Override
    public int compareTo(QuestionVO o) {
        if (o==null) {
            return 1;
        }
        return this.id.compareTo(o.id);
    }
}
