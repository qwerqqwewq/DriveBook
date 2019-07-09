package com.zte.drive.service.impl;

import com.zte.drive.dao.FavoritesDao;
import com.zte.drive.dao.QuestionDao;
import com.zte.drive.entity.Favorites;
import com.zte.drive.entity.User;
import com.zte.drive.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ASUS on 2019/7/3.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    private FavoritesDao favoritesDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public int add(Favorites favorites) {
        return favoritesDao.insert(favorites);
    }

    @Override
    public int remove(User user, Integer id) {
        return favoritesDao.delete(user,id);
    }

    @Override
    public int removeall(User user) {
        return favoritesDao.deleteall(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Favorites> find(User user) {
        List<Favorites> favorites=favoritesDao.select(user);
        for(Favorites favorite:favorites){
            favorite.setQuestion(questionDao.selectById(favorite.getQuestion().getId()));
        }
        return favorites;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Favorites> findByNum(User user, Integer num) {
        List<Favorites> favorites=favoritesDao.selectByNum(user,num);
        for(Favorites favorite:favorites){
            favorite.setQuestion(questionDao.selectById(favorite.getQuestion().getId()));
        }
        return favorites;
    }

    @Override
    public Favorites findByqid(User user, Integer qid) {
        Favorites favorites=favoritesDao.selectByqid(user, qid);
        if(favorites!=null) {
            Integer uid = favorites.getQuestion().getId();
            favorites.setQuestion(questionDao.selectById(uid));
            return favorites;
        }else{
            return null;
        }
    }
}
