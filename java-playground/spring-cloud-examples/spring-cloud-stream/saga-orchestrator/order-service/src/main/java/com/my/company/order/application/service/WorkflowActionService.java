package com.my.company.order.application.service;

import com.my.company.common.util.DuplicateEventValidator;
import com.my.company.order.application.mapper.EntityDtoMapper;
import com.my.company.order.application.repository.OrderWorkflowActionRepository;
import com.my.company.order.common.dto.OrderWorkflowActionDto;
import com.my.company.order.common.enums.WorkflowAction;
import com.my.company.order.common.service.WorkflowActionRetriever;
import com.my.company.order.common.service.WorkflowActionTracker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkflowActionService implements WorkflowActionTracker, WorkflowActionRetriever {

    private final OrderWorkflowActionRepository repository;

    @Override
    public Flux<OrderWorkflowActionDto> retrieve(UUID orderId) {
        return this.repository.findByOrderIdOrderByCreatedAt(orderId)
                              .map(EntityDtoMapper::toOrderWorkflowActionDto);
    }

    @Override
    public Mono<Void> track(UUID orderId, WorkflowAction action) {
        return DuplicateEventValidator.validate(
                this.repository.existsByOrderIdAndAction(orderId, action),
                this.repository.save(EntityDtoMapper.toOrderWorkflowAction(orderId, action)) // defer if required
        ).then();
    }
}
