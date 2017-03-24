function test(isStaggerValue,isTooltips,isShowValue){
nv.addGraph(function() {
	var chart = nv.models.discreteBarChart()
		.x(function(d) { return d.label })
		.y(function(d) { return d.value })
		.staggerLabels(isStaggerValue)
		.tooltips(isTooltips)
		.showValues(isShowValue)

	d3.select('#chart svg')
		.datum(chartValue)
		.transition().duration(500)
		.call(chart)
		;
	nv.utils.windowResize(chart.update);
	return chart;
 });
}