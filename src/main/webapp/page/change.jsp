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
    <script type="text/javascript" src="../../admin/js/jquery-1.8.3.js"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../../images/logo.gif"></DIV>
    <DIV class=search>【欢迎${user.name}】
        <LABEL class="ui-green searchs"><a href="/page/house/selectAll?ispass=1&isdel=0" title="">返回首页</a></LABEL>
        <LABEL class=ui-green><INPUT onclick='document.location="../login.jsp"' value="退       出" type=button name=search></LABEL>
    </DIV></DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DL class=clearfix>
            <DT>新房屋信息发布</DT>
            <DD class=past>填写房屋信息</DD></DL>
        <DIV class=box>
            <FORM id=add_action method=post name=add.action
                  action=/page/house/update enctype="multipart/form-data">
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <TD class=field>标　　题：</TD>
                            <TD><INPUT id=add_action_title class=text type=text name=title value="${houseExt.title}"> </TD></TR>
                        <TR>
                            <TD class=field>户　　型：</TD>
                            <TD>
                                <select name="typeId"  id="type_name">
                                    <option value=''>---请选择---</option>
                                    <c:forEach items="${typeList}" var="type">
                                        <option value="${type.id}" <c:if test="${type.name==houseExt.tname}">selected</c:if>>${type.name}</option>
                                    </c:forEach>
                                </select>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>面　　积：</TD>
                            <TD><INPUT id=add_action_floorage class=text type=text name=floorage value="${houseExt.floorage}"></TD></TR>
                        <TR>
                            <TD class=field>价　　格：</TD>
                            <TD><INPUT id=add_action_price class=text type=text name=price value="${houseExt.price}"> </TD></TR>
                        <TR>
                            <TD class=field>发布日期：</TD>
                            <TD><INPUT class=text type=date name=pubdate  value="<f:formatDate value="${houseExt.pubdate}" pattern="yyyy-MM-dd"></f:formatDate>"></TD></TR>
                        <TR>
                            <TD class=field>位　　置：</TD>
                            <TD>区：<SELECT class=text name=districtId id="district_name">
                                <option value='0'>---请选择---</option>
                                <c:forEach items="${districtList}" var="district">
                                    <option value="${district.id}" <c:if test="${district.name==houseExt.dname}">selected</c:if>>${district.name}</option>
                                </c:forEach>
                            </SELECT>
                                街：<SELECT class=text name=streetId id="street_name">
                                    <option value='0'>---请选择---</option
                                    <c:forEach items="${streetList}" var="street">
                                        <option value="${street.id}" <c:if test="${street.name==houseExt.sname}">selected</c:if>>${street.name}</option>
                                    </c:forEach>
                                </SELECT> </TD>
                        </TR>
                        <TR>
                            <TD class=field>联系方式：</TD>
                            <TD><INPUT id=add_action_contact class=text type=text name=contact value="${houseExt.contact}"> </TD>
                        </TR>
                        <TR>
                            <TD class=field>图片：</TD>
                            <TD>
                                <%--将旧的图片路径传到后台用于删除就图片--%>
                                <input type="hidden" name="oldPath" value="${houseExt.path}">
                                <%--将id传到后台用于修改--%>
                                <input type="hidden" name="id" value="${houseExt.id}">
                                <input type="file" name="pfile" value="${houseExt.path}"></TD>
                        </TR>
                        <TR>
                            <TD class=field>详细信息：</TD>
                            <TD><TEXTAREA name=description>${houseExt.description}</TEXTAREA></TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                    <DIV class=buttons><INPUT value=修改 type=submit><INPUT value=返回 type=button onclick="window.location.href='/page/house/selectByUsersId?isdel=0'"></DIV>

                </DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY>
<script type="text/javascript">
    //区域下拉列表发生变化时，街道列表也发生变化
    $("#district_name").change(function () {
        //清空街道列表中的数据
        $("#street_name").children().each(function(i, streets) {
            if (i > 0) {
                streets.remove();
            }
        });
        //取区域对应的id
        var id=$(this).val();
        $.post('/page/street/selectByDistrictId',{id:id},function (data) {
            if (data!=null){
                for (var i = 0; i <data.length ; i++) {
                    $("#street_name").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                }
            }
        },'json')
    })
</script>
</HTML>
