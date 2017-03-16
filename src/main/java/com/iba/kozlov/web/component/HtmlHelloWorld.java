package com.iba.kozlov.web.component;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.apache.log4j.Logger;



@FacesComponent(value = "HtmlHelloWorld")
public class HtmlHelloWorld extends UIComponentBase {
	private static final Logger LOGGER = Logger.getLogger(HtmlHelloWorld .class);
	@Override
	public String getFamily() {
		LOGGER.info("getFamily");
		return "com.iba.kozlov";
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		LOGGER.info("encodeAll");
		ResponseWriter writer = context.getResponseWriter();
		
		writer.write("Hello World!");
		StringBuilder html=new StringBuilder();
		html.append("<div id='chart'>");
		html.append("<svg></svg>");
		html.append("</div>");
		
		writer.write(html.toString());
		StringBuilder javascript=new StringBuilder();
		javascript.append("<script>");
		
		javascript.append("nv.addGraph(function() {");
		javascript.append("var chart = nv.models.discreteBarChart()");
		javascript.append(".x(function(d) { return d.label })");
		javascript.append(".y(function(d) { return d.value })");
		javascript.append(".staggerLabels(true)");
		javascript.append(".tooltips(false)");
		javascript.append(".showValues(true)");
		
		javascript.append("d3.select('#chart svg')");
		javascript.append(".datum(data)");
		javascript.append(".transition().duration(500)");
		javascript.append(".call(chart)");
		javascript.append(";");
		
		javascript.append("nv.utils.windowResize(chart.update);");
		javascript.append("return chart;");
		
		javascript.append("});");
		
		javascript.append("</script>");
		writer.write(javascript.toString());
		
	}

}
