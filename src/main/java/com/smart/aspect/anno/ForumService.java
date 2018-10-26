package com.smart.aspect.anno;

/**
 * @author jason
 */
public class ForumService {

    @NeedTest(value = true)
    public void deleteForum(int forumId) {
        System.out.println("删除论坛模快：" + forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int postId) {
        System.out.println("删除论坛主题：" + postId);
    }

}
