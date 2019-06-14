package com.tian.boot.one.mapper;

import com.tian.boot.common.model.ZmoneyDfcf;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface ZmoneyDfcfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZmoneyDfcf record);

    int insertSelective(ZmoneyDfcf record);

    ZmoneyDfcf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZmoneyDfcf record);

    int updateByPrimaryKey(ZmoneyDfcf record);

	Integer queryPmNum(ZmoneyDfcf temp);

	List<ZmoneyDfcf> queryByNumAndToday(ZmoneyDfcf temp);
}