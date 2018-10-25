package com.jason.es;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;

import org.elasticsearch.common.inject.PrivateBinder;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * 向ES添加索引对象
 *
 * @author donlian
 */
public class IndexTest {

    public static Client init() {
        Settings settings = Settings.builder()
                //指定集群名称
                .put("cluster.name", "elasticsearch")
                //探测集群中机器状态
                .put("client.transport.sniff", true).build();
        /*
         * 创建客户端，所有的操作都由客户端开始，这个就好像是JDBC的Connection对象
         * 用完记得要关闭
         */
        try {
            Client client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
            return client;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] argv) throws UnknownHostException {
        // es初始化
        Client client = init();

        String index = "twitter";
        String type = "jason";
        String id = "1";
        for( int i = 0 ; i < 100 ; i ++) {
            createIndexData(client, index, type, String.valueOf(i));
        }


        client.close();

    }

    /***
     * @Param client
     * 创建一个es索引对象
     */
    private static void createIndexData(Client client, String index, String type, String id) {
        String json = ESUtils.toJson(new LogModel());
        //在这里创建我们要索引的对象
        IndexResponse response = client.prepareIndex(index, type)
                //必须为对象单独指定ID
                .setId(id)
                .setSource(json)
                .execute()
                .actionGet();
        //多次index这个版本号会变
        System.out.println("response.version():" + response.getVersion());

    }

    // 获取es中的数据
    private static void getData(Client client, String index, String type, String id) {
        GetResponse response = client.prepareGet(index, type, id).execute().actionGet();
        System.out.println("response.getId(): " + response.getId());
        System.out.println("response.getSourceAsString(): " + response.getSourceAsString());
    }

    private static void delete(Client client, String index, String type, String id) {
        DeleteResponse response = client.prepareDelete(index, type, id)
                .execute().actionGet();
        System.out.println(response.getId());
        System.out.println(ESUtils.toJson(response.status()));
    }


}  