package com.goodisgood.escrow.settlement.domain;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * 판매자에게 지급될 정산 정보를 담는 엔티티
 * 실제 지급액 = 총 결제 금액 - 수수료
 */
@Entity
@Table(name = "settlements")
@Getter
@NoArgsConstructor
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 정산 고유 ID

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private EscrowTransaction transaction; // 어떤 거래의 정산인지

    @Column(nullable = false)
    private Long sellerId; // 정산 대상 판매자 ID (UUID → Long)

    @Column(nullable = false)
    private Integer totalAmount; // 총 결제 금액

    @Column(nullable = false)
    private Integer feeAmount;   // 수수료 공제 금액

    @Column(nullable = false)
    private Integer netAmount;   // 실제 정산 금액 (totalAmount - feeAmount)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SettlementStatus status; // 정산 상태 (READY, COMPLETED, FAILED)

    @CreationTimestamp
    private LocalDateTime settledAt; // 정산 완료 시간 (실제 송금 완료 시 기록)
}
