# 用于配置tables

# 将id设置为主键
ALTER TABLE config ADD CONSTRAINT pk_category_id PRIMARY KEY (id);
ALTER TABLE category ADD CONSTRAINT pk_category_id PRIMARY KEY (id);
ALTER TABLE record ADD CONSTRAINT pk_category_id PRIMARY KEY (id);

# 设置id的自增长
ALTER TABLE config CHANGE id id INT AUTO_INCREMENT;
ALTER TABLE category CHANGE id id INT AUTO_INCREMENT;
ALTER TABLE record CHANGE id id INT AUTO_INCREMENT;

# 添加外键约束
ALTER TABLE record ADD CONSTRAINT fk_record_category FOREIGN KEY (category_id) REFERENCES category (id);
