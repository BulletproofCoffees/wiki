--위키회원-----------------------------------------------------------
 create table wikimember(
    Id VARCHAR2(20)NOT NULL,
    pwd VARCHAR2(20),--암호
    email VARCHAR2(40), --이메일
    Vandals CHAR(1)DEFAULT 'Y', --블랙리스트
    usetn CHAR(1)DEFAULT 'Y',-- 탈퇴여부
    indate DATE DEFAULT SYSDATE, --가입일
    CONSTRAINT PK_wikimember_no  PRIMARY KEY(Id)--기본키생성
    );

--위키문서-----------------------------------------------------------    
    create table wikidocument(
    wseq number(5) not null,
    kind varchar2(20), 
    title varchar2(100), --제목
    content clob,  --내용
    id varchar2(20), 
    image varchar2(100),
    indate date default sysdate,
    CONSTRAINT PK_wikidocument PRIMARY KEY(wseq), --기본키
    constraint fk_wikidocument foreign key(id) references wikimember(Id) --외래키
    );
--시퀀스객체
   CREATE SEQUENCE wikidocument_no INCREMENT BY 1 NOCACHE NOCYCLE;

--문서 텍스트테이블-------------------------------------------------
  CREATE TABLE wikidocumenttext(
   no number(5) NOT NULL,  --시퀀스번호
  nno number(5), --문서제목 번호
  content CLOB,  --내용
  indate DATE DEFAULT SYSDATE, --작성일
  CONSTRAINT PK_wikidocumenttext PRIMARY KEY(no), --기본키
  CONSTRAINT FK_wikidocumenttext_nno FOREIGN KEY(nno) REFERENCES wikidocument(wseq)--외래키
 );
  CREATE SEQUENCE wikidocument_text_no INCREMENT BY 1 NOCACHE NOCYCLE; --시퀀스
   
--관리자-------------------------------------------------------
CREATE TABLE wikiworker(
  Id VARCHAR2(20)NOT NULL,
  pwd VARCHAR2(20),--암호
  CONSTRAINT PK_wikiworker_ID PRIMARY KEY(Id)--기본키생성
 );

 --포럼 미완성 댓글기능 ㅠㅠ----------------------------------------------------------
 CREATE TABLE wikiforum(
  no number(5) NOT NULL,
  id VARCHAR2(20),
  title VARCHAR2(100),
  text VARCHAR2(1000),
 commen VARCHAR2(100),
  indate DATE DEFAULT SYSDATE, 
  CONSTRAINT PK_wikiforum PRIMARY KEY(NO), --기본키
  CONSTRAINT FK_wikiforum_id FOREIGN KEY(id) REFERENCES wikimember(id)--외래키
 );
  CREATE SEQUENCE wikiforum_no INCREMENT BY 1 NOCACHE NOCYCLE; --시퀀스

--포럼댓글----------------------------------
CREATE TABLE WIKICOMMEN(
  no number(5) NOT NULL, 
  nno number(5), 
  id VARCHAR2(20),
  title VARCHAR2(100),
  commen VARCHAR2(1000),
  indate DATE DEFAULT SYSDATE, 
  CONSTRAINT PK_WIKICOMMEN PRIMARY KEY(NO), --기본키
  CONSTRAINT FK_WIKICOMMEN_nno FOREIGN KEY(nno) REFERENCES wikiforum(no),--외래키
   CONSTRAINT FK_WIKICOMMEN_id FOREIGN KEY(id) REFERENCES wikimember(id)--외래키
 );
  CREATE SEQUENCE commen_seq INCREMENT BY 1 NOCACHE NOCYCLE; --시퀀스

--댓글뷰-------------------------------------------------------------------------
 create or replace view comment_view
    as
    select c.no, c.nno, c.id, f.id fid, f.title, f.text, c.commen, c.indate
    from wikicommen c, wikiforum f 
    where c.nno = f.no;
    commit;
 -- 코멘트 뷰 만들기
    create or replace view comment_view
    as
    select c.no, c.nno, c.id, f.id fid, f.title, f.text, c.commen, c.indate
    from wikicommen c, wikiforum f 
    where c.nno = f.no;
    commit;

 --공지사항-------------------------------------------------------------
 CREATE TABLE wikinotice(
  no number(5) NOT NULL,
  id VARCHAR2(20),
  title VARCHAR2(100),
  text VARCHAR2(1000),
  indate DATE DEFAULT SYSDATE, 
  CONSTRAINT PK_wikinotice PRIMARY KEY(no), --기본키
  CONSTRAINT FK_wikinotice_id FOREIGN KEY(id) REFERENCES wikiworker(id)--외래키
 );
 CREATE SEQUENCE wikinotice_no INCREMENT BY 1 NOCACHE NOCYCLE; --시퀀스

 
update wikidocument set kind=1, title=2, content=3, image=3 where wseq=58; 