$(function(){
     $('#tabs a').click(function(e) {
          e.preventDefault();                
          $('#tabs li').removeClass("current").removeClass("hoverItem");
          $(this).parent().addClass("current");
          $("#content div").removeClass("show");
          $('#' + $(this).attr('title')).addClass('show');
      });

     $('#tabs a').hover(function(){
        if(!$(this).parent().hasClass("current")){
          $(this).parent().addClass("hoverItem");
        }
     },function(){
        $(this).parent().removeClass("hoverItem");
     });
	 
	 $("#searchBook").click(function(){
		 var content = $(".search #searchText").val();
		 console.log(content);
		 creatTable(content);
	 })
	 
	 //创建书单详情表体
	 function creatTable(){
		 $.ajax({
			 type:"GET",
			 url:"" + content,
			 async:false,
			 success:function(data){
				 
				 
			 },
			 error:function(){
				 alert("网络错误！");
			 }
		 })
	 }
	 
	 //注册顾客
	 $("#addClick").click(function(){
		 var add_Customer = $(".customer form").serialize();
		 console.log(add_Customer);
		 
		 $(".customer  input").val("");
		 $("#myModal").modal("hide"); 
	 })
	 
	 //修改顾客信息
	 $(".alter").click(function(){
		 $("#alterModal").modal("show");
		 customerId = $(this).val();
		 console.log(customerId);
	 })
	 //修改顾客信息，点击提交
	 $("#alterClick").click(function(){
		 console.log(customerId)
		 var alter_Customer = $(".alter form").serialize();
		 alert(alter_Customer);
		 
		 
		 $(".alter  input").val("");
		 $("#alterModal").modal("hide");
		
	 })
  });