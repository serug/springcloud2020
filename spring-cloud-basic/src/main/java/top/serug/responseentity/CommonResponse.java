package top.serug.responseentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private T data;


    public CommonResponse(Integer code, String message){

        this(code, message, null);
    }
    
    private static <T> CommonResponse<T> fail(){

        return fail(123);
    }

    private static <T> CommonResponse<T> fail(Integer code){

        return new CommonResponse<>(code, "message", null);
    }

}
