## 模块描述
尝试利用spring framework 的事务来实现一个服务内部单个数据源的事务管理。

### 结论

1. spring framework 中```@Transactional```注解可以对单数据源进行操作

1. 此时无论数据库设置的 ```autocommit=ON``` or   ````autocommit=OFF```都能实现事务处理
    
1. 将日志级别设置成trace，可以观察到如下事务处理逻辑

    ```$java
    2020-12-03 15:20:54.203 DEBUG 20211 --- [           main] o.s.j.d.DataSourceTransactionManager     : Acquired Connection [HikariProxyConnection@1154759881 wrapping com.mysql.cj.jdbc.ConnectionImpl@6f07d414] for JDBC transaction
    2020-12-03 15:20:54.213 DEBUG 20211 --- [           main] o.s.j.d.DataSourceTransactionManager     : Switching JDBC Connection [HikariProxyConnection@1154759881 wrapping com.mysql.cj.jdbc.ConnectionImpl@6f07d414] to manual commit
    2020-12-03 15:20:54.218 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Bound value [org.springframework.jdbc.datasource.ConnectionHolder@4e94669c] for key [HikariDataSource (mysql_chengf)] to thread [main]
    2020-12-03 15:20:54.218 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Initializing transaction synchronization
    2020-12-03 15:23:01.059 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Bound value [org.mybatis.spring.SqlSessionHolder@5a06904] for key [org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@6481dce5] to thread [main]
    2020-12-03 15:23:01.534 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Retrieved value [org.springframework.jdbc.datasource.ConnectionHolder@4e94669c] for key [HikariDataSource (mysql_chengf)] bound to thread [main]
    2020-12-03 15:23:01.536 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Retrieved value [org.springframework.jdbc.datasource.ConnectionHolder@4e94669c] for key [HikariDataSource (mysql_chengf)] bound to thread [main]
    2020-12-03 15:23:01.539 DEBUG 20211 --- [           main] o.m.s.t.SpringManagedTransaction         : JDBC Connection [HikariProxyConnection@1154759881 wrapping com.mysql.cj.jdbc.ConnectionImpl@6f07d414] will be managed by Spring
    2020-12-03 15:23:01.623 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Retrieved value [org.springframework.jdbc.datasource.ConnectionHolder@4e94669c] for key [HikariDataSource (mysql_chengf)] bound to thread [main]
    2020-12-03 15:23:01.627 DEBUG 20211 --- [           main] c.c.t.singledb.dao.UserMapper.insert     : ==>  Preparing: INSERT INTO t_user ( name, age ) VALUES ( ?, ? ) 
    2020-12-03 15:23:02.069 DEBUG 20211 --- [           main] c.c.t.singledb.dao.UserMapper.insert     : ==> Parameters: cc6(String), 20(Integer)
    2020-12-03 15:23:02.098 DEBUG 20211 --- [           main] c.c.t.singledb.dao.UserMapper.insert     : <==    Updates: 1
    2020-12-03 15:23:02.099 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Retrieved value [org.mybatis.spring.SqlSessionHolder@5a06904] for key [org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@6481dce5] bound to thread [main]
    2020-12-03 15:23:02.100 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Retrieved value [org.mybatis.spring.SqlSessionHolder@5a06904] for key [org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@6481dce5] bound to thread [main]
    2020-12-03 15:23:02.103 DEBUG 20211 --- [           main] org.mybatis.spring.SqlSessionUtils       : Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1805383]
    2020-12-03 15:23:24.190 TRACE 20211 --- [           main] o.s.t.i.TransactionInterceptor           : Completing transaction for [com.chengf.transaction.singledb.service.DbService.commit] after exception: java.lang.RuntimeException: department id is null
    2020-12-03 15:23:24.192 TRACE 20211 --- [           main] o.s.t.i.RuleBasedTransactionAttribute    : Applying rules to determine whether transaction should rollback on java.lang.RuntimeException: department id is null
    2020-12-03 15:23:24.193 TRACE 20211 --- [           main] o.s.t.i.RuleBasedTransactionAttribute    : Winning rollback rule is: RollbackRuleAttribute with pattern [java.lang.Exception]
    2020-12-03 15:23:24.195 TRACE 20211 --- [           main] o.s.j.d.DataSourceTransactionManager     : Triggering beforeCompletion synchronization
    2020-12-03 15:23:24.204 DEBUG 20211 --- [           main] org.mybatis.spring.SqlSessionUtils       : Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1805383]
    2020-12-03 15:23:24.206 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Removed value [org.mybatis.spring.SqlSessionHolder@5a06904] for key [org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@6481dce5] from thread [main]
    2020-12-03 15:23:24.213 DEBUG 20211 --- [           main] org.mybatis.spring.SqlSessionUtils       : Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1805383]
    2020-12-03 15:23:24.217 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Retrieved value [org.springframework.jdbc.datasource.ConnectionHolder@4e94669c] for key [HikariDataSource (mysql_chengf)] bound to thread [main]
    2020-12-03 15:23:24.218 DEBUG 20211 --- [           main] o.s.j.d.DataSourceTransactionManager     : Initiating transaction rollback
    2020-12-03 15:23:24.220 DEBUG 20211 --- [           main] o.s.j.d.DataSourceTransactionManager     : Rolling back JDBC transaction on Connection [HikariProxyConnection@1154759881 wrapping com.mysql.cj.jdbc.ConnectionImpl@6f07d414]
    2020-12-03 15:23:24.245 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Clearing transaction synchronization
    2020-12-03 15:23:24.247 TRACE 20211 --- [           main] o.s.j.d.DataSourceTransactionManager     : Triggering afterCompletion synchronization
    2020-12-03 15:23:24.249 TRACE 20211 --- [           main] .s.t.s.TransactionSynchronizationManager : Removed value [org.springframework.jdbc.datasource.ConnectionHolder@4e94669c] for key [HikariDataSource (mysql_chengf)] from thread [main]
    2020-12-03 15:23:24.269 DEBUG 20211 --- [           main] o.s.j.d.DataSourceTransactionManager     : Releasing JDBC Connection [HikariProxyConnection@1154759881 wrapping com.mysql.cj.jdbc.ConnectionImpl@6f07d414] after transaction
    ```
   
    在```DataSourceTransactionManager#doBegin```方法中，会调用```con.setAutoCommit(false)```,将本连接设置成非自动commit，等事务结束时还会数据库连接池时再转换成自动commit。
    