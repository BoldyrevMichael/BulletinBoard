package ru.boldyrev.ma.spring1.bulletinboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import ru.boldyrev.ma.spring1.bulletinboard.config.security.SecurityConfig;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ru.boldyrev.ma.spring1.bulletinboard.repository")
@ComponentScan("ru.boldyrev.ma.spring1.bulletinboard.service")
//@Import(SecurityConfig.class)
public class AppConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/spring1dz3");
        dataSource.setUsername("geekuser");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setPassword("geekuser");
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        // Создание класса фабрики, реализующей интерфейс FactoryBean<EntityManagerFactory>
        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        // Задание источника подключения
        factory.setDataSource(getDataSource());
        // Задание адаптера для конкретной реализации JPA
        // указывает, какая именно библиотека будет использоваться в качестве поставщика постоянства
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        // Указание пакетов, в которых будут находиться классы-сущности
        factory.setPackagesToScan("ru.boldyrev.ma.spring1.bulletinboard.entity");
        // Создание свойств для настройки Hibernate
        final Properties properties = new Properties();
        // Указание диалекта конкретной базы данных – необходимо для генерации запросов Hibernate к БД
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        // Указание максимальной глубины связи (будет рассмотрено в следующем уроке)
        properties.put("hibernate.max_fetch_depth", 3);
        // Определение максимального количества строк, возвращаемых за один запрос из БД
        properties.put("hibernate.jdbc.fetch_size", 50);
        // Определение максимального количества запросов при использовании пакетных операций
        properties.put("hibernate.jdbc.batch_size", 10);
        // Включает логирование
        properties.put("hibernate.show_sql", true);
        //Создание таблиц автоматически, update: update the schema.
        properties.put("hibernate.hbm2ddl.auto", "update");
        factory.setJpaProperties(properties);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
