desc review_img;

DROP TABLE review_img CASCADE CONSTRAINTS;

CREATE TABLE review_img(
		review_img_no                 		NUMBER(10)		 NULL ,
		review_img_name               		VARCHAR2(200)		 NOT NULL,
		review_no                     		NUMBER(10)		 NULL 
);

DROP SEQUENCE review_img_review_img_no_SEQ;

CREATE SEQUENCE review_img_review_img_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

ALTER TABLE review_img ADD CONSTRAINT IDX_review_img_PK PRIMARY KEY (review_img_no);
ALTER TABLE review_img ADD CONSTRAINT IDX_review_img_FK0 FOREIGN KEY (review_no) REFERENCES review (review_no);





insert into product_img(review_img_no, review_img_name, review_no) values         (review_img_review_img_no_SEQ.nextval,?,?)     ,     (review_img_review_img_no_SEQ.nextval,?,?)     ,     (review_img_review_img_no_SEQ.nextval,?,?)     ,     (review_img_review_img_no_SEQ.nextval,?,?)
