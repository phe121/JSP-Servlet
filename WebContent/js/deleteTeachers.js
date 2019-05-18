/**
 * 删除学生页面的js
 */
//是否全选该页面的老师
var isSelectAll = false;		

/*全选老师或取消全选方法*/
function selectTeachers() {
	var currentPageIds = document.getElementsByName("currentPageTheachers");
	var id = document.getElementsByName("teachers");
	
	//如果选中全选框，则对此页面全部老师打钩，否则全部取消打钩。
	if (currentPageIds[0].checked) {		
		for (var i = 0; i < id.length; i++) {
			id[i].checked = true;
		}
		isSelectAll = !isSelectAll;
		console.log(isSelectAll);
	} else {
		for (var i = 0; i < id.length; i++) {
			id[i].checked = false;
		}
		isSelectAll = !isSelectAll;
		console.log(isSelectAll);
	}
}

//取消某个老师选中时，取消全选;如老师全部选中，则自动对全选打钩
function selectTeacher() {
	var currentPageIds = document.getElementsByName("currentPageTheachers");
	var id = document.getElementsByName("teachers");
	var teacherNumbers = 0;
	//console.log(id.length);
	for (var i = 0; i < id.length; i++) {
		if (id[i].checked){
			teacherNumbers ++;
		}
	}
	//console.log(teacherNumbers);
	//如果选中的老师人数==页面老师人数，则对全选框打钩，否则取消。
	if(teacherNumbers == id.length){		
		currentPageIds[0].checked = true;
		isSelectAll = currentPageIds[0].checked;
		console.log(isSelectAll);
	}else{
		currentPageIds[0].checked = false;
		isSelectAll = currentPageIds[0].checked;
		console.log(isSelectAll);
	}

}

function deleteTeachers() {
	var id = document.getElementsByName("teachers");
	var currentPage = document.getElementById("currentPage").value;
	var Ids = 0;
	
	for (var i = 0; i < id.length; i++) {
		if (id[i].checked) {
			console.log(id[i].value);
			Ids += "&id="+id[i].value;
		}
	}
	//传入所有选中的id到地址栏
	window.location.href = './DeleteTeacher?currentPage='+currentPage+'&id='+Ids+'&isSelectAll='+isSelectAll;
}