//获取设备状态
function init(){

	var message = "init";
	//注册init事件，向插件请求设备状态。
	var evt = document.createEvent("CustomEvent");
	evt.initCustomEvent('hanvon_initEvent', true, false, message);
	document.dispatchEvent(evt);

	//监听inited事件，获取当前设备状态。	
	document.addEventListener("initedEvent",function(evt){
			/*
			  监听initedEvent事件获取设备初始化状态。
			*/
			if(evt.detail){
				document.getElementById("pluginapp").removeAttribute("disabled");
				document.getElementById("pluginapp1").removeAttribute("disabled");
				document.getElementById("pluginapp2").removeAttribute("disabled");
				alert("设备初始化成功");
				
			}else{
				
				alert("设备初始化失败");
				
			}
		});
		
}



document.getElementById('pluginapp').onclick=function()
{
	/*
		参数说明
		signid:页面接收签字图片数据的img元素id名称
		corp：公司名称
		pen_w:笔迹粗细设置
		pic_w：签字窗口宽
		pic_h：签字窗口高
		imageType:生成签名图片类型
		message：拼接全部参数传给chrome插件，注：分为可传不带签字图片参数也可传带签字图片参数两种方式
	*/
	var signid = "signimg";
	var corp = "hanwang technology";
	var pen_w = "1";//笔宽值自定义设置，取值范围：1-4，取值类型：整数
	/***********************/
	//OrgX:签名窗口弹出时显示在屏幕位置的X坐标值。
	//OrgY:签名窗口弹出时显示在屏幕位置的Y坐标值。
	//OrgX与OrgY不设置时，签名窗口弹出时，默认显示在屏幕正中间。
	/**********************/
	var OrgX = "200";
	var OrgY = "150";

	var pic_w = "500";
	var pic_h = "300";
	var imageType = "2";//生成签名图片的类型 1->BMP(图片数据支持2MB以下), 2->JPG, 3->PNG, 4->GIF
	var fpr_req = "0";//0--签名 1--指纹+签名，2--- 指纹 此接口只支持ESP370D一款硬件设备
	
	var signpic_w = "100";//返回签名图片宽
	var signpic_h = "60";//返回签名图片高	

	var message = signid+";"+corp+";"+pen_w+";"+ OrgX + ";"+ OrgY + ";"+pic_w+";"+pic_h+";"+imageType + ";" + fpr_req +";"+signpic_w + ";" +
		signpic_h + ";";//最后一个分号后是base64签名数据，空代表第一次签。
	//
	var evt = document.createEvent("CustomEvent");
	evt.initCustomEvent('hanvon_signProEvent', true, false, message);
	document.dispatchEvent(evt);
};
function btn_pluginapp1()
{
	/*
		参数说明
		signid:页面接收签字图片数据的img元素id名称
		corp：公司名称
		pen_w:笔迹粗细设置
		pic_w：签字窗口宽
		pic_h：签字窗口高
		imageType:生成签名图片类型
		message：拼接全部参数传给chrome插件，注：分为可传不带签字图片参数也可传带签字图片参数两种方式
	*/
	
	
	var signid = "signimg1";
	var corp = "赛普科技公司";
	var pen_w = "2";//笔宽值自定义设置，取值范围：1-4，取值类型：整数
	/***********************/
	//OrgX:签名窗口弹出时显示在屏幕位置的X坐标值。
	//OrgY:签名窗口弹出时显示在屏幕位置的Y坐标值。
	//OrgX与OrgY不设置时，签名窗口弹出时，默认显示在屏幕正中间。
	/**********************/
	var OrgX = "200";
	var OrgY = "150";

	var pic_w = "500";
	var pic_h = "300";
	var imageType = "3";//生成签名图片的类型 1->BMP(图片数据支持2MB以下), 2->JPG, 3->PNG, 4->GIF
	var fpr_req = "1";//0--签名 1--指纹+签名， 2--- 指纹 
	var signpic_w = "100";//返回签名图片宽
	var signpic_h = "60";//返回签名图片高	

	var message = signid+";"+corp+";"+pen_w+";"+ OrgX + ";"+ OrgY + ";"+pic_w+";"+pic_h+";"+imageType + ";" + fpr_req +";"+signpic_w + ";" +
		signpic_h + ";";//最后一个分号后是base64签名数据，空代表第一次签。
	
	
	var evt = document.createEvent("CustomEvent");
	evt.initCustomEvent('hanvon_signProEvent', true, false, message);
	document.dispatchEvent(evt);
};
function btn_pluginapp2()
{
	/*
		参数说明
		signid:页面接收签字图片数据的img元素id名称
		corp：公司名称
		pen_w:笔迹粗细设置
		pic_w：签字窗口宽
		pic_h：签字窗口高
		imageType:生成签名图片类型
		message：拼接全部参数传给chrome插件，注：分为可传不带签字图片参数也可传带签字图片参数两种方式
	*/
	
	
	var signid = "signimg2";
	var corp = "赛普科技公司";
	var pen_w = "2";//笔宽值自定义设置，取值范围：1-4，取值类型：整数
	/***********************/
	//OrgX:签名窗口弹出时显示在屏幕位置的X坐标值。
	//OrgY:签名窗口弹出时显示在屏幕位置的Y坐标值。
	//OrgX与OrgY不设置时，签名窗口弹出时，默认显示在屏幕正中间。
	/**********************/
	var OrgX = "200";
	var OrgY = "150";

	var pic_w = "500";
	var pic_h = "300";
	var imageType = "3";//生成签名图片的类型 1->BMP(图片数据支持2MB以下), 2->JPG, 3->PNG, 4->GIF
	var fpr_req = "2";//0--签名 1--指纹+签名， 2--- 指纹 

	var signpic_w = "100";//返回签名图片宽
	var signpic_h = "60";//返回签名图片高	

	var message = signid+";"+corp+";"+pen_w+";"+ OrgX + ";"+ OrgY + ";"+pic_w+";"+pic_h+";"+imageType + ";" + fpr_req +";"+signpic_w + ";" +
		signpic_h + ";";//最后一个分号后是base64签名数据，空代表第一次签。
	
	
	
	var evt = document.createEvent("CustomEvent");
	evt.initCustomEvent('hanvon_signProEvent', true, false, message);
	document.dispatchEvent(evt);
};
