
//@One to One mapping
create table instructor(
id int AUTO_INCREMENT,
    first_name varchar(40),
    last_name varchar(40),
    email varchar(40),
    inst_id int,
    PRIMARY KEY(id),
    foreign key(inst_id)
        references instructor_details(inst_id)
);

create table instructor_details(
inst_id int AUTO_INCREMENT,
    youtube_channel varchar(128) ,
    hobby varchar(45) ,   
    primary key(inst_id)
);

//@OneToManyMapping:

create table course(
id int AUTO_INCREMENT,
    title varchar(40),
    inst_id int,
    PRIMARY KEY(id),
    foreign key(inst_id)
        references instructor(id) ON UPDATE CASCADE ON DELETE RESTRICT
);


//ManyToMany

create table student(
id int AUTO_INCREMENT,
    title varchar(40),
    inst_id int,
    PRIMARY KEY(id),
    foreign key(inst_id)
        references instructor(id) ON UPDATE CASCADE ON DELETE RESTRICT
);

create table customer (
id int AUTO_INCREMENT,
    first_name varchar(20),
    last_name varchar(20),
    email varchar(20),
    primary key(id)
);
INSERT INTO `customer`(`first_name`, `last_name`, `email`) VALUES ("Vihu","Gore","vihaan@gmail.com")