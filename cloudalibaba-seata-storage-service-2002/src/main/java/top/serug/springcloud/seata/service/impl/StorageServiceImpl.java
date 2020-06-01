package top.serug.springcloud.seata.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.seata.dao.StorageDao;
import top.serug.springcloud.seata.service.StorageService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  11:20
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;


    @Override
    public CommonResponse decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
        return new CommonResponse(200,"调用 storageDao 成功",true);
    }
}













