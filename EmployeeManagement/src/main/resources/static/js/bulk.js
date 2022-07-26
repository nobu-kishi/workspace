// jQueryエリア
// FIXME:jQueryとJavasqriptが混在しているので、jQueryに寄せて修正したい
window.addEventListener("DOMContentLoaded", function () {
  // jQuery(function () {
  console.log("jQueryは有効です");

  //送信Listの配列番号を自動採番
  function postListNumbering() {
    $(".postList").each(function (index) {
      $(this)
        .find("input")
        .each(function () {
          var replaceText = $(this)
            .attr("name")
            .replace(/\[[0-9]{1,3}\]/, "[" + index + "]");
          $(this).attr("name", replaceText);
        });
    });
    console.log("送信Lsitを自動採番");
  }

  // console.log($("input"));

  var localData = localStorage.getItem("form_data");
  localData = JSON.parse(localData);
  console.log(localData);

  //ローカルストレージにデータがなければ null が返ってくるので、nullで分岐
  if (localData !== null) {
    console.log("一時保存呼出");
    // $("tr").html("");
    // for (let i = 0; i < localStorage.length; i++) {
    //   $(".postlist").append(
    //     // "<li class='list-group-item'><button class='btn btn-danger mr-2' onclick='deleteItem(" +
    //     //   localStorage.key(i) +
    //     //   ")'><i class='fas fa-trash-alt'></i></button>" +
    //     //   localStorage.getItem(localStorage.key(i)) +
    //     //   "</li>"

    //     "<tr><td><input name=" +
    //       localStorage.key(i) +
    //       " type='text' class='form-control' value=" +
    //       localStorage.getItem(localStorage.key(i)) +
    //       "></td></tr>"
    //   );
    // }
    console.log($(".postlist"));
    for (var index in localData) {
      var data = localData[index];
      var formName = data["name"]; //name属性
      var formVal = data["value"]; //値
      // console.log(formName);
      console.log();
      //$("tr input").val(""); //仮置き
      console
        .log
        // $("[name='formName']").val()
        //.val(formVal)
        ();
      // $(".postList").append(
      // "<li class='list-group-item'><button class='btn btn-danger mr-2' onclick='deleteItem(" +
      //   localStorage.key(i) +
      //   ")'><i class='fas fa-trash-alt'></i></button>" +
      //   localStorage.getItem(localStorage.key(i)) +
      //   "</li>"

      // "<tr><td><input name=" +
      //   formName +
      //   " type='text' class='form-control' value=" +
      //   formVal +
      //   "<td><input name=" +
      //   formName +
      //   " type='text' class='form-control' value=" +
      //   formVal +
      //   "></td>" +
      //   formName +
      //   " type='text' class='form-control' value=" +
      //   formVal +
      //   "></td>" +
      //   formName +
      //   " type='text' class='form-control' value=" +
      //   formVal +
      //   "></td>" +
      //   formName +
      //   " type='text' class='form-control' value=" +
      //   formVal +
      //   "></td>" +
      //   //formName +
      //   " type='text' class='form-control' value=" +
      //   //formVal +
      //   "></td>" +
      //   "></td></tr>"
      // );

      //   // $(input).find("input").Val();
      //   // .each(function () {
      //   //   var replaceText = $(this)
      //   //     .attr("name")
      //   //     .replace(/\[[0-9]{1,3}\]/, "[" + index + "]");
      //   //   $(this).attr("name", replaceText);
      //   // });

      //   // console.log(formName);
      //   // console.log(formVal);

      //   /* もう一度値をセットする処理など.... */
      //   // $("input").val("");

      //   // console.log("フォームに値を再セット");
      //   // console.log($("input[name='formName']"));

      //   // form-control
      //   // let form = $("#bulk-form");
      //   // $("input[name='formName']")
      //   //   .attr("value", formVal)
      //   //   .find("[name='formName']");
      //   // $("[name='formName']"); //.parent().find("input").attr("value", formVal)

      //   // const inputs = $(".input")
      //   //   .each(function (index, element) {
      //   //     return element.value; // valueを取り出す
      //   //   })
      //   //   .get(); // 標準的な配列に変換

      //   // console.log(inputs);

      //   // .parent().find("input")
      //   // .attr("value")
      //   // (formVal)
      //   // $("[name='formName']").attr("value", "formVal");
    }
  } else {
    console.log("一時保存データはありません");
  }

  let $form = $("#bulk-form");
  let $serialize = $form.serialize();
  let $serializeArray = $form.serializeArray();
  console.log($serializeArray);
  // console.log($serialize);

  // console.log("jsonを文字列に");
  // console.log(JSON.stringify($serializeArray));

  // リセット
  $(".reset-table").on("click", function () {
    console.log("リセット");
    $("tr input").val("");
  });

  // 行新規
  $(".insert-row").on("click", function () {
    console.log("行追加");
    $lastRow = $(".table tbody tr:last-child");
    $lastRow
      .clone(true) // 指定した一番初めの行のHTML要素を複製する
      .appendTo(".table tbody"); // 複製した要素をtbodyに追加する
    $(".table tbody tr:last-child input").val("");
    // postListNumbering();
  });

  // 行複製
  $(".clone-row").on("click", function () {
    console.log("複製");
    $lastRow = $(".table tbody tr:last-child");
    $lastRow.clone(true).appendTo(".table tbody"); // 追加した行の値をクリアする

    //【検証】一時保存用Json
    // let form = $("#bulk-form");
    // let formData = form.serialize();
    // console.log(formData);
    // let formDataJson = form.serializeArray();
    // console.log(formDataJson);
    postListNumbering();
  });

  // 行削除
  $(".delete-row").on("click", function () {
    if ($(".table tbody tr").length > 1) {
      $(this) // クリックした削除ボタンを指定する（ ここがthisであることは重要です ）
        .closest("tr") // 指定した要素の直近のtr要素を取得する
        .remove(); // 取得した要素を削除する
    } else {
      console.log("行を削除できません");
    }
    postListNumbering();
  });

  /*
   * $(this).closest("tr").attr(“id");
   */

  // 一時保存

  /*  $text = $("input.elemnts");
  console.log($text);
  $empty = $("input").val;
  console.log($empty);*/
  // console.log($.trim($empty.text()));

  // if (!$('button').val()) {
  // alert('Enter your name!');
  // }

  // $empty = $("input");
  // if ($.trim($empty.text()) == "") {
  // console.log("empty");
  // }

  // $input = $("input").val().length;
  // cosole.log($input);
  // let myValue = $("select").val();
  // let inputArr = $("input").val();
  // cosol.log(inputArr);

  $(".tmp-save").on("click", function () {
    console.log("一時保存");
    let form = $("#bulk-form");
    let formData = form.serializeArray();
    let formJson = JSON.stringify(formData);
    console.log(formJson);
    localStorage.setItem("form_data", formJson);

    // if ($.trim($empty.text()) == "") {
    // $empty = $("input");
    // console.log($empty);
    // if (!data.length) {
    //   window.alert("未入力の項目が存在します");
    // } else {
    //   window.alert("OK");
    // }
  });

  // retireEmployee(employeeId);
  // } else {
  // window.alert("未入力の項目が存在します");
  // }
  // });

  /*
   * tmp-save confirm
   */

  //確定ボタン
  //TODO:Jsでsubmitする
  $(".confirm").on("click", function () {
    if (window.confirm("この作業は修正できません。本当によろしいですか？")) {
      // let employeeId = $(this).attr("id");
      // retireEmployee(employeeId);
      localStorage.removeItem("form_data");
    } else {
      window.alert("キャンセルされました");
    }
  });

  // ajaxでemployeeIdを送信し、ページ遷移せずにページ情報を更新
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
  // });
});
