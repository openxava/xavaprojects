if (phone == null) var phone = {};

openxava.addEditorInitFunction(function() {
	phone.watch();
	$(document).on("click", function(event) { 
		if ($(event.target).parent().hasClass("phone-dropdown-button") || $(event.target).hasClass("phone-dropdown-button")) return;
		$('.phone-dropdown:not(:hidden)').hide();
		$('.phone-dropdown-button').removeClass('selected');
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

phone.showDropdown = function(dropdownId) { 
	var button = $(event.currentTarget);
	var d = $('#phone_dropdown_' + dropdownId); 
	if (d.is(":visible")) {
		button.removeClass("selected");
		d.fadeOut();
	}
	else {
		button.addClass("selected");
		d.fadeIn(200);
	}
}

phone.hideDropdown = function() {
	var d = $(event.currentTarget).parent();
	var button = d.prev();
	button.removeClass("selected");
	d.fadeOut();
}

phone.markDropdownOption = function(element) {
	$(element).parent().find('i').hide()
	$(element).find('i').show();
	$(element).parent().prev().removeClass("selected");
}
