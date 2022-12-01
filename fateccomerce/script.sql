--Estrutura de base de dados--
create table brand(
	id_brand serial not null,
	name_brand varchar(256) not null unique,
	description_brand text, /*text não tem limite*/
	constraint pk_brand primary key (id_brand)
);

create table category(
	id_category serial not null,
	name_category varchar(256) not null unique,
	description_category text,
	constraint pk_category primary key (id_category)
);

create table product(
	id_product serial not null,
	name_product varchar(256) not null unique,
	description_product text,
	cost_price_product decimal(15,2),
	sale_price_product decimal(15,2),
	id_brand integer,
	id_category integer,
	constraint pk_product primary key (id_product),
	constraint fk_product_category foreign key (id_category) references category,
	constraint fk_product_brand foreign key (id_brand) references brand
);