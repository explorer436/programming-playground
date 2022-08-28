package com.example.assignment.rewards.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.rewardsCalculator.base-path:}")
public class RewardsApiController implements RewardsApi {

    private final RewardsApiDelegate delegate;

    public RewardsApiController(@Autowired(required = false) RewardsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new RewardsApiDelegate() {});
    }

    @Override
    public RewardsApiDelegate getDelegate() {
        return delegate;
    }

}
