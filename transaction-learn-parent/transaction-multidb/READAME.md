## 模块描述
尝试利用spring framework 的事务来实现多数据源的事务管理。

## 结论

1. spring framework 中```@Transactional```注解只能对单数据源进行操作

1. 当采用

```
<groupId>com.baomidou</groupId>
<artifactId>dynamic-datasource-spring-boot-starter</artifactId>
            
```

多数据源功能时，会利用primary数据源进行事务封装处理,所以多数据源时，单纯利用spring的事务处理功能，已经不能满足需求