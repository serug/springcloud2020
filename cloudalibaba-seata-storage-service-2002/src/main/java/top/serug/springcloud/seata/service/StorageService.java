package top.serug.springcloud.seata.service;

import top.serug.responseentity.CommonResponse;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  11:20
 */
public interface StorageService {

    public CommonResponse decrease( Long productId, Integer count);
}
