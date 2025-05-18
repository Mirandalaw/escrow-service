package com.goodisgood.escrow.transaction.dto;

import java.util.UUID;

/**
 * 거래 생성 요청 DTO
 * - 구매자가 새로운 거래를 생성할 때 사용됨
 */
public record EscrowTransactionCreateRequest(
        UUID buyerId,    // 구매자 ID
        UUID sellerId,   // 판매자 ID
        UUID itemId,     // 거래 아이템 ID
        Integer amount   // 거래 금액 (원화 단위)
) {}