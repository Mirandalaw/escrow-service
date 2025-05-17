package com.goodisgood.escrow.transaction.domain;

public enum TransactionStatus {
    PENDING,     // 거래 생성됨
    PAID,        // 결제 완료
    DELIVERED,   // 아이템 전달됨
    CONFIRMED,   // 구매자 확인
    SETTLED,     // 정산 완료
    REFUNDED,    // 환불됨
    DISPUTED     // 분쟁 중
}
