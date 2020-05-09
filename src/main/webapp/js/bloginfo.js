var current_user_id;
$(function(){
	current_user_id = $("#current_user_id").val();
	comment_select();
});

/**
 * 查询所有评论
 */
function comment_select(){
	var bid_param = $("#bid").val();
	$.getJSON("getcommentlist",{bid:bid_param},function(data){
		var html = "";
        if(data.length==0){
        	html += "<div class='comment_author'>还没有人</div>";
            html +=	"<div class='comment_text'>快来抢沙发！</div>";
        }else{
			$.each(data,function(i,comment){
				html += "<div class='comment_author'><span>"+(i+1)+"楼</span><span>"+comment.userName+"</span><span>"+comment.dateTimeStr+"</span>";
				if(current_user_id!=null&&comment.uid==current_user_id){
					html +="<span class='comment_delete' onClick='comment_delete("+comment.id+","+comment.bid+")'>删除</span>";
				}
				html += "</div>";
		        html += "<div class='comment_text'>"+comment.content+"</div>";
			});
        }
		$("#comment").html(html);
	});
}
/**
 * 在用户评论前进行一次检查
 */
function check(){
	var content = $("#comment_content").val();
	var uid = $("#uid").val();
	if(content==""){
		alert("content is not null");
		return false;
	}
	if(uid==""){
		alert("user id is not null");
		return false;
	}
	return true;
}
/**
 * 用户发表评论
 */
function comment_submit(){
	var bid_param = $("#bid").val();
	var uid_param = $("#current_user_id").val();
	var content_param = $("#comment_content").val();
	if(check()){
		$.post("savecomment",{bid:bid_param,uid:uid_param,content:content_param},function(data){
			var flag = data;
			if(flag){
				//局部刷新评论
				comment_select();
			}
			$("#comment_content").val("");
		},"json");
	}
}
//
/**
 * 删除评论
 * @param param1 评论的id
 * @param param2 博客id
 */
function comment_delete(param1,param2){
	$.getJSON("deletecomment",{id:param1,bid:param2},function(data){
		var flag = data;
		if(flag){
			comment_select();//刷新评论列表
		}
	});
}

