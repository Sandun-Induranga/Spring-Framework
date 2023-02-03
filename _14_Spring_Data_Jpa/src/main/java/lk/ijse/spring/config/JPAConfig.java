package lk.ijse.spring.config;

import lk.ijse.spring.repo.CustomerRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
@EnableJpaRepositories(basePackageClasses = {CustomerRepo.class})
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter vendorAdapter) {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("lk.ijse.spring.entity");
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(vendorAdapter);

        return factoryBean;

    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db?createDatabaseIfNotExist=true");
        dataSource.setUsername("sandu");
        dataSource.setPassword("1234");
        return dataSource;

    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(true); // Creates Queries
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
        vendorAdapter.setShowSql(true);
        return vendorAdapter;

    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory managerFactory){

        return new JpaTransactionManager(managerFactory);

    }

}
