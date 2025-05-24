package com.goodisgood.escrow.dispute.dto;

/**
 * 분쟁 등록 요청 DTO
 */
public record DisputeCreateRequest(
        Long transactionId,  // 분쟁 대상 거래 ID
        Long reportedBy,     // 분쟁 제기자 (buyer/seller UUID)
        String reason        // 분쟁 사유 (사용자 작성)
) {}