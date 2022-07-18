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

/*------------------------------------------------------------------------------------------------------------*/

// jQueryエリア
//FIXME:jQueryとJavasqriptが混在しているので、jQueryに寄せて修正したい
window.addEventListener("DOMContentLoaded", function () {
  /* alert('jQueryは有効です') */
  console.log("jQueryは有効です");

  // コメント必須チェック設定
  // function nullChcek() {
  //   $("input").validate({
  //     rules: {
  //       input要素のname: {
  //         有効化するルール: true,
  //       },
  //     },
  //     messages: {
  //       input要素のname: {
  //         有効化するルール: "エラーとして表示したい文言",
  //       },
  //     },
  //   });
  // }

  //リセット
  $(".reset-table").on("click", function () {
    console.log("リセット");
    $("input").val("");
  });

  //行追加
  $(".insert-row").on("click", function () {
    console.log("行追加");
    $(".table tbody tr:first-child") // テーブルの一番初めの行を指定する
      .clone(true) // 指定した一番初めの行のHTML要素を複製する
      .appendTo(".table tbody"); // 複製した要素をtbodyに追加する
    $(".table tbody tr:last-child input").val(""); // 追加した行の値をクリアする
  });

  //行複製
  $(".clone-row").on("click", function () {
    console.log("複製");
    $(".table tbody tr:last-child").clone(true).appendTo(".table tbody");
    $(".table tbody tr:last-child input");
  });

  //行削除
  $(".delete-row").on("click", function () {
    $(this) // クリックした削除ボタンを指定する（ ここがthisであることは重要です ）
      .closest("tr") // 指定した要素の直近のtr要素を取得する
      .remove(); // 取得した要素を削除する
  });

  //一時保存
  $text = $("input.elemnts]");
  console.log($text);
  $empty = $("input").val;
  console.log($empty);
  // console.log($.trim($empty.text()));

  //   if (!$('button').val()) {
  //     alert('Enter your name!');
  // }

  // $empty = $("input");
  // if ($.trim($empty.text()) == "") {
  //   console.log("empty");
  // }

  // $input = $("input").val().length;
  // cosole.log($input);
  // var myValue = $("select").val();
  // let inputArr = $("input").val();
  // cosol.log(inputArr);

  $(".tmp-save").on("click", function () {
    // if ($.trim($empty.text()) == "") {
    // $empty = $("input");
    // console.log($empty);

    if (!data.length) {
      window.alert("未入力の項目が存在します");
    } else {
      window.alert("OK");
    }
  });

  //     retireEmployee(employeeId);
  //   } else {
  //     window.alert("未入力の項目が存在します");
  //   }
  // });

  /*
tmp-save
confirm*/

  $(".btn-danger").on("click", function () {
    if (window.confirm("この作業は修正できません。本当によろしいですか？")) {
      let employeeId = $(this).attr("id");
      retireEmployee(employeeId);
    } else {
      window.alert("キャンセルされました");
    }
  });

  //ajaxでemployeeIdを送信し、ページ遷移せずにページ情報を更新
  function retireEmployee(employeeId) {
    console.log("employeeIdは「" + employeeId + "」");

    Array();
    $.ajax({
      type: "PUT",
      cache: false,
      url: "/department/retire/" + employeeId,
      data: employeeId,
      dataType: "json",
    })
      .done(function (data) {
        /* alert('社員番号「' + employeeId + "」は退職しました"); */
        console.log("社員番号「" + employeeId + "」は退職しました");
        /* window.location.href = "/department/sector"; */
        window.location.reload();
      })
      .fail(function (jqXHR, textStatus, errorThrown) {
        alert("ユーザー更新に失敗しました");
      })
      .always(function () {
        // 常に実行する処理
      });
  }
});
