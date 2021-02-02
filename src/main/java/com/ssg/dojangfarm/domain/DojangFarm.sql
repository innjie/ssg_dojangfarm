
/* Drop Tables */

DROP TABLE CommonJoin CASCADE CONSTRAINTS;
DROP TABLE ImPur CASCADE CONSTRAINTS;
DROP TABLE Refund CASCADE CONSTRAINTS;
DROP TABLE OrderTable CASCADE CONSTRAINTS;
DROP TABLE SBid CASCADE CONSTRAINTS;
DROP TABLE Delivery CASCADE CONSTRAINTS;
DROP TABLE Address CASCADE CONSTRAINTS;
DROP TABLE Bid CASCADE CONSTRAINTS;
DROP TABLE Auction CASCADE CONSTRAINTS;
DROP TABLE Payment CASCADE CONSTRAINTS;
DROP TABLE Card CASCADE CONSTRAINTS;
DROP TABLE item CASCADE CONSTRAINTS;
DROP TABLE Cart CASCADE CONSTRAINTS;
DROP TABLE Discount CASCADE CONSTRAINTS;
DROP TABLE Message CASCADE CONSTRAINTS;
DROP TABLE QnA CASCADE CONSTRAINTS;
DROP TABLE Normal CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE Category CASCADE CONSTRAINTS;
DROP TABLE Common CASCADE CONSTRAINTS;
DROP TABLE CommonNotice CASCADE CONSTRAINTS;
DROP TABLE UserTable CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE Address
(
	addrNo number NOT NULL,
	addr varchar2(50) NOT NULL,
	zip number NOT NULL,
	detail varchar2(100),
	aName varchar2(50),
	userNo number NOT NULL,
	PRIMARY KEY (addrNo)
);


CREATE TABLE Auction
(
	aNo number NOT NULL,
	title varchar2(50) NOT NULL,
	detail varchar2(3000),
	minPrice number DEFAULT 1000 NOT NULL check(minPrice >= 1000),
	rDate date DEFAULT SYSDATE,
	deadline date DEFAULT SYSDATE+1 NOT NULL check(rDate < deadline),
	imPurAva varchar2(1) DEFAULT '''0''',
	imPurPrice number check(imPurPrice > minPrice),
	state varchar2(10) DEFAULT '''진행중''' check(state in(‘진행중’, ‘종료’)),
	pNo number NOT NULL,
	userNo number NOT NULL,
	PRIMARY KEY (aNo)
);


CREATE TABLE Bid
(
	bidNo number NOT NULL,
	cBidPrice number,
	bidPrice number NOT NULL check(bidPrice > cBidPrice),
	bidTime date DEFAULT SYSDATE,
	aNo number NOT NULL,
	userNo number NOT NULL,
	PRIMARY KEY (bidNo)
);


CREATE TABLE Card
(
	cardNo number NOT NULL,
	bank varchar2(10) DEFAULT '''우리은행''' NOT NULL,
	cardPW number NOT NULL,
	period date NOT NULL,
	userNo number NOT NULL,
	type varchar2(10) DEFAULT '''Visa''' check(type in(‘Visa’, ‘MasterCard’, ‘American Express’)),
	PRIMARY KEY (cardNo)
);


CREATE TABLE Cart
(
	cartNo number NOT NULL,
	totalPrice number,
	PRIMARY KEY (cartNo)
);


CREATE TABLE Category
(
	cateNo number NOT NULL,
	kind varchar2(10) NOT NULL check(kind in('과일', '채소', '기타')),
	PRIMARY KEY (cateNo)
);


CREATE TABLE Common
(
	saleNo number NOT NULL,
	saleType varchar2(10) NOT NULL,
	picture varchar2(100),
	title varchar2(50) NOT NULL,
	saleState varchar2(10) NOT NULL,
	info varchar2(3000),
	price number check(price > 0),
	count number check(number > 0),
	deadline date DEFAULT SYSDATE,
	min number NOT NULL check(min > 0),
	userNo number NOT NULL,
	PRIMARY KEY (saleNo)
);


CREATE TABLE CommonJoin
(
	cjNo number NOT NULL,
	cjState varchar2(10) DEFAULT '''신청''' check(cjState in(‘신청’, ‘취소’)),
	saleNo number NOT NULL,
	userNo number NOT NULL,
	dNo number NOT NULL,
	payNo number,
	PRIMARY KEY (cjNo)
);


CREATE TABLE CommonNotice
(
	cnNo number NOT NULL,
	title varchar2(50) NOT NULL,
	info varchar2(200),
	userNo number NOT NULL,
	PRIMARY KEY (cnNo)
);


CREATE TABLE Delivery
(
	dNo number NOT NULL,
	status varchar2(10) DEFAULT '''배송전''' check(status in(‘배송전’, ‘배송중’, ‘배송완료’)),
	phone varchar2(15),
	addrNo number NOT NULL,
	PRIMARY KEY (dNo)
);


CREATE TABLE Discount
(
	dRate number,
	dDate date DEFAULT SYSDATE,
	saleNo number NOT NULL,
	PRIMARY KEY (saleNo)
);


CREATE TABLE ImPur
(
	imPurNo number NOT NULL,
	aNo number NOT NULL,
	userNo number NOT NULL,
	dNo number NOT NULL,
	payNo number NOT NULL,
	PRIMARY KEY (imPurNo)
);


CREATE TABLE item
(
	itemNo number NOT NULL,
	quantity number DEFAULT 1,
	selected varchar2(1) DEFAULT '''0''',
	cartNo number NOT NULL,
	PRIMARY KEY (itemNo)
);


CREATE TABLE Message
(
	msgNo number NOT NULL,
	read varchar2(1) DEFAULT '''0''',
	title varchar2(50) NOT NULL,
	sDate date DEFAULT SYSDATE,
	content varchar2(1000),
	deleteState varchar2(1) DEFAULT '''0''',
	cMsgNo number,
	saleNo number NOT NULL,
	sUserNo number NOT NULL,
	rUserNo number NOT NULL,
	PRIMARY KEY (msgNo)
);


CREATE TABLE Normal
(
	saleNo number NOT NULL,
	saleType varchar2(10) NOT NULL,
	picture varchar2(100),
	title varchar2(50) NOT NULL,
	saleState varchar2(10) NOT NULL,
	info varchar2(3000),
	price number check(price > 0),
	count number check(number > 0),
	state varchar2(1) DEFAULT '0',
	pNo number NOT NULL,
	userNo number NOT NULL,
	regidDate date DEFAULT SYSDATE,
	PRIMARY KEY (saleNo)
);


CREATE TABLE OrderTable
(
	orderNo number NOT NULL,
	dNo number NOT NULL,
	payNo number NOT NULL,
	quantity number,
	saleNo number NOT NULL,
	userNo number NOT NULL,
	PRIMARY KEY (orderNo)
);


CREATE TABLE Payment
(
	payNo number NOT NULL,
	method varchar2(10) DEFAULT '''카드'''  check(method in(‘카드’, ‘무통장’, ‘카카오페이’)),
	payCheck varchar2(1) DEFAULT '''1''',
	pDate date DEFAULT SYSDATE,
	cardNo number NOT NULL,
	totalPrice number NOT NULL,
	PRIMARY KEY (payNo)
);


CREATE TABLE Product
(
	pNo number NOT NULL,
	pName varchar2(20) NOT NULL,
	cateNo number NOT NULL,
	PRIMARY KEY (pNo)
);


CREATE TABLE QnA
(
	qNo number NOT NULL,
	question varchar2(1000) NOT NULL,
	qDate date DEFAULT SYSDATE,
	answer varchar2(1000),
	secret varchar2(1) DEFAULT '0',
	saleNo number NOT NULL,
	userNo number NOT NULL,
	PRIMARY KEY (qNo)
);


CREATE TABLE Refund
(
	refundNo number NOT NULL,
	account varchar2(20),
	bank varchar2(10),
	name varchar2(20),
	refundType varchar2(10) DEFAULT '''계좌''' check(refundType in('계좌', '포인트', '카드')),
	orderNo number NOT NULL,
	PRIMARY KEY (refundNo)
);


CREATE TABLE SBid
(
	sBidNo number NOT NULL,
	payState varchar2(10) DEFAULT '''결제예정''' check(payState in(‘결제예정’, ‘결제완료’)),
	bidNo number NOT NULL,
	dNo number,
	payNo number,
	PRIMARY KEY (sBidNo)
);


CREATE TABLE UserTable
(
	userNo number NOT NULL,
	name varchar2(10) NOT NULL,
	phone varchar2(20) NOT NULL UNIQUE,
	id varchar2(10) NOT NULL UNIQUE,
	pw varchar2(20) NOT NULL,
	point number DEFAULT 0,
	PRIMARY KEY (userNo)
);



/* Create Foreign Keys */

ALTER TABLE Delivery
	ADD FOREIGN KEY (addrNo)
	REFERENCES Address (addrNo)
;


ALTER TABLE Bid
	ADD FOREIGN KEY (aNo)
	REFERENCES Auction (aNo)
;


ALTER TABLE ImPur
	ADD FOREIGN KEY (aNo)
	REFERENCES Auction (aNo)
;


ALTER TABLE SBid
	ADD FOREIGN KEY (bidNo)
	REFERENCES Bid (bidNo)
;


ALTER TABLE Payment
	ADD FOREIGN KEY (cardNo)
	REFERENCES Card (cardNo)
;


ALTER TABLE item
	ADD FOREIGN KEY (cartNo)
	REFERENCES Cart (cartNo)
;


ALTER TABLE Product
	ADD FOREIGN KEY (cateNo)
	REFERENCES Category (cateNo)
;


ALTER TABLE CommonJoin
	ADD FOREIGN KEY (saleNo)
	REFERENCES Common (saleNo)
;


ALTER TABLE CommonJoin
	ADD FOREIGN KEY (dNo)
	REFERENCES Delivery (dNo)
;


ALTER TABLE ImPur
	ADD FOREIGN KEY (dNo)
	REFERENCES Delivery (dNo)
;


ALTER TABLE OrderTable
	ADD FOREIGN KEY (dNo)
	REFERENCES Delivery (dNo)
;


ALTER TABLE SBid
	ADD FOREIGN KEY (dNo)
	REFERENCES Delivery (dNo)
;


ALTER TABLE Message
	ADD FOREIGN KEY (cMsgNo)
	REFERENCES Message (msgNo)
;


ALTER TABLE Discount
	ADD FOREIGN KEY (saleNo)
	REFERENCES Normal (saleNo)
;


ALTER TABLE Message
	ADD FOREIGN KEY (saleNo)
	REFERENCES Normal (saleNo)
;


ALTER TABLE OrderTable
	ADD FOREIGN KEY (saleNo)
	REFERENCES Normal (saleNo)
;


ALTER TABLE QnA
	ADD FOREIGN KEY (saleNo)
	REFERENCES Normal (saleNo)
;


ALTER TABLE Refund
	ADD FOREIGN KEY (orderNo)
	REFERENCES OrderTable (orderNo)
;


ALTER TABLE CommonJoin
	ADD FOREIGN KEY (payNo)
	REFERENCES Payment (payNo)
;


ALTER TABLE ImPur
	ADD FOREIGN KEY (payNo)
	REFERENCES Payment (payNo)
;


ALTER TABLE OrderTable
	ADD FOREIGN KEY (payNo)
	REFERENCES Payment (payNo)
;


ALTER TABLE SBid
	ADD FOREIGN KEY (payNo)
	REFERENCES Payment (payNo)
;


ALTER TABLE Auction
	ADD FOREIGN KEY (pNo)
	REFERENCES Product (pNo)
;


ALTER TABLE Normal
	ADD FOREIGN KEY (pNo)
	REFERENCES Product (pNo)
;


ALTER TABLE Address
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE Auction
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE Bid
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE Card
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE Common
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE CommonJoin
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE CommonNotice
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE ImPur
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE Message
	ADD FOREIGN KEY (sUserNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE Message
	ADD FOREIGN KEY (rUserNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE Normal
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE OrderTable
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;


ALTER TABLE QnA
	ADD FOREIGN KEY (userNo)
	REFERENCES UserTable (userNo)
;



