if (phone == null) var phone = {};

openxava.addEditorInitFunction(function() {
	phone.watch();
	$(document).on("click", function(event) {
		var b = $('#phone_dropdown_button');
		if(b !== event.target && !b.has(event.target).length){
			$('#phone_dropdown').hide();
		} 
		           
	});
});

phone.watch = function() {
	jQuery( "#filter_list_text" ).typeWatch({
		callback: phone.filter,
		wait:500,
		highlight:true,
	    captureLength:0
	});
	
	$( "#filter_list_text" ).keyup(function() {
		if ($(this).val() == "") phone.displayAll();
	});
}

phone.filter = function() {
	phone.showSearching();
	PhoneList.filter(phone.application, phone.module, $("#filter_list_text").val(), phone.refresh);
}

phone.displayAll = function() {
	phone.showSearching();
	PhoneList.filter(phone.application, phone.module, "", phone.refresh);	
}

phone.refresh = function(phoneList) {
	if (phoneList == null) return;	
	
	$('#phone_list_core').html(phoneList);
	phone.hideSearching();
}

phone.showSearching = function() {	
	$('#xava_loading').show(); 	
	$('#searching_list').addClass('searching');	
}

phone.hideSearching = function() {
	$('#xava_loading').hide(); 	
	$('#searching_list').removeClass('searching');
}

phone.showDropdown = function() {
	var d = $('#phone_dropdown');
	if (d.is(":visible")) {
		$("#phone_dropdown_button").removeClass("selected");
		d.fadeOut();
	}
	else {
		$("#phone_dropdown_button").addClass("selected");
		d.fadeIn(200);
	}
}

phone.markDropdownOption = function(element) {
	$('#phone_dropdown i').hide()
	$(element).find('i').show();
	$("#phone_dropdown_button").removeClass("selected");
}
