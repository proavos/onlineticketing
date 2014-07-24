-- for mysql database

CREATE TABLE IF NOT EXISTS TBL_CITY(
	CITY_ID	 	INT 			NOT NULL AUTO_INCREMENT,
	CITY_NAME	VARCHAR(100) 	NOT NULL,
	STATUS		CHAR(3)	 		NOT NULL,
	VERSION		INT				NOT NULL,
	PRIMARY KEY(CITY_ID)
);



CREATE TABLE IF NOT EXISTS TBL_BUS(
	BUS_ID	 		INT 			NOT NULL AUTO_INCREMENT,
	FROM_CITY_ID	INT 			NOT NULL,
	TO_CITY_ID		INT	 			NOT NULL,
	ROUTE_CODE		VARCHAR(10)		NOT NULL,
	DEP_DATETIME	TIMESTAMP		NOT NULL,
	ARR_DATETIME	TIMESTAMP		NOT NULL,
	TICKET_PRICE	DECIMAL(10,5)	NOT NULL,
	STATUS			CHAR(3)			NOT NULL,
	VERSION		INT					NOT NULL,
	PRIMARY KEY(BUS_ID)
);

CREATE TABLE IF NOT EXISTS TBL_INVENTORY(
	INVENTORY_ID	INT 		NOT NULL AUTO_INCREMENT,
	BUS_ID			INT 		NOT NULL,
	SEATS_CAPACITY	INT	 		NOT NULL,
	SEATS_BOOKED	INT	 		NOT NULL,
	SEATS_AVAILABLE	INT	 		NOT NULL,
	VERSION			INT			NOT NULL,
	PRIMARY KEY(INVENTORY_ID)
);

CREATE TABLE IF NOT EXISTS TBL_BOOKING (
	BOOKING_ID 		INT 			NOT NULL AUTO_INCREMENT,
	BOOKING_REF		VARCHAR(6)		NOT NULL,
	BUS_ID			INT	 			NOT NULL,
	SEATS_BOOKED	VARCHAR(10)		NOT NULL,
	CONTACT_NAME	VARCHAR(200)	NOT NULL,
	CONTACT_PHONE	VARCHAR(15),
	TOTAL_PRICE		DECIMAL(10,5)	NOT NULL,
	TOTAL_PAID		DECIMAL(10,5)	NOT NULL,
	BOOKED_DATETIME	TIMESTAMP		NOT NULL,
	STATUS			CHAR(3)			NOT NULL,
	VERSION			INT				NOT NULL,
	PRIMARY KEY(BOOKING_ID)
);