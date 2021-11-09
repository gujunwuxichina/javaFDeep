package com.gujun.test;

import com.gujun.ultimate.annotation.Test01;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @ClassName: TestLocalDate
 * @Author GuJun
 * @Description:
 * @Date 2021年09月29日 15:20
 */
public class TestLocalDate {

    @Test
    public void test01(){
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }

}
