CREATE TABLE category
  (
     id          IDENTITY,
     name        VARCHAR(50),
     description VARCHAR(255),
     image_url   VARCHAR(50),
     active_ind  BOOLEAN,
     CONSTRAINT pk_category_id PRIMARY KEY (id)
  );   
  
  INSERT INTO category(name,description,image_url,active_ind) VALUES ('Laptop','This is description of Laptop','CAT_1.png',true);
  INSERT INTO category(name,description,image_url,active_ind) VALUES ('Mobile','This is description of Mobile','CAT_2.png',true);
  INSERT INTO category(name,description,image_url,active_ind) VALUES ('Television','This is description of tv','CAT_3.png',true);
  
  CREATE TABLE user_detail
  (
     id             IDENTITY,
     first_name     VARCHAR(50),
     last_name      VARCHAR(50),
     ROLE           VARCHAR(50),
     active_ind     BOOLEAN,
     password       VARCHAR(50),
     email          VARCHAR(100),
     contact_number VARCHAR(12),
     CONSTRAINT pk_user_id PRIMARY KEY (id)
  );  
  
  INSERT INTO user_detail (first_name, last_name ,role,active_ind ,password, email ,contact_number) 
                   VALUES ('RAMESH','ARVIND','ADMIN',true,'admin','ramesh.arvind@gmail.com','9004800912');
  INSERT INTO user_detail (first_name, last_name ,role,active_ind ,password, email ,contact_number) 
                   VALUES ('PRAKASH','RAJ','SUPPLIER',true,'12345','prakash.raj@gmail.com','9004800914');  
  INSERT INTO user_detail (first_name, last_name ,role,active_ind ,password, email ,contact_number) 
                   VALUES ('ARJUN','RAMPAL','SUPPLIER',true,'12345','arjun.rampal@gmail.com','9004800916');                  
                   
 
 CREATE TABLE product
  (
     id          IDENTITY,
     code        VARCHAR(50),
     name        VARCHAR(50),
     brand       VARCHAR(50),
     description VARCHAR(255),
     unit_price  DECIMAL (10, 2),
     quantity    INT,
     active_ind  BOOLEAN,
     category_id INT,
     supplier_id INT,
     purchases   INT DEFAULT 0,
     views       INT DEFAULT 0,
     CONSTRAINT pk_product_id PRIMARY KEY (id),
     CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category (id),
     CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id)
  );                    
             
 INSERT INTO product (code,name, brand, description, unit_price, quantity, active_ind ,category_id ,supplier_id) VALUES
 ('PRDABC123DEFX','iPhone X','Apple','Built in Voice Recorder',32000,12,true,2,2);
 
 INSERT INTO product (code,name, brand, description, unit_price, quantity, active_ind ,category_id ,supplier_id) VALUES
 ('PRDABZ123DEFX','PULSE IX','VIDEOCON','Built in GPS MAP',17000,34,true,2,2);
 
 INSERT INTO product (code,name, brand, description, unit_price, quantity, active_ind ,category_id ,supplier_id) VALUES
 ('PRDABY123DEFX','MI NOTE 5','Xiomi','Built in Video Recorder',12000,72,true,2,3);
 
  INSERT INTO product (code,name, brand, description, unit_price, quantity, active_ind ,category_id ,supplier_id) VALUES
 ('PRDAWY123DEFX','THUNDER','ONIDA','CURVED SCREEN',42000,32,true,3,3);
 
  INSERT INTO product (code,name, brand, description, unit_price, quantity, active_ind ,category_id ,supplier_id) VALUES
 ('PRDQBY123DEFX','BRAVIA','SONY','HD video',72000,23,true,3,2);
 
  INSERT INTO product (code,name, brand, description, unit_price, quantity, active_ind ,category_id ,supplier_id) VALUES
 ('PRDQBY123DESX','LENOVO SLIM','LENOVO','HIGH PERFORMANCE',72000,21,true,1,2);
 
  INSERT INTO product (code,name, brand, description, unit_price, quantity, active_ind ,category_id ,supplier_id) VALUES
 ('PRDQBY133DEFW','INSPIRON','DELL','GOOD DESIGN',82000,13,true,1,3);
 
 
 
 
 
 
 
 
 
 
 
                   
  