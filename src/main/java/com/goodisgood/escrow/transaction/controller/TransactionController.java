package com.goodisgood.escrow.transaction.controller;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import com.goodisgood.escrow.transaction.dto.EscrowTransactionCreateRequest;
import com.goodisgood.escrow.transaction.dto.EscrowTransactionResponse;
import com.goodisgood.escrow.transaction.dto.TransactionStatusUpdateRequest;
import com.goodisgood.escrow.transaction.usecase.CreateTransactionUsecase;
import com.goodisgood.escrow.transaction.usecase.FindTransactionUsecase;
import com.goodisgood.escrow.transaction.usecase.GetTransactionUsecase;
import com.goodisgood.escrow.transaction.usecase.UpdateTransactionStatusUsecase;
import com.goodisgood.escrow.transaction.usecase.command.UpdateTransactionStatusCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TransactionController
 * - 거래 생성 요청을 처리하는 REST 컨트롤러
 */
@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final CreateTransactionUsecase createTransactionUsecase;
    private final GetTransactionUsecase getTransactionUsecase;
    private final UpdateTransactionStatusUsecase updateTransactionStatusUsecase;
    private final FindTransactionUsecase findTransactionUsecase;

    @PostMapping
    public ResponseEntity<Long> createTransaction(@RequestBody @Valid EscrowTransactionCreateRequest request) {
        EscrowTransaction tx = createTransactionUsecase.execute(request.toCommand());
        return ResponseEntity.ok(tx.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscrowTransactionResponse> getTransaction(@PathVariable Long id) {
        EscrowTransaction tx = getTransactionUsecase.getById(id);
        return ResponseEntity.ok(EscrowTransactionResponse.from(tx));
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(
            @PathVariable Long id,
            @RequestBody @Valid TransactionStatusUpdateRequest request
    ) {
        updateTransactionStatusUsecase.execute(request.toCommand(id));
        return ResponseEntity.ok().build();
    }

}