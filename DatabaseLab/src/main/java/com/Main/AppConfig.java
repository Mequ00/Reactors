package com.Main;

import com.DataBase.JpaConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com")
@EnableJpaRepositories(basePackages = "com.DataBase.Repositories")
@Import(JpaConfig.class)
@EnableTransactionManagement
public class AppConfig {
}
