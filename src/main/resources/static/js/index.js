$(document).ready(function(){
    console.log("book");
    initPage();
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
    //页面初始化//
    function initPage(){
        initBook();
        initCustomer();
        initOrder();
    }

    function initBook(){//初始化书单
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/shop/listBook",
            async:false,
            success:function(data){
				console.log(data.data.books);
				$("#first>tbody").empty();
				var books = data.data.books;
				for(var i = 0 ;i < books.length ; i++){
				    var html = "<tr>";
				    html += "<td>" + books[i].bookName +"</td>";
				    html += "<td>" + books[i].bookNumber + "</td>"
                    html += "<td>" + books[i].bookPrice + "</td>"
                    html += "<td>" + books[i].bookDate + "</td>"
                    html += "<td><button class='btn btn-info'>移除</button></td>"
                    html += "</tr>";
                    $("#first>tbody").append(html);
                }
            },
            error:function(){
                alert("网络错误")
            },
        })
    };
    function initCustomer(){//初始化顾客表单
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/shop/customer/listCustomer",
            async:false,
            success:function(data){
                $("#three>tbody").empty();
                var books = data.data.list;
                for(var i = 0 ;i < books.length ; i++){
                    var html = "<tr>";
                    html += "<td>" + (i+1) + "</td>"
                    html += "<td>" + books[i].name+"</td>";
                    html += "<td>" + books[i].sex + "</td>"
                    html += "<td>" + books[i].age + "</td>"
                    html += "<td><button class='btn btn-primary alter\' value=" +books[i].customerId + ">修改</button><button class='btn btn-danger'>踢出</button></td></td>"
                    html += "</tr>";
                    $("#three>tbody").append(html);
                }
            },
            error:function(){
                alert("网络错误")
            },
        })
    };
    $("#addOrderClick").click(function(){
        addOrder();
    })
    function addOrder(){
        var add_Order = $(".addOrder form").serialize();
        console.log(add_Order);
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/shop/save?" + add_Order,
            async:false,
            success:function (data) {
                alert("添加成功！")
            },
            error:function () {
                alert("网络错误！");
            }
        })
        $(".addOrder  input").val("");
        $("#addOrderModal").modal("hide");
    }

    function initOrder(){//初始化订单
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/shop/listOrder",
            async:false,
            success:function(data){
                $("#two>tbody").empty();
                var books = data.data.list;
                for(var i = 0 ;i < books.length ; i++){
                    var html = "<tr>";
                    html += "<td>" + i+1 + "</td>"
                    html += "<td>" + books[i].number+"</td>";
                    html += "<td>" + books[i].bookName+ "</td>"
                    html += "<td>" + books[i].name + "</td>"
                    html += "<td><button class='btn btn-primary delete' value="+ books[i].ordersId+ ">删除</button></td>"
                    html += "</tr>";
                    $("#two>tbody").append(html);
                }
            },
            error:function(){
                alert("网络错误")
            },
        })
    }


    //点击查询，
    $("#searchBook").click(function(){
        var content = $(".search #searchText").val();
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/shop/findOne?id=" + content,
            async:false,
            success:function (data) {
                $("#first>tbody").empty();
                var books = data.data.book;
                console.log(books);
                for(var i = 0 ;i < books.length; i++){
                    var html = "<tr>";
                    html += "<td>" + books.bookName +"</td>";
                    html += "<td>" + books.bookNumber + "</td>"
                    html += "<td>" + books.bookPrice + "</td>"
                    html += "<td>" + books.bookDate + "</td>"
                    html += "<td><button class='btn btn-info'>移除</button></td>"
                    html += "</tr>";
                    $("#first>tbody").append(html);
                }
            }
        })
    })

    //增加顾客
    $("#addClick").click(function(){
        var add_Customer = $(".customer form").serialize();
        console.log(add_Customer);
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/shop/customer/addCustomer?" + add_Customer,
            async:false,
            success:function (data) {
                alert("添加成功！")
                },
            error:function () {
                alert("网络错误！");
            }
        })
        $(".customer  input").val("");
        $("#myModal").modal("hide");
    })


    //删除
    $(".delete").click(function(){
        ordersId = $(this).val();//顾客的ID值填入在按钮值上，点击增加时会设置当前ID值 为customerId
        //做回显操作
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/shop/deleteOrder?id=" + ordersId,
            async:false,
            success:function (data) {
                alert("删除成功！")
            },
            error:function () {
                alert("网络错误！");
            }
        })
        initCustomer();

    })

    //修改顾客信息
    $(".alter").click(function(){
        $("#alterModal").modal("show");
        customerId = $(this).val();//顾客的ID值填入在按钮值上，点击增加时会设置当前ID值 为customerId
        console.log(customerId);
        //做回显操作
        var age = $(this).parent().prev().text();
        var sex = $(this).parent().prev().prev().text();
        var name = $(this).parent().prev().prev().prev().text();
        $(".alterDetail input[name='name']").val(name);
        $(".alterDetail input[name='age']").val(age);
        $(".alterDetail input[name='sex']").val(sex);

    })

    //修改完成后，点击提交
    $("#alterClick").click(function(){
        console.log(customerId);
        var alter_Customer = $(".alterDetail form").serialize();
        alert(alter_Customer);
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/shop/customer/updateCustomer?" + alter_Customer +"&customerId=" + customerId,
            async:false,
            success:function (data) {
                alert("添加成功！")
            },
            error:function () {
                alert("网络错误！");
            }
        })
        initCustomer();
        $(".alter input").val("");//清空输入框
        $("#alterModal").modal("hide");//模态框消失
    });



});