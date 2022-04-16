/*package coursework.computer.main.SpringSessionController;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class SpringSessionConfig {



        @Bean
        @Primary
        @ConfigurationProperties("primary.datasource")
        public DataSourceProperties primaryDataSourceProperties() {
            return new DataSourceProperties();
        }

        @Bean
        @Primary
        public DataSource primaryDataSource() {
            return primaryDataSourceProperties().initializeDataSourceBuilder()
                    .type(HikariDataSource.class).build();
        }

        @Bean
        @ConfigurationProperties("session.datasource")
        public DataSourceProperties sessionDataSourceProperties() {
            return new DataSourceProperties();
        }

        @Bean
        @SpringSessionDataSource
        public DataSource springSessionDataSource() {
            return sessionDataSourceProperties().initializeDataSourceBuilder()
                    .type(HikariDataSource.class).build();

    }
}*/
