package com.ruoyi.my.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.my.mapper.MyGoodsMapper;
import com.ruoyi.my.domain.MyGoods;
import com.ruoyi.my.service.IMyGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品Service业务层处理
 * 
 * @author weilai
 * @date 2024-06-03
 */
@Service
public class MyGoodsServiceImpl implements IMyGoodsService 
{
    @Autowired
    private MyGoodsMapper myGoodsMapper;

    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public MyGoods selectMyGoodsById(Long id)
    {
        return myGoodsMapper.selectMyGoodsById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param myGoods 商品
     * @return 商品
     */
    @Override
    public List<MyGoods> selectMyGoodsList(MyGoods myGoods)
    {
        return myGoodsMapper.selectMyGoodsList(myGoods);
    }

    /**
     * 新增商品
     * 
     * @param myGoods 商品
     * @return 结果
     */
    @Override
    public int insertMyGoods(MyGoods myGoods)
    {
        return myGoodsMapper.insertMyGoods(myGoods);
    }

    /**
     * 修改商品
     * 
     * @param myGoods 商品
     * @return 结果
     */
    @Override
    public int updateMyGoods(MyGoods myGoods)
    {
        return myGoodsMapper.updateMyGoods(myGoods);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteMyGoodsByIds(String ids)
    {
        return myGoodsMapper.deleteMyGoodsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteMyGoodsById(Long id)
    {
        return myGoodsMapper.deleteMyGoodsById(id);
    }
}
