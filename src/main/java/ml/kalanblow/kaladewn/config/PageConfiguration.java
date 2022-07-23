package ml.kalanblow.kaladewn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class PageConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

		viewControllerRegistry.addViewController("/").setViewName("index");
		viewControllerRegistry.addViewController("/student/all").setViewName("allStudent");
		viewControllerRegistry.addViewController("/student/create").setViewName("createStudent");
		viewControllerRegistry.addViewController("/student/edit/{id}").setViewName("editStudent");
		viewControllerRegistry.addViewController("/student/delete/{id}").setViewName("editStudent");
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver(); // <.>
	}

	@Bean
	public LocaleChangeInterceptor localeInterceptor() { // <.>
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		return localeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) { // <.>
		registry.addInterceptor(localeInterceptor());
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}

}
