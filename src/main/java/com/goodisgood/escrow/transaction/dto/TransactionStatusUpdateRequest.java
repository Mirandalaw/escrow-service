package com.goodisgood.escrow.transaction.dto;

/**
 * 거래 상태 변경 요청 DTO
 * - 관리자, 시스템, 사용자에 의해 상태가 변경될 때 사용
 */
public record TransactionStatusUpdateRequest(
        String status,     // 변경할 상태명 (Enum: CONFIRMED, DISPUTED 등)
        String changedBy,  // 변경 주체 (buyer, seller, system)
        String memo        // 상태 변경 이유나 설명 (optional)
) {}