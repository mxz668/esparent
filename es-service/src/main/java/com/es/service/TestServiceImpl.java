package com.es.service;

import com.es.biz.TestService;
import com.es.util.EsUtil;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String createIndex() {
        TransportClient client = EsUtil.getTransportClient();
        XContentBuilder content = null;
        try {
            content = XContentFactory.jsonBuilder().startObject().field("name","zhangsan");
            content.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建索引
        UpdateResponse response = client.prepareUpdate("index1","es","1212")
                .setDoc(content)
                .get();
        return response.getIndex();
    }
}
