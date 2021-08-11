package com.gujun.ultimate.thread.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Account
 * @Author GuJun
 * @Description:
 * @Date 2021年08月11日 11:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"no"})
public class Account {

    private String no;

    private Double balance;

}
