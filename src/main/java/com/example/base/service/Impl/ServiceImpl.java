package com.example.base.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.example.base.service.ServiceEmail;
import com.example.base.util.Email;

import freemarker.template.Template;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class ServiceImpl implements ServiceEmail {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Override
	public void email() throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("content", "看看士大夫士大夫似的");
		String  str=getMailText(freeMarkerConfigurer,"template_1.ftl", map);
		System.out.println(str);
		Email.Emaimain(str);
	}

	public String getMailText(FreeMarkerConfigurer freeMarkerConfigurer, String templateName, Map<String, Object> map)
			throws Exception {
		String htmlText = "";
		// 通过指定模板名获取FreeMarker模板实例
		Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
		// Template tpl =
		// freeMarkerConfiguration.createConfiguration().getTemplate(templateName);
		// FreeMarker通过Map传递动态数据
		// 解析模板并替换动态数据，最终content将替换模板文件中的${content}标签。
		htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
		return htmlText;
	}

}
