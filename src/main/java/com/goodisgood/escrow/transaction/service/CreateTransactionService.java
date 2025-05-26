package com.goodisgood.escrow.transaction.service;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import com.goodisgood.escrow.transaction.repository.EscrowTransactionRepository;
import com.goodisgood.escrow.transaction.usecase.CreateTransactionUsecase;
import com.goodisgood.escrow.transaction.usecase.command.CreateTransactionCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * CreateTransactionService
 * - 거래 생성을 실제로 처리하는 유즈케이스 구현체
 */
@Service
@RequiredArgsConstructor
public class CreateTransactionService implements CreateTransactionUsecase {

    private final EscrowTransactionRepository transactionRepository;

    @Override
    public EscrowTransaction execute(CreateTransactionCommand command) {
        EscrowTransaction tx = new EscrowTransaction(
                command.getBuyerId(),
                command.getSellerId(),
                command.getItemId(),
                command.getAmount()
        );
        return transactionRepository.save(tx);
    }
}