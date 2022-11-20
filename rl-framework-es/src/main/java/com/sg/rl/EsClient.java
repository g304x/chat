package com.sg.rl;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EsClient implements ApplicationListener<ContextRefreshedEvent> {

    private final static int CONNECT_TIMEOUT = 100;
    private final static int SOCKET_TIMEOUT = 60 * 1000;
    private final static int REQUEST_TIMEOUT = SOCKET_TIMEOUT;
    private RestHighLevelClient restHighLevelClient;  //JDK8 推荐使用这种高阶的client
    private BasicHeader[] basicHeaders;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            initClient();
        } catch (Exception e) {
            log.error("es client init exception", e);
            try {
                Thread.sleep(1000);
            } catch (Exception e1) {

            }
            initClient();
        }
    }

    private void initClient() {
        log.info("es client init start");
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        log.info("es client init end");
    }





}
