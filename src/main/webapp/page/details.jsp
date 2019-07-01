<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Object o = session.getAttribute("user");
  if (o==null){
    out.print("<script>alert('你还没有登录或登录超时,请重新登录');" +
            "location.href='/page/login.jsp';</script>");
  }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
</HEAD>
<BODY>

<DIV id=header class=wrap>
<DIV id=logo><IMG src="../../images/logo.gif"></DIV>
  <DIV class=search>【欢迎${user.name}】
    <LABEL class="ui-green searchs"><a href="/page/house/selectAll?ispass=1&isdel=0" title="">返回</a></LABEL>
    <LABEL class=ui-green><INPUT onclick='document.location="../login.jsp"' value="退       出" type=button name=search></LABEL>
  </DIV>
<%--<DIV class=search>--%>
<%--<FORM method=get>--%>
  <%--<INPUT class=text type=text name=keywords>--%>
 <%--<LABEL class="ui-green searchs"><a href="list.jsp" target="_blank">搜索房屋</a></LABEL>--%>
<%--</FORM>--%>
  <%----%>
<%--</DIV>--%>
</DIV>
<%--<DIV id=navbar class=wrap>--%>
<%--<DL class="search clearfix">--%>
  <%--<FORM id=sform method=post action=search.action>--%>
  <%--<DT>--%>
  <%--<UL>--%>
    <%--<LI class=bold>房屋信息</LI>--%>
    <%--<LI>标题：<INPUT class=text type=text name=title> <LABEL class=ui-blue><INPUT onclick=doSearch() value=搜索房屋 type=button name=search></LABEL> --%>
    <%--</LI></UL></DT>--%>
  <%--<DD>--%>
  <%--<UL>--%>
    <%--<LI class=first>价格 </LI>--%>
    <%--<LI><SELECT id=price name=price> <OPTION selected value="">不限</OPTION> --%>
      <%--<OPTION value=0-100>100元以下</OPTION> <OPTION --%>
      <%--value=100-200>100元—200元</OPTION> <OPTION --%>
    <%--value=200-1000000>200元以上</OPTION></SELECT> </LI></UL></DD>--%>
  <%--<DD>--%>
  <%--<UL>--%>
    <%--<LI class=first>房屋位置</LI>--%>
    <%--<LI><SELECT id=street name=street_id>--%>
      <%--<OPTION selected value="">不限</OPTION>--%>
      <%--<c:forEach items="${streetList}" var="street">--%>
        <%--<option value=${street.id}> ${street.name} </option>--%>
      <%--</c:forEach>--%>
    <%--</SELECT></LI></UL></DD>--%>
  <%--<DD>--%>
  <%--<UL>--%>
    <%--<LI class=first>房型</LI>--%>
    <%--<LI><SELECT id=housetype name=type_id>--%>
      <%--<OPTION selected value="">不限</OPTION>--%>
      <%--<c:forEach items="${typeList}" var="type">--%>
        <%--<option value=${type.id}> ${type.name} </option>--%>
      <%--</c:forEach>--%>
    <%--</SELECT></LI></UL></DD>--%>
  <%--<DD>--%>
  <%--<UL>--%>
    <%--<LI class=first>面积 </LI>--%>
    <%--<LI><SELECT id=floorage name=floorage> <OPTION selected --%>
      <%--value="">不限</OPTION> <OPTION value=0-40>40以下</OPTION> <OPTION --%>
      <%--value=40-500>40-500</OPTION> <OPTION --%>
    <%--value=500-1000000>500以上</OPTION></SELECT> </LI></UL></DD></FORM></DL></DIV>--%>
<DIV id=position class=wrap>当前位置：青鸟租房网 - 浏览房源</DIV>
<DIV id=view class="main wrap">
<DIV class=intro>
<DIV class=lefter>
<H1>${houseExt.title}</H1>
<DIV class=subinfo><f:formatDate value="${houseExt.pubdate}" pattern="yyyy-MM-dd"></f:formatDate> </DIV>
<DIV class=houseinfo>
<P>户　　型：<SPAN>${houseExt.tname}</SPAN></P>
<P>面　　积：<SPAN>${houseExt.floorage}m<SUP>2</SUP></SPAN></P>
<P>位　　置：<SPAN>${houseExt.dname}区${houseExt.sname}</SPAN></P>
<P>联系方式：<SPAN>${houseExt.contact}</SPAN></P></DIV></DIV>
<DIV class=side>
<P><A class=bold href="http://localhost:8080/House-2/#">北京青鸟房地产经纪公司</A></P>
<P>资质证书：有</P>
<P>内部编号:1000</P>
<P>联 系 人：小王</P>
<P>联系电话：<SPAN>110</SPAN></P>
<P>手机号码：<SPAN>120119114</SPAN></P></DIV>
<DIV class=clear></DIV>
<DIV class=introduction>
<H2><SPAN><STRONG>房源详细信息</STRONG></SPAN></H2>
<DIV class=content>
<P>${houseExt.description}</P></DIV></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
</BODY>
</HTML>
