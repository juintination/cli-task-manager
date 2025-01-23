### 1주차 과제 내용

CLI 프로그램 제작 (동기 프로그램)

- 콘솔 형태의 프로그램은 어떠한 종류라도 상관 없음
    - 예시 [링크](https://www.youtube.com/watch?v=EKy4m5FxhjE)
- 과제는 다음 순서대로 진행
    1. 프로그램 클래스 설계도(다이어그램) 작성
        1. 속성, 메서드, 상속의 관계를 먼저 정의
            - 예시 [링크](https://blog.kakaocdn.net/dn/KKHyA/btrb7uJR0y0/fCTJikYRHAQWhJP5yA3x00/img.png)
    2. 2차 상속은 최소 하나 이상
        - UML 프로그램 사용 금지, 손으로 그리세요!
          - 이유: 툴 학습법 익힐 시간 없음
          - 제출 방법: 사진을 찍어 제출
    3. 설계도 기반 콘솔 프로그램 제작
        - 사용자에게 입력을 받고 진행이 되는 형태

### 프로그램 설명

- CLI 기반의 간단한 작업 관리 프로그램
    - 사용자는 해야 할 작업을 등록하고 관리할 수 있다.
- 진행중인 작업 PendingTask와 완료된 작업 CompletedTask는 기본 작업 BasicTask를 상속받는다.
    - 긴급하게 해야 할 작업 UrgentTask는 PendingTask를 상속받는다.

### 클래스 다이어그램

![diagram](https://github.com/user-attachments/assets/aaf59b06-1e3e-4855-9435-fea35c04e2c0)

### 구현할 기능 목록

- 사용자 이름 입력
- 작업 목록 출력 기능
- 작업 추가 기능
- 작업 내용 수정 기능
    - 작업 완료 여부 변경
    - 작업 중요도(일반, 긴급) 변경
    - 작업 제목 변경
    - 작업 내용 변경
- 작업 삭제 기능

### 개발 환경

- IDE: IntelliJ
- 언어: JAVA21
