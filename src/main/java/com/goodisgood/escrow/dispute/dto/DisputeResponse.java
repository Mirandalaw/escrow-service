package com.goodisgood.escrow.dispute.dto;

import java.time.LocalDateTime;

/**
 * 분쟁 조회 응답 DTO
 */
public record DisputeResponse(
        Long id,               // 분쟁 고유 ID
        Long transactionId,    // 분쟁이 발생한 거래 ID
        Long reportedBy,       // 제기한 사용자 ID
        String status,         // 분쟁 상태 (OPEN, UNDER_REVIEW, RESOLVED)
        String reason,         // 분쟁 사유
        String resolution,     // 관리자 또는 시스템 처리 결과
        LocalDateTime resolvedAt // 해결된 시점 (없으면 null)
) {}