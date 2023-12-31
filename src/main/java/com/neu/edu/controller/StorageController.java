package com.neu.edu.controller;

import com.neu.edu.service.StorageService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.StorageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/storage")
public class StorageController {
    @Autowired
    StorageService storageService;

    /**
     * 获取所有库存信息
     */
    @GetMapping(value = "/getAllStoragesInfo")
    public ResultModelGet<StorageVO> getAllStoragesInfo() {
        return storageService.getAllStoragesInfo();
    }

    /**
     * 获取库存编号storageNum, 返回一个list
     */
    @GetMapping(value = "/getStoragesNum")
    public ResultModelGet<String> getStoragesNum() {
        return storageService.getStoragesNum();
    }

    /**
     * 按页获取库存信息
     * @param page 页数
     * @param size 每页大小
     */
    @GetMapping(value = "/getStoragesInfoByPage")
    public ResultModelGet<StorageVO> getStoragesInfoByPage(int page, @RequestParam(value = "size", defaultValue = "2") int size) {
        return storageService.getStoragesInfoByPage(page, size);
    }

    /**
     * 添加库存
     * @param storageVO 库存信息 可以不传入storageNum，storageNum为null是会自动赋值
     */
    @PostMapping(value = "/addStorage")
    public ResultModel addStorage(@RequestBody StorageVO storageVO) {
        return storageService.addStorage(storageVO);
    }

    /**
     * 删除库存
     * @param storageNum 库存编号
     */
    @DeleteMapping(value = "/deleteStorageById/{storageNum}")
    public ResultModel deleteStorageById(@PathVariable("storageNum") int storageNum) {
        return storageService.deleteStorageById(storageNum);
    }

    /**
     * 更新库存信息
     * @param storageVO 库存信息 必须传入storageNum
     */
    @PutMapping(value = "/updateStorage")
    public ResultModel updateStorage(@RequestBody StorageVO storageVO) {
        return storageService.updateStorage(storageVO);
    }
}
