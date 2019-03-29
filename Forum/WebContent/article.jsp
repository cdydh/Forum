<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
        <!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->
        <!--[if IE 7]>    <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->
        <!--[if IE 8]>    <html class="lt-ie9" lang="en-US"> <![endif]-->
        <!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
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
                                     <a href="#">发布新帖</a>
                             </h1>
                             <hr> 
                     </article>


                     <form id="contact-form" class="row" action="topicServlet" method="post">

                             <div class="span2">
                                     <label for="name">标题</label>
                             </div>
                             <div class="span6">
                                     <input type="text" name="title" id="name" class="required input-xlarge" value="" title="* 请输入标题">
                             </div>
                             <div class="span2">
                                     <label for="reason">板块</label>
                             </div>
                             <div class="span6">
                                     <input type="text" name="boardname" id="reason" class="input-xlarge" value="">
                             </div>

                             <div class="span2">
                                     <label for="message">内容 </label>
                             </div>
                             <div class="span6">
                                     <textarea name="content" id="message" class="required span6" rows="16" title="* 请输入帖子内容"></textarea>
                             </div>

                             <div class="span6 offset2 bm30">
                                     <input type="submit" name="submit" value="发布" class="btn btn-inverse">
                                     <img src="images/loading.gif" id="contact-loader" alt="Loading...">
                             </div>

                     </form>
             </div>
             <!-- end of page content -->
             </div>
             </div>
             </div>
        </body>
</html>

    