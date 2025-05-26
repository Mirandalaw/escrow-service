package com.goodisgood.escrow.transaction.usecase;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import com.goodisgood.escrow.transaction.usecase.command.CreateTransactionCommand;

/**
 * CreateTransactionUsecase
 * - 거래 생성을 위한 유즈케이스 인터페이스
 */
public interface CreateTransactionUsecase {
    EscrowTransaction execute(CreateTransactionCommand command);
}