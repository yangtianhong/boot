package com.tian.boot.two.mapper;

import com.tian.boot.common.model.Stock;
import org.springframework.stereotype.Service;

@Service
public interface TwoStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}