package com.es.service;

import com.es.biz.TestService;
import com.es.util.EsUtil;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

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

    @Override
    public String query() {
        TransportClient client = EsUtil.getTransportClient();
        SearchRequest request = new SearchRequest("index1");
        request.types("es");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(1);
        sourceBuilder.size(2);

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termQuery("user","zhangsan"));

        sourceBuilder.query(boolQueryBuilder);

        request.source(sourceBuilder);

        ActionFuture<SearchResponse> resp = client.search(request);
        try {
            SearchResponse response = resp.get();
            SearchHits hits = response.getHits();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
