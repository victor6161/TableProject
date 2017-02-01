function selectRow(tableWidjet, rowNumber, rowPerPage) {
	tableWidjet.unselectAllRows();
	tableWidjet.selectRow(rowNumber - tableWidjet.paginator.getCurrentPage()
			* rowPerPage, false);
}