package com.ou.service.impl;

import com.ou.dao.NewsCateDao;
import com.ou.dao.NewsDao;
import com.ou.entity.News;
import com.ou.entity.NewsCate;
import com.ou.entity.NewsCateVo;
import com.ou.factory.DaoFactory;
import com.ou.service.NewsCateService;

import java.util.ArrayList;
import java.util.List;

public class NewsCateServiceImpl implements NewsCateService {

    private NewsCateDao newsCateDao = (NewsCateDao) DaoFactory.getDao("NewsCateDao");

    private NewsDao newsDao = (NewsDao) DaoFactory.getDao("NewsDao");

    @Override
    public List<NewsCate> getAllCate() {
        try {
            return newsCateDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NewsCateVo> getAllNewsCateVo(Integer length) {

        List<NewsCateVo> allNewsCateVo = new ArrayList<>();
        try {
            List<NewsCate> newsAllCate = newsCateDao.getAll();
            for (NewsCate newsCate:newsAllCate){
                NewsCateVo newsCateVo = new NewsCateVo();
                newsCateVo.setCateId(newsCate.getId());
                newsCateVo.setName(newsCate.getName());
                newsCateVo.setNews(newsDao.getNewsListByCate(newsCate.getId(),0,length));
                allNewsCateVo.add(newsCateVo);
            }
            return allNewsCateVo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public NewsCate getNewsCateById(Integer id) {
        try {
            return newsCateDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insert(NewsCate newsCate) {
        try {
            return newsCateDao.insert(newsCate);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(NewsCate newsCate) {
        try {
            return newsCateDao.update(newsCate);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Integer id) {
        try {
            return newsCateDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
