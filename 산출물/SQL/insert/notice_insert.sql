-- [notice]
--일반글
insert into notice values(NOTICE_NOTICE_NO_SEQ.nextval, '흙당근마켓 이벤트', '오픈기념 10% 자동 할인 이벤트', sysdate,0,0);
insert into notice values(NOTICE_NOTICE_NO_SEQ.nextval, '포인트 10%추가 지급 이벤트', '오픈기념 10% 자동 할인 이벤트', sysdate,0,0);
insert into notice values(NOTICE_NOTICE_NO_SEQ.nextval, '흙당근마켓 홈페이지 서버점검 안내', '오픈기념 10% 자동 할인 이벤트', sysdate,0,0);
insert into notice values(NOTICE_NOTICE_NO_SEQ.nextval, '흙당근마켓 긴급 서버점검 안내', '긴급 서버 점검', sysdate,0,0);


--고정글
insert into notice values(NOTICE_NOTICE_NO_SEQ.nextval, '고정 공지 제목', '고정 내용 입니다',sysdate,0,1);
insert into notice values(NOTICE_NOTICE_NO_SEQ.nextval, '중요한 공지 내용!', '중요한 내용 입니다',sysdate,0,1);
insert into notice values(NOTICE_NOTICE_NO_SEQ.nextval, '꼭 보세요!!', '완전 중요', sysdate,0,1);



select * from notice;

desc notice;
