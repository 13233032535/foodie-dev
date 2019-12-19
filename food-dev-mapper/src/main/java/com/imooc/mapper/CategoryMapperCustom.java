package com.imooc.mapper;

import com.imooc.pojo.vo.CategoryVo;
import com.imooc.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {

    public List<CategoryVo> getSubCatList(Integer rootCatId);

    public List<NewItemsVO> getSixNewItemLazy(@Param("paramsMap") Map<String,Object> map);
}