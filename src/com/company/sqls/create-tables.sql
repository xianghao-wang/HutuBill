/*
    用于创建所需要的表格
*/

USE hutubill;

/* 存储配置基本配置信息 */
CREATE TABLE config (
    id INT,
    key_ VARCHAR (255),
    value VARCHAR (255)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

/* 存储消费的种类 */
CREATE TABLE category (
    id INT,
    name VARCHAR (255) # 分类的名称
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

/* 存储消费记录 */
CREATE TABLE record (
    id INT,
    spend INT, # 消费金额
    category_id INT, # 分类的id
    comment VARCHAR (255),
    date DATE # 消费日期
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


