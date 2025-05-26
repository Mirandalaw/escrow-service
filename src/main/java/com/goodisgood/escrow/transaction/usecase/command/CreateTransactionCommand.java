package com.goodisgood.escrow.transaction.usecase.command;

import lombok.Getter;

/**
 * CreateTransactionCommand
 * - 거래 생성 유즈케이스에 전달되는 내부 커맨드 모델
 */
@Getter
public class CreateTransactionCommand {
    private final Long buyerId;
    private final Long sellerId;
    private final Long itemId;
    private final Integer amount;

    public CreateTransactionCommand(Long buyerId, Long sellerId, Long itemId, Integer amount) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.itemId = itemId;
        this.amount = amount;
    }
}

