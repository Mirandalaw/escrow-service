package com.goodisgood.escrow.transaction.dto;

/**
 * 거래 생성 요청 DTO
 * - 구매자가 새로운 거래를 생성할 때 사용됨
 */
public record EscrowTransactionCreateRequest(
        Long buyerId,    // 구매자 ID
        Long sellerId,   // 판매자 ID
        Long itemId,     // 거래 아이템 ID
        Integer amount   // 거래 금액 (원화 단위)
) {}
