package ml.kalanblow.kaladewn.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class KaladewnConfig {
	@Bean
	@Description("Thymeleaf template engine with Spring integration")
	public SpringTemplateEngine templateEngine() {
		var templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(thymeleafTemplateResolver());
		templateEngine.addDialect(new LayoutDialect());

		return templateEngine;
	}

	@Bean
	@Description("Thymeleaf template resolver serving HTML 5")
	public ClassLoaderTemplateResolver thymeleafTemplateResolver() {
		var templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setCheckExistence(true);
		templateResolver.setOrder(0);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		return templateResolver;
	}

	@Bean
	public ITemplateResolver svgTemplateResolver() {
		var  resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("classpath:/templates/svg/");
		resolver.setSuffix(".svg");
		resolver.setOrder(1);
		resolver.setTemplateMode("XML");

		return resolver;
	}

	@Bean
	@Description("Thymeleaf view resolver")
	public ViewResolver viewResolver() {

		var viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCache(false);
	    viewResolver.setViewNames(new String[] {"*.html"});
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean (MessageSource messageSource) {
		
		LocalValidatorFactoryBean bean= new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource);
		
		return bean;
	}
}
