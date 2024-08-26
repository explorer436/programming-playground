package kafka.examples.analytics.service.controller;

import kafka.examples.analytics.service.dto.ProductTrendingDto;
import kafka.examples.analytics.service.service.ProductTrendingBroadcastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("trending")
@RequiredArgsConstructor
public class TrendingController {

    private final ProductTrendingBroadcastService productTrendingBroadcastService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<ProductTrendingDto>> trending() {
        return productTrendingBroadcastService.getTrends();
    }

}
