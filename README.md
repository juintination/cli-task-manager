### 1주차 과제 내용

콘솔 환경에서 사용자에게 입력을 받고 진행이 되는 동기 프로그램 제작

- 클래스 다이어그램 작성
    - UML 프로그램을 사용하지 않고 수기로 작성

### 프로그램 설명

- CLI 기반의 간단한 작업 관리 프로그램
    - 사용자는 해야 할 작업을 등록하고 관리할 수 있다.
    - 사용자의 작업 목록은 `tasks/사용자 이름.txt` 에 저장된다.
      - 기존의 작업 목록이 존재한다면 프로그램 시작 시 불러온다.
- 각 작업은 작업의 상태를 의미하는 TaskState를 속성으로 가진다.
    - 진행중을 의미하는 Pending과 완료됨을 의미하는 Completed는 TaskState를 상속받는다.
    - 긴급하게 해야 함을 의미하는 Urgent는 Pending을 상속받는다.

### 클래스 다이어그램

![diagram](https://github.com/user-attachments/assets/1828aca6-52d0-47e4-8ea9-421c07732517)

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
- 작업 목록 파일 입출력 기능
  - 작업 목록 불러오기
  - 작업 추가 기능
  - 작업 내용 수정 및 삭제 기능

### 개발 환경

- IDE: IntelliJ
- 언어: JAVA21
