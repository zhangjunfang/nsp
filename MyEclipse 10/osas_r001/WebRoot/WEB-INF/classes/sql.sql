CREATE DATABASE IF NOT EXISTS testdb_a    DEFAULT CHARACTER SET utf8;

USE testdb_a;

DROP TABLE IF EXISTS tab_a;

CREATE TABLE tab_a (
    id bigint(20) NOT NULL,
    name varchar(60) DEFAULT NULL,
    address varchar(120) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE DATABASE IF NOT EXISTS testdb_b    DEFAULT CHARACTER SET utf8;

USE testdb_b;

DROP TABLE IF EXISTS tab_b;

CREATE TABLE tab_b (
    id bigint(20) NOT NULL,
    name varchar(60) DEFAULT NULL,
    address varchar(120) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 