package fr.ajcbanque.projetBFI;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:*-context.xml")
@ComponentScan(basePackages = { "fr.ajcbanque.projetBFI.repositories",
	"fr.ajcbanque.projetBFI.services",
	"fr.ajcbanque.projetBFI.components" })
@EnableJpaRepositories("fr.ajcbanque.projetBFI.repositories")
@EnableTransactionManagement
public class AppConfig {
    // Empty class
}
