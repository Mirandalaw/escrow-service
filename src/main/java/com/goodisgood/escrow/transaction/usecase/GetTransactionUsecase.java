package com.goodisgood.escrow.transaction.usecase;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;

/**
 * GetTransactionUsecase
 * - 거래 상세 조회 유즈케이스
 */
public interface GetTransactionUsecase {
    EscrowTransaction getById(Long id);
}