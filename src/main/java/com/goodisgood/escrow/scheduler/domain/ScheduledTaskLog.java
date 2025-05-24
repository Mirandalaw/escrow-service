package com.goodisgood.escrow.scheduler.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * 시스템 자동 처리 작업(예: 자동 확정, 자동 정산 등)의 실행 결과 로그
 * 문제 발생 시 추적, 재처리, 모니터링에 사용됨
 */
@Entity
@Table(name = "scheduled_task_logs")
@Getter
@NoArgsConstructor
public class ScheduledTaskLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // BIGINT + Auto Increment
    private Long id;  // 로그 고유 ID

    @Column(nullable = false)
    private Long transactionId; // 대상 거래 ID (UUID → Long)

    @Column(nullable = false)
    private String taskType; // 작업 유형 (ex: CONFIRM_AUTO, SETTLE_AUTO, REFUND_AUTO)

    @Column(nullable = false)
    private String result; // SUCCESS | FAIL

    private String errorMessage; // 실패 시 에러 메시지

    @CreationTimestamp
    private LocalDateTime executedAt; // 작업 실행 시각
}
