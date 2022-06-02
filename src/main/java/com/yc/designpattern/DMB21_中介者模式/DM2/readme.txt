需求说明: 有三种数据库 Mysql、Redis、Elasticsearch，
    1. Mysql 作为主数据库(支持事务处理） ，当增加一条数据时需要同步到另外两个数据库中；
    2. Redis 作为缓存数据库， 有缓存功能cache(),  当增加一条数据时不需要同步到另外另个数据库；
    3. Elasticsearch 作为大数据查询数据库，有一个统计功能count()，当增加一条数据时只需要同步到 Mysql