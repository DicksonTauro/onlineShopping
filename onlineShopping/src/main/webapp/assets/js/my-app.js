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
	default:
		console.log(menu);
		$('#home').addClass('active');
	    break;
	}
})