<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:set var="picPath" value="http://127.0.0.1:8081/ssmImg"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.js"></script>

</head>
<body> 
<form id="userForm" action="${pageContext.request.contextPath }/user/updateUser.do" method="post">
<input type="hidden" name="id" value="${user.id }"/>
修改个人信息：
<table width="100%" border=1>
<tr>
	<td>姓名</td>
	<td><input type="text" name="name" value="${user.name }"/></td>
</tr>
<tr>
	<td>密码</td>
	<td><input type="text" name="pwd" value="${user.pwd}"/></td>
</tr>
<tr>
	<td>年龄</td>
	<td><input type="text" name="age" value="${user.age}"/></td>
</tr>
<tr>
	<td>地址</td>
	<td><input type="text" name="address" value="${user.address}"/></td>
</tr>
<tr>
	<td>商品图片</td>
	<td>
		<p><label></label>
		<img id='imgSize1ImgSrc' src='${picPath}${user.pic}'  height="100" width="100" />
		<input type='file' id='imgSize1File' name='imgSize1File' class="file" onchange='submitImgSize1Upload()' /><span class="pos" id="imgSize1FileSpan">请上传图片的大小不超过3MB</span>
        <input type='hidden' id='imgSize1' name='pic' value='' reg="^.+$" tip="亲！您忘记上传图片了。" />
		</p>
 
	</td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>
<script type="text/javascript">
function submitImgSize1Upload(){
	var option={
			type:'POST',
			url:'${pageContext.request.contextPath }/upload/uploadPic.do',
			dataType:'text',
			data:{
				fileName : 'imgSize1File'
			},
			success:function(data){
				
				//把json格式的字符串转换成json对象
				var jsonObj = $.parseJSON(data);
				
				//返回服务器图片路径，把图片路径设置给img标签
				$("#imgSize1ImgSrc").attr("src",jsonObj.fullPath);
				//数据库保存相对路径
				$("#imgSize1").val(jsonObj.relativePath);
			}
			
		};
	
	$("#userForm").ajaxSubmit(option);
	
}
</script>

</html>