package com.goodisgood.escrow.transaction.dto;

import java.time.LocalDateTime;

/**
 * 거래 응답 DTO
 * - 단일 거래 조회 또는 생성 응답 등에 사용
 */
public record EscrowTransactionResponse(
        Long id,
        Long buyerId,
        Long sellerId,
        Long itemId,
        Integer amount,
        String status,            // 거래 상태 (ex: PENDING, PAID, CONFIRMED)
        boolean disputed,
        LocalDateTime expiredAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
