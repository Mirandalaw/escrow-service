package com.goodisgood.escrow.transaction.service;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import com.goodisgood.escrow.transaction.domain.TransactionStatus;
import com.goodisgood.escrow.transaction.repository.EscrowTransactionRepository;
import com.goodisgood.escrow.transaction.usecase.UpdateTransactionStatusUsecase;
import com.goodisgood.escrow.transaction.usecase.command.UpdateTransactionStatusCommand;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * UpdateTransactionStatusService
 * - 거래 상태 변경 유즈케이스 구현체
 * - 유효한 상태 전이만 허용하며, 변경 주체에 따른 권한도 검증
 */
@Service
@RequiredArgsConstructor
public class UpdateTransactionStatusService implements UpdateTransactionStatusUsecase {

    private final EscrowTransactionRepository transactionRepository;

    @Override
    @Transactional
    public void execute(UpdateTransactionStatusCommand command) {
        EscrowTransaction tx = transactionRepository.findById(command.getTransactionId())
                .orElseThrow(() -> new NoSuchElementException("거래를 찾을 수 없습니다: id=" + command.getTransactionId()));

        TransactionStatus current = tx.getStatus();
        TransactionStatus target = TransactionStatus.valueOf(command.getStatus());

        // 상태 전이 유효성 검사
        validateStatusTransition(current, target);

        // 변경 주체 권한 검증
        checkPermission(command.getChangedBy(), target);

        // 상태 변경
        tx.setStatus(target);
        tx.setUpdatedAtNow();

        // 저장
        transactionRepository.save(tx);
    }

    /**
     * 상태 전이 유효성 검사
     * 허용되지 않은 상태 전이는 예외 발생
     */
    private void validateStatusTransition(TransactionStatus current, TransactionStatus target) {
        // 예시: PENDING → PAID / PAID → DELIVERED / DELIVERED → CONFIRMED 만 허용
        if (current == TransactionStatus.PENDING && target == TransactionStatus.PAID) return;
        if (current == TransactionStatus.PAID && target == TransactionStatus.DELIVERED) return;
        if (current == TransactionStatus.DELIVERED && target == TransactionStatus.CONFIRMED) return;
        if (current == TransactionStatus.CONFIRMED && target == TransactionStatus.SETTLED) return;
        if (target == TransactionStatus.DISPUTED) return;
        if (target == TransactionStatus.REFUNDED) return;

        throw new IllegalStateException("허용되지 않은 상태 전이입니다: " + current + " → " + target);
    }

    /**
     * 상태 변경 주체(changedBy)의 권한 검증
     */
    private void checkPermission(String changedBy, TransactionStatus target) {
        if (changedBy.equalsIgnoreCase("buyer") && (target == TransactionStatus.CONFIRMED || target == TransactionStatus.DISPUTED))
            return;
        if (changedBy.equalsIgnoreCase("seller") && (target == TransactionStatus.DELIVERED || target == TransactionStatus.DISPUTED))
            return;
        if (changedBy.equalsIgnoreCase("system")) return;

        throw new IllegalArgumentException("해당 사용자는 상태 [" + target + "]로 변경할 권한이 없습니다.");
    }
}