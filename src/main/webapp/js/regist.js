function nameBlur(){
	//取到name
	var n = $("#name").val();
	console.log(n);
	
	$.ajax({
		type:"post",
		url:"check.action",
		data:{name:n},
		dataType:"text",
		success: function(result){
			console.log(result);
			if(result=="true"){
				console.log("jinlaile");
				$("#name_exist").html("");
			}else{
				$("#name_exist").html("name is exist");
			}
		}
	});
}
/*省市区级联查询操作*/
$(function(){
	$.post("getprovince.action",{type:1},function(result){
		var html = "<option value='0'>-prov-</option>";
		$.each(result,function(i,data){
			html += "<option value='"+data.provinceId+"'>"+data.province+"</option>";
		});
		$("#provincedId").html(html);
	},"json");
});
//市
function showCity(pid){
	var html = "<option value='0'>-city-</option>";
	if(pid!=0){
		$.getJSON("getcity.action",{provinceId:pid},function(result){
			$.each(result,function(i,data){
				html += "<option value='"+data.cityId+"'>"+data.city+"</option>";
			});
			$("#cityId").html(html);
		});
	}
	$("#cityId").html(html);
	$("#areaId").html("<option value='0'>-area-</option>");
}
//区县
function showArea(cid){
	$.getJSON("getarea.action",{cityId:cid},function(result){
		var html = "<option value='0'>-area-</option>";
		$.each(result,function(i,data){
			html += "<option value='"+data.areaId+"'>"+data.areas+"</option>";
		});
		$("#areaId").html(html);
	});
}

/**
 * 校验是否成功，如果成功则提交表单
 * @returns {Boolean}
 */
function check() {
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;
	var name = document.getElementById("name").value;
	var name_exit = $("#name_exist").html();
	if (name == "please input your name") {
		alert("用户名不能为空");
		return false;
	}
	if(name_exit != ""){
		alert("用户名已经存在");
		return false;
	}
	if (pass1 == "") {
		alert("密码不能为空");
		return false;
	}
	if (pass1 == pass2) {
		// document.getElementById("form1").submit();
		document.getElementsByTagName("form").item(0).submit();
	} else {
		alert("密码不相同");
		return false;
	}
}