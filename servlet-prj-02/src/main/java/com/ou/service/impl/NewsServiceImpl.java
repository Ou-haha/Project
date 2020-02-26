package com.ou.service.impl;

import com.ou.dao.NewsCateDao;
import com.ou.dao.NewsDao;
import com.ou.entity.News;
import com.ou.entity.NewsVo;
import com.ou.entity.Page;
import com.ou.factory.DaoFactory;
import com.ou.service.NewsService;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    private NewsDao newsDao = (NewsDao) DaoFactory.getDao("NewsDao");
    private NewsCateDao newsCateDao = (NewsCateDao) DaoFactory.getDao("NewsCateDao");

    @Override
    public List<NewsVo> getNewsVoList(Integer pageIndex, Integer length) {

        ArrayList<NewsVo> newsVos = new ArrayList<>();
        try {
            List<News> newsList = newsDao.getNewsList(pageIndex, length);
            for (News news:newsList){
                NewsVo newsVo = new NewsVo();
                newsVo.setId(news.getId());
                newsVo.setCateId(news.getCateId());
                newsVo.setTime(news.getTime());
                newsVo.setTitle(news.getTitle());
                newsVo.setAuthor(news.getAuthor());
                newsVo.setContent(news.getContent());
                newsVo.setNewsCate(newsCateDao.getById(news.getCateId()));
                newsVos.add(newsVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return newsVos;
    }
    //通过cateId，数据库表起始位置及查询条数获取新闻类目结果集
    @Override
    public List<News> getNewsListByCate(Integer cateId, Integer pageIndex, Integer length) {

        try {
            return newsDao.getNewsListByCate(cateId,pageIndex,length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Page<News> getNewsPageByCate(Integer cateId, Integer pageIndex, Integer pageSize) {

        Page<News> newsPage = new Page<News>();
        newsPage.setPageIndex(pageIndex);
        newsPage.setPageSize(pageSize);
        //此处pageIndex为网页的分页页码，对应getNewsListByCate方法的pageIndex关系为(pageIndex - 1) * pageSize
        newsPage.setBeanList(getNewsListByCate(cateId,(pageIndex - 1) * pageSize,pageSize));
        try {
            newsPage.setTotalCount(newsDao.getCountByCate(cateId));
            newsPage.setTotalPage((int) Math.ceil(newsPage.getTotalCount()/pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return newsPage;
    }

    @Override
    public Page<NewsVo> getNewsVoPage(Integer pageIndex, Integer pageSize) {

            Page<NewsVo> pageNewsVo = new Page<NewsVo>();
            pageNewsVo.setBeanList(getNewsVoList((pageIndex - 1) * pageSize, pageSize));
            pageNewsVo.setPageIndex(pageIndex);
            pageNewsVo.setPageSize(pageSize);
        try {
            pageNewsVo.setTotalCount(newsDao.getCount());
            pageNewsVo.setTotalPage((int) Math.ceil(newsDao.getCount()/pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return pageNewsVo;
    }

    @Override
    public News getNewsById(Integer id) {

        try {
            return newsDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int deleteNewsById(Integer id) {
        try {
            return newsDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<NewsVo> getAllNewsVo() {
        return null;
    }

    @Override
    public int publish(News news) {
        try {
            return newsDao.insert(news);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
