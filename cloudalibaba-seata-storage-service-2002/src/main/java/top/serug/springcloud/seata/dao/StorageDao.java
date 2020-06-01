package top.serug.springcloud.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  12:57
 */
@Mapper
public interface StorageDao {
    public void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
