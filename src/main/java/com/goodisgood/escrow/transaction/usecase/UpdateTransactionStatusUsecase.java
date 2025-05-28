package com.goodisgood.escrow.transaction.usecase;

import com.goodisgood.escrow.transaction.usecase.command.UpdateTransactionStatusCommand;

/**
 * UpdateTransactionStatusUsecase
 * - 거래 상태 변경 유스케이스 인터페이스
 * - Command 객체 기반 실행 메서드
 */
public interface UpdateTransactionStatusUsecase {
    void execute(UpdateTransactionStatusCommand command);
}
