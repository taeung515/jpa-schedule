-- user 테이블
CREATE TABLE user
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '회원 식별자',
    username    VARCHAR(4)   NOT NULL COMMENT '회원 이름',
    email       VARCHAR(100) NOT NULL UNIQUE COMMENT '회원 이메일',
    password    VARCHAR(255) NOT NULL COMMENT '회원 비밀번호',
    created_at  DATETIME COMMENT '회원 생성일',
    modified_at DATETIME COMMENT '회원정보 수정일'
);

-- schedule 테이블
CREATE TABLE schedule
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 식별자',
    title       VARCHAR(10) NOT NULL COMMENT '일정 제목',
    contents    LONGTEXT    NOT NULL COMMENT '일정 내용',
    created_at  DATETIME COMMENT '일정 생성일',
    modified_at DATETIME COMMENT '일정 수정일',
    user_id     BIGINT REFERENCES user (id)
);