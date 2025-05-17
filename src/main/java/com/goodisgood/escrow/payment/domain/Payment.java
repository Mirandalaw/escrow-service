package com.goodisgood.escrow.payment.domain;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 결제 완료된 거래의 결제 정보를 저장하는 엔티티
 * PG사 결제 트랜잭션과 매핑되며, 환불/정산 시 필수 정보로 사용됨
 */
@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private UUID id;  // 결제 레코드 고유 ID

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private EscrowTransaction transaction; // 결제 대상 거래

    @Column(nullable = false)
    private UUID buyerId; // 결제한 사용자 ID

    @Column(nullable = false)
    private Integer paidAmount; // 실제 결제 금액 (원화 기준)

    @Column(nullable = false, length = 30)
    private String pgProvider; // PG사 이름 (예: 'toss', 'kakaopay', 'inicis')

    @Column(nullable = false, unique = true)
    private String pgTransactionId; // PG사에서 제공한 고유 결제 트랜잭션 ID

    @CreationTimestamp
    private LocalDateTime paidAt; // 결제 완료 시각
}