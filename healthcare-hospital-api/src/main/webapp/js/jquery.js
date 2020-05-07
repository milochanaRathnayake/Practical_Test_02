const api_path = 'http://localhost:8080/healthcare-hospital-api/api/hospital/';
$(document).ready(function(){
	var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	$('#insertHospital').click(function(){
		if($('#name').val() != ''){
			if($('#address').val() != ''){
				if($('#email').val() != ''){
					if($('#email').val().match(email_regex)){
						if($('#contact').val().trim().length() == 10){
							return true;
						}else{
							alert('Phone number must contain 10 digits');
							
						}
					}else{
						alert('must be an email')
					}
				}else{
					alert('email cannot be null')
				}
			}else{
				alert('address cannot be null')
			}
		}else{
			alert('name cannot be null')
		}
		return false;
	});
	
	$('#updateHospital').click(function(){
		if($('#u_name').val() != ''){
			if($('#u_address').val() != ''){
				if($('#u_email').val() != ''){
					if($('#u_email').val().match(email_regex)){
						if($('#u_contact').val().trim().length() == 10){
							return true;
						}else{
							alert('Phone number must contain 10 digits');
						}
					}else{
						alert('must be an email')
					}
				}else{
					alert('email cannot be null')
				}
			}else{
				alert('address cannot be null')
			}
		}else{
			alert('name cannot be null')
		}
		return false;
	});
	
	
	$('#viewHospital').click(function(){
		viewHospital(function(response){
			$('#v_name').val(response.name);
			$('#v_address').val(response.address);
			$('#v_email').val(response.email);
			$('#v_contact').val(response.phone);
		},$('#v_id').val());
	});

	function viewHospital(response, id){
		jQuery.ajax({
			url:api_path + id,
			type: 'GET',
			success:function(resp, status){
				response(resp);
			}
		});
	}
	
});