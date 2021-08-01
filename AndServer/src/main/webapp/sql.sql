DROP TABLE member cascade constraints;
DROP TABLE checklist;
DROP TABLE cosmetic;
DROP TABLE ingredient;
DROP TABLE sold_table;
DROP TABLE u_cosmetic;


CREATE TABLE member (
	id	varchar2(50)		NOT NULL,
	pw	varchar2(50)		NOT NULL,
	skintype	varchar2(50)		NOT NULL
);


CREATE TABLE checklist (
	q_num	varchar2(50)		NOT NULL,
	q_content	varchar2(50)		NOT NULL,
	q_yes	varchar2(50)		NOT NULL,
	q_no	varchar2(50)		NOT NULL
);


CREATE TABLE cosmetic (
	cos_id		varchar2(50)		NOT NULL,
	cos_name	varchar2(50)		NOT NULL,
	cos_brand	varchar2(50)		NOT NULL,
	cos_price		varchar2(50)		NOT NULL,
	cos_type		varchar2(50)		NOT NULL,
	cos_allergy	varchar2(50)		NULL
);


CREATE TABLE ingredient (
	igt_id	varchar2(50)		NOT NULL,
	cos_id	varchar2(50)		NOT NULL,
	igt1	varchar2(50)		NOT NULL,
	igt2	varchar2(50)		NOT NULL,
	igt3	varchar2(50)		NOT NULL,
	igt4	varchar2(50)		NOT NULL,
	igt5	varchar2(50)		NOT NULL
);


CREATE TABLE sold_table (
	table_id	varchar2(50)		NOT NULL,
	id	varchar2(50)		NOT NULL,
	solddate	varchar2(50)		NOT NULL
);


CREATE TABLE u_cosmetic (
	u_cos_id		varchar2(50)		NOT NULL,
	id		varchar2(50)		NOT NULL,
	cos_id		varchar2(50)		NOT NULL,
	u_cos_date	varchar2(50)		NOT NULL,
	amount		varchar2(50)		NOT NULL,
	u_cos_dead	varchar2(50)		NOT NULL
);



--insert into testInterval values('test2','test2','test2',sysdate,'test2', sysdate+(interval '2' year));

select * from u_cosmetic;
update u_cosmetic set amount=3 where u_cos_id='test123';

ALTER TABLE member ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	id
);

ALTER TABLE checklist ADD CONSTRAINT "PK_CHECKLIST" PRIMARY KEY (
	q_num
);

ALTER TABLE cosmetic ADD CONSTRAINT "PK_COSMETIC" PRIMARY KEY (
	cos_id
);

ALTER TABLE ingredient ADD CONSTRAINT "PK_INGREDIENT" PRIMARY KEY (
	igt_id,
	cos_id
);

ALTER TABLE sold_table ADD CONSTRAINT "PK_SOLD_TABLE" PRIMARY KEY (
	table_id,
	id
);

ALTER TABLE u_cosmetic ADD CONSTRAINT "PK_U_COSMETIC" PRIMARY KEY (
	u_cos_id,
	id,
	cos_id
);

ALTER TABLE ingredient ADD CONSTRAINT "FK_cosmetic_TO_ingredient_1" FOREIGN KEY (
	cos_id
)
REFERENCES cosmetic (
	cos_id
);

ALTER TABLE sold_table ADD CONSTRAINT "FK_member_TO_sold_table_1" FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE u_cosmetic ADD CONSTRAINT "FK_member_TO_u_cosmetic_1" FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE u_cosmetic ADD CONSTRAINT "FK_cosmetic_TO_u_cosmetic_1" FOREIGN KEY (
	cos_id
)
REFERENCES cosmetic (
	cos_id
);

