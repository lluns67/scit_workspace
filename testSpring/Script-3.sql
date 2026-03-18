-- 테스트



CREATE DATABASE test;
COMMIT;
USE test;


-- 1) 시험 문제의 정답을 저장한 테이블
CREATE TABLE exam_answers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  question_no INT NOT NULL UNIQUE,
  correct_answer VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2) 시험에 응시한 학생의 개인 정보와 답안을 저장할 테이블
CREATE TABLE student_responses (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  -- 각 문항의 답: Q1~Q5 (필수 입력)
  answer1 VARCHAR(255) NOT NULL,
  answer2 VARCHAR(255) NOT NULL,
  answer3 VARCHAR(255) NOT NULL,
  answer4 VARCHAR(255) NOT NULL,
  answer5 VARCHAR(255) NOT NULL,
  score INT DEFAULT 0,
  submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3) 정답 테이블에 저장할 정답 데이터 입력 insert 구문

INSERT INTO exam_answers (question_no, correct_answer) VALUES
(1, '2'),
(2, '3'),
(3, '3'),
(4, 'extends'),
(5, 'try');


-- 4) 학생 응시 정보 테이블에 저장할 테스트용 데이터 5개 입력 insert 구문
DROP TABLE student_responses;
-- 1. 홍길동: 100점 (모든 정답 일치)
INSERT INTO student_responses 
(name, email, password, answer1, answer2, answer3, answer4, answer5, score, submitted_at)
VALUES 
('홍길동', 'hong@test.com', '1234', '2', '3', '1', 'extends', 'try', 100, '2025-12-21 11:00:00');

-- 2. 김영희: 80점 (5번 오답: catch)
INSERT INTO student_responses 
(name, email, password, answer1, answer2, answer3, answer4, answer5, score, submitted_at)
VALUES 
('김영희', 'kim@test.com', '1234', '2', '3', '1', 'extends', 'catch', 80, '2025-12-21 17:00:51');

-- 3. 이철수: 60점 (1번 오답: 1, 5번 오답: finally)
INSERT INTO student_responses 
(name, email, password, answer1, answer2, answer3, answer4, answer5, score, submitted_at)
VALUES 
('이철수', 'lee@test.com', '1234', '1', '3', '1', 'extends', 'finally', 60, '2025-12-22 17:00:40');

-- 4. 추가 샘플 데이터 1 (40점)
INSERT INTO student_responses 
(name, email, password, answer1, answer2, answer3, answer4, answer5, score, submitted_at)
VALUES 
('박철수', 'park@test.com', '1234', '1', '1', '1', 'extends', 'throw', 40, '2025-12-23 09:30:15');

-- 5. 추가 샘플 데이터 2 (20점)
INSERT INTO student_responses 
(name, email, password, answer1, answer2, answer3, answer4, answer5, score, submitted_at)
VALUES 
('최유리', 'choi@test.com', '1234', '1', '1', '2', 'implements', 'try', 20, '2025-12-24 14:20:00');
COMMIT;





