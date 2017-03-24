package com.iba.kozlov.web.component;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.apache.log4j.Logger;

@FacesComponent(value = "HtmlHelloWorld")
@ResourceDependencies({
	@ResourceDependency(library = "js",name = "d3.js" ,target="head"),
	@ResourceDependency(library = "js",name = "nv.d3.min.js",target="head" ),
	@ResourceDependency(library = "js",name = "barChart.js" ,target="head")
})
public class HtmlHelloWorld extends UIComponentBase {
	private static final Logger LOGGER = Logger.getLogger(HtmlHelloWorld.class);

	private final int topFiveWriter = 5;

	@Override
	public String getFamily() {
		LOGGER.info("getFamily");
		return "com.iba.kozlov";
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		LOGGER.info("encodeBegin");

		DataModel dataModel = (DataModel) this.getAttributes().get("model");
		
		 
		ResponseWriter writer = context.getResponseWriter();
		writer.write("TOP 5 Most Popular Writer");
		StringBuffer json = new StringBuffer();

		//json.append("\nfunction exampleData() {\n");
		json.append("var chartValue =  [\n");
		json.append("{\n");
		json.append("key: 'Cumulative Return',\n");
		json.append("values: [\n");
		
		for(int i=0;i<topFiveWriter;i++){
			json.append("{ \n");
			json.append(String.format("'label' : '%s',\n", dataModel.getChartValue().get(i).getWriterSurname()));
			json.append(String.format("'value' : '%s'\n", dataModel.getChartValue().get(i).getBookAmount()));
			json.append(" } , \n");
		}
		json.append(" ]  \n");
		json.append(" }  \n");
		json.append(" ]  \n");
		//json.append(" }  \n");

		StringBuffer html = new StringBuffer();
		html.append("<div id='chart'>");
		html.append("<svg></svg>");
		html.append("</div>");

		writer.write(html.toString());

		StringBuffer javascript = new StringBuffer();
		javascript.append("\n<script>");
		javascript.append(json.toString());
		javascript.append(String.format("var model={isStaggerValue:'%s',isTooltips:'%s',isShowValue:'%s'};\n",dataModel.isStaggerLabels(), dataModel.isTooltips(),dataModel.isShowValues()));
		
		javascript.append("test(model);\n");

		javascript.append("</script>");
		writer.write(javascript.toString());

	}

}

/*		DataModel dataModel = (DataModel) this.getAttributes().get("model");

ResponseWriter writer = context.getResponseWriter();

writer.write("TOP 5 Most Popular Writer");	
StringBuffer html = new StringBuffer();
html.append(String.format("<div id='%s'>", dataModel.getIdChart()));
html.append("<svg></svg>");
html.append("</div>");

writer.write(html.toString());

StringBuffer javascript = new StringBuffer();
StringBuffer json = new StringBuffer();
json.append("var chartValue =  [\n");
json.append("{\n");
json.append(String.format("key: '%s',\n",dataModel.getKey()));
json.append("values: [\n");

for (int i = 0; i < topFiveWriter; i++) {
	json.append("{ \n");
	json.append(String.format("'label' : '%s',\n", dataModel.getChartValue().get(i).getWriterSurname()));
	json.append(String.format("'value' : '%s'\n", dataModel.getChartValue().get(i).getBookAmount()));
	json.append(" } , \n");
}
json.append(" ]  \n");
json.append(" }  \n");
json.append(" ]  \n");
javascript.append("\n<script>");
javascript.append(json.toString());
javascript.append("\nnv.addGraph(function() {\n");
javascript.append(" var chart = nv.models.discreteBarChart()\n ");
javascript.append(".x(function(d) { return d.label })\n");
javascript.append(".y(function(d) { return d.value })\n");
javascript.append(".staggerLabels(true)\n");
javascript.append(".tooltips(false)\n");
javascript.append(".showValues(true) \n");

javascript.append("d3.select('#chart svg')\n");
javascript.append(".datum(charValue)\n");
javascript.append(".transition().duration(500)\n");
javascript.append(".call(chart)\n");
javascript.append(";\n");

javascript.append(" nv.utils.windowResize(chart.update);\n");
javascript.append(" return chart;\n");

javascript.append(" });\n");


javascript.append("</script>");
writer.write(javascript.toString());*/
