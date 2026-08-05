-- 테이블 생성
-- 컬럼, 레코드(행의 저장 단위)
-- AUTO_INCREMENT: 자동증가
-- NOT NULL: 빈 값을 허용하지 않음
-- UNIQUE: 중복값 허용 불가
-- PRIMARY KEY: 중복을 허용하지 않고 index(색인) 만들어짐.

CREATE TABLE tblMember(
	num INT AUTO_INCREMENT PRIMARY KEY,
	name CHAR(20) NOT NULL,
	phone CHAR(20) UNIQUE NOT NULL,
	address CHAR(70) NOT NULL,
	team CHAR(20) NOT NULL
);


CREATE TABLE tblZipcode(
 zipcode CHAR(5) NOT NULL,
 area1 CHAR(20) NOT NULL,
 area2 CHAR(30) NOT NULL,
 area3 CHAR(50) NOT NULL 
);

--입력
INSERT tblmember(NAME, phone, address, team)
VALUES ('홍길동', '010-5555-8888', '서울시 강남구', '산적');

INSERT tblmember --테이블 만들때 순서
VALUES (null,'소지섭','010-7777-8888','서울시 강남구','김부장');

--가져오기: * 모든 컬럼(테이블 만들때 순서대로 가져옴)
SELECT * FROM tblmember;

--필요한 컬럼 리턴
SELECT num, NAME, phone FROM tblmember;

--조건에 맞는 레코드(행) 가져오기
SELECT *
FROM tblMember
WHERE team = 'bts';

SELECT NAME, team
FROM tblmember 
WHERE NAME = '홍길동' OR team = 'BTS'; 

--수정
UPDATE tblmember SET NAME = '홍길순' ,team = 'MC' 
WHERE NAME = '홍길동';

--삭제
DELETE FROM tblMember
WHERE num = 3; 

--데이터 전부 삭제(스키마:schema 유지)
TRUNCATE TABLE tblmember;

--테이블 제거
DROP TABLE tblmember;

SELECT * FROM tblmember;