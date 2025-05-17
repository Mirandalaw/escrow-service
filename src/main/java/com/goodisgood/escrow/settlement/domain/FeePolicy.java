package com.goodisgood.escrow.settlement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 거래 수수료 정책을 정의하는 엔티티
 * 고정 수수료 + 비율 수수료를 조합하여 유연한 요금 정책을 구성할 수 있음
 */
@Entity
@Table(name = "fee_policies")
@Getter
@NoArgsConstructor
public class FeePolicy {

    @Id
    @GeneratedValue
    private UUID id; // 수수료 정책 고유 식별자

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal percentage; // 비율 수수료 (예: 2.50% = 2.50)

    @Column(nullable = false)
    private Integer fixedFee; // 고정 수수료 (예: 100원)

    @Column(nullable = false)
    private LocalDateTime effectiveFrom; // 정책 적용 시작 일시

    @Column(nullable = false)
    private boolean active; // 현재 활성화 여부
}