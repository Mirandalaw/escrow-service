package com.goodisgood.escrow.dispute.domain;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 거래 중 분쟁이 발생했을 때 해당 내역을 기록하고 처리 상태를 관리하는 엔티티
 */
@Entity
@Table(name = "disputes")
@Getter
@NoArgsConstructor
public class Dispute {

    @Id
    @GeneratedValue
    private UUID id;  // 분쟁 고유 식별자

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private EscrowTransaction transaction; // 분쟁이 발생한 거래

    @Column(nullable = false)
    private UUID reportedBy; // 분쟁 제기자 (buyer 또는 seller의 UUID)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DisputeStatus status; // 분쟁 상태 (OPEN, UNDER_REVIEW, RESOLVED)

    @Column(nullable = false, length = 1000)
    private String reason; // 분쟁 사유 (사용자 작성)

    private String resolution; // 분쟁 처리 결과 또는 관리자 메모

    private LocalDateTime resolvedAt; // 분쟁 해결 시각 (처리 완료 시 기록)
}