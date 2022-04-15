package ru.sindm.otus

import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Configuration
open class Configuration {

    @Bean
    open fun namedParameterJdbcTemplate(dateSource: DataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dateSource)
    }

    @Bean
    @Primary
    open fun dateSourceHealthIndicator(dataSource: DataSource): DataSourceHealthIndicator {
        return DataSourceHealthIndicator(dataSource)
    }

}