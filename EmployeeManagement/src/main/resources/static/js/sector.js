	//定数
		//FIXME:変数名を見直す
	const $working = document.getElementsByClassName("exsits");
	console.log($working);
	const $retire = document.getElementsByClassName("bg-secondary");
	console.log($retire);

	 // 在職者表示制御
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
		$radio = document.getElementsByName('radio')
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
	};

	/* 退職ボタン */
	function retireClick() {
		if (window.confirm('この作業は修正できません。本当によろしいですか？')) {
			window.alert('嘘ぴょーん');
		}
		else {
			window.alert('キャンセルされました');
		}
	};