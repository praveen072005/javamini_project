use testdb;
create table category(
/* primary key
primary key na no  two rows have same values,
unique irukkanum values elloam ,
oru table multiple primary key irukkalam athuku peru composite primary key,
primary key la null alue irukka kudathu 
   */
id int primary key auto_increment,
/* varchar
varchar -variable length string (store txt,number,symbols)
*/
name varchar(255) not null
);
create table product(
id int primary key auto_increment,
name varchar(256)not null,
model_number varchar(500),
image_url varchar(600),
category_id int,
/*  foreign key
oru table refers to another table ,
create the reationshp btw two table,
foreign key vlue provide the column value of parent table is linked to the 
child table of  values,
reference use pannuvanga
*/
foreign key(category_id) references category(id)
);


insert into category(name) values
('Rings'),
 ('Necklaces'),
 ('Bracelets');
insert into  product (name, model_number, image_url, category_id) values
('Gold Ring', 'GR-101', 'https://example.com/ring1.jpg', 1),
('Diamond Ring', 'DR-202', 'https://example.com/ring2.jpg', 1),
('Pearl Necklace', 'PN-303', 'https://example.com/necklace1.jpg', 2),
('Silver Bracelet', 'SB-404', 'https://example.com/bracelet1.jpg', 3);

select * from product;	

select * from category;

-- Add jewel_type_id to category table
ALTER TABLE category ADD COLUMN jewel_type_id INT;

-- Example categories linked to jewel types
INSERT INTO category(name, jewel_type_id) VALUES
('Snake Design Ring', 1),
('Classic Ring', 1),
('Choker Necklace', 2),
('Long Necklace', 2),
('Bangle Bracelet', 3),
('Charm Bracelet', 3);


UPDATE product
SET 
category_id=case
when id = 3 then  4
when id = 4 then  4
end,
image_url= case
when id = 3 then '/images/ring3.jpg'
when id = 4 then '/images/ring4.webp'
end,
name=case
when id = 3 then 'ring1'
when id = 4 then  'ring2'
end
where id in (3,4);




