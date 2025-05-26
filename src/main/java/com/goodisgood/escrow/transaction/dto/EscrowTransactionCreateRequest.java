package com.goodisgood.escrow.transaction.dto;

import com.goodisgood.escrow.transaction.usecase.command.CreateTransactionCommand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * 거래 생성 요청 DTO
 * - 구매자가 새로운 거래를 생성할 때 사용하는 요청 DTO
 */
@Getter
@Setter
public class EscrowTransactionCreateRequest {
    @NotNull
    private Long buyerId;    // 구매자 ID
    @NotNull
    private Long sellerId;   // 판매자 ID
    @NotNull
    private Long itemId;     // 거래 아이템 ID
    @NotNull
    @Min(1)
    private Integer amount;   // 거래 금액 (원화 단위)

    public CreateTransactionCommand toCommand() {
        return new CreateTransactionCommand(buyerId, sellerId, itemId, amount);
    }
}