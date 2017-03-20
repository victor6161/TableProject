package com.iba.kozlov.web.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.apache.log4j.Logger;

@FacesComponent(value = "HtmlHelloWorld")
public class HtmlHelloWorld extends UIComponentBase {
	private static final Logger LOGGER = Logger.getLogger(HtmlHelloWorld.class);

	@Override
	public String getFamily() {
		LOGGER.info("getFamily");
		return "com.iba.kozlov";
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		LOGGER.info("encodeAll");

		//создать класс со значениями авторов
		
		ResponseWriter writer = context.getResponseWriter();
		writer.write("Hello World!");
		StringBuffer json = new StringBuffer();

		json.append("\nfunction exampleData() {\n");
		json.append("return  [\n");
		json.append("{\n");
		json.append("key: 'Cumulative Return',\n");
		json.append("values: [\n");
		json.append("{ \n");
		json.append("'label' : 'A Label' ,\n");
		json.append("'value' : -29.765957771107\n");
		json.append(" } , \n");
		json.append(" { \n");
		json.append("  'label' : 'B Label' ,  \n");
		json.append("'value' : 21\n");
		json.append(" }  \n");
		json.append(" ]  \n");
		json.append(" }  \n");
		json.append(" ]  \n"); 
		json.append(" }  \n");

		StringBuffer html = new StringBuffer();
		html.append("<div id='chart'>");
		html.append("<svg></svg>");
		html.append("</div>");
		

		writer.write(html.toString());

		StringBuffer javascript = new StringBuffer();
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
		javascript.append(".datum(exampleData())\n");
		javascript.append(".transition().duration(500)\n");
		javascript.append(".call(chart)\n");
		javascript.append(";\n");

		javascript.append(" nv.utils.windowResize(chart.update);\n");
		javascript.append(" return chart;\n");

		javascript.append(" });\n");

		javascript.append("</script>");
		writer.write(javascript.toString());

	}

}
