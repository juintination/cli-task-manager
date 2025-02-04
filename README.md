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
- 각 작업은 작업의 상태를 의미하는 TaskState를 속성으로 가진다.
    - 진행중을 의미하는 Pending과 완료됨을 의미하는 Completed는 TaskState를 상속받는다.
    - 긴급하게 해야 함을 의미하는 Urgent는 Pending을 상속받는다.

### 클래스 다이어그램

![diagram](https://github.com/user-attachments/assets/619feb1c-cc13-4130-bed2-0eef9ceff4c9)

### 입출력 예시

- 사용자 이름 입력

```
Please enter your name: jay
```

- 작업 목록이 비어있는 경우

```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 1
There are no tasks to view.
```

- 작업 추가

```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 2
Enter the title of the task: Sample title
Enter the description of the task: Sample description
```

- 작업 상태(완료 여부) 변경


```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 3
Which task would you like to modify?
1. "Sample title - Sample description" is pending.
2. "Sample Title 2 - Sample Description 2" is pending.
3. "Sample Title 3 - Sample Description 3" is pending.
0. Go back
Enter the number of the task: 1
What would you like to do with the task?
1. Change status
2. Change priority
3. Change title
4. Change description
0. Go back
Enter the number: 1
```

- 작업 중요도 변경

```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 3
Which task would you like to modify?
1. "Sample title - Sample description" is completed.
2. "Sample Title 2 - Sample Description 2" is pending.
3. "Sample Title 3 - Sample Description 3" is pending.
0. Go back
Enter the number of the task: 2
What would you like to do with the task?
1. Change status
2. Change priority
3. Change title
4. Change description
0. Go back
Enter the number: 2
```

- 작업 제목 및 내용 변경

```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 3
Which task would you like to modify?
1. "Sample title - Sample description" is completed.
2. [URGENT] "Sample Title 2 - Sample Description 2" is pending.
3. "Sample Title 3 - Sample Description 3" is pending.
0. Go back
Enter the number of the task: 3
What would you like to do with the task?
1. Change status
2. Change priority
3. Change title
4. Change description
0. Go back
Enter the number: 3
Enter the title of the task: Modified Title

Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 3
Which task would you like to modify?
1. "Sample title - Sample description" is completed.
2. [URGENT] "Sample Title 2 - Sample Description 2" is pending.
3. "Modified Title - Sample Description 3" is pending.
0. Go back
Enter the number of the task: 3
What would you like to do with the task?
1. Change status
2. Change priority
3. Change title
4. Change description
0. Go back
Enter the number: 4
Enter the description of the task: Modified Description
```

- 모든 작업 목록 출력

```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 1
What would you like to do?
1. View every tasks
2. View pending tasks
3. View urgent tasks
4. View completed tasks
0. Go back
Enter the number: 1
Every tasks...
1. "Sample title - Sample description" is completed.
2. [URGENT] "Sample Title 2 - Sample Description 2" is pending.
3. "Modified Title - Modified Description" is pending.
```

- 진행중인 작업 목록 출력

```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 1
What would you like to do?
1. View every tasks
2. View pending tasks
3. View urgent tasks
4. View completed tasks
0. Go back
Enter the number: 2
Pending tasks...
2. [URGENT] "Sample Title 2 - Sample Description 2" is pending.
3. "Modified Title - Modified Description" is pending.
```

- 작업 삭제

```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 4
Which task would you like to remove?
1. "Sample title - Sample description" is completed.
2. [URGENT] "Sample Title 2 - Sample Description 2" is pending.
3. "Modified Title - Modified Description" is pending.
0. Go back
Enter the number of the task: 1
```

- 프로그램 종료

```
Hi, jay! Welcome to CLI Task Manager. What would you like to do?
1. View tasks
2. Add a task
3. Modify tasks
4. Remove a task
0. Exit
Enter the number: 0
Goodbye, jay!
```

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
