package com.example.demo;

import org.apache.curator.test.TestingServer;
import org.springframework.cloud.zookeeper.ZookeeperProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class EmbeddedZookeeperConfiguration {

    @Bean(destroyMethod = "close")
    TestingServer testingServer() throws Exception {
        return new TestingServer();
    }

    @Bean
    @Primary
    ZookeeperProperties tweakedZookeeperProperties(TestingServer testingServer) throws Exception {
        ZookeeperProperties zookeeperProperties = new ZookeeperProperties();
        zookeeperProperties.setConnectString("localhost:" + testingServer.getPort());
        return zookeeperProperties;
    }
}
