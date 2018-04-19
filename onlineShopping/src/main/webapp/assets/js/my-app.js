
jQuery( document ).ready(function( $ ) {

$(function(){ 
	//solving the active menu problem
	switch(menu) {
	
	case 'About us':
		console.log(menu);
		$('#about').addClass('active');
		break;
	case 'Contact us':
		console.log(menu);
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#productList').addClass('active');
		break;
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		$('#productList').addClass('active');
	    $("#a_"+menu).addClass('active');
	    break;
	}
});

var products = [
                ['1','Sachin'],
                ['2','Mahi'],
                ['3','Azar'],
                ['4','Amaresh'],
                ['5','Anand'],
                ['6','Kamalesh'],
                ['7','Kittur'],
                ['8','Nahid']
                ];

var table = $('#productListTable');

if(table.length) {
	var jsonUrl = '';
	
	if(window.categoryId==''){
	  
		jsonUrl = window.contextRoot+'/json/data/all/products';
	}
	else {
		jsonUrl = window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		
	}
	console.log(jsonUrl);
	table.DataTable({
		lengthMenu:[[3,5,10,-1],['3 records','5 records','10 records','ALL records']],
		pageLength:5,
		ajax: {
			url:jsonUrl,
			dataSrc:'',
		},
		columns:[{
			data:'code',
			bSortable:false,
			mRender:function(data,type,row){
				return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="tableImage"/>'
			}
		},{
			data:'name'
		},{
			data:'brand'
		},{
			data:'unitPrice',
			mRender:function(data,type,row){
				return '&#8377; '+data;
			}
		},{
			data:'quantity',
			mRender:function(data,type,row) {
				if(data < 1){
					return '<span style="color:red">Out of Stock</span>'
				}
				return data;
			}
		},{
			data:'id',
			bSortable:false,
			mRender:function(data,type,row){
				var str = '';
				str+= '<a href=" '+ window.contextRoot+'/show/'+data+'/product" class="btn btn-primary">View</i></a> &nbsp;';
				
				
				if(userRole == 'ADMIN'){
					str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"> Edit </a>';
				}
				else{
				
				
				if(row.quantity < 1){
					str+='<a href="javascript:void(0)" class="btn btn-success disabled"><strike> Add to cart </strike> </a>';
				}
				else {
						str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"> Add to cart </a>';
				}
				}
				return str;
			}
			
		}]
	});
}

//dismissing the alert after 3 seconds

var alert = $('.alert');

/*if(alert.length){
	setTimeout(function(){
		alert.fadeOut('slow');
	},1000)
}
*/

$('#tableBody').on('change',"input[type=checkbox]",function(){
	
	var checkbox = $(this);
	var checked = checkbox.prop('checked');
	
	var msg = checked ? 'Do you want Activate the product ?':'Do you want Deactivate the product ?';
	
	var value = checkbox.prop('value');
	
	
	
	$('#confirmModal').on('show.bs.modal', function (event) {
		 var modal = $(this);
		 modal.find('.modal-title').text('Product Activation And Deactivation');
		 modal.find('.modal-body').text(msg);
	});
	
	$('#confirmModal').modal({keyboard:false,backdrop:'static'})
	
	$('#confirmModal').modal('show');
	
	$('#confirm').off('click').on('click', function() {
		var url = window.contextRoot+"/manage/products/"+value+'/activation';
		$.post(url,function(data){
			$('#infoModal').on('show.bs.modal', function (event) {
				 var modal = $(this);
				 modal.find('#infoModalLabel').text('Info');
				 modal.find('#modal-body').text(data);
			});
			$('#infoModal').modal('show');
		});
		
		
		$('#confirmModal').modal('hide');
	});
	
	$('#closed').off('click').on('click', function() {
		checkbox.prop('checked',!checked);
		$('#confirmModal').modal('hide');
	});
});

//code for admin product table

var adminsProductTable = $('#adminsProductTable');

if(adminsProductTable.length) {
	var jsonUrl = window.contextRoot+'/json/data/admin/all/products';
	
	adminsProductTable.DataTable({
		lengthMenu:[[3,5,10,-1],['3 records','5 records','10 records','ALL records']],
		pageLength:5,
		ajax: {
			url:jsonUrl,
			dataSrc:'',
		},
		columns:[{
			data:'id',
		},{
			data:'code',
			bSortable:false,
			mRender:function(data,type,row){
				return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>'
			}
		},{
			data:'name'
		},{
			data:'brand'
		},{
			data:'quantity',
			mRender:function(data,type,row) {
				if(data < 1){
					return '<span style="color:red">Out of Stock</span>'
				}
				return data;
			}
		},{
			data:'unitPrice',
			mRender:function(data,type,row){
				return '&#8377; '+data;
			}
		},{
			data:'activeInd',
			bSortable:false,
			mRender:function(data,type,row){
				var str = '';
				str += '<label class="switch">';
				if(data){
					str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
				}
				else {
					str += '<input type="checkbox" value="'+row.id+'" />';
				}
				str += '<div class="slider"></div></label';
				return str;
			}
		},{
			data:'id',
			bSortale:false,
			mRender:function(data,type,row){
				var str = '';
				str+= '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-primary">Edit</a';
				return str;
				
			}
		}]
	});
}

// categoy form validation

var categoryForm  = $('#categoryForm');

if(categoryForm.length){
	categoryForm.validate({
		rules: {
			name:{
				required:true,
				minlength:2
			},
			description:{
				required:true
			}
		},
		messages: {
			name:{
				required:'Please add the category name !',
				minlength:'The category name should not be less than 2 charecters'
			},
			description:{
				required:'Please add a description for this category!'
			}
		},
		errorElement:'em',
		errorPlacement:function(error,element){
			error.addClass('help-block');
			error.insertAfter(element);
		}
	})
	
}

var loginForm  = $('#loginForm');

if(loginForm.length){
	loginForm.validate({
		rules: {
			username:{
				required:true,
				minlength:2
			},
			password:{
				required:true
			}
		},
		messages: {
			username:{
				required:'Please Please enter username !',
				minlength:'The username should not be less than 2 charecters'
			},
			password:{
				required:'Please enter password!'
			}
		},
		errorElement:'em',
		errorPlacement:function(error,element){
			error.addClass('help-block');
			error.insertAfter(element);
		}
	})
	
}

//to get csrf token

var token = $('meta[name="_csrf"]').attr('content');
var header = $('meta[name="_csrf_header"]').attr('content');
if( token.length > 0 && header.length >0){
	// set the token header for the ajax request
	$(document).ajaxSend(function(event,xhr,options){
		xhr.setRequestHeader(header,token);
	});
}

});