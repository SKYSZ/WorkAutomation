package com.generate.method.section.impl;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import com.generate.method.section.BaseMethod;
import com.generate.model.SectionTemplate;
import com.generate.model.config.BaseConfig;
import com.generate.util.ParseXMLTemplateHelper;
import com.generate.util.SelectorUtils;

public class BaseMethodImpl implements BaseMethod {
	
	public static final ParseXMLTemplateHelper parseXMLTemplateHelper = ParseXMLTemplateHelper.getInstance(); 
	public static final List<SectionTemplate> xmlTemplates = ParseXMLTemplateHelper.sectionTemplates;
	private static final String METHODNAME = "baseMethod";
	private static Map<String,String> sections = ParseXMLTemplateHelper.getSectionTemplate(METHODNAME).getSections();
	
	public BaseMethodImpl() {
		super();
		//can find XML file 
		List<String> methodNames = ParseXMLTemplateHelper.methodNames;
		Assert.assertTrue("Named ["+METHODNAME+"] must be not found , Plase check the XML! ", methodNames.contains(METHODNAME));
	}

	@Override
	public String definedMethod(BaseConfig config) {
		String value = config.getName();
		String source = sections.get("definedMethod");
		String regex = "name";
		return SelectorUtils.assignmentPlaceholder(source,value,regex);
	}

	@Override
	public String definedParameters(BaseConfig config) {
		String value = config.getParameter();
		String source = sections.get("definedParameters");
		String regex = "parameter";
		return SelectorUtils.assignmentPlaceholder(source,value,regex);
	}

	@Override
	public String definedRequestParameters(BaseConfig config) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnNull() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnMapping(BaseConfig config) {
		String value = config.getMapping();
		String source = sections.get("returnMapping");
		String regex = "mapping";
		return SelectorUtils.assignmentPlaceholder(source,value,regex);
	}

}