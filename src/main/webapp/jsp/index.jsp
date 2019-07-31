<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<%--
	codeServlet中还是设置验证码


--%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>WEB01</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>

		<%--
			动态包含首部
		--%>
		<jsp:include page="/jsp/head.jsp" />

			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：轮播条
            -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${pageContext.request.contextPath}/img/1.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/2.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/3.jpg">
							<div class="carousel-caption">

							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>

				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>

				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>


					<c:forEach items="${requestScope.nList}" var="product" varStatus="abc">
						<c:choose>
							<c:when test="${abc.count mod 3 eq 0}">
								<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
									<a href="${pageContext.request.contextPath}/product?method=findById&pid=${product.pid}">
										<img src="${pageContext.request.contextPath}/${product.pimage}" width="130" height="130" style="display: inline-block;">
									</a>
									<p><a href="${pageContext.request.contextPath}/product?method=findById&pid=${product.pid}" style='color:#666'>${product.pname}</a></p>
									<p><font color="#E4393C" style="font-size:16px">&yen;${product.market_price}</font></p>
								</div>
							</c:when>

							<c:otherwise>
								<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
									<a href="${pageContext.request.contextPath}/product?method=findById&pid=${product.pid}">
										<img src="${pageContext.request.contextPath}/${product.pimage}" width="130" height="130" style="display: inline-block;">
									</a>
									<p><a href="${pageContext.request.contextPath}/product?method=findById&pid=${product.pid}" style='color:#666'>${product.pname}</a></p>
									<p><font color="#E4393C" style="font-size:16px">&yen;${product.market_price}</font></p>
								</div>
							</c:otherwise>
						</c:choose>

					</c:forEach>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：广告部分
            -->
            <div class="container-fluid">
				<img src="${pageContext.request.contextPath}/products/hao/ad.jpg" width="100%"/>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>

					//varStatus="abc"  表示

					<%--
					varStatus="abc"
					current：当前这次迭代的（集合中的）项
					index：当前这次迭代从 0 开始的迭代计数 ${abc.count}  0， 1，2，。。。，8
					count：当前这次迭代从 1 开始的迭代计数 ${abc.count}  如果有9个数据，每次遍历 ${abc.count} 值加1，从1开始 1，2，3，。。。，9
					first：用来表明当前这轮迭代是否为第一次迭代的标志，返回true/false
					last：用来表明当前这轮迭代是否为最后一次迭代的标志,返回true/false

					--%>
					<c:forEach items="${requestScope.hList}" var="product" varStatus="abc">
						<c:choose>
							<c:when test="${abc.count mod 3 eq 0}">
								<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
									<a href="${pageContext.request.contextPath}/product?method=findById&pid=${product.pid}">
										<img src="${pageContext.request.contextPath}/${product.pimage}" width="130" height="130" style="display: inline-block;">
									</a>
									<p><a href="${pageContext.request.contextPath}/product?method=findById&pid=${product.pid}" style='color:#666'>${product.pname}</a></p>
									<p><font color="#E4393C" style="font-size:16px">&yen;${product.market_price}</font></p>
								</div>
							</c:when>

							<c:otherwise>
								<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
									<a href="${pageContext.request.contextPath}/product?method=findById&pid=${product.pid}">
										<img src="${pageContext.request.contextPath}/${product.pimage}" width="130" height="130" style="display: inline-block;">
									</a>
									<p><a href="${pageContext.request.contextPath}/product?method=findById&pid=${product.pid}" style='color:#666'>${product.pname}</a></p>
									<p><font color="#E4393C" style="font-size:16px">&yen;${product.market_price}</font></p>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</div>			
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：页脚部分
            -->
			<div class="container-fluid">
				<div style="margin-top:50px;">
					<img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
				</div>
		
				<div style="text-align: center;margin-top: 5px;">
					<ul class="list-inline">
						<li><a href="info.html">关于我们</a></li>
						<li><a>联系我们</a></li>
						<li><a>招贤纳士</a></li>
						<li><a>法律声明</a></li>
						<li><a>友情链接</a></li>
						<li><a>支付方式</a></li>
						<li><a>配送方式</a></li>
						<li><a>服务声明</a></li>
						<li><a>广告声明</a></li>
					</ul>
				</div>
				<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
					opyright &copy; 2009-202 品优商城 版权所有
				</div>
			</div>
		</div>
			</div>
	</body>

</html>