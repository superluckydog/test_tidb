https://www.awaimai.com/2587.html
Docker安装MySQL
https://www.jianshu.com/p/d6febf6f95e0

docker exec -it mysql bash



https://pingcap.com/docs-cn/dev/how-to/get-started/deploy-tidb-from-docker-compose/

mysql -h 172.18.0.1 -P 4000 -u root
mysql -h 172.18.0.1 -P 4000 -u test -p
tidb_learner

GRANT ALL PRIVILEGES ON *.* TO 'xxx'@'%';

CREATE USER 'test'@'172.18.0.1' IDENTIFIED BY 'tidb_learner';

CREATE USER 'test'@'%' IDENTIFIED BY 'tidb_learner';

GRANT ALL PRIVILEGES ON *.* TO 'test'@'%' WITH GRANT OPTION;


程序入口 CompareWithMysql


程序实现问题：
结果验证方法2：
1.与MYSQL同步比较结果 没有调试 MYSQL服务有问题
2.与内存数据比较结果  数据量小时候可以 没有落盘比较
3.JSON格式数据中文乱码 没有解决掉
4.只实现了SELECT /DELETE   UPDATE没有完成
没有加入函数等操作
