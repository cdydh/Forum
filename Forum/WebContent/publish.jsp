<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!doctype html>
<head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0">                
      <link rel='stylesheet' id='bootstrap-css-css'  href='css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
      <link rel='stylesheet' id='main-css-css'  href='css/main5152.css?ver=1.0' type='text/css' media='all' />     
<style>
.div{margin:0 auto; width:620px; border:1px solid #fff"}
</style>
</head>
<body>     
<div  class="div">          
       <section class="span4 articles-list">
            <h3>帖子列表</h3>
            <ul class="articles">
            <li class="article-entry standard">
            <form  action="article.jsp"><span class="like-count"><input type="submit" value="发帖" ></span></form>
            </li>
            	  <c:forEach items="${topictemp}" var="topic">
                  <li class="article-entry standard">
                          <h4><a href="">${topic.title}</a></h4>
                          <span class="article-meta">${topic.postTime}<a href="single.html" title="View all posts in Server &amp; Database">Server &amp; Database</a></span>
                          <span class="like-count1"><a href="replyshowServlet?${topic.topicId}">点击帖子查看</a></span>
                          <span class="like-count">66点赞</span>
                  </li>
                  </c:forEach>
            </ul>
       </section>
</div>
</body>
</html>

