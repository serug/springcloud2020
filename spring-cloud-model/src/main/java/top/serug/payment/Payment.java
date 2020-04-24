package top.serug.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/22  23:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private long payId;
    private BigDecimal payMoney;
}
