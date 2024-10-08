package com.my.company.payment.application.service;

import com.my.company.common.events.payment.PaymentStatus;
import com.my.company.common.util.DuplicateEventValidator;
import com.my.company.payment.application.entity.Customer;
import com.my.company.payment.application.entity.CustomerPayment;
import com.my.company.payment.application.mapper.EntityDtoMapper;
import com.my.company.payment.application.repository.CustomerRepository;
import com.my.company.payment.application.repository.PaymentRepository;
import com.my.company.payment.common.dto.PaymentDto;
import com.my.company.payment.common.dto.PaymentProcessRequest;
import com.my.company.payment.common.exception.CustomerNotFoundException;
import com.my.company.payment.common.exception.InsufficientBalanceException;
import com.my.company.payment.common.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private static final Mono<Customer> CUSTOMER_NOT_FOUND = Mono.error(new CustomerNotFoundException());
    private static final Mono<Customer> INSUFFICIENT_BALANCE = Mono.error(new InsufficientBalanceException());
    private final CustomerRepository customerRepository;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Mono<PaymentDto> process(PaymentProcessRequest request) {
        return DuplicateEventValidator.validate(
                                              this.paymentRepository.existsByOrderId(request.orderId()),
                                              this.customerRepository.findById(request.customerId())
                                      )
                                      .switchIfEmpty(CUSTOMER_NOT_FOUND)
                                      .filter(c -> c.getBalance() >= request.amount())
                                      .switchIfEmpty(INSUFFICIENT_BALANCE)
                                      .flatMap(c -> this.deductPayment(c, request))
                                      .doOnNext(dto -> log.info("payment processed for {}", dto.orderId()));
    }

    private Mono<PaymentDto> deductPayment(Customer customer, PaymentProcessRequest request) {
        var customerPayment = EntityDtoMapper.toCustomerPayment(request);
        customer.setBalance(customer.getBalance() - request.amount());
        customerPayment.setStatus(PaymentStatus.DEDUCTED);
        return this.customerRepository.save(customer)
                                      .then(this.paymentRepository.save(customerPayment))
                                      .map(EntityDtoMapper::toDto);
    }

    @Override
    @Transactional
    public Mono<PaymentDto> refund(UUID orderId) {
        return this.paymentRepository.findByOrderIdAndStatus(orderId, PaymentStatus.DEDUCTED)
                                     .zipWhen(cp -> this.customerRepository.findById(cp.getCustomerId()))
                                     .flatMap(t -> this.refundPayment(t.getT1(), t.getT2()))
                                     .doOnNext(dto -> log.info("refunded amount {} for {}", dto.amount(), dto.orderId()));
    }

    private Mono<PaymentDto> refundPayment(CustomerPayment customerPayment, Customer customer) {
        customer.setBalance(customer.getBalance() + customerPayment.getAmount());
        customerPayment.setStatus(PaymentStatus.REFUNDED);
        return this.customerRepository.save(customer)
                                      .then(this.paymentRepository.save(customerPayment))
                                      .map(EntityDtoMapper::toDto);
    }

}
