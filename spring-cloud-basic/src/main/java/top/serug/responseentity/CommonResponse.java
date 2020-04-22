package top.serug.responseentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.serug.enumentity.BaseEnum;

/**
 * @Description: 通用的返回对象
 * @Author: serug
 * @Date: 2020/4/22  21:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {

    private Integer code;
    private String message;
    private boolean isSuccess;
    private T data;


    /**
     * @Description: 构造器
     * @Param:
     * @return:
     */
    public CommonResponse(Integer code, String message, boolean isSuccess){

        this(code, message, isSuccess,null);
    }

    /**
     * @Description: 失败
     * @Param:
     * @return:
     */
    private static <T> CommonResponse<T> fail(){

        return fail(BaseEnum.ResultEnum.Fail.getName());
    }

    /**
     * @Description: 失败
     * @Param: code
     * @return:
     */
    private static <T> CommonResponse<T> fail(Integer code){

        return new CommonResponse<T>(code, "message", false,null);
    }

    /**
     * @Description: 失败
     * @Param: message
     * @return:
     */
    private static <T> CommonResponse<T> fail(String message){

        return new CommonResponse<T>(BaseEnum.ResultEnum.Fail.getCode(), message, false,null);
    }
}
