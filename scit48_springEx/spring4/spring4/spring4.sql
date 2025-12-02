create table guestbook(
    -- 글 번호, 기본키, 자동증가
    num     integer     auto_increment      primary key,
    -- 이름, 문자열, 100문자
    name    varchar(100)                    not null,
    -- 비밀번호, 문자열, 100문자
    password  varchar(100)                  not null,
    -- 본문내용, 문자열.
    message text                            not null,
    -- 시간, 현재시간 자동 저장
    inputdate   timestamp                   default current_timestamp
    
);