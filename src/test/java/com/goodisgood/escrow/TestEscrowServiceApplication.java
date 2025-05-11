package com.goodisgood.escrow;

import org.springframework.boot.SpringApplication;

public class TestEscrowServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(EscrowServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
