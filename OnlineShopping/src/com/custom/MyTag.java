package com.custom;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag extends SimpleTagSupport {

	private Date dNow = new Date();
	private SimpleDateFormat ft;// = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	private String fontColor;
	private String fontSize;
	private String dateFormat;
	private String timeFormat;

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();

		String s = dateFormat + " 'at' " + timeFormat;
		ft = new SimpleDateFormat(s);

		out.println(
				"<span style=\"color:" + fontColor + "; font-size:" + fontSize + ";\">" + ft.format(dNow) + "</span>");
		//System.out.println("Current Date: " + ft.format(dNow));
	}

}
