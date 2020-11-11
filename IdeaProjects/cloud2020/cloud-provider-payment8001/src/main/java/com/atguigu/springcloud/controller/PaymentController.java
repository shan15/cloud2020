package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "insert success", result);
        } else {
            return new CommonResult(444, "insert fail", result);

        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPamentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "select success", payment);
        } else {
            return new CommonResult(444, "none, id: " + id, null);

        }

    }
}
