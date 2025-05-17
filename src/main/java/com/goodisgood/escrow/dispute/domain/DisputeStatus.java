package com.goodisgood.escrow.dispute.domain;

public enum DisputeStatus {
    OPEN,           // 사용자가 분쟁 제기한 상태
    UNDER_REVIEW,   // 운영자 또는 시스템이 처리 중
    RESOLVED        // 분쟁 처리 완료
}