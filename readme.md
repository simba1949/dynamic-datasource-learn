# 动态数据源配置

# 实现多数据源方式
1. base-simple-datasource 简易实现
2. base-abstract-routing-datasource 基于 AbstractRoutingDataSource 实现
3. base-multi-mybatis-datasource 基于集成多个 MyBatis 实现

# 切换多数据源方式
1. base-mybatis-interceptor-switch-datasource：基于 MyBatis 插件方式实现（只适用于读写分离的方式）
2. base-aop-switch-datasource：基于 spring aop 切面实现

# dynamic-datasource
dynamic-datasource 实现多数据源及切换：base-dynamic-datasource