# Spring Boot MVC 게시판

Spring Boot + MyBatis + Thymeleaf + MySQL로 만든 게시판입니다.

## 기능
- 게시글 등록 / 목록 / 조회(조회수 증가) / 수정 / 삭제
- 목록 페이징 (한 페이지 10건)

## 구조
| 계층 | 파일 |
| --- | --- |
| Controller | `controller/PostController.java` |
| Service | `service/PostService.java`, `service/PostServiceImpl.java` |
| Mapper | `mapper/PostMapper.java`, `resources/mapper/PostMapper.xml` |
| DTO | `dto/Post.java`, `dto/Page.java` |
| View | `templates/index.html`, `templates/Post/*.html` |

## 테이블
```sql
CREATE TABLE post (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(200) NOT NULL,
    content     TEXT         NOT NULL,
    writer      VARCHAR(50)  NOT NULL,
    view_count  INT          NOT NULL DEFAULT 0,
    created_at  DATETIME     NOT NULL,
    updated_at  DATETIME     NOT NULL
);
```

## 실행
DB 비밀번호는 환경변수로 넣습니다.
```bash
DB_PASSWORD=비밀번호 ./gradlew bootRun
```
접속: http://localhost:8080
