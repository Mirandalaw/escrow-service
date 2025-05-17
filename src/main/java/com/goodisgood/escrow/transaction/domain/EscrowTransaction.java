package com.goodisgood.escrow.transaction.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "escrow_transactions")
@Getter
@NoArgsConstructor
public class EscrowTransaction {

    @Id
    @GeneratedValue
    private UUID id;  // 거래 고유 식별자 (UUID)

    @Column(nullable = false)
    private UUID buyerId;   // 구매자 사용자 ID

    @Column(nullable = false)
    private UUID sellerId;  // 판매자 사용자 ID

    @Column(nullable = false)
    private UUID itemId;    // 거래되는 아이템 ID (외부 시스템에서 관리)

    @Column(nullable = false)
    private Integer amount; // 거래 금액 (원화 기준)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status; // 거래 상태 (PENDING, PAID, CONFIRMED, ... )

    @Column(nullable = false)
    private boolean disputed; // 분쟁 여부 (true: 분쟁 중, false: 정상)

    private LocalDateTime expiredAt; // 자동 확정 예정 시각 (구매자 미확정 시 시스템 자동 처리)

    @CreationTimestamp
    private LocalDateTime createdAt; // 생성 시각

    @UpdateTimestamp
    private LocalDateTime updatedAt; // 최종 수정 시각

    // private String platform;        // 거래 발생 플랫폼 ('PC', 'MOBILE')
    // private String itemType;        // 아이템 유형 ('GOLD', 'ACCOUNT')
    // private String memo;            // 거래 메모 또는 설명
}