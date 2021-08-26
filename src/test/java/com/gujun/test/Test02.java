package com.gujun.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.gujun.ultimate.annotation.Test01;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @ClassName: Test02
 * @Author GuJun
 * @Description:
 * @Date 2021年08月24日 15:17
 */
public class Test02 {

    @Test
    public void test01(){
        String s1="";
        String s2="gujun";
    }

    @Test
    public void test02(){
        Task task=new Task();
        task.setName("task");
        System.out.println(JSONObject.toJSONString(task));
    }

    @Test
    public void test03(){
        Task task=JSONObject.parseObject("{\"name\":\"task\",\"localDateTime\":null}",Task.class);
        System.out.println(task);
    }

    @Test
    public void test04(){
        ResponseBean<TaskStepBean> responseBean=JSONObject.parseObject("{\"success\":true,\"code\":200,\"message\":\"操作成功\",\"data\":" +
                "{\"workTaskDetail\":{\"workTaskDetailId\":\"c2b49c5dd0834986a70794de8bacaca0\",\"workTaskId\":\"0773704e9b773a83375ee74542db5b9b\",\"workFlowDetailId\":\"217c9bb6393140b1aafd200a32cf4439\",\"flowDetailType\":4,\"number\":1,\"startTime\":\"2021-08-24T16:11:33\",\"endTime\":null,\"feedBack\":null,\"fileUrl\":\"http://gujun-cat.oss-cn-shanghai.aliyuncs.com/37d0154b689b455f82893219f5656993.gif\",\"completer\":null,\"chooseValue\":0},\"workTask\":{\"workTaskId\":null,\"mainTaskId\":null,\"taskName\":null,\"workFlowId\":\"92dd9c45a2fd1a3e1295ea59fd10a441\",\"deviceLedgerId\":null,\"state\":2,\"deptId\":null,\"operator\":null,\"planStartTime\":null,\"completeTime\":null,\"remark\":null,\"currentNumber\":1,\"isMain\":null,\"createBy\":null,\"createTime\":null,\"updateBy\":null,\"updateTime\":null,\"planCompleteTime\":null,\"comment\":null},\"flowDetail\":{\"flowDetailId\":\"217c9bb6393140b1aafd200a32cf4439\",\"flowId\":\"92dd9c45a2fd1a3e1295ea59fd10a441\",\"type\":4,\"title\":\"图片\",\"text\":null,\"fileUrl\":\"http://gujun-cat.oss-cn-shanghai.aliyuncs.com/37d0154b689b455f82893219f5656993.gif\",\"number\":null,\"isBranch\":0,\"branchValue\":null,\"targetIds\":\"327ce92f418948abb56ec1b2aec8da98\",\"sourceIds\":\"start\",\"isCheck\":0,\"photo\":0,\"delay\":0,\"buttons\":\"[]\"}},\"timeStamp\":\"2021-08-24 04:42:25\"}",new TypeReference<ResponseBean<TaskStepBean>>(){}.getType());
        System.out.println(responseBean.getData().getWorkTask().getWorkFlowId());
        System.out.println(responseBean.getMessage());
    }

}
