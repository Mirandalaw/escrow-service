package com.goodisgood.escrow.transaction.repository;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EscrowTransactionRepository
 * - 거래 정보를 저장하는 JPA Repository
 */
public interface EscrowTransactionRepository extends JpaRepository<EscrowTransaction, Long> {
}