### 基于Java企业级应用开发进行Forum模拟实现
以**MVC设计结构**为基础，以**JavaBean**的形式对**DAO**层中的*board,Reply,topic,user*等进行封装，**Entity**中包含*Board,Reply,Topic,User*.Service层中包含*BoardService,ReplyService,TopicService,UserService*等**。通过servlet处理请求和响应**,使用**JDBC实现对数据的访问**
#### 功能包含
- 登录验证
- 权限设置
- 发帖
- 回帖
- 帖子删除
- 用户界面
- 帖子查询
