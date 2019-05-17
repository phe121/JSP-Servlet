/**
 * 页面跳转的js
 */
/*
 * 如果输出数据合法，则跳转到对应页面，否则到指定页面
 */
function upPage() {
	let currentPage = document.getElementById("currentPage").value;
	currentPage--;
	if (currentPage === 0 || currentPage < 0) {
		alert("已经是第一页了");
		window.location.href = './ShowAllTeacher?currentPage=1';
	} else {
		window.location.href = './ShowAllTeacher?currentPage=' + currentPage;
	}
}
function nextPage() {
	let currentPage = document.getElementById("currentPage").value;
	let teachersNumbers = document.getElementById("teachersNumbers").value;
	let totalPages = parseInt(teachersNumbers % 10) === 0 ? parseInt(teachersNumbers / 10) : parseInt(teachersNumbers / 10 + 1);
	currentPage++;
	console.log(currentPage);
	if (currentPage > totalPages) {
		alert("已经是最后一页了");
		window.location.href = './ShowAllTeacher?currentPage='+totalPages;
	} else {
		window.location.href = './ShowAllTeacher?currentPage=' + currentPage;
	}
}
function turnPage() {
	let inputPage = document.getElementById("inputPage").value;
	//let currentPage = document.getElementById("currentPage").value;
	let teachersNumbers = document.getElementById("teachersNumbers").value;
	let totalPages = parseInt(teachersNumbers % 10 == 0) ? parseInt(teachersNumbers / 10) : parseInt(teachersNumbers / 10 + 1);
	
	if(inputPage < 1 || inputPage > totalPages){
		alert("页面跳转出错");
	}else{
		window.location.href = './ShowAllTeacher?currentPage=' + inputPage;
	}
}
