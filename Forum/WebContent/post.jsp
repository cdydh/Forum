<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!doctype html>
<head>
     <!-- META TAGS -->
     <meta charset="UTF-8" />
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Style Sheet-->
     <link rel="stylesheet" href="style.css"/>
     <link rel='stylesheet' id='bootstrap-css-css'  href='css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
     <link rel='stylesheet' id='responsive-css-css'  href='css/responsive5152.css?ver=1.0' type='text/css' media='all' />
     <link rel='stylesheet' id='pretty-photo-css-css'  href='js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
     <link rel='stylesheet' id='main-css-css'  href='css/main5152.css?ver=1.0' type='text/css' media='all' />
     <link rel='stylesheet' id='custom-css-css'  href='css/custom5152.html?ver=1.0' type='text/css' media='all' />


     <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
     <!--[if lt IE 9]>
     <script src="js/html5.js"></script></script>
     <![endif]-->
</head>
        <body>

                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 page-content">

                                                <article class="type-page hentry clearfix">
                                                        <h1 class="post-title">
                                                                <a href="">${titletemp}</a>
                                                        </h1>
                                                        <hr>
                                                        </article>


                                                <form id="contact-form" class="row" action="replyServlet?${topicidtemp}" method="post">
                                                        <div class="span2">
                                                                <label for="message">帖子内容 <span>*</span> </label>
                                                        </div>
                                                        <div class="span6">
                                                        <label for="message">
                                                       		${contenttemp}</br></br></br></br></br>
														</label>
                                                        </div> 
									<c:forEach items="${replytemp}" var="reply">
									   	<div class="span2">
									           <label for="message">用户评论 <span>*</span> </label>
									   	</div>
									   	<div class="span6">
									  			<label for="message">${reply.content}</label>  
									   	</div>
									   	<div class="span2">
									           <label for="message">评论时间 <span>*</span> </label>
									   	</div>
									   	<div class="span6">
									  			<label for="message">${reply.replyTime}</label>  
									    </div>
									</c:forEach>
                                                         <div class="span2">
                                                                <label for="message">添加评论 <span>*</span> </label>
                                                        </div>
                                                        <div class="span6">
                                                                <textarea name="content" id="message" class="required span6" rows="4"></textarea>
                                                        </div>

                                                        <div class="span6 offset2 bm30">
                                                                <input type="submit" name="message" value="发布评论" class="btn btn-inverse">
                                                                <img src="images/loading.gif" id="contact-loader">
                                                        </div>

                                                </form>
                                        </div>
                                        <!-- end of page content -->


                                        <!-- start of sidebar -->
                                        <div class="span4 page-sidebar">

                                                <section class="widget">
                                                        <div class="support-widget">
                                                                <h3 class="title">作者信息</h3>
                                                                <p class="intro">该贴作者为${username}，该贴回复数为${replynumbertemp}。</p>
                                                        </div>
                                                </section>

                                                <section class="widget">
                                                        <h3 class="title">其他帖子</h3>
                                                        <c:forEach items="${topiclisttemp}" var="topic" begin="0" end="4" step="1">
	                                                        <ul class="articles">
	                                                                <li class="article-entry standard">
	                                                                        <h4><a href="">${topic.title}</a></h4>
	                                                                        <span class="article-meta">${topic.postTime}</span>
	                                                                        <span class="like-count"><%
																										double number=Math.random()*100;
																				 						out.print((int)number);
																									%>赞
																			</span>
	                                                                </li>
	                                                        </ul>
                                                        </c:forEach>
                                                </section>


                                        </div>
                                        <!-- end of sidebar -->
                                </div>
                        </div>
                </div>
                <!-- End of Page Container -->    
        </body>
        <foot>
        <!-- Footer Bottom -->
                      
                                <div id="footer-bottom" class="container">
                                        <div class="row">
                                                
                                                <center>
                                                <p class="copyright">
                                                	关于我们 |
                        						 	免责声明 |
                        						 	广告合作 | 
                        						 	知识产权 | 
                        						 	支付方式 | 
                        						 	联系方式 |
                        						 	加入我们
								            Github论坛 © 2019. JavaEE-Web BBS项目    版权所有
                                                        </p>
                                                        </center>
                                                
                                        </div>
                                </div>
        </foot>
</html>


