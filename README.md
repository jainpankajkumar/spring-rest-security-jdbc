# spring-rest-security-jdbc

1. Create Below two tables - 
  CREATE TABLE "LEARNING"."USERS" 
    (	"USERNAME" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	  "PASSWORD" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	  "ENABLED" NUMBER(1,0) NOT NULL ENABLE, 
	  CONSTRAINT "USERS_PK" PRIMARY KEY ("USERNAME")



  CREATE TABLE "LEARNING"."USER_ROLES" 
    (	"USERNAME" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	  "ROLE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	   CONSTRAINT "USER_ROLES_FK1" FOREIGN KEY ("USERNAME")
	    REFERENCES "LEARNING"."USERS" ("USERNAME") ENABLE
     )
   
 2. Insert data in these two tables - 

Insert into USERS (USERNAME,PASSWORD,ENABLED) values ('pankaj','$2a$10$5BS9MdhaF/zh790crzUoeOZXOo2te9dRJHZgJXcsGwWSHqL/bEzJa',1);
Insert into USERS (USERNAME,PASSWORD,ENABLED) values ('admin','$2a$10$5BS9MdhaF/zh790crzUoeOZXOo2te9dRJHZgJXcsGwWSHqL/bEzJa',1);
Insert into USERS (USERNAME,PASSWORD,ENABLED) values ('employee','$2a$10$5BS9MdhaF/zh790crzUoeOZXOo2te9dRJHZgJXcsGwWSHqL/bEzJa',1);


Insert into USER_ROLES (USERNAME,ROLE) values ('pankaj','ROLE_TECH_LEAD');
Insert into USER_ROLES (USERNAME,ROLE) values ('admin','ROLE_ADMIN');
Insert into USER_ROLES (USERNAME,ROLE) values ('employee','ROLE_EMPLOYEE');

3. modify db.properties with DB details - 

oracle.driver=com.mysql.cj.jdbc.Driver
oracle.jdbcUrl=jdbc:oracle:thin:@localhost:1521:orcl
oracle.username=learning
oracle.password=learning
