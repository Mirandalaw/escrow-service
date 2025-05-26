package com.goodisgood.escrow.transaction.controller;

import com.goodisgood.escrow.transaction.domain.EscrowTransaction;
import com.goodisgood.escrow.transaction.dto.EscrowTransactionCreateRequest;
import com.goodisgood.escrow.transaction.dto.EscrowTransactionResponse;
import com.goodisgood.escrow.transaction.usecase.CreateTransactionUsecase;
import com.goodisgood.escrow.transaction.usecase.GetTransactionUsecase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}