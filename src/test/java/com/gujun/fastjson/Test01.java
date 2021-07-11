package com.gujun.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:
 * @Date 2021年06月30日 16:01
 */
public class Test01 {

    @Test
    public void test01(){
        String s="[{\"brief\":\"{\\\"type\\\":\\\"deviceLedger\\\",\\\"typeId\\\":\\\"57c878da-a7ee-11eb-bdcc-8cec4b1b747e\\\"}\",\"score\":0.99709959419822,\"cont_sign\":\"3199140035,1923088071\"}]";
        JSONArray jsonArray1= JSONObject.parseArray(s);
        System.out.println(jsonArray1.toJSONString());
        System.out.println(((JSONObject)jsonArray1.get(0)).get("brief").getClass().getSimpleName());

        JSONArray jsonArray2=JSONArray.parseArray(s, ParserConfig.getGlobalInstance());
        System.out.println(jsonArray2.toJSONString());
        System.out.println(((JSONObject)jsonArray2.get(0)).get("brief"));
        JSONObject jsonObject= (JSONObject) jsonArray2.get(0);
        JSONObject result=JSONObject.parseObject(jsonObject.get("brief").toString());
        System.out.println(result.get("type").toString());

    }

}
