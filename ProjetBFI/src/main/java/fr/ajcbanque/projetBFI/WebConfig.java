package fr.ajcbanque.projetBFI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@Import(value = { AppConfig.class}) // rajouter SecurityConfig.class lorsqu'on attatque loginService
@EnableWebMvc
@ComponentScan("fr.ajcbanque.projetBFI.controllers")
public class WebConfig implements WebMvcConfigurer {
    /**
     * Configuration des ressources statiques afin d'éviter les filtres inutiles
     * sur les requêtes.
     * <p>
     * Classiquement tous les fichiers JS, CSS et images.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/static/**")
		.addResourceLocations("/static/");
    }

    /**
     * Configuration des JSP, chemin et extension.
     */
    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setViewClass(JstlView.class);
	viewResolver.setPrefix("/WEB-INF/jspf/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
    }

    /**
     * Configuration des fichiers properties contenant les messages
     * externalisés.
     */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
	ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
	source.setBasename("classpath:messages");
	return source;
    }

    /**
     * Configuration de du paramètre de langue pour l'application.
     */
    @Bean
    public CookieLocaleResolver localeResolver() {
	CookieLocaleResolver resolver = new CookieLocaleResolver();
	resolver.setCookieName(AppLanguage.CODE);
	resolver.setDefaultLocale(AppLanguage.FR.getLocale());
	return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	interceptor.setParamName(AppLanguage.CODE);
	registry.addInterceptor(interceptor);
    }

    /**
     * Configuration des fichiers properties contenant les messages d'erreur de
     * validation.
     */
    @Bean
    public ReloadableResourceBundleMessageSource validationMessageSource() {
	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	messageSource.setBasename("classpath:errors");
	return messageSource;
    }

    @Override
    public Validator getValidator() {
	LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	validator.setValidationMessageSource(validationMessageSource());
	return validator;
    }
}