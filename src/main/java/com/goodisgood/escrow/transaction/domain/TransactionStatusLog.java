package com.goodisgood.escrow.transaction.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * 거래 상태 변경 이력을 기록하는 로그 테이블
 * 거래 상태 추적 및 감사 용도로 사용되며, 실제 거래 흐름 분석에 활용됨
 */
@Entity
@Table(name = "transaction_status_logs")
@Getter
@NoArgsConstructor
public class TransactionStatusLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 로그 고유 식별자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private EscrowTransaction transaction; // 어떤 거래에 대한 로그인지

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status; // 변경된 거래 상태

    @Column(nullable = false)
    private String changedBy; // 상태 변경 주체 ('buyer', 'seller', 'admin', 'system')

    private String memo; // 사유 또는 메모 (선택)

    @CreationTimestamp
    private LocalDateTime timestamp; // 상태 변경 시각
}
