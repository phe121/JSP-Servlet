/**
 * 
 */
var collegeList = [
      ["计算机科学与工程学院","物联网","计算机科学","网络工程","信息管理"],
      ["两江人工智能学院","软件工程","大数据","电科"],
      ["管理学院","企业管理","","工商管理","公共管理","旅游管理"],
      ["理学院","金融数学","数学与应用数学","应用统计学","应用物理学"],
      ["外国语学院","英语系","日语系","德语系"]
];

function fillCollege()
{

var targetSlt = document.forms["teacherForm"].elements["college"];		//学院下拉列表
var opt;

for(var i = 0; i < collegeList.length; i++){
	opt = new Option(collegeList[i][0],collegeList[i][0]);		//各个子数组的0号元素表述了学院名称，新建option，两个参数为文本(text)和值(value)
	targetSlt.options.add(opt); 	//添加
    }

}

window.onload = fillCollege;

function fillProfession()   		//省份下拉列表内容改变时执行
{

var professionSlt = document.forms["teacherForm"].elements["college"];  		//学院下拉列表
var college = professionSlt.options[professionSlt.selectedIndex].value; 		//获取学院下拉列表中选择的参数
var targetSlt = document.forms["teacherForm"].elements["profession"]; 			//专业下拉列表

targetSlt.options.length = 1;		

var opt;

for (var i = 0; i < collegeList.length; i++) {
	if (college == collegeList[i][0])			//找到表示当前学院的子数组
	{
        for(var j = 1; j < collegeList[i].length; j++)  		//专业下拉列表数据，从j=1开始是因为第0元素为学院
        {
        	opt = new Option(collegeList[i][j],collegeList[i][j]);
        	targetSlt.options.add(opt);
        } 
        break;
	}
}
}