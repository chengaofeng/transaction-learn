## 模块描述
1. 本模块利用alibaba 开源的分布式事务组件 [seata](http://seata.io/en-us/)对多数据源进行事务处理

1. 例子参考[multiple-datasource-mybatis-plus](https://github.com/seata/seata-samples/tree/master/multiple-datasource-mybatis-plus)


## 结论
1. 利用seata可以实现多数据源事务处理
2. 能和```mybatis-plus（baomidou）```的多数据源组件完美结合```@DS```
3. seata利用```undo log ```实现数据回滚操作，所以参与事务的表必须要有index（主键）