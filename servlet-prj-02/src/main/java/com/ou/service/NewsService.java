package com.ou.service;

import com.ou.entity.News;
import com.ou.entity.NewsVo;
import com.ou.entity.Page;

import java.util.List;

public interface NewsService {

    List<NewsVo> getNewsVoList(Integer pageIndex,Integer length);

    List<News> getNewsListByCate(Integer cateId,Integer pageIndex,Integer length);

    Page<News> getNewsPageByCate(Integer cateId,Integer pageIndex,Integer PageSize);

    Page<NewsVo> getNewsVoPage(Integer pageIndex,Integer pageSize);

    News getNewsById(Integer id);

    int deleteNewsById(Integer id);

    List<NewsVo> getAllNewsVo();

    int publish(News news);

}
