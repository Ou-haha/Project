package com.ou.service;


import com.ou.entity.NewsCate;
import com.ou.entity.NewsCateVo;

import java.util.List;

public interface NewsCateService {

    List<NewsCate> getAllCate();

    List<NewsCateVo> getAllNewsCateVo(Integer length);

    NewsCate getNewsCateById(Integer id);

    int insert(NewsCate newsCate);

    int update(NewsCate newsCate);

    int delete(Integer id);

}
