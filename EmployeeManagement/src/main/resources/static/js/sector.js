
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


const form = /*[[${item.employeeId}]]*/"employeeId";
console.log(employeeId);



/*------------------------------------------------------------------------------------------------------------*/
/** 画⾯ロード時の処理. */
jQuery(function($) {
	/** 更新ボタンを押したときの処理. */
	$("#btn-update").click(function(event) {
		// ユーザー更新
		updateUser();
	});
	/** 削除ボタンを押したときの処理. */
	$("#btn-delete").click(function(event) {
		// ユーザー削除
		deleteUser();
	});
});

/** ユーザー更新処理. */
function updateUser() {
	// フォームの値を取得
		/*var formData = $("#user-detail-form").serialize;*/


	Array();
	// ajax通信
	$.ajax({
		type : "PUT",
		cache : false,
		url : "/department/retire",
		data : formData,
		dataType : "json",
	}).done(function(data) {
		// ajax成功時の処理
		alert("ユーザーを更新しました");
		// ユーザー⼀覧画⾯にリダイレクト
			/*window.location.href = "/user/list";*/
	}).fail(function(jqXHR, textStatus, errorThrown) {
		// ajax失敗時の処理
		alert("ユーザー更新に失敗しました");
	}).always(function() {
		// 常に実⾏する処理
	});
}
