/* [userinfo] **************************************************/
desc userinfo;
/*
이름             널?       유형            
-------------- -------- ------------- 
USER_ID        NOT NULL VARCHAR2(10)  
USER_PW                 VARCHAR2(10)  
USER_NAME               VARCHAR2(50)  
USER_EMAIL              VARCHAR2(100) 
USER_PHONE              VARCHAR2(15)  
USER_FRESHNESS          NUMBER(10,1)    
USER_POINT              NUMBER(10)    
USER_PROFILE            VARCHAR2(200) 
*/

SELECT
    *
FROM
    userinfo;

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'carrot1',
    '1111',
    '김당근',
    'carrot1@brown.com',
    '010-1111-1111',
    36.5,
    0,
    NULL
);

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'carrot2',
    '2222',
    '이당근',
    'carrot2@brown.com',
    '010-2222-2222',
    36.5,
    0,
    NULL
);

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'carrot3',
    '3333',
    '박당근',
    'carrot3@brown.com',
    '010-3333-3333',
    36.5,
    0,
    NULL
);

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'carrot4',
    '4444',
    '정당근',
    'carrot4@brown.com',
    '010-4444-4444',
    36.5,
    0,
    NULL
);

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'carrot5',
    '5555',
    '최당근',
    'carrot5@brown.com',
    '010-5555-5555',
    36.5,
    0,
    NULL
);

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'carrot6',
    '6666',
    '임당근',
    'carrot6@brown.com',
    '010-6666-6666',
    36.5,
    0,
    NULL
);

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'carrot7',
    '7777',
    '이당근',
    'carrot7@brown.com',
    '010-7777-7777',
    36.5,
    0,
    NULL
);

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'carrot8',
    '8888',
    '한당근',
    'carrot8@brown.com',
    '010-8888-8888',
    36.5,
    0,
    NULL
);

INSERT INTO userinfo (
    user_id,
    user_pw,
    user_name,
    user_email,
    user_phone,
    user_freshness,
    user_point,
    user_profile
) VALUES (
    'admin',
    '1111',
    '흙당근관리자',
    'admin@brown.com',
    '010-1234-5678',
    36.5,
    0,
    NULL
);    

/* [address] **************************************************/
desc address;
/*
이름             널?       유형            
-------------- -------- ------------- 
ADDRESS_NO     NOT NULL NUMBER(30)    
ADDRESS_NAME            VARCHAR2(100) 
ADDRESS_COORDS          NUMBER(20)    
ADDRESS_RANGE           NUMBER(20)    
USER_ID                 VARCHAR2(30)   
*/
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 개포동', null,3,'carrot1');
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 논현동', null,5,'carrot1');

insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 대치동',null,2,'carrot2');
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 도곡동',null,4,'carrot2');

insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 삼성동',null,2,'carrot3');
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 세곡동',null,3,'carrot3');

insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 수서동',null,3,'carrot4');
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 역삼동',null,4,'carrot4');

insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 자곡동',null,3,'carrot5');
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 강남구 청담동',null,5,'carrot5');

insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 서초구 반포동',null,3,'carrot6');
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 서초구 방배동',null,5,'carrot6');

insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 서초구 서초동',null,3,'carrot7');
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 서초구 양재동',null,3,'carrot7');

insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 서초구 우면동',null,3,'carrot8');
insert into address(address_no, address_name, address_coords, address_range,user_id)
values(address_address_no_seq.nextval, '서울특별시 서초구 잠원동',null,5,'carrot8');

/* [invitation] **************************************************/
desc invitation;
select * from invitation;
/*
이름         널?       유형            
---------- -------- ------------- 
INVI_NO    NOT NULL NUMBER(10)    
INVI_EMAIL          VARCHAR2(100) 
USER_ID             VARCHAR2(10) 
*/
insert into invitation(invi_no,invi_email,user_id) values(INVITATION_INVI_NO_SEQ.nextval,'invi1@test.com','carrot1');
insert into invitation(invi_no,invi_email,user_id) values(INVITATION_INVI_NO_SEQ.nextval,'invi2@test.com','carrot1');
insert into invitation(invi_no,invi_email,user_id) values(INVITATION_INVI_NO_SEQ.nextval,'invi3@test.com','carrot1');
insert into invitation(invi_no,invi_email,user_id) values(INVITATION_INVI_NO_SEQ.nextval,'invi4@test.com','carrot2');
insert into invitation(invi_no,invi_email,user_id) values(INVITATION_INVI_NO_SEQ.nextval,'invi5@test.com','carrot2');
insert into invitation(invi_no,invi_email,user_id) values(INVITATION_INVI_NO_SEQ.nextval,'invi6@test.com','carrot2');
insert into invitation(invi_no,invi_email,user_id) values(INVITATION_INVI_NO_SEQ.nextval,'invi7@test.com','carrot3');
insert into invitation(invi_no,invi_email,user_id) values(INVITATION_INVI_NO_SEQ.nextval,'invi8@test.com','carrot3');

/* [p_category] ******************/
desc p_category;
/*
이름          널?       유형           
----------- -------- ------------ 
P_CTGR_NO   NOT NULL NUMBER(10)   
P_CTGR_NAME          VARCHAR2(50) 
*/

insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '디지털기기');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '생활가전');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '가구/인테리어');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '생활/주방');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '유아동');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '유아도서');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '여성의류');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '여성잡화');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '남성패션/잡화');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '뷰티/미용');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '스포츠레저');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '취미/게임/음반');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '도서');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '티켓/교환권');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '가공식품');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '반려동물용품');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '식물');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '기타 중고물품');
insert into p_category(p_ctgr_no, p_ctgr_name) values(p_category_p_ctgr_no_SEQ.nextval, '삽니다');

/* [town_category] ******************/
desc town_category;

/*
이름          널?       유형           
----------- -------- ------------ 
T_CTGR_NO   NOT NULL NUMBER(10)   
T_CTGR_NAME          VARCHAR2(10) 
*/

insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '동네소식');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '같이해요');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '동네질문');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '동네맛집');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '취미생활');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '일상');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '분실/실종센터');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '동네사건사고');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '해주세요');
insert into town_category(t_ctgr_no, t_ctgr_name) values(town_category_t_ctgr_no_SEQ.nextval, '동네사진전');

/* [product] & [product_img]**************************************************/
desc product;
desc product_img;
select * from product;
select * from product_img;

/*
이름         널?       유형            
---------- -------- ------------- 
P_NO       NOT NULL NUMBER(20)    
P_TITLE             VARCHAR2(500) 
P_DESC              VARCHAR2(500) 
P_PRICE             NUMBER(20)    
P_DATE              DATE          
P_SELL              NUMBER(10)    
P_COUNT             NUMBER(10)    
P_WISH              NUMBER(10)    
P_ADDRESS_NAME      VARCHAR2(100)
P_ADDRESS_COORDS    NUMBER(20)
P_CTGR_NO           NUMBER(10)
USER_ID             VARCHAR2(30)
*/
/*
insert into product values(PRODUCT_P_NO_SEQ.nextval, '양심을 팝니다', '양심 팝니다.', 10000000, sysdate, null, 123, 10, null ,null);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '개구리 팝니다', '개구리 팝니다.', 43250, sysdate, null, 456, 52, null ,null);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '프라다백 팝니다', '프라다백 팝니다.', 8000000, sysdate, null, 789, 102, null ,null);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '얼굴을 팝니다', '얼굴 팝니다.', 32400000, sysdate, null, 0, 167, null ,null);

insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, '양심.jpg', '1');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, '개구리.jpg', '2');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, '프라다백.jpg', '3');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, '얼굴.jpg', '4');
*/

insert into product values(PRODUCT_P_NO_SEQ.nextval, '(미개봉)키보드', '선물받았는데 필요없어져서 팝니다. 직거래환영', 20000, sysdate-30, null, 10, 5, '역삼동', null, 1,'carrot1');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'keyboard1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'keyboard2.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot6');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '(미개봉)마우스', '선물받았는데 필요없어져서 팝니다. 직거래환영', 30000, sysdate-30, null, 10, 5,'역삼동',null, 1,'carrot2');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'mouse1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'mouse2.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot6');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '최신형 청소기', '선물받았는데 필요없어져서 팝니다. 직거래환영', 30000, sysdate-30, null, 10, 5,'서초동',null,2,'carrot3');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'vacuum1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'vacuum2.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot4');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '전자레인지 팝니다', '선물받았는데 필요없어져서 팝니다. 직거래환영', 30000, sysdate-30, null, 10, 5,'서초동',null,2,'carrot3');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'microwave.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot1');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '푹신한 의자', '앉으면 일어날 수 없어요', 30000, sysdate-30, null, 10, 5,'서초동',null,2,'carrot4');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'chair.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot2');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '어린이용 책상', '아이가 커져서 팝니다.', 30000, sysdate-30, null, 10, 5,'논현동',null,2,'carrot4');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'desk.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot5');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '라면냄비', '2번사용했습니다.', 30000, sysdate-30, null, 10, 5,'논현동',null,3,'carrot4');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'pot.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot7');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '후라이팬', '계란후라이에 딱입니다.', 30000, sysdate-30, null, 10, 5,'도곡동',null,3,'carrot5');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'pan.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot7');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '딸랑이 세트', '깔끔하게 소독했어요', 30000, sysdate-30, null, 10, 5,'도곡동',null,4,'carrot5');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'toy1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'toy2.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot8');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '신생아 양말', '미착용했습니다.', 30000, sysdate-30, null, 10, 5,'삼성동',null,4,'carrot6');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'toddler_socks1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'toddler_socks2.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot4');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '동화책3권팝니다', '낱권 구매가능합니다.', 30000, sysdate-30, null, 10, 5,'삼성동',null,5,'carrot7');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'book1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'book2.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot3');

insert into product values(PRODUCT_P_NO_SEQ.nextval, '가나다 한글책', '깨끗합니다.', 30000, sysdate-30, null, 10, 5,'수서동',null,5,'carrot8');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'book3.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'book4.jpg', PRODUCT_P_NO_SEQ.currval);
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,PRODUCT_P_NO_SEQ.currval,'carrot1');








--#### <<join>> product - product_img - address(user_id,판매자)
/*
select * from product p
join product_img pi
on p.p_no=pi.p_no
join address a
on p.address_no=a.address_no;
*/



/* [wishlist] **************************************************/
desc wishlist;
/*
이름          널?       유형           
----------- -------- ------------ 
WISHLIST_NO NOT NULL NUMBER(10)   
P_NO                 NUMBER(20)   
USER_ID              VARCHAR2(10) 
*/
select * from wishlist;

/*
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,1,'carrot6');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,1,'carrot7');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,1,'carrot8');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,2,'carrot4');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,2,'carrot5');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,2,'carrot6');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,3,'carrot6');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,3,'carrot1');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,3,'carrot2');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot1');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot2');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot3');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot4');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot5');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot1');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot2');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot3');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot4');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot5');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,6,'carrot1');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,6,'carrot3');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,6,'carrot5');
*/

--#### <<join>> product - address(user_id,판매자) - wishlist(user_id,구매자)
/*
select * from product p
join address a
on p.address_no=a.address_no
join wishlist w
on p.p_no=p.p_no;
*/

--#############[town_board],[town_img],[town_reaction]
desc town_board;
desc town_img;
desc town_reaction;
/*
이름         널?       유형             
---------- -------- -------------- 
T_NO       NOT NULL NUMBER(10)     
T_TITLE             VARCHAR2(300)  
T_CONTENT           VARCHAR2(1000) 
T_DATE              DATE           
T_COUNT             NUMBER(10)     
T_CTGR_NO           NUMBER(10)     
ADDRESS_NO          NUMBER(10) 
*/
--****** 3개의 table에 insert를 각각 하는 경우
--[town_board]carrot4, 역삼동, 동네소식
insert into town_board(t_no, t_title, t_content, t_date, t_count, t_ctgr_no, t_address_name, t_address_coords)
values(TOWN_BOARD_T_NO_SEQ.nextval, '날씨가 좋아요~','바람도 불고 시원하고 걷기 좋은 날씨에요~',sysdate-6,10,1,'역삼동',null);
--[town_img]
insert into town_img(t_img_no, t_img_name, t_no) values(TOWN_IMG_T_IMG_NO_SEQ.nextval,'날씨가좋아요.jpg',1);
--[town_reaction]
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,1,'carrot3');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,1,'carrot2');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,1,'carrot1');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,1,'carrot5');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,1,'carrot6');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,1,'carrot7');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,1,'carrot8');

--****** 3개의 table에 insert를 동시에 하는 경우
--[town_board]carrot7, 서초동, 동네소식
insert into town_board(t_no, t_title, t_content, t_date, t_count, t_ctgr_no, t_address_name, t_address_coords)
values(TOWN_BOARD_T_NO_SEQ.nextval, '미용실 추천해주세요','기분전환 겸 염색하고 싶은데 추천할만한 곳 있을까요?',sysdate-5,10,1,'역삼동',null);
--[town_img]
insert into town_img(t_img_no, t_img_name, t_no) values(TOWN_IMG_T_IMG_NO_SEQ.nextval,'미용실.jpg',TOWN_BOARD_T_NO_SEQ.currval);
--[town_reaction]
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,TOWN_BOARD_T_NO_SEQ.currval,'carrot1');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,TOWN_BOARD_T_NO_SEQ.currval,'carrot2');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,TOWN_BOARD_T_NO_SEQ.currval,'carrot3');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,TOWN_BOARD_T_NO_SEQ.currval,'carrot4');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,TOWN_BOARD_T_NO_SEQ.currval,'carrot5');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,TOWN_BOARD_T_NO_SEQ.currval,'carrot6');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,TOWN_BOARD_T_NO_SEQ.currval,'carrot8');

--select & join
/*
select * from town_board tb
join address a
on tb.address_no=a.address_no
join town_reaction tr
on tb.t_no=tr.t_no;
*/
-- >>>>image는 1장만 넣을까..? JOIN...
-- >>>> title이 필요한가??? -> 일단은 넣어두는 걸로


--######################[town_wishlist]
desc town_wishlist;

/*
이름      널?       유형           
------- -------- ------------ 
T_WL_NO NOT NULL NUMBER(10)   
USER_ID          VARCHAR2(10) 
T_NO             NUMBER(10) 
*/
select * from town_wishlist;

insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot3',1);
insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot2',1);
insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot1',1);

insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot3',2);
insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot2',2);
insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot1',2);







--######################[town_reply]
--[town_reply] --> 미완료. 은비가 마무리할 예정
desc town_reply;
/*
이름              널?       유형             
--------------- -------- -------------- 
T_REPLY_NO      NOT NULL NUMBER(10)     
T_REPLY_TITLE            VARCHAR2(300)  
T_REPLY_CONTENT          VARCHAR2(1000) 
T_REPLY_DATE             DATE           
GROUPNO                  NUMBER(10)     
STEP                     NUMBER(10)     
DEPTH                    NUMBER(10)     
USER_ID                  VARCHAR2(10)   
T_NO                     NUMBER(10)  
*/
select * from town_board;
insert into town_reply(T_REPLY_NO, T_REPLY_TITLE, T_REPLY_CONTENT,T_REPLY_DATE ,GROUPNO,STEP,DEPTH,user_id, t_no)
values(TOWN_REPLY_T_REPLY_NO_SEQ.nextval,'맞아요~','한강가기 좋은날씨에요~',sysdate-5,1,1,1,'carrot3',1);

