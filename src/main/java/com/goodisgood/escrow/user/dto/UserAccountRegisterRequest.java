package com.goodisgood.escrow.user.dto;

/**
 * 판매자 계좌 등록 요청 DTO
 */
public record UserAccountRegisterRequest(
        Long userId,            // 계좌를 등록하는 사용자 ID
        String bankName,        // 은행 이름 (카카오뱅크)
        String accountNumber,   // 계좌번호
        String accountHolder    // 예금주명
) {}
