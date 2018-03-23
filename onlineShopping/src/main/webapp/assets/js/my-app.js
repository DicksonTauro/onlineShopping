
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
				
				if(row.quantity < 1){
					str+='<a href="javascript:void(0)" class="btn btn-success disabled"><strike> Add to cart </strike> </a>';
				}
				else {
					str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"> Add to cart </a>';
				}
				
				return str;
			}
			
		}]
	});
}

});