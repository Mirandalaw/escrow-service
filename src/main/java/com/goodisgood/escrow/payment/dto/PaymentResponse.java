package com.goodisgood.escrow.payment.dto;

import java.time.LocalDateTime;

/**
 * 결제 완료 후 사용자 또는 시스템에 반환되는 결제 정보 응답 DTO
 */
public record PaymentResponse(
        Long id,                // 결제 고유 식별자
        Long transactionId,     // 결제 대상 거래 ID
        Long buyerId,           // 결제한 사용자 ID
        Integer paidAmount,     // 결제 금액 (원화 기준)
        String pgProvider,      // PG사 이름 (예: toss, kakaopay)
        String pgTransactionId, // PG사에서 발급한 고유 결제 트랜잭션 ID
        LocalDateTime paidAt    // 결제 완료 시각
) {}
