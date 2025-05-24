package com.goodisgood.escrow.settlement.dto;

import java.time.LocalDateTime;

/**
 * 정산 결과 조회 응답 DTO
 */
public record SettlementResponse(
        Long id,                 // 정산 고유 ID
        Long transactionId,      // 정산 대상 거래 ID
        Long sellerId,           // 정산 대상 판매자 ID
        Integer totalAmount,     // 전체 거래 금액
        Integer feeAmount,       // 공제된 수수료
        Integer netAmount,       // 실제 정산될 금액 (total - fee)
        String status,           // 정산 상태 (READY, COMPLETED, FAILED 등)
        LocalDateTime settledAt  // 정산 완료 시간 (또는 null)
) {}
