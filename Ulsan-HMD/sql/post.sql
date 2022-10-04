-------
--게시판
-------
create table post(
    bbs_id      number(10),         --게시글 번호
    bcategory   varchar2(11),       --분류카테고리
    title       varchar2(150),      --제목
    email       varchar2(50),       --email
    nickname    varchar2(30),       --별칭
    hit         number(5) default 0,          --조회수
    bcontent    clob,               --본문
    pbbs_id     number(10),         --부모 게시글번호
    bgroup      number(10),         --답글그룹
    step        number(3) default 0,          --답글단계
    bindent     number(3) default 0,          --답글들여쓰기
    status      char(1),               --답글상태  (삭제: 'D', 임시저장: 'I')
    cdate       timestamp default systimestamp,         --생성일시
    udate       timestamp default systimestamp          --수정일시
);

--기본키
alter table post add Constraint post_post_id_pk primary key (post_id);

--외래키
alter table post add constraint post_bcategory_fk
    foreign key(bcategory) references code(code_id);
alter table post add constraint post_ppost_id_fk
    foreign key(ppost_id) references post(post_id);
alter table post add constraint post_email_fk
    foreign key(email) references member(email);

--제약조건
alter table post modify bcategory constraint post_bcategory_nn not null;
alter table post modify title constraint post_title_nn not null;
alter table post modify email constraint post_email_nn not null;
alter table post modify nickname constraint post_nickname_nn not null;
alter table post modify bcontent constraint post_bcontent_nn not null;

--시퀀스
create sequence post_post_id_seq;
