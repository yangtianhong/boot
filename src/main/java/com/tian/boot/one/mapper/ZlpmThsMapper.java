package com.tian.boot.one.mapper;

import com.tian.boot.common.model.ZlpmThs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface ZlpmThsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZlpmThs record);

    int insertSelective(ZlpmThs record);

    ZlpmThs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZlpmThs record);

    int updateByPrimaryKey(ZlpmThs record);

	Integer queryPmNum(ZlpmThs zlpmThs);

	List<ZlpmThs> queryByNumAndToday(ZlpmThs temp);
}