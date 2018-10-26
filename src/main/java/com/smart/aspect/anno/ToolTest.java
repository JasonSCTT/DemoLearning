package com.smart.aspect.anno;

import java.lang.reflect.Method;

/**
 * @author jason
 */
public class ToolTest {

    public static void main(String[] args) {
        //得到forumService对应的class对象
        Class clazz = ForumService.class;

        // 得到方法数据
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            //获取方法上所标注的注解
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "需要测试。。。。。。");
                } else {
                    System.out.println(method.getName() + "不需要测试。。。。");
                }

            }

        }

    }
}
