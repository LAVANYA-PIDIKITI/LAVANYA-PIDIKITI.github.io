    	let balance = 0;
		let transactions = [];

		function deposit() {
			let amount = parseInt(document.getElementById("deposit").value);
			if(amount <= 0 || isNaN(amount)) {
				alert("Please enter a valid amount");
				return;
			}
			balance += amount;
			transactions.push(`Deposit: +${amount}`);
			document.getElementById("balance").innerHTML = balance;
			document.getElementById("deposit").value = "";
			alert(`Deposit of ${amount} successful. Current balance: ${balance}`);
		}

		function withdraw() {
			let amount = parseInt(document.getElementById("withdraw").value);
			if(amount <= 0 || isNaN(amount)) {
				alert("Please enter a valid amount");
				return;
			}
			if(amount > balance) {
				alert("Insufficient balance");
				return;
			}
			balance -= amount;
			transactions.push(`Withdrawal: -${amount}`);
			document.getElementById("balance").innerHTML = balance;
			document.getElementById("withdraw").value = "";
			alert(`Withdrawal of ${amount} successful. Current balance: ${balance}`);
		}

		function displayStatement() {
			let table = document.getElementById("statement-table");
			table.innerHTML = "";
			let headerRow = table.insertRow(0);
			headerRow.insertCell(0).innerHTML = "<b>Date</b>";
			headerRow.insertCell(1).innerHTML = "<b>Description</b>";
			headerRow.insertCell(2).innerHTML = "<b>Amount</b>";
			for(let i=0; i<transactions.length; i++) {
				let row = table.insertRow(i+1);
				let transaction = transactions[i].split(": ");
				row.insertCell(0).innerHTML = new Date().toLocaleDateString();
				row.insertCell(1).innerHTML = transaction[0];
				row.insertCell(2).innerHTML = transaction[1];
			}
		}