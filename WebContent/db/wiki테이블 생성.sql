--��Űȸ��-----------------------------------------------------------
 create table wikimember(
    Id VARCHAR2(20)NOT NULL,
    pwd VARCHAR2(20),--��ȣ
    email VARCHAR2(40), --�̸���
    Vandals CHAR(1)DEFAULT 'Y', --������Ʈ
    usetn CHAR(1)DEFAULT 'Y',-- Ż�𿩺�
    indate DATE DEFAULT SYSDATE, --������
    CONSTRAINT PK_wikimember_no  PRIMARY KEY(Id)--�⺻Ű����
    );

--��Ű����-----------------------------------------------------------    
    create table wikidocument(
    wseq number(5) not null,
    kind varchar2(20), 
    title varchar2(100), --����
    content clob,  --����
    id varchar2(20), 
    image varchar2(100),
    indate date default sysdate,
    CONSTRAINT PK_wikidocument PRIMARY KEY(wseq), --�⺻Ű
    constraint fk_wikidocument foreign key(id) references wikimember(Id) --�ܷ�Ű
    );
--��������ü
   CREATE SEQUENCE wikidocument_no INCREMENT BY 1 NOCACHE NOCYCLE;

--���� �ؽ�Ʈ���̺�-------------------------------------------------
  CREATE TABLE wikidocumenttext(
   no number(5) NOT NULL,  --��������ȣ
  nno number(5), --�������� ��ȣ
  content CLOB,  --����
  indate DATE DEFAULT SYSDATE, --�ۼ���
  CONSTRAINT PK_wikidocumenttext PRIMARY KEY(no), --�⺻Ű
  CONSTRAINT FK_wikidocumenttext_nno FOREIGN KEY(nno) REFERENCES wikidocument(wseq)--�ܷ�Ű
 );
  CREATE SEQUENCE wikidocument_text_no INCREMENT BY 1 NOCACHE NOCYCLE; --������
   
--������-------------------------------------------------------
CREATE TABLE wikiworker(
  Id VARCHAR2(20)NOT NULL,
  pwd VARCHAR2(20),--��ȣ
  CONSTRAINT PK_wikiworker_ID PRIMARY KEY(Id)--�⺻Ű����
 );

 --���� �̿ϼ� ��۱�� �Ф�----------------------------------------------------------
 CREATE TABLE wikiforum(
  no number(5) NOT NULL,
  id VARCHAR2(20),
  title VARCHAR2(100),
  text VARCHAR2(1000),
 commen VARCHAR2(100),
  indate DATE DEFAULT SYSDATE, 
  CONSTRAINT PK_wikiforum PRIMARY KEY(NO), --�⺻Ű
  CONSTRAINT FK_wikiforum_id FOREIGN KEY(id) REFERENCES wikimember(id)--�ܷ�Ű
 );
  CREATE SEQUENCE wikiforum_no INCREMENT BY 1 NOCACHE NOCYCLE; --������

--�������----------------------------------
CREATE TABLE WIKICOMMEN(
  no number(5) NOT NULL, 
  nno number(5), 
  id VARCHAR2(20),
  title VARCHAR2(100),
  commen VARCHAR2(1000),
  indate DATE DEFAULT SYSDATE, 
  CONSTRAINT PK_WIKICOMMEN PRIMARY KEY(NO), --�⺻Ű
  CONSTRAINT FK_WIKICOMMEN_nno FOREIGN KEY(nno) REFERENCES wikiforum(no),--�ܷ�Ű
   CONSTRAINT FK_WIKICOMMEN_id FOREIGN KEY(id) REFERENCES wikimember(id)--�ܷ�Ű
 );
  CREATE SEQUENCE commen_seq INCREMENT BY 1 NOCACHE NOCYCLE; --������

--��ۺ�-------------------------------------------------------------------------
 create or replace view comment_view
    as
    select c.no, c.nno, c.id, f.id fid, f.title, f.text, c.commen, c.indate
    from wikicommen c, wikiforum f 
    where c.nno = f.no;
    commit;
 -- �ڸ�Ʈ �� �����
    create or replace view comment_view
    as
    select c.no, c.nno, c.id, f.id fid, f.title, f.text, c.commen, c.indate
    from wikicommen c, wikiforum f 
    where c.nno = f.no;
    commit;

 --��������-------------------------------------------------------------
 CREATE TABLE wikinotice(
  no number(5) NOT NULL,
  id VARCHAR2(20),
  title VARCHAR2(100),
  text VARCHAR2(1000),
  indate DATE DEFAULT SYSDATE, 
  CONSTRAINT PK_wikinotice PRIMARY KEY(no), --�⺻Ű
  CONSTRAINT FK_wikinotice_id FOREIGN KEY(id) REFERENCES wikiworker(id)--�ܷ�Ű
 );
 CREATE SEQUENCE wikinotice_no INCREMENT BY 1 NOCACHE NOCYCLE; --������

 
update wikidocument set kind=1, title=2, content=3, image=3 where wseq=58; 