$(document).ready(
		function() {

			// Login Page
			/*$('#userName input').focus(function() {
				$(this).val('');
				$(this).css('color', 'black');
			});
			$('#pwd input').focus(function() {
				$(this).replaceWith('<input type="password" value=""/>');
				$('#pwd input').focus();
				$('#pwd input').css('color', 'black');
			});*/

			var first = $(".tabContainer ul li:first-child").attr("id");

			$('#' + first + "_DISP").show();
			$('#' + first).addClass('active');
			$('.tabContainer ul li').click(function() {
				$('.tabContainer ul li').removeClass('active');
				$(this).addClass('active');
				var now = $(this).attr("id");
				$('.tab').hide();
				$('.' + now).show();
				clearError();
			});

			var secfirst = $(".secondaryTabs ul li a:first-child").attr("id");
			$('#' + secfirst + "_DISP").show();
			$('#' + secfirst).addClass('selected');
			$('.secondaryTabs ul li a').live("click", function() {
				$('.secondaryTabs ul li a').removeClass('selected');
				$(this).addClass('selected');
				var now = $(this).attr("id");
				$('.sectab').hide();
				$('.' + now).show();
				clearError();
			});

			// Home Page
			$('#gpcGenerateCodes .rField input').focus(function() {
				$(this).val('');
			});

			// batch history
			$('.basic').live("click", function() {
				var gridtab = $('div#modal > div');
				gridtab.hide();
				gridtab.filter(this.hash).modal();
				return false;
			});

			$('.gpcBtn').click(function() {
				var country = $('select.countryName option:selected').val();
				if (country == '') {
					$('#countryNameErrMsg').show();
				} else {
					$('#countryNameErrMsg').hide();
				}

			});

			// Select dropdown
			/*
			 * $('.cSelectbox select').each(function () { alert(this.length);
			 * if(($(this).find('option:selected').val()).toLowerCase() !=
			 * 'select'){
			 * $(this).parent().find('span').html($(this).find('option:selected').text()); }
			 * else{ $(this).parent().find('span').html('Select'); }
			 * 
			 * if($(this).prop('disabled') == true){
			 * $(this).parent().addClass('disableSelect'); } else{
			 * $(this).parent().removeClass('disableSelect'); } });
			 */

			$('.contentArea').delegate(
					'.cSelectbox select',
					'change',
					function() {
						$(this).parent().find('span').html(
								$(this).find('option:selected').text());
					});
			$('.modalWrapper').delegate(
					'.cSelectbox select',
					'change',
					function() {
						$(this).parent().find('span').html(
								$(this).find('option:selected').text());
					});
			$('.cancel').live('click', function() {
				$('.modalCloseImg').trigger('click');
			});
			
			//Added default text to search
			$('.default-value').each(function(){
			    this.value = $(this).attr('title');
			    $(this).addClass('text-label');
			 
			    $(this).focus(function(){
			        if(this.value == $(this).attr('title')) {
			            this.value = '';
			            $(this).removeClass('text-label');
			        }
			    });
			    $(this).blur(function(){
			        if(this.value == '') {
			            this.value = $(this).attr('title');
			            $(this).addClass('text-label');
			        }
			    });
			});
			
			
			$('.purgeCheckBox').click(function() {
				if( $('.purgeCheckBox').is(':checked') ){
					$('#purgeText').show();
				}else{
					$('#purgeText').hide();
					$('#numberofDaysErr').hide();
				}
			      
			    });
			
		});

$("table tr:even").css('background', '#fff');
$("table tr:odd").css('background', '#f2f2f2');

$("table tbody tr").click(function() {
	$("table tr:even").css('background', '#fff');
	$("table tr:odd").css('background', '#f2f2f2');
	$(this).css('background', '#FFB6C1');
});

// open popup
$("table.managerUser tbody tr").live('click', function() {
	$("table tr:even").css('background', '#fff');
	$("table tr:odd").css('background', '#f2f2f2');
	$(this).css('background', '#FFB6C1');
	$('#updateUserLink').click();
	setTimeout("$('.cSelectbox select').trigger('change')", 300);
});

// open popup
$("table.managerBrand tbody tr").live('click', function() {
	$("table tr:even").css('background', '#fff');
	$("table tr:odd").css('background', '#f2f2f2');
	$(this).css('background', '#FFB6C1');
	$('#updateBrandLink').click();
	setTimeout("$('.cSelectbox select').trigger('change')", 300);
});
// open popup
$("table.managePromotion tbody tr").live('click', function() {
	$("table tr:even").css('background', '#fff');
	$("table tr:odd").css('background', '#f2f2f2');
	$(this).css('background', '#FFB6C1');
	$('#updateDeletePromotionLink').click();
	setTimeout("$('.cSelectbox select').trigger('change')", 300);
});
$('.deleteBrand').live('click', function() {
	$('#updateBrandForm').hide();
	$('#deleteBrand').show();
});

// open popup
$("table.managerPackCode tr").live('click', function() {
	$("table tr:even").css('background', '#fff');
	$("table tr:odd").css('background', '#f2f2f2');
	$(this).css('background', '#FFB6C1');
	$('#updatePackCodeLink').click();
});

$(".downloadCodeTbl table tbody td input").live('click', function() {
	$("table tr:even").css('background', '#fff');
	$("table tr:odd").css('background', '#f2f2f2');
	$(this).parent().parent().parent().css('background', '#FFB6C1');
});

$('.deletePackCode').live('click', function() {
	$('#updatePackCodeForm').hide();
	$('#deletePackCode').show();
});

$('.deletePromotion').live('click', function() {
	$('#updatePromotionForm').hide();
	$('#deletePromotion').show();
});
/* UAT Fix 1443163*/
function clearError(){
	$('.msginform').html('');
	$('.msgfatal').html('');
	$('.msgwarn').html('');
	$('.successMsg').html('');
}
function isNumeric(value) {
	if (value != null && !value.toString().match(/^[0-9]+$/))
		return false;
	return true;
}

function validateGCForm() {

	var gcCode = document.getElementById('generateCodeForm:codeToGenerate').value;
	var countryId = document.getElementById('generateCodeForm:countryId').value;
	var promotionId = document.getElementById('generateCodeForm:promotionId').value;
	var packageId = document.getElementById('generateCodeForm:packageId').value;
	var hasError = true;
	if (countryId == null || countryId == "0") {
		hasError = false;
	}
	if (promotionId == null || promotionId == "0") {
		hasError = false;
	}
	if (packageId == null || packageId == "") {
		hasError = false;
	}
	if (gcCode == null || gcCode == "") {
		$('#codeError').html("Please Enter Code");
		$('#codeError').show();
		hasError = false;

	} else if (gcCode != null && gcCode != "" && !isNumeric(gcCode)) {
		$('#codeError').html("Please enter numeric code");
		$('#codeError').show();
		hasError = false;
	} else if ((gcCode != null && gcCode != "" && (gcCode <= 0 || gcCode > 6000000))) {
		$('#codeError')
				.html("Entered code should be within 1 to 6000000 limit");
		$('#codeError').show();
		hasError = false;
	}

	return hasError;
}

/** Validate Code Script * */
function isAlphaNumeric(value) {
	var aplhaNumreicRegex = /^([a-zA-Z0-9]+)$/;
	if (value != null && !aplhaNumreicRegex.test(value))
		return false;
	return true;
}
function upperCaseRemoveSpace(currentobject) {
	$(currentobject).val(
			$(currentobject).val().toUpperCase().replace(/[^a-z0-9]/gi, ''));
}
function validateCodeForm() {
	var vcCountryId = $('select[name=validateCodeForm:vcCountryId] option:selected').val();  
    var vcPromotionId = $('select[name=validateCodeForm:vcPromotionId] option:selected').val();    
	$('#vcCountryIdErr,#vcPromotionIdError,#vccodeError').hide();
	var hasError = true;
	if (vcCountryId == null || vcCountryId == "0") {
		$('#vcCountryIdErr').show();
		hasError = false;
	}
	if (vcPromotionId == null || vcPromotionId == "0") {
		$('#vcPromotionIdError').show();
		hasError = false;
	}
	var codeVal = $('.promotionCode').val();
	if (codeVal == "" || codeVal == null) {
		$('#vccodeError').html("Please Enter Code");
		$('#vccodeError').show();
		hasError = false;

	} else if (!isAlphaNumeric(codeVal)) {
		$('#vccodeError').html("Please enter alpha numeric code");
		$('#vccodeError').show();
		hasError = false;
	}
	return hasError;
}

function validateSignInForm() {

	var uName = $('#userName input').val();
	var uPwd = $('#password input').val();
	var hasError = false;

	if ((uName == null || uName == "") && (uPwd == null || uPwd == "")) {
		$('#uErrMsg,#pErrMsg').show();
		hasError = true;
	} else if (uName == null || uName == "") {
		$('#uErrMsg').show();
		$('#pErrMsg').hide();
		hasError = true;
	} else if (uPwd == null || uPwd == "") {
		$('#pErrMsg').show();
		$('#uErrMsg').hide();
		hasError = true;
	} else {
		$('#uErrMsg,#pErrMsg').hide();
		hasError = false;
	}

	return !hasError;
}

// confirm dialog before delete record
function ConfirmDelete() {
	var Delet_Confirm = confirm("Do you really want to delete this record ?");
	if (Delet_Confirm == true) {
		return true;
	} else {
		return false;
	}
}

function compareDate() {
	alert(hi);

	var start = document.formName.sdatepicker.value;
	var end = document.formName.edatepicker.value;

	var stDate = new Date(start);
	var enDate = new Date(end);
	var compDate = enDate - stDate;

	if (compDate >= 0)
		return true;
	else {
		alert("Please Enter the correct date ");
		return false;
	}
}

/* Redemption Info Code */
function validateRedeemCode() {
	var redeemptionCode = $('.rdinfoBx').val();
	if (redeemptionCode == null || redeemptionCode == "") {
		$('#rdinfoBxError').html(" Please enter customer Id");
		$('#rdinfoBxError').show();
		return false;
	} else {
		$('#rdinfoBxError').html("");
		$('#rdinfoBxError').hide();
		return true;
	}
}

/* Validate Brand Form */
function validateBrandForm(formName) {
	var brccountryId = '';
	var brcbrandName = '';
	var brcbrandCode = '';
	if (formName == 'update') {
		brccountryId = $(
				'select[name=updateBrandForm:brccountryId] option:selected')
				.val();
		brcbrandName = $('input[name=updateBrandForm:brcbrandName]').val();
		brcbrandCode = $('input[name=updateBrandForm:brcbrandCode]').val();

	} else {
		brccountryId = $(
				'select[name=brandCreateForm:brccountryId] option:selected')
				.val();
		brcbrandName = $('input[name=brandCreateForm:brcbrandName]').val();
		brcbrandCode = $('input[name=brandCreateForm:brcbrandCode]').val();

	}
	var hasError = false;
	if (formName == 'update') {
		$('#brccountryIdEr,#brcbrandNameEr,#brcbrandCodeEr').hide();
	} else {
		$('#brccountryIdEr1,#brcbrandNameEr1,#brcbrandCodeEr1').hide();
	}
	if (brccountryId == "0") {
		if (formName == 'update') {
			$('#brccountryIdEr').show();
		} else {
			$('#brccountryIdEr1').show();
		}
		hasError = true;
	}
	if (brcbrandName == "") {
		if (formName == 'update') {
			$('#brcbrandNameEr').show();
		} else {
			$('#brcbrandNameEr1').show();
		}
		hasError = true;
	}

	if (brcbrandCode == "") {
		if (formName == 'update') {
			$('#brcbrandCodeEr').show();
		} else {
			$('#brcbrandCodeEr1').show();
		}
		hasError = true;
	}

	return !hasError;
}
/* Validate Brand Form Ends */

/* Validate Pack Code Form */

function validatePackCodeForm(formName) {
	var pccountryId = '';
	var pcpromotionId = '';
	var brandID = '';
	var pcpackcode = '';
	var sdatepicker = '';
	var edatepicker = '';
	if (formName == 'update') {
		pccountryId = $(
				'select[name=updatePackCodeForm:pccountryId] option:selected')
				.val();
		pcpromotionId = $(
				'select[name=updatePackCodeForm:pcpromotionId] option:selected')
				.val();

		pcpackcode = $('input[name=updatePackCodeForm:pcpackcode]').val();
		sdatepicker = $('input[name=updatePackCodeForm:sdatepicker]').val();
		edatepicker = $('input[name=updatePackCodeForm:edatepicker]').val();

	} else {
		pccountryId = $(
				'select[name=packCodeCreateForm:pccountryId] option:selected')
				.val();
		pcpromotionId = $(
				'select[name=packCodeCreateForm:pcpromotionId] option:selected')
				.val();

		pcpackcode = $('input[name=packCodeCreateForm:pcpackcode]').val();
		sdatepicker = $('input[name=packCodeCreateForm:sdatepicker]').val();
		edatepicker = $('input[name=packCodeCreateForm:edatepicker]').val();

	}
	var hasError = false;
	if (formName == 'update') {
		$(
				'#pccountryIdEr,#pcpromotionIdEr,#pcpackcodeEr,#sdatepickerEr,#edatepickerEr')
				.hide();
	} else {
		$(
				'#pccountryIdEr1,#pcpromotionIdEr1,#pcpackcodeEr1,#sdatepickerEr1,#edatepickerEr1')
				.hide();
	}
	if (pccountryId == "0") {
		if (formName == 'update') {
			$('#pccountryIdEr').show();
		} else {
			$('#pccountryIdEr1').show();
		}
		hasError = true;
	}
	if (pcpromotionId == "0") {
		if (formName == 'update') {
			$('#pcpromotionIdEr').show();
		} else {
			$('#pcpromotionIdEr1').show();
		}
		hasError = true;
	}

	if (pcpackcode == "") {
		if (formName == 'update') {
			$('#pcpackcodeEr').show();
		} else {
			$('#pcpackcodeEr1').show();
		}
		hasError = true;
	}

	if (sdatepicker == "") {
		if (formName == 'update') {
			$('#sdatepickerEr').show();
		} else {
			$('#sdatepickerEr1').show();
		}
		hasError = true;
	}

	if (edatepicker == "") {
		if (formName == 'update') {
			$('#edatepickerEr').show();
		} else {
			$('#edatepickerEr1').show();
		}
		hasError = true;
	}
	return !hasError;
}

/* Validate Pack Code Form Ends */

/* Validate Report Form */

function validateReportForm(formName) {
	var countryId = '';
	var promotionId = '';
	var from = '';
	var to = '';
	if (formName == 'validate') {
		countryId = $('#countryId option:selected').val();
		promotionId = $('#promotionId option:selected').val();
		from = $('#from').val();
		to = $('#to').val();

	}
	var hasError = false;
	if (formName == 'validate') {
		$('#countryIdEr1,#promotionIdEr1,#fromEr1,#toEr1').hide();
	}
	if (countryId == "0") {
		if (formName == 'validate') {
			$('#countryIdEr1').show();
		}
		hasError = true;
	}
	if (promotionId == "0") {
		if (formName == 'validate') {
			$('#promotionIdEr1').show();
		}
		hasError = true;
	}
	if (from == "") {
		if (formName == 'validate') {
			$('#fromEr1').show();
		}
		hasError = true;
	}
	if (to == "") {
		if (formName == 'validate') {
			$('#toEr1').show();
		}
		hasError = true;
	}
	return !hasError;
}

/* Validate Report Form Ends */

/* Validate User Form */
function validateUserForm(formName) {
	var userName = '';
	var userId = '';
	var password = '';
	var confirmPassword = '';
	var roleId = '';
	var enabled = '';
	if (formName == 'update') {
		userName = $('input[name=updateUserForm:userName]').val();
		userId = $('input[name=updateUserForm:userId]').val();
		password = $('input[name=updateUserForm:password]').val();
		confirmPassword = $('input[name=updateUserForm:confirmPassword]').val();
		roleId = $('select[name=updateUserForm:roleId] option:selected').val();
		enabled = $('input:radio[name=updateUserForm:enabled ]:checked').val();
	} else {
		userName = $('input[name=userCreateForm:userName]').val();
		userId = $('input[name=userCreateForm:userId]').val();
		password = $('input[name=userCreateForm:password]').val();
		confirmPassword = $('input[name=userCreateForm:confirmPassword]').val();
		roleId = $('select[name=userCreateForm:roleId] option:selected').val();
		enabled = $('input:radio[name=userCreateForm:enabled ]:checked').val();
	}
	var hasError = false;
	if (formName == 'update') {
		$(
				'#userNameEr,#userIdEr,#passwordUpdateEr1,#passwordUpdateEr2,#passwordUpdateEr3,#confirmPasswordEr,#confirmPassword2Er,#roleIdEr,#enabledEr')
				.hide();
	} else {
		$(
				'#userNameEr1,#userIdEr1,#passwordEr1,#passwordEr2,#passwordEr3,#confirmPasswordEr1,#confirmPassword2Er1,#roleIdEr1,#enabledEr1')
				.hide();
	}
	if (userName == "") {
		if (formName == 'update') {
			$('#userNameEr').show();
		} else {
			$('#userNameEr1').show();
		}
		hasError = true;
	}
	if (userId == "") {
		if (formName == 'update') {
			$('#userIdEr').show();
		} else {
			$('#userIdEr1').show();
		}
		hasError = true;
	}
	if (password == "") {

		if (formName == 'update') {
			$('#passwordUpdateEr1').show();
		} else {
			$('#passwordEr1').show();
		}
		hasError = true;
	} else if (password.length < 8) {
		if (formName == 'update') {
			$('#passwordUpdateEr2').show();
		} else {
			$('#passwordEr2').show();
		}
		hasError = true;
	} else if (!hasNumber(password)) {
		if (formName == 'update') {
			$('#passwordUpdateEr3').show();
		} else {
			$('#passwordEr3').show();
		}
		hasError = true;
	} else if (confirmPassword == "") {

		if (formName == 'update') {
			$('#confirmPasswordEr').show();
		} else {
			$('#confirmPasswordEr1').show();
		}
		hasError = true;
	} else if ((password != "" && confirmPassword != "" && password != confirmPassword)) {

		if (formName == 'update') {
			$('#confirmPassword2Er').show();
		} else {
			$('#confirmPassword2Er1').show();
		}
		hasError = true;
	}
	if (roleId == "0") {
		if (formName == 'update') {
			$('#roleIdEr').show();
		} else {
			$('#roleIdEr1').show();
		}
		hasError = true;
	}
	if (!enabled) {
		if (formName == 'update') {
			$('#enabledEr').show();
		} else {
			$('#enabledEr1').show();
		}
		hasError = true;
	}
	// if(!hasError){$('.modalCloseImg').trigger('click');}
	return !hasError;
}
/* Validate User Form Ends */
/* Promotion Validation */

function codePrefixIntoUpperCase(currentObject){
	$(currentObject).val(
			$(currentObject).val().toUpperCase().replace(/[^A-T,W-Z]/g,""));
}	
function createPromotion() {
	var country = '';
	var promoName = '';
	var productType = '';
	var numberDays ='';
	var brandReq =false;
	var hasError = false;
	
	// Get the values
	country = $(
			'select[name=createPromotionForm:crpromoCountryId] option:selected')
			.val();
	promoName = $('input[name=createPromotionForm:promotionName]').val();
	productType = $(
			'select[name=createPromotionForm:productTypeId] option:selected')
			.val();
	numberDays = $('.numberofDays').val();
	promotionCodePrefix = $('input[name=createPromotionForm:promotionCodePrefix]').val();
	
	$('#promoCountryIdErr,#promotionNameErr,#productTypeIdErr,#brandMultiselectListErr,#numberofDaysErr,#promotionCodePrefixErr').hide();
	brandReq =($('.rf-pick-tgt .rf-pick-opt').html()==null);
	
	if (country == "0") {
		$('#promoCountryIdErr').show();
		hasError = true;
	}
	if (promoName == "") {
		$('#promotionNameErr').show();
		hasError = true;
	}
	if (productType == "") {
		$('#productTypeIdErr').show();
		hasError = true;
	}
	if( $('.purgeCheckBox').is(':checked') && !isNumeric(numberDays)){
		$('#numberofDaysErr').show();
		hasError = true;
	}
	if(brandReq){
		$('#brandMultiselectListErr').show();
		hasError = true;
	}
	
	if( promotionCodePrefix == "" || promotionCodePrefix.length != 2 ){
		$('#promotionCodePrefixErr').show();
		hasError = true;
	}
			
	return !hasError;

}
function updatePromotion() {
	var promoName = '';
	var hasError = false;
	// Get the values
	promoName = $('input[name=updatePromotionForm:upPromotionName]').val();
	$('#uppromotionNameErr').hide();
	if (promoName == "") {
		$('#uppromotionNameErr').show();
		hasError = true;
	}
	return !hasError;

}

function resetPromoCode() {
	$('.promotionCode').val("");

}
function submitByEnter(e) {
	if (e.keyCode == 13) {
		e.preventDefault();
		document.getElementById("applicantProductListForm:refreshButton")
				.click();
	}
}
function hasNumber(string) {
	var array = string.split('');
	for ( var i = 0; i < array.length; i++) {
		if (!isNaN(array[i] - 0)) {
			return true;
		}
	}
	return false;
}
captureClick = function(e, className) {
    if(e.keyCode == 13) { 
        jQuery(this).blur();
        jQuery('.'+className).focus().click();
        return false; 
    }
};   
function hasSplChar(value){
	var splCharRegex = /^[0-9a-zA-Z*$?_&!%/'.]*$/;
	return !splCharRegex.test(value);
}

//Assign your error handling function to a variable
function userTimeOut() {
    //Handle all errors by simply redirecting to an error page
   if(window.confirm("Your current session has expired. Please click OK to return to the Login page.")){
          window.location.href = "SignIn.xhtml";
    }
}