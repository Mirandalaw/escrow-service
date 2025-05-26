package com.goodisgood.escrow.transaction.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * 거래 상태 변경 요청 DTO
 * - 관리자, 시스템, 사용자에 의해 상태가 변경될 때 사용
 */
public record TransactionStatusUpdateRequest(
        @NotBlank
        @Pattern(regexp = "PENDING|PAID|DELIVERED|CONFIRMED|SETTLED|REFUNDED|DISPUTED")
        String status,

        @NotBlank
        String changedBy,

        String memo
) {}