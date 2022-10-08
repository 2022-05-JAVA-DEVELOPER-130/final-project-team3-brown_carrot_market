/********[review]********/
desc review;
/*
이름           널?       유형            
------------ -------- ------------- 
REVIEW_NO    NOT NULL NUMBER(10)    
REVIEW_DESC           VARCHAR2(100) 
REVIEW_IMAGE          VARCHAR2(100) 
REVIEW_POINT          NUMBER(10,1)  
ORDERS_NO             NUMBER(10)    
USER_ID               VARCHAR2(30)    
*/

select p.p_no, o.user_id oo,p.user_id pp from orders o
join product p
on o.p_no=p.p_no
;

--구매자
insert into review(review_no,review_desc,review_image,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'친절하고 약속시간을 잘지켜요','',0.1, 1,'carrot5');
--판매자    
insert into review(review_no,review_desc,review_image,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'쿨거래했어요','',0.1, 1,'carrot6');

--구매자
insert into review(review_no,review_desc,review_image,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'최고에요!','',0.2, 2,'carrot5');
--판매자    
insert into review(review_no,review_desc,review_image,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'별로에요','',-0.1, 2,'carrot7');   
    
--구매자
insert into review(review_no,review_desc,review_image,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'그냥그래요','',0, 3,'carrot5');
--판매자    
insert into review(review_no,review_desc,review_image,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'친절해요','',0.1, 3,'carrot7');     
    
    
select * from review;


-- ***** 받은 거래 후기
-- '구매자'가 '판매자'에게 남긴 전체 후기
/*
select p.p_no,p.p_title, p.user_id, o.orders_no,o.user_id, r.review_no,r.user_id from product p
join orders o
on p.p_no=o.p_no
join review r
on o.orders_no=r.orders_no
where o.user_id=r.user_id;
*/

--********[거래후기상세]페이지

-- 전체후기 : 판매자 or 구매자가 나에게 남긴 후기
select *
from review r
join orders oo
on r.orders_no=oo.orders_no
join product pp
on oo.p_no=pp.p_no
join userinfo u
on pp.user_id=u.user_id
where r.user_id in
(select o.user_id buyer from product p
join orders o
on p.p_no=o.p_no
where p.user_id = 'carrot1')
or r.user_id in
(select p.user_id seller from product p
join orders o
on p.p_no=o.p_no
where o.user_id = 'carrot1');

-- '판매자(carrot3)'인 경우 : 구매자가 남긴 후기 
select * from review r
where r.user_id in
(select o.user_id buyer from product p
join orders o
on p.p_no=o.p_no
where p.user_id = 'carrot3');

-- '구매자(carrot1)'인 경우 : 판매자가 남긴 후기
select * from review r
where r.user_id in
(select p.user_id seller from product p
join orders o
on p.p_no=o.p_no
where o.user_id = 'carrot1');




--insert into orders values(ORDERS_ORDERS_NO_SEQ.nextval, 3,'carrot5');
/*
insert into review(review_no,review_desc,review_image,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'(구매)친절하고 약속시간을 잘지켜요','',0.1, 6,'carrot1');
    insert into review(review_no,review_desc,review_image,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'(판매)친절하고 약속시간을 잘지켜요','',0.1, 6,'carrot4');
*/