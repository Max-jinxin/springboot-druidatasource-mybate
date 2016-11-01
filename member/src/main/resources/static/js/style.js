$(function(){
	// 获取屏幕的高度
	var wH = $(window).height();
	// 获取leftBottom内容的高度
	var bH = $('.leftBottom').height();
	// 获取leftTop内容的高度	
	var tH = $('.leftTop').height();
	tH = (wH - bH -44-75) + 'px';
	var contH = $('.leftTop ul').height();
	if(tH<=contH){
		$('.leftTop').css('height',contH);
	}else{
		$('.leftTop').css('height',tH);
	}
	
	// 文件切换信息显示隐藏
	$('.file h3').click(function(){
		$('.file ul').toggle();
	})

	// 侧导航切换内容
	$('.leftBottom ul li').click(function(){

		var index = $(this).index();
		$('.list').removeClass('act');
		$('.list').eq(index).addClass('act');
	})

})