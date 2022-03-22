package com.gujun.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test01
 * @Author GuJun
 * @Description:
 * @Date 2022年02月03日 11:48
 */
public class Test01 {

    private static void testSentinel01(){
        try(Entry entry= SphU.entry("testSentinel01")){
            System.out.println("testSentinel01");
        }catch ( BlockException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void initFlowRules(){
        List<FlowRule> flowRules=new ArrayList<>();
        FlowRule flowRule=new FlowRule();
        flowRule.setResource("testSentinel01");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(10);
        flowRules.add(flowRule);
        FlowRuleManager.loadRules(flowRules);
    }

    private static void initDegradeRule(){
    }

    @Test
    public void test01(){
        initFlowRules();
        while (true){
            testSentinel01();
        }
    }

}
