package com.example.assignment.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import openapitools.RewardsOuterClass;
import openapitools.services.rewardsservice.RewardsServiceOuterClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig(classes = { MyServiceUnitTestConfiguration.class })
@Slf4j
// Spring doesn't start without a config (might be empty)
// Don't use @EnableAutoConfiguration in this scenario
public class RewardsGrpcServiceTests {

    @Autowired
    private RewardsGrpcService rewardsGrpcService;

    @Test
    void test_getRewards() throws Exception {
        RewardsServiceOuterClass.GetRewardsByCustomerIdRequest request = RewardsServiceOuterClass.GetRewardsByCustomerIdRequest.newBuilder()
                .setCustomerId("1")
                .build();

        StreamObserver<RewardsOuterClass.Rewards> responseObserver = new StreamObserver<RewardsOuterClass.Rewards>() {
            @Override
            public void onNext(RewardsOuterClass.Rewards rewards) {
                log.info("onNext");
                log.info(rewards.toString());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                log.info("onCompleted");
            }
        };

        rewardsGrpcService.getRewardsByCustomerId(request, responseObserver);
    }
}
