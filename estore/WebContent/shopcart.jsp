<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--文件头开始-->
<jsp:include page="header.jsp"></jsp:include>

<!--文件体开始-->

<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
	<tr>
		<td height=25 valign=middle><img src="images/Forum_nav.gif"
			align="middle"> <a href=index.jsp>杰普电子商务门户</a> → <img
			border="0" src="images/dog.gif" width="19" height="18"> 购物清单</td>
	</tr>
</table>
<br>

<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
	<tr>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>序号</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>产品名称</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>价格</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>数量</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>合计</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>操作</b></font></td>
	</tr>

		<c:forEach items="${lineList }" var="list">
			<c:if test="${list!=null }">
				<tr>
					<form method="post" action="AddOrderLineServlet" name="f1">
						<input type="hidden" name="bookid" value="${list.book.id }">
						<td class=tablebody2 valign=middle align=center width="">${list.id }</td>
						<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a
							href="productDetail.jsp?productid=2">${list.book.name }</a></td>
						<td class=tablebody2 valign=middle align=center width="">${list.book.price }</td>
						<td class=tablebody1 valign=middle align=center width=""><input
							type="text" name="num" value="${list.num }" size="4"
							onblur="javascript:if(this.value<1){alert('对不起，产品数量不能小于 1 ');this.focus();}else{number.value=this.value;}" />
						</td>
						<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;￥${list.book.price*list.num }</td>
						<td class=tablebody1 valign=middle align=center width=""><input
							type="button" value="取消"
							onclick="javascript:window.location='RemoveLineServlet?id=${list.book.id}';"> <input
							type="submit" value="保存修改"></td>
					</form>
				</tr>
			</c:if>
		</c:forEach>
		
		<tr>
		<td class=tablebody1 valign=middle align=center colspan="4"></td>
		<td class=tablebody1 valign=middle align=left width="">&nbsp;&nbsp;<font
			color="#ff0000"><b>￥${cost }</b></font></td>
		<td class=tablebody1 valign=middle align=center width=""></td>
	</tr>	
	
	<tr>
		<td class=tablebody2 valign=middle align=center colspan="6"><input
			type="button" value="提交订单"
			onclick="javascript:window.location='ConfirmOrderServlet';"> <input
			type="button" value="继续购物"
			onclick="javascript:window.location='index.jsp';"> <input
			type="button" value="清空购物车"
			onclick="javascript:window.location='ClearShopCarServlet';">
		</td>
	</tr>
</table>
<br>
<!--文件尾开始-->
<jsp:include page="footer.jsp"></jsp:include>
