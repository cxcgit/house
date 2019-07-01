<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Object o = session.getAttribute("user");
  if (o==null){
      out.print("<script>alert('你还没有登录或登录超时,请重新登录');" +
              "location.href='/page/login.jsp';</script>");
  }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
  <script type="text/javascript" src="../../admin/js/jquery-1.8.3.js"></script>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</HEAD>
<BODY>
<DIV id=header class=wrap>
  <DIV id=logo><IMG src="../../images/logo.gif"></DIV><h4 align="right">【欢迎${user.name}】<a href="/page/house/selectByUsersId?isdel=0">房屋信息管理</a></h4></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=/page/house/selectAll?ispass=1&isdel=0>
  <DT>
  <UL>
    <LI class=bold>房屋信息</LI>
    <LI>标题：<INPUT class=text type=text name=title value="${houseCondition.title}">
    </LI></UL></DT>
  <DD>
  <UL>
    <LI class=first>价格 </LI>
    <LI><SELECT name=priceScope>
      <OPTION selected value=""  <c:if test="${houseCondition.priceScope==''}">selected</c:if>>不限</OPTION>
      <OPTION value=0-3000  <c:if test="${houseCondition.priceScope=='0-3000'}">selected</c:if>>3000元以下</OPTION>
      <OPTION value=3000-8000  <c:if test="${houseCondition.priceScope=='3000-8000'}">selected</c:if>>3000—8000元</OPTION>
      <OPTION value=8000-1000000  <c:if test="${houseCondition.priceScope=='8000-1000000'}">selected</c:if>>8000元以上
      </OPTION>
    </SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房屋位置</LI>
    <LI><SELECT id=street name=streetId>
      <OPTION value="" <c:if test="${houseCondition.streetId==''}">selected</c:if>>不限</OPTION>
      <c:forEach items="${streetList}" var="street">
        <option value=${street.id} <c:if test="${houseCondition.streetId==street.id}">selected</c:if>> ${street.name} </option>
      </c:forEach>
    </SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房型</LI>
    <LI><SELECT name=typeId>
      <OPTION value=""  <c:if test="${houseCondition.typeId==''}">selected</c:if>>不限</OPTION>
      <c:forEach items="${typeList}" var="type">
        <option value=${type.id} <c:if test="${houseCondition.typeId==type.id}">selected</c:if>> ${type.name} </option>
      </c:forEach>
    </SELECT></LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>面积 </LI>
    <LI><SELECT name=floorageScope>
      <OPTION selected value=""  <c:if test="${houseCondition.floorageScope==''}">selected</c:if>>不限</OPTION>
      <OPTION value=0-40  <c:if test="${houseCondition.floorageScope=='0-40'}">selected</c:if>>40以下</OPTION>
      <OPTION value=40-100  <c:if test="${houseCondition.floorageScope=='40-100'}">selected</c:if>>40-100</OPTION>
      <OPTION value=100-1000000  <c:if test="${houseCondition.floorageScope=='100-1000000'}">selected</c:if>>100以上</OPTION>
    </SELECT> </LI></UL></DD>
    <DD>
      <UL>
        <LI><input type="hidden" name="page" id="page" value="${pageInfo.pageNum}"></LI>
        <LI><LABEL class=ui-blue><INPUT value=搜索房屋 type=submit></LABEL></LI>
      </UL>
    </DD>
  </FORM></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${pageInfo.list}" var="house">
    <TR>
    <TD class=house-thumb><span><A href="/page/house/selectOne?id=${house.id}" target="_blank"><img src="http://localhost/${house.path}" width="100" height="75" alt=""></a></span></TD>
    <TD>
    <DL>
    <DT><A href="/page/house/selectOne?id=${house.id}" target="_blank">${house.title}</A></DT>
    <DD>${house.dname}区${house.sname},${house.floorage}平米<BR>联系方式：${house.contact} </DD></DL></TD>
    <TD class=house-type>${house.tname}</TD>
    <TD class=house-price><SPAN>${house.price}</SPAN>元/月</TD>
    </TR>
  </c:forEach>
  </TBODY>
</TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:toPage(1)">首页</A></LI>
  <LI><A href="javascript:toPage(${pageInfo.prePage})">上一页</A></LI>
  <LI><A href="javascript:toPage(${pageInfo.nextPage})">下一页</A></LI>
  <LI><A href="javascript:toPage(${pageInfo.pages})">末页</A></LI></UL><SPAN
class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
</BODY>
<script type="text/javascript">
  function toPage(page) {
    $("#page").val(page);
    $("#sform").submit();
  }
</script>
</HTML>
