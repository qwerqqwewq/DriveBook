package com.zte.drive.service.impl;

import com.zte.drive.dao.MistakeDao;
import com.zte.drive.dao.QuestionDao;
import com.zte.drive.entity.Mistake;
import com.zte.drive.entity.User;
import com.zte.drive.service.MistakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class MistakeServiceImpl implements MistakeService {
    @Autowired
    private MistakeDao mistakeDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public int add(Mistake mistake) {
        return mistakeDao.insert(mistake);
    }

    @Override
    public int remove(User user, Integer id) {
        return mistakeDao.delete(user,id);
    }

    @Override
    public int removeall(User user) {
        return mistakeDao.deleteall(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Mistake> findall(User user) {
        List<Mistake> mistakes = mistakeDao.selectall(user);
        for (Mistake mistake : mistakes) {
            mistake.setQuestion(questionDao.selectById(mistake.getQuestion().getId()));
        }
        return mistakes;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Mistake findById(User user, Integer id) {
        Mistake mistake=mistakeDao.selectById(user,id);
        Integer uid=mistake.getQuestion().getId();
        mistake.setQuestion(questionDao.selectById(uid));
        return mistake;

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Mistake> findByContent(User user, String content) {
        List<Mistake> mistakes=mistakeDao.selectByContent(user,content);
        for(Mistake mistake:mistakes){
            mistake.setQuestion(questionDao.selectById(mistake.getQuestion().getId()));
        }
        return mistakes;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Mistake> findByType(User user, String type) {
        List<Mistake> mistakes=mistakeDao.selectByType(user,type);
        for(Mistake mistake:mistakes){
            mistake.setQuestion(questionDao.selectById(mistake.getQuestion().getId()));
        }
        return mistakes;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Mistake> findByTime(User user, Integer num) {
        List<Mistake> mistakes=mistakeDao.selectByTime(user,num);
        for(Mistake mistake:mistakes){
            mistake.setQuestion(questionDao.selectById(mistake.getQuestion().getId()));
        }
        return mistakes;
    }

    @Override
    public Mistake findByqid(User user, Integer qid) {
        Mistake mistake=mistakeDao.selectByqid(user,qid);
        if(mistake!=null) {
            Integer uid = mistake.getQuestion().getId();
            mistake.setQuestion(questionDao.selectById(uid));
            return mistake;
        }else{
            return null;
        }
    }
}
