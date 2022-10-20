/*
delete from review;
delete from transfer;
delete from orders;
delete from payment;
update userinfo set user_point =0;
desc transfer;
*/
--***[payment]->[user_point :update]****************************************************************
--[payment] carrot1
insert into payment values('payment439085dsfr46546ue', 'kakaopay', '10000', sysdate-30, 'carrot1');
--[user_point :update]
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment439085dsfr46546ue')
    where user_id= (select user_id from payment where payment_no = 'payment439085dsfr46546ue');

insert into payment values('payment439085dsfr46557sd', 'naverpay', '3000', sysdate-29, 'carrot1');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment439085dsfr46557sd')
    where user_id= (select user_id from payment where payment_no = 'payment439085dsfr46557sd');

insert into payment values('payment852185dsfr46557sd', 'tosspay', '44000', sysdate-28, 'carrot1');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment852185dsfr46557sd')
    where user_id= (select user_id from payment where payment_no = 'payment852185dsfr46557sd');

insert into payment values('payment753185dsfr46557sd', 'tosspay', '20000', sysdate-20, 'carrot1');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment753185dsfr46557sd')
    where user_id= (select user_id from payment where payment_no = 'payment753185dsfr46557sd');

insert into payment values('payment598185dsfr46557sd', 'kakaopay', '56000', sysdate-15, 'carrot1');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment598185dsfr46557sd')
    where user_id= (select user_id from payment where payment_no = 'payment598185dsfr46557sd');

--[payment] carrot2
insert into payment values('payment439roew3343223456', 'card', '20000', sysdate-8, 'carrot2');
--[user_point :update]
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment439roew3343223456')
    where user_id= (select user_id from payment where payment_no = 'payment439roew3343223456');

insert into payment values('payment124roew3343223456', 'naverpay', '30000', sysdate-7, 'carrot2');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment124roew3343223456')
    where user_id= (select user_id from payment where payment_no = 'payment124roew3343223456');

insert into payment values('payment986roew3343223456', 'tosspay', '7000', sysdate-5, 'carrot2');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment986roew3343223456')
    where user_id= (select user_id from payment where payment_no = 'payment986roew3343223456');

insert into payment values('payment421roew3343223456', 'card', '5000', sysdate-3, 'carrot2');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment421roew3343223456')
    where user_id= (select user_id from payment where payment_no = 'payment421roew3343223456');

insert into payment values('payment689roew3343223456', 'kakaopay', '10000', sysdate-1, 'carrot2');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment689roew3343223456')
    where user_id= (select user_id from payment where payment_no = 'payment689roew3343223456');

--[payment] carrot3
insert into payment values('payment3958rkjgfdfekwf45', 'tosspay', '30000', sysdate-17, 'carrot3');
--[user_point :update]
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment3958rkjgfdfekwf45')
    where user_id= (select user_id from payment where payment_no = 'payment3958rkjgfdfekwf45');
    
insert into payment values('payment3457rkjgfdfekwf45', 'kakaopay', '25000', sysdate-6, 'carrot3');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment3457rkjgfdfekwf45')
    where user_id= (select user_id from payment where payment_no = 'payment3457rkjgfdfekwf45');

insert into payment values('payment4578rkjgfdfekwf45', 'kakaopay', '50000', sysdate-5, 'carrot3');
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment4578rkjgfdfekwf45')
    where user_id= (select user_id from payment where payment_no = 'payment4578rkjgfdfekwf45');
    
--[payment] carrot4
insert into payment values('payment20394ertiujwkdsfg', 'naverpay', '80000', sysdate-8, 'carrot4');
--[user_point :update]
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment20394ertiujwkdsfg')
    where user_id= (select user_id from payment where payment_no = 'payment20394ertiujwkdsfg');

--[payment] carrot5
insert into payment values('payment20123ertiujwkdsfg', 'naverpay', '100000', sysdate-15, 'carrot5');
--[user_point :update]
update userinfo set user_point =user_point+(select payment_amount from payment where payment_no = 'payment20123ertiujwkdsfg')
    where user_id= (select user_id from payment where payment_no = 'payment20123ertiujwkdsfg');

--***[orders]->[transfer]->[user_point :update]->[review]************************************************
desc transfer;

--[orders] p_no=1, 판매자 carrot1, 구매자 carrot5
insert into orders values(ORDERS_ORDERS_NO_SEQ.nextval, 1,'carrot5',sysdate-10);
--[transfer] 구매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            0,
            (-1*(select p_price from product where p_no = 1)),
            sysdate-9,
            (select user_id from orders where p_no =1),
            (select orders_no from orders where p_no = 1),
            1,
            (select user_point from userinfo where user_id=(select user_id from orders where p_no = 1))
                    -(select p_price from product where p_no = 1)
            );
--[transfer] 판매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            (select p_price from product where p_no = 1),
            0,
            sysdate-9,
            (select user_id from product where p_no =1),
            (select orders_no from orders where p_no = 1),
            1,
            (select user_point from userinfo where user_id=(select user_id from product where p_no = 1))
                    +(select p_price from product where p_no = 1)
            );           
--[user_point :update] 구매자
update userinfo set user_point =user_point-(select p_price from product where p_no = 1)
    where user_id= (select user_id from orders where p_no =1);
--[user_point :update] 판매자
update userinfo set user_point =user_point+(select p_price from product where p_no = 1)
    where user_id= (select user_id from product where p_no = 1);
--[review] 구매자
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'친절하고 약속시간을 잘지켜요','carrot1',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot5');
--[review] 판매자    
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'쿨거래했어요','carrot5',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot1');
    
    
--************
--[orders] p_no=2, 판매자 carrot3, 구매자 carrot1
insert into orders values(ORDERS_ORDERS_NO_SEQ.nextval, 2,'carrot1',sysdate-10);
--[transfer] 구매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            0,
            (-1*(select p_price from product where p_no = 2)),
            sysdate-9,
            (select user_id from orders where p_no =2),
            (select orders_no from orders where p_no = 2),
            2,
            (select user_point from userinfo where user_id=(select user_id from orders where p_no = 2))
                    -(select p_price from product where p_no = 2)
            );
--[transfer] 판매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            (select p_price from product where p_no = 2),
            0,
            sysdate-9,
            (select user_id from product where p_no =2),
            (select orders_no from orders where p_no = 2),
            2,
            (select user_point from userinfo where user_id=(select user_id from product where p_no = 2))
                    +(select p_price from product where p_no = 2)
            );           
--[user_point :update] 구매자
update userinfo set user_point =user_point-(select p_price from product where p_no = 2)
    where user_id= (select user_id from orders where p_no =2);
--[user_point :update] 판매자
update userinfo set user_point =user_point+(select p_price from product where p_no = 2)
    where user_id= (select user_id from product where p_no = 2);
--[review] 구매자
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'친절하고 약속시간을 잘지켜요','carrot3',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot1');
--[review] 판매자    
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'쿨거래했어요','carrot1',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot3');
    
--************
--[orders] p_no=3, 판매자 carrot3, 구매자 carrot4
insert into orders values(ORDERS_ORDERS_NO_SEQ.nextval, 3,'carrot4',sysdate-10);
--[transfer] 구매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            0,
            (-1*(select p_price from product where p_no = 3)),
            sysdate-9,
            (select user_id from orders where p_no =3),
            (select orders_no from orders where p_no = 3),
            3,
            (select user_point from userinfo where user_id=(select user_id from orders where p_no = 3))
                    -(select p_price from product where p_no = 3)
            );
--[transfer] 판매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            (select p_price from product where p_no = 3),
            0,
            sysdate-9,
            (select user_id from product where p_no =3),
            (select orders_no from orders where p_no = 3),
            3,
            (select user_point from userinfo where user_id=(select user_id from product where p_no = 3))
                    +(select p_price from product where p_no = 3)
            );           
--[user_point :update] 구매자
update userinfo set user_point =user_point-(select p_price from product where p_no = 3)
    where user_id= (select user_id from orders where p_no =3);
--[user_point :update] 판매자
update userinfo set user_point =user_point+(select p_price from product where p_no = 3)
    where user_id= (select user_id from product where p_no = 3);
--[review] 구매자
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'마음에 들어요','carrot3',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot4');
--[review] 판매자    
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'친절해요','carrot4',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot3');
    
--************
--[orders] p_no=4, 판매자 carrot4, 구매자 carrot2
insert into orders values(ORDERS_ORDERS_NO_SEQ.nextval, 4,'carrot2',sysdate-10);
--[transfer] 구매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            0,
            (-1*(select p_price from product where p_no = 4)),
            sysdate-9,
            (select user_id from orders where p_no =4),
            (select orders_no from orders where p_no = 4),
            4,
            (select user_point from userinfo where user_id=(select user_id from orders where p_no = 4))
                    -(select p_price from product where p_no = 4)
            );
--[transfer] 판매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            (select p_price from product where p_no = 4),
            0,
            sysdate-9,
            (select user_id from product where p_no =4),
            (select orders_no from orders where p_no = 4),
            4,
            (select user_point from userinfo where user_id=(select user_id from product where p_no = 4))
                    +(select p_price from product where p_no = 4)
            );           
--[user_point :update] 구매자
update userinfo set user_point =user_point-(select p_price from product where p_no = 4)
    where user_id= (select user_id from orders where p_no =4);
--[user_point :update] 판매자
update userinfo set user_point =user_point+(select p_price from product where p_no = 4)
    where user_id= (select user_id from product where p_no = 4);
--[review] 구매자
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'굳굳','carrot4',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot2');
--[review] 판매자    
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'좋아요','carrot2',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot4');
    
--************
--[orders] p_no=7, 판매자 carrot5, 구매자 carrot2
insert into orders values(ORDERS_ORDERS_NO_SEQ.nextval, 7,'carrot2',sysdate-5);
--[transfer] 구매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            0,
            (-1*(select p_price from product where p_no = 7)),
            sysdate-5,
            (select user_id from orders where p_no =7),
            (select orders_no from orders where p_no = 7),
            7,
            (select user_point from userinfo where user_id=(select user_id from orders where p_no = 7))
                    -(select p_price from product where p_no = 7)
            );
--[transfer] 판매자
insert into transfer values(TRANSFER_TRANSFER_NO_SEQ.nextval,
            (select p_price from product where p_no = 7),
            0,
            sysdate-5,
            (select user_id from product where p_no =7),
            (select orders_no from orders where p_no = 7),
            7,
            (select user_point from userinfo where user_id=(select user_id from product where p_no = 7))
                    +(select p_price from product where p_no = 7)
            );           
--[user_point :update] 구매자
update userinfo set user_point =user_point-(select p_price from product where p_no = 7)
    where user_id= (select user_id from orders where p_no =7);
--[user_point :update] 판매자
update userinfo set user_point =user_point+(select p_price from product where p_no = 7)
    where user_id= (select user_id from product where p_no = 7);
--[review] 구매자
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'깔끔해요','carrot5',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot2');
--[review] 판매자    
insert into review(review_no,review_desc,your_id,review_point,orders_no,user_id)
    values(REVIEW_REVIEW_NO_SEQ.nextval,'만족합니다','carrot2',0.1, ORDERS_ORDERS_NO_SEQ.currval,'carrot5');
