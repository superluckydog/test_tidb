Docker安装MySQL
https://www.jianshu.com/p/d6febf6f95e0

https://pingcap.com/docs-cn/dev/how-to/get-started/deploy-tidb-from-docker-compose/

mysql -h 172.18.0.1 -P 4000 -u root
mysql -h 172.18.0.1 -P 4000 -u test -p
tidb_learner

GRANT ALL PRIVILEGES ON *.* TO 'xxx'@'%';

CREATE USER 'test'@'172.18.0.1' IDENTIFIED BY 'tidb_learner';

CREATE USER 'test'@'%' IDENTIFIED BY 'tidb_learner';

GRANT ALL PRIVILEGES ON *.* TO 'test'@'%' WITH GRANT OPTION;
