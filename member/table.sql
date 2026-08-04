-- table.sql 저장
-- 테이블 생성
-- 컬럼, 레코드(행의 저장 단위)
-- AUTO_INCREMENT: 값을 넣었을 때 자동으로 카운팅(int)
-- NOT NULL: 빈 값을 허용하지 않음
-- UNIQUE: 중복값 허용 불가
-- PRIMARY KEY: 중복을 허용하지 않고, index가 만들어짐.
CREATE TABLE tblMember(
	num INT AUTO_INCREMENT PRIMARY KEY, 
	name CHAR(20) NOT NULL,
	phone CHAR(20) UNIQUE NOT NULL,
	address CHAR(70) NOT NULL,
	team CHAR(20) NOT NULL
);

-- 입력
INSERT tblmember(NAME, phone, address, team)
VALUES ('홍길동', '010-5555-8888', '서울시 강남구', '산적');

INSERT tblmember
VALUES (NULL, '소지섭', '010-7777-8888', '서울시 강남구', '김부장'); -- AUTO_INCREMENT를 해놨기때문에 null을 넣어줘야한다.

/*
SELECT * FROM tblmember;

-- 필요한 컬럼 리턴
SELECT num, NAME, phone FROM tblmember;

-- 조건에 맞는 레코드(행) 가져오기
-- 실행순서 from -> select  -> where
SELECT *
FROM tblmember
WHERE team = 'BTS';

SELECT NAME, team
FROM tblmember
WHERE NAME = '홍길동' or team = 'BTS';

-- 수정
UPDATE tblmember SET NAME = '홍길순', team = 'MC'
WHERE NAME = '홍길동';

-- 삭제
DELETE FROM tblmember  
WHERE num = 3;

-- 데이터 전부 삭제(스키마는 유지)
TRUNCATE TABLE tblmember

-- 테이블 제거Q
DROP TABLE tblmember
*/
