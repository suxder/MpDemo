package com.jac.mpdemo.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.jac.mpdemo.entity.*;
import com.jac.mpdemo.mapper.ApplyBaseMapper;
import com.jac.mpdemo.mapper.ApplyInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplyController {

    @Autowired
    private ApplyBaseMapper applyBaseMapper;
    @Autowired
    private ApplyInfoMapper applyInfoMapper;

    // 查询开发申请的基本信息列表
    @GetMapping("/apply/base")
    public List queryBaseList() {
        List<PlanApplyBase> list = applyBaseMapper.selectList(null);
        return list;
    }

    // 根据ID数组进行批量删除(同时级联删除明细表中的数据)
    @DeleteMapping ("/apply")
    public JSONResultBatch deleteByIDS(@RequestBody int ids[]) {
        int successCount = 0;
        int failureCount = 0;

        JSONResultBatch jsonResultBatch = new JSONResultBatch();

        // 批量删除
        for ( Integer id : ids) {
            // 组装wrapper
            QueryWrapper<PlanApplyInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("apply_id", id);

            // 先删除子表，再删除主表
            applyInfoMapper.delete(wrapper);
            int resOfBase = applyBaseMapper.deleteById(id);
            if (resOfBase == 0 ) {
                failureCount++;
            } else {
                successCount++;
            }
        }

        jsonResultBatch.setSuccessCount(successCount);
        if (failureCount == 0) {
            jsonResultBatch.setCode(1);
            jsonResultBatch.setMsg("删除成功");
        } else {
            jsonResultBatch.setCode(0);
            jsonResultBatch.setMsg("删除失败");
        }

        return jsonResultBatch;
    }

    // 新增申请（增加n条子表数据）
    @PostMapping("/apply/save")
    public JSONResultBatch saveApply(@RequestBody PlanApply planApply) throws Exception {
        JSONResultBatch jsonResultBatch = new JSONResultBatch();

        PlanApplyBase planApplyBase = new PlanApplyBase();
        planApplyBase.setApplyCode(planApply.getApply_code());
        planApplyBase.setApplyUserId(planApply.getApply_user_id());
        planApplyBase.setApplyCompany(planApply.getApply_company());
        planApplyBase.setApplyUserName(planApply.getApply_user_name());
        planApplyBase.setSupplierCode(planApply.getSupplier_code());
        planApplyBase.setSupplierName(planApply.getSupplier_name());

        int res = applyBaseMapper.insert(planApplyBase);

        // 得到插入主表后的apply_id
        int applyID  =planApplyBase.getApplyId();


        // 得到插入后的apply_id
        // 拼接数据后，批量insert
        for (ProductInfo productInfo : planApply.getApply_info()) {
            PlanApplyInfo planApplyInfo = new PlanApplyInfo();
            planApplyInfo.setApplyId(applyID);
            planApplyInfo.setProductArea(productInfo.getProduct_area());
            planApplyInfo.setProductName(productInfo.getProduct_name());

            int res1 = applyInfoMapper.insert(planApplyInfo);
        }

        if (res == 0) {
            jsonResultBatch.setCode(0);
            jsonResultBatch.setMsg("新增开发申请失败");
            jsonResultBatch.setSuccessCount(0);
        } else {
            jsonResultBatch.setCode(1);
            jsonResultBatch.setMsg("新增开发申请成功");
            jsonResultBatch.setSuccessCount(1);
        }

        return jsonResultBatch;
    }

    // 修改申请（增加、删除、修改明细信息）
    @PutMapping("/apply/update")
    public JSONResultBatch updateApply(@RequestBody PlanApply planApply) throws Exception {

        PlanApplyBase planApplyBase = new PlanApplyBase();
        JSONResultBatch jsonResultBatch = new JSONResultBatch();

        // 组装实体类
        planApplyBase.setApplyId(planApply.getApply_id());
        planApplyBase.setApplyCode(planApply.getApply_code());
        planApplyBase.setApplyUserId(planApply.getApply_user_id());
        planApplyBase.setApplyCompany(planApply.getApply_company());
        planApplyBase.setApplyUserName(planApply.getApply_user_name());
        planApplyBase.setSupplierCode(planApply.getSupplier_code());
        planApplyBase.setSupplierName(planApply.getSupplier_name());

        // 根据ID 进行更新
        int res = applyBaseMapper.updateById(planApplyBase);

        /**
         *  对子表数据进行覆盖式更新
         */

        // 根据apply_id(子表外键)删除子表数据
        // 拼装wrapper
        QueryWrapper<PlanApplyInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("apply_id", planApply.getApply_id());

        int resOfDel = applyInfoMapper.delete(wrapper);

        // 组装实体进行插入
        for (ProductInfo productInfo : planApply.getApply_info()) {
            PlanApplyInfo planApplyInfo = new PlanApplyInfo();
            planApplyInfo.setApplyId(planApply.getApply_id());
            planApplyInfo.setProductArea(productInfo.getProduct_area());
            planApplyInfo.setProductName(productInfo.getProduct_name());

            int resOfInsert = applyInfoMapper.insert(planApplyInfo);
        }

        if (res == 0) {
            jsonResultBatch.setCode(0);
            jsonResultBatch.setMsg("更新失败");
            jsonResultBatch.setSuccessCount(res);
        } else {
            jsonResultBatch.setCode(1);
            jsonResultBatch.setMsg("更新成功");
            jsonResultBatch.setSuccessCount(res);
        }

        return jsonResultBatch;
    }

    // 根据申请ID，查询单条申请的产品明细
    @GetMapping("/apply/info/{id}")
    public List<PlanApplyInfo> queryInfoByID(@PathVariable int id) {
        // 组装wrapper
        QueryWrapper<PlanApplyInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("apply_id", id);

        List<PlanApplyInfo> list = applyInfoMapper.selectList(wrapper);

        return list;
    }
}
