package com.goodisgood.escrow.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 판매자의 정산 계좌 정보를 저장하는 엔티티
 * 정산 금액 송금 시 사용되며, PG사 또는 은행 API와 연동될 수 있음
 */
@Entity
@Table(name = "user_accounts")
@Getter
@NoArgsConstructor
public class UserAccount {

    @Id
    private UUID userId; // 사용자 고유 ID (판매자 기준)

    @Column(nullable = false)
    private String bankName; // 은행 이름 (예: '카카오뱅크', '국민은행')

    @Column(nullable = false)
    private String accountNumber; // 실제 계좌번호

    @Column(nullable = false)
    private String accountHolder; // 예금주명 (실명 인증 필요)

    private LocalDateTime registeredAt; // 계좌 최초 등록 시각
}