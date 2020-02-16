function back(){
	window.history.back();
}
function convertToNonUnicode(str) {
	  var result = str.toString();

	  result = result.replace(/\u0110/g, 'D');
	  result = result.replace(/\u0111/g, 'd');
	  result = result.replace(/(\u00c0|\u00c1|\u00c2|\u00c3|\u0102|\u1ea0|\u1ea2|\u1ea4|\u1ea6|\u1ea8|\u1eaa|\u1eac|\u1eae|\u1eb0|\u1eb2|\u1eb4|\u1eb6)/g, 'A');
	  result = result.replace(/(\u00e0|\u00e1|\u00e2|\u00e3|\u0103|\u1ea1|\u1ea3|\u1ea5|\u1ea7|\u1ea9|\u1eab|\u1ead|\u1eaf|\u1eb1|\u1eb3|\u1eb5|\u1eb7)/g, 'a');
	  result = result.replace(/(\u00c8|\u00c9|\u00ca|\u1eb8|\u1eba|\u1ebc|\u1ebe|\u1ec0|\u1ec2|\u1ec4|\u1ec6)/g, 'E');
	  result = result.replace(/(\u00e8|\u00e9|\u00ea|\u1eb9|\u1ebb|\u1ebd|\u1ebf|\u1ec1|\u1ec3|\u1ec5|\u1ec7)/g, 'e');
	  result = result.replace(/(\u00cc|\u00cd|\u0128|\u1ec8|\u1eca)/g, 'I');
	  result = result.replace(/(\u00ec|\u00ed|\u0129|\u1ec9|\u1ecb)/g, 'i');
	  result = result.replace(/(\u00d2|\u00d3|\u00d4|\u00d5|\u01a0|\u1ecc|\u1ece|\u1ed0|\u1ed2|\u1ed4|\u1ed6|\u1ed8|\u1eda|\u1edc|\u1ede|\u1ee0|\u1ee2)/g, 'O');
	  result = result.replace(/(\u00f2|\u00f3|\u00f4|\u00f5|\u01a1|\u1ecd|\u1ecf|\u1ed1|\u1ed3|\u1ed5|\u1ed7|\u1ed9|\u1edb|\u1edd|\u1edf|\u1ee1|\u1ee3)/g, 'o');
	  result = result.replace(/(\u00d9|\u00da|\u0168|\u01af|\u1ee4|\u1ee6|\u1ee8|\u1eea|\u1eec|\u1eee|\u1ef0)/g, 'U');
	  result = result.replace(/(\u00f9|\u00fa|\u0169|\u01b0|\u1ee5|\u1ee7|\u1ee9|\u1eeb|\u1eed|\u1eef|\u1ef1)/g, 'u');
	  result = result.replace(/(\u00dd|\u1ef2|\u1ef4|\u1ef6|\u1ef8)/g, 'Y');
	  result = result.replace(/(\u00fd|\u1ef3|\u1ef5|\u1ef7|\u1ef9)/g, 'y');
	  result = result.replace(" ","-")
	  
	  result = result.toLowerCase();
	  return result;
	}
function show(id,string,typeEvent,title){
	document.getElementById("typeEvent").innerText = typeEvent;
    document.getElementById("inputTitle").innerText = title;
    document.getElementById("idHidden").value = id;
    if(title === 'Error'){
    	document.getElementById("inputText").innerHTML = " <b> "+string+ " </b> ";
    	document.getElementById("btnExe").style.display = "none";
    	document.getElementById("btnCancel").value = "Ok";
    }else if(title === 'Confirm'){
    	document.getElementById("btnExe").style.display = "inline-block";
    	document.getElementById("inputText").innerHTML = " <b> "+ id+" - "+string+ " </b> ";
    }
    document.getElementById("btnCancel").focus();
    document.getElementById("modal").style.display = "block";
}

function hide(){
    document.getElementById("modal").style.display = "none";
}
function checkUnique(paramName,list){
		var param = document.forms[0][paramName].value;
		for(var i = 0 ; i < list.length; i++){
			if(param == list[i].value){
				show(null,param+' đã tồn tại!',paramName,'Error');
				return true;
			}
		}
		return false;
}
function checkLength(paramName, max, min){
	var param = document.forms[0][paramName].value;
	var size = param.length;
	if(size<=min){
		if(min == 0)
			show(null,"Không được để trống",paramName,'Error');
		else
			show(null,"Phải lớn hơn "+min+" ký tự",paramName,'Error');
		return true;
	}else if(size > max){
		show(null,"Phải nhỏ hơn "+max+" ký tự",paramName,'Error');
		return true;
	}else return false;
}
//
var url = window.location.pathname;
var idPage = url.split("/")[3];
document.getElementById(idPage).classList.add("active-menu"); 