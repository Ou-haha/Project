package com.ou.dao.impl;

import com.ou.dao.NewsDao;
import com.ou.entity.News;
import com.ou.utils.BeanHandler;
import com.ou.utils.BeanListHandler;
import com.ou.utils.JdbcTemplate;

import java.util.List;

public class NewsDaoImpl implements NewsDao{

    @Override
    public int getCount() throws Exception {
        String sql = "select count(*) from news";
        return JdbcTemplate.queryCount(sql);
    }

    @Override
    public int getCountByCate(Integer cateId) throws Exception {
        String sql = "select count(*) from news where cate_id = ? order by time desc";
        return JdbcTemplate.queryCount(sql,cateId);
    }

    @Override
    public List<News> getNewsList(Integer beginIndex, Integer length) throws Exception{
        String sql = "select * from news order by time desc limit ?,?";
        return (List<News>) JdbcTemplate.query(sql, new BeanListHandler(News.class),beginIndex,length);
    }

    @Override
    public List<News> getNewsListByCate(Integer cateId, Integer beginIndex, Integer length) throws Exception{
        String sql = "select * from news where cate_id = ? order by time desc limit ?,?";
        return (List<News>) JdbcTemplate.query(sql,new BeanListHandler(News.class),cateId,beginIndex,length);
    }

    @Override
    public List<News> getAll() throws Exception{
        String sql = "select * from news";
        return (List<News>) JdbcTemplate.query(sql,new BeanListHandler(News.class));
    }

    @Override
    public News getById(Integer id) throws Exception{
        String sql = "select * from news where id=?";
        return (News) JdbcTemplate.query(sql,new BeanHandler(News.class),id);
    }

    @Override
    public int insert(News news) throws Exception{
        String sql = "insert into news(cate_id,title,time,author,content) values(?,?,?,?,?)";
        return JdbcTemplate.update(sql,news.getCateId(),news.getTitle(),news.getTime(),news.getAuthor(),news.getContent());
    }


    @Override
    public int deleteById(Integer id) throws Exception{
        String sql ="delete from news where id = ?";
        return JdbcTemplate.update(sql,id);
    }
}
