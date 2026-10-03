# msa4-my-db

Java JDBC로 MySQL의 사원 데이터를 조회하는 학습 프로젝트입니다. `Statement`와 `PreparedStatement`로 쿼리를 실행하고, `ResultSet`을 `EmployeeDTO` 목록으로 변환해 사원 번호와 이름을 출력합니다.

## 예제에서 비교하는 것

| 조회 메서드 | 동작 |
| --- | --- |
| `getEmployees(int limit)` | `Statement`로 고정 SQL을 실행하며 인자와 관계없이 `LIMIT 10` 사용 |
| `getEmployeesLimit(int limit)` | `PreparedStatement`의 `LIMIT ?`에 인자를 바인딩 |

[Main.java](src/main/java/org/example/Main.java)는 두 메서드를 각각 10과 2로 호출합니다. 현재 예제는 `SELECT` 조회를 수행하며 DB 데이터를 추가·변경·삭제하지 않습니다. 연결과 쿼리 자원은 try-with-resources로 정리합니다.

## 실행 준비

- IDE 프로젝트 설정은 JDK 17을 사용합니다.
- Gradle Wrapper는 9.3.0, MySQL Connector/J는 8.4.0을 사용합니다. Java toolchain은 빌드 파일에 고정돼 있지 않습니다.
- 접속 가능한 개인 실습용 MySQL DB와 사원 데이터가 필요합니다. 테이블 생성문과 초기 데이터는 저장소에 포함돼 있지 않습니다.

### DB 설정

[MyConnection.java](src/main/java/org/example/MyConnection.java)의 다음 상수를 개인 실습 DB에 맞게 변경합니다.

| 설정 이름 | 용도 |
| --- | --- |
| `DB_HOST`, `DB_PORT` | MySQL 서버 주소와 포트 |
| `DB_NAME` | 조회할 데이터베이스 이름 |
| `DB_USER`, `DB_PW` | DB 접속 계정과 비밀번호 |

현재 코드는 상수로 접속 정보를 읽으며 환경변수 설정을 지원하지 않습니다. 개인 접속값을 공유 저장소에 올리지 마세요.

[EmployeeRepository.java](src/main/java/org/example/EmployeeRepository.java)는 `employees` 테이블의 `emp_id`, `name`, `birth`, `gender`, `hire_at`, `fire_at`, `sup_id`, `created_at`, `updated_at`, `deleted_at` 컬럼을 읽습니다. 테이블과 컬럼이 준비돼 있는지 먼저 확인하세요.

### 실행

1. IntelliJ IDEA 등에서 저장소를 Gradle 프로젝트로 엽니다.
2. Gradle 의존성을 반영합니다. 최초 사용 시 Gradle과 의존성을 다운로드할 수 있습니다.
3. DB 설정을 마친 뒤 Gradle 의존성이 포함된 실행 설정으로 `org.example.Main`을 실행합니다.
4. 두 조회 결과의 출력 개수와 쿼리 작성 방식을 비교합니다.

컴파일만 확인하려면 저장소 루트의 Windows PowerShell에서 다음 명령을 사용합니다.

```powershell
.\gradlew.bat classes
```

macOS·Linux에서는 `./gradlew classes`를 사용합니다. `application` 플러그인이 없으므로 `gradlew run` 작업은 정의돼 있지 않습니다.

## 소스 읽기

| 파일 | 역할 |
| --- | --- |
| [Main.java](src/main/java/org/example/Main.java) | 조회 메서드 호출과 출력 |
| [MyConnection.java](src/main/java/org/example/MyConnection.java) | 접속 설정과 JDBC 연결 생성 |
| [EmployeeRepository.java](src/main/java/org/example/EmployeeRepository.java) | 쿼리 실행과 `ResultSet`의 DTO 변환 |
| [EmployeeDTO.java](src/main/java/org/example/EmployeeDTO.java) | 사원 정보 필드와 접근 메서드 |
| [build.gradle](build.gradle) | 빌드와 JDBC 드라이버 의존성 |
