package com.goodisgood.escrow.transaction.service;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import com.goodisgood.escrow.transaction.repository.EscrowTransactionRepository;
import com.goodisgood.escrow.transaction.usecase.GetTransactionUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * GetTransactionService
 * - 거래 상세 조회 유즈케이스 구현체
 */
@Service
@RequiredArgsConstructor
public class GetTransactionService implements GetTransactionUsecase {

    private final EscrowTransactionRepository transactionRepository;

    @Override
    public EscrowTransaction getById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("거래가 존재하지 않습니다: id=" + id));
    }
}