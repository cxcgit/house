<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Object o = session.getAttribute("user");
  if (o==null){
    out.print("<script>alert('你还没有登录或登录超时,请重新登录');" +
            "location.href='/page/login.jsp';</script>");
  }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../../css/style.css">
<META name=GENERATOR >
<script type="text/javascript" src="../../admin/js/jquery-1.8.3.js"></script>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../../images/logo.gif"></DIV>
  <DIV class=search>【欢迎${user.name}】
  <LABEL class="ui-green searchs"><a href="/page/house/toFaBu" title="">发布房屋</a></LABEL>
  <LABEL class="ui-green searchs"><a href="/page/house/selectByUsersId?isdel=1" title="">已删除房屋信息</a></LABEL>
  <LABEL class="ui-green searchs"><a href="/page/house/selectAll?ispass=1&isdel=0" title="">返回首页</a></LABEL>
  <LABEL class=ui-green><INPUT onclick='document.location="../login.jsp"' value="退       出" type=button name=search></LABEL>
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${pageInfo.list}" var="house">
  <TR>
    <TD class=house-thumb><SPAN><A href="/page/house/selectOne?id=${house.id}" target="_blank"><img src="http://localhost/${house.path}" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="/page/house/selectOne?id=${house.id}" target="_blank">${house.title}</A></DT>
        <DD>${house.dname}区${house.sname},${house.floorage}平米,${house.tname}<BR>联系方式：${house.contact} </DD></DL>
    </TD>
    <td><c:choose>
      <c:when test="${house.ispass==0}">未审核</c:when>
      <c:when test="${house.ispass==1}">已审核</c:when>
    </c:choose></td>
    <TD class=house-type><LABEL class=ui-green><INPUT value="修    改" type=button name=search onclick="location.href='/page/house/toChange?id=${house.id}'"></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name=search onclick="delOne(${house.id})"></LABEL></TD>
  </TR>
  </c:forEach>
  </TBODY>
</TABLE></DIV>
<DIV class=pager>
<UL>
  <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="i">
    <LI class=current>
      <A id=widget_338868862 href="/page/house/selectByUsersId?page=${i}&isdel=0"
      parseContent="true" showError="true" targets="houseArea" ajaxAfterValidation="false" validate="false"
      dojoType="struts:BindAnchor">${i}</A>
    </LI>
  </c:forEach>
</UL>
  <SPAN class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN>
</DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY>
<script type="text/javascript">
    function delOne(id) {
        if (confirm('确定删除吗？')){
            location.href='/page/house/deleteOne?isdel=1&id='+id;
            // $.post('/page/house/deleteOne',{'id':id,'isdel':1},function (data) {
            //     if (data.result>0){
            //         //删除tr
            //         tr.remove();
            //     }
            // },'json')
        }
    }
 </script>
</HTML>
