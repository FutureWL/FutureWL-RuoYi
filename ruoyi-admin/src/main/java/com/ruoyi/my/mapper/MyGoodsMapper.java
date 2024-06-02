package com.ruoyi.my.mapper;

import java.util.List;
import com.ruoyi.my.domain.MyGoods;

/**
 * 商品Mapper接口
 * 
 * @author weilai
 * @date 2024-06-03
 */
public interface MyGoodsMapper 
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
     * 删除商品
     * 
     * @param id 商品主键
     * @return 结果
     */
    public int deleteMyGoodsById(Long id);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyGoodsByIds(String[] ids);
}
