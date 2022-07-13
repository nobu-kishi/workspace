
// 定数
// FIXME:変数名を見直す
const $working = document.getElementsByClassName("exsits");
console.log($working);
const $retire = document.getElementsByClassName("bg-secondary");
console.log($retire);
const $row = document.getElementsByTagName("tr");
console.log($row);

// 現職者表示制御
const showWorking = () => {
  let $workingIndex = 0;
  while ($workingIndex < $working.length) {
    $working[$workingIndex].style.display = "";
    $workingIndex++;
  }
};

const hideWorking = () => {
  let $workingIndex = 0;
  while ($workingIndex < $working.length) {
    $working[$workingIndex].style.display = "none";
    $workingIndex++;
  }
};

// 退職者表示制御
const showRretire = () => {
  let $retireIndex = 0;
  while ($retireIndex < $retire.length) {
    $retire[$retireIndex].style.display = "";
    $retireIndex++;
  }
};

const hideRretire = () => {
  let $retireIndex = 0;
  while ($retireIndex < $retire.length) {
    $retire[$retireIndex].style.display = "none";
    $retireIndex++;
  }
};

// 現職者・退職者社員絞り込み
function selectClick() {
  $radio = document.getElementsByName("radio");
  if ($radio[0].checked) {
    showWorking();
    showRretire();
  } else if ($radio[1].checked) {
    showWorking();
    hideRretire();
  } else if ($radio[2].checked) {
    hideWorking();
    showRretire();
  }
}

/* 退職ボタン */
function retireClick() {
  if (window.confirm("この作業は修正できません。本当によろしいですか？")) {
    window.alert("アップデート文を流す");


  } else {
    window.alert("キャンセルされました");
  }
}



/*------------------------------------------------------------------------------------------------------------*/

//jQueryエリア
window.addEventListener('DOMContentLoaded', function(){
	/*alert('jQueryは有効です')*/
	console.log('jQueryは有効です');


	$('.btn-danger').click(function(event) {
		var employeeId =  $(this).attr("id");
	    /*alert(employeeId);*/
	    retireEmployee(employeeId);
	});

	function retireEmployee(employeeId) {
		console.log('employeeIdは「' + employeeId + '」');

		Array();
		$.ajax({
			type : "PUT",
			cache : false,
			url : "/department/retire/" + employeeId,
			data : employeeId,
			dataType : "json",
		}).done(function(data) {
			// ajax成功時の処理
			alert('社員番号「' + employeeId + "」は退職しました");
				/*window.location.href = "/department/sector";*/
				window.location.reload();
		}).fail(function(jqXHR, textStatus, errorThrown) {
			// ajax失敗時の処理
			alert("ユーザー更新に失敗しました");
		}).always(function() {
			// 常に実行する処理
		});
	};
});
