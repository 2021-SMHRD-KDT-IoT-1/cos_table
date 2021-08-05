DROP TABLE member cascade constraints;
DROP TABLE cosmetic cascade constraints;
DROP TABLE ingredient;
DROP TABLE sold_table cascade constraints;
DROP TABLE u_cosmetic;


CREATE TABLE member (
   id       varchar2(50)      NOT NULL,
   table_id   varchar2(50)     NULL,
   pw      varchar2(50)      NOT NULL,
   skintype varchar2(50)      NOT NULL
);

select*from member;

CREATE TABLE cosmetic (
   cos_id      varchar2(50)      NOT NULL,
   cos_name   varchar2(50)      NOT NULL,
   cos_brand   varchar2(50)      NOT NULL,
   cos_price      varchar2(50)      NOT NULL,
   cos_type      varchar2(50)      NOT NULL,
   cos_allergy   varchar2(50)      NULL
);
select*from cosmetic;

CREATE TABLE ingredient (
   igt_id   varchar2(50)      NOT NULL,
   cos_id   varchar2(50)      NOT NULL,
   igt1   varchar2(100)      NOT NULL,
   igt2   varchar2(100)      NOT NULL,
   igt3   varchar2(100)      NOT NULL,
   igt4   varchar2(100)      NOT NULL,
   igt5   varchar2(100)      NOT NULL
);

select * from ingredient;
CREATE TABLE sold_table (
   table_id   varchar2(50)      NOT NULL,
   solddate   varchar2(50)      NOT NULL
);


CREATE TABLE u_cosmetic (
   u_cos_id   varchar2(50)      NOT NULL,
   id         varchar2(50)      NOT NULL,
   cos_id      varchar2(50)      NOT NULL,
   u_cos_date   varchar2(50)      NOT NULL,
   amount      varchar2(50)      NOT NULL,
   u_cos_dead   varchar2(50)      NOT NULL,
   state      varchar2(50)      DEFAULT '»ç¿ëÁß'
);

--select*from member;
--select * from u_cosmetic;
--select*from cosmetic;


ALTER TABLE member ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
   id
);

ALTER TABLE cosmetic ADD CONSTRAINT "PK_COSMETIC" PRIMARY KEY (
   cos_id
);

ALTER TABLE ingredient ADD CONSTRAINT "PK_INGREDIENT" PRIMARY KEY (
   igt_id,
   cos_id
);

ALTER TABLE sold_table ADD CONSTRAINT "PK_SOLD_TABLE" PRIMARY KEY (
   table_id
);

ALTER TABLE u_cosmetic ADD CONSTRAINT "PK_U_COSMETIC" PRIMARY KEY (
   u_cos_id,
   id,
   cos_id
);

ALTER TABLE member ADD CONSTRAINT "FK_sold_table_TO_member_1" FOREIGN KEY (
   table_id
)
REFERENCES sold_table (
   table_id
);

ALTER TABLE ingredient ADD CONSTRAINT "FK_cosmetic_TO_ingredient_1" FOREIGN KEY (
   cos_id
)
REFERENCES cosmetic (
   cos_id
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