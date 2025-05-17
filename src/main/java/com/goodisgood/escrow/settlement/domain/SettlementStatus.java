package com.goodisgood.escrow.settlement.domain;

public enum SettlementStatus {
    READY,      // 정산 준비됨
    COMPLETED,  // 정산 완료됨
    FAILED      // 정산 실패 (예: 송금 실패)
}