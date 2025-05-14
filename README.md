# Escrow Service

**거래 보호를 위한 MSA 기반 Spring Boot 에스크로 서비스**

본 서비스는 아이템 중개 플랫폼을 위한 **에스크로 거래, 결제, 정산, 분쟁 처리** 기능을 담당합니다.  
Node.js 기반의 API Gateway를 통해 요청을 받아 독립적으로 작동하며, 상용 수준의 확장성과 안정성을 고려하여 설계되었습니다.

---

##  주요 기능

- 거래 생성 및 상태 흐름 관리 (PENDING → PAID → DELIVERED → CONFIRMED → SETTLED)
- 구매자 결제 및 PG사 트랜잭션 기록
- 정산 수수료 자동 계산 및 정산 이력 관리
- 자동 확정 및 정산 스케줄러
- 분쟁 등록 및 관리자 처리 흐름
- 상태 변경 로그 및 감사 이력 관리

---

##  기술 스택

| 영역         | 스택 |
|--------------|------|
| Language     | Java 17 |
| Framework    | Spring Boot 3.x, Spring Data JPA |
| Database     | PostgreSQL |
| Scheduler    | Spring Scheduler (`@Scheduled`) |
| Build Tool   | Gradle (Kotlin DSL) |
| Deploy       | Docker, Docker Compose |
| Messaging    | Kafka (선택 사항) |
| Infra 연동   | PG사, 정산 계좌 시스템 (REST or Webhook) |
| 기타         | Redis, Lombok, MapStruct, Swagger(OpenAPI) |

---

##  프로젝트 구조

```text
escrow-service/
├── src/
│   ├── main/java/com/escrow/
│   │   ├── transaction/   ← 거래 도메인
│   │   ├── settlement/    ← 정산 도메인
│   │   ├── payment/       ← 결제 도메인
│   │   ├── dispute/       ← 분쟁 도메인
│   │   ├── user/          ← 정산용 유저 계좌
│   │   ├── scheduler/     ← 자동 정산/확정 작업
│   │   ├── event/         ← Kafka 등 메시징 처리
│   │   ├── integration/   ← 외부 API 연동 (PG사, 알림)
│   │   ├── global/        ← 예외, 응답 공통 처리
│   │   └── config/        ← 설정 클래스
├── build.gradle.kts
├── Dockerfile
└── README.md
