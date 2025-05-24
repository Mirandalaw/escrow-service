package com.goodisgood.escrow.user.dto;

import java.time.LocalDateTime;

/**
 * 판매자 계좌 정보 조회 응답 DTO
 */
public record UserAccountResponse(
        Long userId,              // 사용자 ID (계좌 소유자)
        String bankName,          // 은행 이름
        String accountNumber,     // 계좌번호
        String accountHolder,     // 예금주
        LocalDateTime registeredAt // 최초 등록일
) {}