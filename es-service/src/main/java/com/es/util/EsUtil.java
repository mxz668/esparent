package com.es.util;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class EsUtil {
    public static TransportClient getTransportClient(){

        TransportClient client = null;
        try {

            //1.设置集群名称
            Settings settings = Settings.builder()
                    .put("cluster.name","es-test") //设置集群的名字,默认是elasticsearch
                    .build();
            //2.创建client
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}
