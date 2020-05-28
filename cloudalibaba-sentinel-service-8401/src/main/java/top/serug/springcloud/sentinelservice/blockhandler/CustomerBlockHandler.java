package top.serug.springcloud.sentinelservice.blockhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import top.serug.responseentity.CommonResponse;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/28  22:35
 */
public class CustomerBlockHandler {

    public static CommonResponse blockHandler_1(BlockException e){
        return new CommonResponse(4444,"blockHandler1",false);
    }

    public static CommonResponse blockHandler_2(BlockException e){
        return new CommonResponse(4444,"blockHandler2",false);
    }


}
