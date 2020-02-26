package com.ou.dao.impl;

import com.ou.dao.NewsCateDao;
import com.ou.entity.NewsCate;
import com.ou.utils.BeanHandler;
import com.ou.utils.BeanListHandler;
import com.ou.utils.JdbcTemplate;

import java.util.List;

public class NewsCateDaoImpl implements NewsCateDao {
    @Override
    public List<NewsCate> getAll() throws Exception {
        String sql = "select * from news_cate";
        return (List<NewsCate>) JdbcTemplate.query(sql,new BeanListHandler(NewsCate.class));
    }

    @Override
    public NewsCate getById(Integer id) throws Exception {
        String sql = "select * from news_cate where id = ?";
        return (NewsCate) JdbcTemplate.query(sql, new BeanHandler(NewsCate.class),id);
    }

    @Override
    public int insert(NewsCate newsCate) throws Exception {
        String sql = "insert into news_cate(name) values (?)";
        return JdbcTemplate.update(sql, newsCate.getName());
    }

    @Override
    public int update(NewsCate newsCate) throws Exception {
        String sql = "update news_cate set name=? where id=?";
        return JdbcTemplate.update(sql, newsCate.getName(),newsCate.getId());
    }

    @Override
    public int deleteById(Integer id) throws Exception {
        String sql = "delete from news_cate where id = ?";
        return JdbcTemplate.update(sql, id);
    }
}
