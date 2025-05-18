package com.goodisgood.escrow.transaction.dto;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 거래 응답 DTO
 * - 단일 거래 조회 또는 생성 응답 등에 사용
 */
public record EscrowTransactionResponse(
        UUID id,
        UUID buyerId,
        UUID sellerId,
        UUID itemId,
        Integer amount,
        String status,            // 거래 상태 (ex: PENDING, PAID, CONFIRMED)
        boolean disputed,
        LocalDateTime expiredAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}