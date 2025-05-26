package com.goodisgood.escrow.transaction.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * EscrowTransaction
 * - 거래 정보를 담는 도메인 엔티티
 */
@Getter
@Entity
@Table(name = "escrow_transactions")
public class EscrowTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 거래 고유 식별자

    @Column(nullable = false)
    private Long buyerId;   // 구매자 ID

    @Column(nullable = false)
    private Long sellerId;  // 판매자 ID

    @Column(nullable = false)
    private Long itemId;    // 거래 아이템 ID

    @Column(nullable = false)
    private Integer amount; // 거래 총 금액 (단위: 원)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status; // 거래 상태 (PENDING, PAID 등)

    @Column(nullable = false)
    private boolean disputed; // 분쟁 여부

    private LocalDateTime expiredAt; // 자동 확정 예정 시간

    @CreationTimestamp
    private LocalDateTime createdAt; // 생성 시각

    @UpdateTimestamp
    private LocalDateTime updatedAt; // 마지막 변경 시각

    protected EscrowTransaction() {
    }

    public EscrowTransaction(Long buyerId, Long sellerId, Long itemId, Integer amount) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.itemId = itemId;
        this.amount = amount;
        this.status = TransactionStatus.PENDING;
        this.disputed = false;
    }
}