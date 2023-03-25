package uz.ulugbek.studentproject.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
//@EnableTransactionManagement
//@RequiredArgsConstructor
public class DataBaseConfig {

//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSourceProperties dataSourceProperties() {
//        return new DataSourceProperties();
//    }

    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
//            final EntityManagerFactoryBuilder primaryBuilder,
//            final DataSource dataSource,
//            HashMap<String, Object> ormProps
//            ) {
//
//        return primaryBuilder
//                .dataSource(dataSource)
//                .packages("uz.ulugbek.studentproject.domain")
//                .persistenceUnit("primary")
//                .properties(ormProps)
//                .build();
//    }

}
