package com.example.assignment.rewards.api.clients;

import com.example.assignment.rewards.api.RewardsApi;
import com.example.assignment.rewards.model.Rewards;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class SampleClient {

    private RewardsApi rewardsApi = new RewardsApi();

    // Ideally, this will be coming from property files.
    private static String url = "http://localhost:8080";

    @PostConstruct
    protected void init() {
        rewardsApi.getApiClient().setBasePath(url);
    }

    public void post() {
        Mono<Rewards> rewardsApiRewardsByCustomerId = rewardsApi.getRewardsByCustomerId("1");

        try {
            Rewards rewards = rewardsApiRewardsByCustomerId.toFuture().get();

            log.info("rewards : " + rewards.toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
