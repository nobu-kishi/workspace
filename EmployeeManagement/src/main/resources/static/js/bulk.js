// jQueryエリア
window.addEventListener("DOMContentLoaded", function () {
  // jQuery(function () {
  console.log("jQueryは有効です");
  // データのバリデーション
  // console.log($("#bulk-form"));
  // $("#bulk-form").validate({
  //   rules: {
  //     required: true,
  //     maxlength: 200,
  //   },
  //   messages: {
  //     required: "** 文章を入力してください **",
  //     maxlength: "** 200文字以下で入力して下さい **",
  //   },
  //   errorPlacement: function (error, element) {
  //     element.before(error);
  //   },
  // });
  // var myValue = "this_is_value";
  // var myKey = "this_is_key";
  // var obj = { [myKey]: myValue }; // => {"this_is_key": "this_is_value"}
  // console.log(obj);

  // 参考
  // $("form").validate({
  //   rules: {
  //     employeeName: {
  //       //departmentSectorList[0].employeeName: {
  //       required: true,
  //       maxlength: 200,
  //     },
  //   },
  //   messages: {
  //     departmentSectorList: {
  //       required: "** 文章を入力してください **",
  //       maxlength: "** 200文字以下で入力して下さい **",
  //     },
  //   },
  //   errorPlacement: function (error, element) {
  //     element.before(error);
  //   },
  // });

  //送信Listの配列番号を自動採番
  function postListNumbering() {
    $(".postList").each(function (index) {
      $(this)
        .find("input")
        .each(function () {
          let replaceText = $(this)
            .attr("name")
            .replace(/\[[0-9]{1,3}\]/, "[" + index + "]");
          $(this).attr("name", replaceText);
        });
    });
    // console.log("レコードの配列番号を採番");
  }

  // レコードを生成（初期設定用）
  function createRecord() {
    $("tbody").append(
      "<tr class='postList'><td><input name='departmentSectorList[0].employeeName' type='text' class='form-control' maxlength='20' required></td>" +
        "<td><input name='departmentSectorList[0].area' type='text' class='form-control' maxlength='10' required></td>" +
        "<td><input name='departmentSectorList[0].profit' type='text' class='form-control' pattern='^[0-9]+$' required></td>" +
        "<td><input name='departmentSectorList[0].customer' type='text' class='form-control' pattern='[0-9]' required></td>" +
        "<td><input name='departmentSectorList[0].departmentId' type='number' class='form-control' pattern='[0-9]' min='1' max='4' required></td>" +
        "<td><button name='button' class='btn btn-danger delete-row' type='button'>削除</button></td></tr>"
    );
    postListNumbering();
  }

  //一時保存データがあれば呼出
  let localData = localStorage.getItem("form_data");
  localData = JSON.parse(localData);
  console.log(localData);
  if (localData !== null) {
    console.log("一時保存呼出");
    // 一時保存データに応じて、レコードを生成
    //MEMO:行数をカウントするため、/5を行う
    localDataLength = $(localData).length / 5;
    for (let i = 0; i < localDataLength; i++) {
      createRecord();
    }
    //formに値をセット
    for (let index in localData) {
      let data = localData[index];
      let formName = data["name"]; //name属性
      let formVal = data["value"]; //値
      $('input[name="' + formName + '"]').val(formVal);
    }
  } else {
    console.log("一時保存データはありません");
    createRecord();
  }

  // リセット
  $(".reset-table").on("click", function () {
    console.log("リセット");
    $("tr input").val("");
  });

  // 行新規
  $(".insert-row").on("click", function () {
    console.log("行新規");
    createRecord();
  });

  // 行複製
  $(".clone-row").on("click", function () {
    console.log("複製");
    $lastRow = $(".table tbody tr:last-child");
    $lastRow.clone(true).appendTo(".table tbody"); // 追加した行の値をクリアする
    postListNumbering();
  });

  // 行削除
  $(".delete-row").on("click", function () {
    if ($(".table tbody tr").length > 1) {
      $(this)
        .closest("tr") // 指定した要素の直近のtr要素を取得する
        .remove(); // 取得した要素を削除する
    } else {
      console.log("行を削除できません");
    }
    postListNumbering();
  });

  // 一時保存
  $(".tmp-save").on("click", function () {
    console.log("一時保存");
    let form = $("#bulk-form");
    let formData = form.serializeArray();
    let formJson = JSON.stringify(formData);
    console.log(formJson);
    localStorage.setItem("form_data", formJson);
    window.alert("一時保存しました");
  });

  //確定ボタン
  $(".confirm").on("click", function () {
    if (window.confirm("本当に確定しますか？")) {
      // window.location.href = "/department";
      //ローカルストレージを削除する
      localStorage.removeItem("form_data");
    } else {
      window.alert("キャンセルされました");
      // validationCheck();
      return false;
    }
  });

  // ajax参考
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
