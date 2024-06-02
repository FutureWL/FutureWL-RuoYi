package com.ruoyi.my.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.my.domain.MyGoods;
import com.ruoyi.my.service.IMyGoodsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author weilai
 * @date 2024-06-03
 */
@Controller
@RequestMapping("/my/goods")
public class MyGoodsController extends BaseController
{
    private String prefix = "my/goods";

    @Autowired
    private IMyGoodsService myGoodsService;

    @RequiresPermissions("my:goods:view")
    @GetMapping()
    public String goods()
    {
        return prefix + "/goods";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("my:goods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MyGoods myGoods)
    {
        startPage();
        List<MyGoods> list = myGoodsService.selectMyGoodsList(myGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("my:goods:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MyGoods myGoods)
    {
        List<MyGoods> list = myGoodsService.selectMyGoodsList(myGoods);
        ExcelUtil<MyGoods> util = new ExcelUtil<MyGoods>(MyGoods.class);
        return util.exportExcel(list, "商品数据");
    }

    /**
     * 新增商品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("my:goods:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MyGoods myGoods)
    {
        return toAjax(myGoodsService.insertMyGoods(myGoods));
    }

    /**
     * 修改商品
     */
    @RequiresPermissions("my:goods:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MyGoods myGoods = myGoodsService.selectMyGoodsById(id);
        mmap.put("myGoods", myGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("my:goods:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MyGoods myGoods)
    {
        return toAjax(myGoodsService.updateMyGoods(myGoods));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("my:goods:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(myGoodsService.deleteMyGoodsByIds(ids));
    }
}
