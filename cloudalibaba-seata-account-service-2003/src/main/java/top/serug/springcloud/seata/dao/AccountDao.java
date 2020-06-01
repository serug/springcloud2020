package top.serug.springcloud.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  12:57
 */
@Mapper
public interface AccountDao {
    public void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
