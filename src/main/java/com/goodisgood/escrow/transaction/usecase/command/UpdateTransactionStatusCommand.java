package com.goodisgood.escrow.transaction.usecase.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UpdateTransactionStatusCommand
 * - 거래 상태 변경 유스케이스에 전달되는 커맨드 객체
 */
@Getter
@AllArgsConstructor
public class UpdateTransactionStatusCommand {
    private final Long transactionId;
    private final String status;
    private final String changedBy;
    private final String memo;
}