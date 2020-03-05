create or replace schema fabrick collate utf8_general_ci;

create or replace schema information_schema collate utf8_general_ci;

create or replace table PAYLOAD
(
	UID varchar(32) not null
		primary key
);

create or replace table PAYLOADTRANSACTION
(
	UID varchar(32) not null
		primary key,
	STATUS varchar(50) not null,
	ERROR varchar(50) not null,
	PAYLOAD_UID varchar(32) not null
);

create or replace table STORICO
(
	UID varchar(32) null,
	PAYLOAD_TRANSACTION_UID varchar(32) null,
	OPERATION varchar(6) null,
	DATA_OPER timestamp null,
	USER_ID varchar(32) null
);

create or replace table TRANSACTION
(
	OPERATION_ID varchar(32) not null,
	TRANSACTION_ID varchar(32) not null,
	PAYLOAD_UID varchar(32) not null,
	ACCOUNT_DATE varchar(10) not null,
	VALUE_DATE varchar(10) not null,
	UID varchar(32) null,
	TYPE_UID varchar(32) null,
	AMOUNT double null,
	CURRENCY varchar(3) null,
	DESCRIZIONE varchar(200) null
);

create or replace table TYPEVALUE
(
	UID varchar(32) not null
		primary key,
	ENUMERATION varchar(50) not null,
	VALUE varchar(50) not null
);

alter table TRANSACTION
	add constraint TRANSACTION_PAYLOAD_UID_fk
		foreign key (PAYLOAD_UID) references PAYLOAD (UID);


/*  TODO  */
