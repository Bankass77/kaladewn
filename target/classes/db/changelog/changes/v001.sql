CREATE TABLE school ( schoolId bigint NOT NULL AUTO_INCREMENT , name
varchar ( 255 ) NOT NULL , city varchar ( 255 ) NOT NULL , codePostale
varchar ( 255 ) NOT NULL , Country varchar ( 255 ) NOT NULL , Street
varchar ( 255 ) NOT NULL , streetNumber varchar ( 255 ) NOT NULL ,
phoneNumber varchar ( 255 ) DEFAULT NULL , email varchar ( 255 ) DEFAULT
NULL , PRIMARY KEY ( schoolId ) ) ;


 CREATE TABLE student ( userId bigint
NOT NULL AUTO_INCREMENT , firstName varchar ( 255 ) NOT NULL , createdDate
datetime NOT NULL , modifyDate datetime NOT NULL , gender varchar ( 255 )
NOT NULL , birthDate date NOT NULL , email varchar ( 255 ) NOT NULL ,
lastName varchar ( 255 ) NOT NULL , city varchar ( 255 ) NOT NULL ,
codePostale varchar ( 255 ) NOT NULL , Country varchar ( 255 ) NOT NULL ,
Street varchar ( 255 ) NOT NULL , streetNumber varchar ( 255 ) NOT NULL ,
phoneNumber varchar ( 255 ) DEFAULT NULL , PRIMARY KEY ( userId ) ) ;

INSERT INTO kalandewndb . school ( schoolId , name , city ,
codePostale , Country , Street , streetNumber , phoneNumber , email
VALUES ( 1 , 'Kabral' , 'Bamako' , 999 , 'Mali' , 'Rue Mariam' , 34 , 334868889
, 'afhhgg@example.com' ) ; 

INSERT INTO kalandewndb . student ( userId ,
firstName , createdDate , modifyDate , gender , birthDate , email ,
lastName , city , codePostale , Country , Street , streetNumber ,
phoneNumber )
VALUES (1 ,'rtryytty' , 'ytyuyiuii',now() ,now() , 'M','2022-06-05','gfghgfgj@example.com' ,'fgfhhgjghj' ,'bamako' ,789898 , 'Mali', 'gfhh',6 ,'767785655' )