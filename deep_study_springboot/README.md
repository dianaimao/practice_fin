## JPA配置
实体类   
+ @Entity  标注实体类
+ @Table()  数据库表名
+ @Id id
+ @GeneratedValue(strategy = GenerationType.IDENTITY) 自增
+ @ManyToOne
+ @JoinColumn(name="did")  //数据库字段did表示 id
+ @JsonBackReference   //防止关系对象的递归回调
+  @ManyToMany  //中间表 对于多对多关系
+  @JoinTable(name="user_role",
      joinColumns = {@JoinColumn(name="user_id")},  过去该实体类表id
      inverseJoinColumns = {@JoinColumn(name="role_id")})   相对的id
### repository  资源持久化 继承JpaRepository接口  可自定义声明方法
### JPA配置类   启用定义接口资源库  定义实体的位置
### use     可生产spring data中的Pageable对象（PageRequest
.of生成）根据页数 /单页数量/排序方式/根据指定字段排序