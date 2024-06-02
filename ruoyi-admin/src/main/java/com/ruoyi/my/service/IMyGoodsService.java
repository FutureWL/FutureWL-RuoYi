package com.ruoyi.my.service;

import java.util.List;
import com.ruoyi.my.domain.MyGoods;

/**
 * 商品Service接口
 * 
 * @author weilai
 * @date 2024-06-03
 */
public interface IMyGoodsService 
{
    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    public MyGoods selectMyGoodsById(Long id);

    /**
     * 查询商品列表
     * 
     * @param myGoods 商品
     * @return 商品集合
     */
    public List<MyGoods> selectMyGoodsList(MyGoods myGoods);

    /**
     * 新增商品
     * 
     * @param myGoods 商品
     * @return 结果
     */
    public int insertMyGoods(MyGoods myGoods);

    /**
     * 修改商品
     * 
     * @param myGoods 商品
     * @return 结果
     */
    public int updateMyGoods(MyGoods myGoods);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteMyGoodsByIds(String ids);

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    public int deleteMyGoodsById(Long id);
}
