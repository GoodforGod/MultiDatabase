package com.univ.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
//@Configuration
//@EnableCassandraRepositories(basePackages = "com.univ.db")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "sample";
    }

    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster =
                new CassandraClusterFactoryBean();
        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9042);
        return cluster;
    }

    @Bean
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE;
    }

    @Bean
    @Override
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}
