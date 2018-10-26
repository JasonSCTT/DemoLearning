package com.smart.dynamic;

public class ServiceImpl implements Service {
    @Override
    public void removeTopic(int topicId) {
        System.out.println("删除topic记录为" + topicId);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeForm(int topicId) {
        System.out.println("删Form除记录为" + topicId);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
