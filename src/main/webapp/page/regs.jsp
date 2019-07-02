<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0049)http://localhost:8080/HouseRent/page/register.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
  <TITLE>青鸟租房 - 用户注册</TITLE>
  <META content="text/html; charset=utf-8" http-equiv=Content-Type>
  <LINK rel=stylesheet type=text/css href="../css/style.css">
  <META name=GENERATOR content="MSHTML 8.00.7601.17514">
  <script type="text/javascript" src="../admin/js/jquery-1.8.3.js"></script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新用户注册</DT>
  <DD class=past>填写个人信息</DD></DL>
<DIV class=box>
<FORM id="form1" action="/page/users/insert">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><INPUT class=text type=text name=name id="name"><span id="span1"></span> </TD>
  </TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><INPUT class=text type=password name=password></TD>
  </TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><INPUT class=text type=password name=repassword> </TD>
  </TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><INPUT class=text type=text name=telephone id="tel">
      <INPUT type=button value="获取验证码" id="but2"></TD>
  </TR>
  <TR>
    <TD class=field>验 证 码：</TD>
    <TD><INPUT class=text type=text name=code> </TD>
  </TR>
  <TR hidden>
    <TD class=field>是否是管理员：</TD>
    <TD><INPUT class=text type=text name=isadmin value="0"> </TD>
  </TR>
  <span id="span2"></span><span id="span3"></span>
  </TBODY>
</TABLE>
<DIV class=buttons>
<INPUT value=立即注册 type=button id="but1"><INPUT value=返回 type=button onclick="window.location.href='/page/login.jsp'">
</DIV>
</DIV>
</FORM>
</DIV>
</DIV>
</DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
</DL>
</DIV>
</BODY>
<script type="text/javascript">
  //判断姓名是否存在
  $("#name").blur(function () {
    //取文本框中的用户名值
    var name=$("#name").val();
    //判断是否输入值
    if (name==''||name==null){
       $("#span1").html('请输入姓名').css('color','red');
       return;
    }
    //发送异步请求
    $.post("/page/users/select",{name:name,isadmin:0},function (data) {
       if (data.result==1){
           $("#span1").html('名字已存在').css('color','red');
       } else{
           $("#span1").html('名字可用').css('color','green')
       }
    },"json")
  })

  //点击获取验证码
  $("#but2").click(function () {
      //发送异步请求发送短信
      $.post('/page/users/sendMsg',{'tel':$('#tel').val()},function (data) {
          if (data.result<1){
              $("#span3").html('短信发送失败，请重试').css('color','red');
          }else{
              alert("验证码通过短信发送成功，请注意查收。")
          }
      },'json')
  })

  //点击立即注册
  $("#but1").click(function () {
      /**通过post请求表单提交
       $("#formid").attr('action')：请求的url，既form表单里定义的action的属性值
       $("#formid").serialize()：提交form的数据
       */
      $.post($("#form1").attr('action'),$("#form1").serialize(),function (data) {
          if (data.result==1){
              location.href='login.jsp';
          }else {
              $("#span2").html('注册失败').css('color','red');
          }
      },'json')
  })

</script>
</HTML>
