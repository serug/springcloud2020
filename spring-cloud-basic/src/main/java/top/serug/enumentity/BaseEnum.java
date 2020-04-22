package top.serug.enumentity;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/22  23:26
 */
public class BaseEnum {
    public enum ResultEnum {
        Success("成功", 10000),
        Fail("失败", -9999),
        ValidateFail("验证失败", -9998),
        SecuritySqlFail("SQL注入问题", -9997),
        SecurityCharFail("特殊字符问题", -9996),
        NoPermission("该请求无权限", -9995),
        NoLogin("请登录", -9994),
        NoToken("无token", -9990),
        TokenError("Token错误",-8999),
        LoginExpired("登录时间过期", -9993),
        UsernameError("用户名或密码错误", -9980),
        RepeatAttack("存在重放攻击", -9992),
        SingleLogin("本账号已在其它地方登录", -9991),
        ValidateCodeExpire("验证码过期", 20001),
        ValidateCodeError("验证码错误", 20002),
        ServiceProblems("服务存在问题",30000),
        ServerError("服务连接中断, 请稍后再试", -9000);

        // 成员变量
        private String name;
        private int code;

        // 构造方法
        private ResultEnum(String name, int code) {
            this.name = name;
            this.code = code;
        }

        // 普通方法
        public static String getNameByCode(int code) {
            for (ResultEnum c : ResultEnum.values()) {
                if (code == c.getCode()) {
                    return c.name;
                }
            }
            return null;
        }

        // get set 方法
        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }

}
