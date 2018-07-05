package com.spring.service;

import java.util.List;

import com.spring.domain.Book;
import com.spring.domain.City;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
    
    List<Book> queryBookAll();
}
