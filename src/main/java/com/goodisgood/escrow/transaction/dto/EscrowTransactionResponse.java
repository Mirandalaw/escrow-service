package com.goodisgood.escrow.transaction.dto;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;

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
        String status,
        boolean disputed,
        LocalDateTime expiredAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static EscrowTransactionResponse from(EscrowTransaction tx) {
        return new EscrowTransactionResponse(
                tx.getId(),
                tx.getBuyerId(),
                tx.getSellerId(),
                tx.getItemId(),
                tx.getAmount(),
                tx.getStatus().name(),
                tx.isDisputed(),
                tx.getExpiredAt(),
                tx.getCreatedAt(),
                tx.getUpdatedAt()
        );
    }
}