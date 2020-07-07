package com.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.javers.core.Javers;
import org.javers.hibernate.integration.HibernateUnproxyObjectAccessHook;
import org.javers.repository.sql.ConnectionProvider;
import org.javers.repository.sql.DialectName;
import org.javers.repository.sql.JaversSqlRepository;
import org.javers.repository.sql.SqlRepositoryBuilder;
import org.javers.spring.auditable.AuthorProvider;
import org.javers.spring.auditable.CommitPropertiesProvider;
import org.javers.spring.auditable.SpringSecurityAuthorProvider;
import org.javers.spring.auditable.aspect.springdata.JaversSpringDataJpaAuditableRepositoryAspect;
import org.javers.spring.jpa.JpaHibernateConnectionProvider;
import org.javers.spring.jpa.TransactionalJaversBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.common.persistance.springjpaaudit.AuditorAwareImpl;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource({ "classpath:/com/config/prop/persistence-mysql.properties" })
@ComponentScan({"com.db"})
@EnableJpaRepositories(basePackages = "org.model")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")

public class PersistenceJPAConfig {

    @Autowired
    private Environment env;
    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    public PersistenceJPAConfig() {
        super();
    }

    // beans
  

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.model.user"});

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        
        em.setJpaProperties(additionalProperties());
        em.getJpaPropertyMap().put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(beanFactory));
        
       
        
       
        return em;
    }

    @Bean
    public DataSource dataSource() {
    	
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
        dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
        dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
        dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    
   /* @Bean not required after hirbernate 5.5
    public FactoryBean<SessionFactory>  sessionFactory() {
    	//HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
        //factory.setEntityManagerFactory(entityManagerFactory().getObject());
    	 HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
         factory.setEntityManagerFactory(entityManagerFactory().getObject());
         
         
    	/*SessionFactory  sessionFactory=  emf.unwrap(SessionFactory.class);
    	sessionFactory.withOptions().interceptor(new CustomInterceptor());*/
    	
    	
    	/*BootstrapServiceRegistry bootstrapServiceRegistry = new BootstrapServiceRegistryBuilder()
    			  .applyClassLoader()
    			 .applyIntegrator(EventListenerIntegrator.INSTANCE)
    			  .applyStrategySelector()
    			  .build();
    	Properties properties = new Properties();
    	properties.putAll(emf.getProperties());
    	StandardServiceRegistryBuilder standardServiceRegistryBuilder = 
    			  new StandardServiceRegistryBuilder(bootstrapServiceRegistry);
    	
    	standardServiceRegistryBuilder.applySettings(properties);
     
    	MetadataSources metadataSources = new MetadataSources(standardServiceRegistryBuilder.build());
         	SessionFactoryBuilder sessionFactoryBuilder = metadataSources.buildMetadata().getSessionFactoryBuilder();
    	 Supply a SessionFactory-level Interceptor
    	sessionFactoryBuilder.applyInterceptor( new CustomSessionFactoryInterceptor() );

    	Add a custom observer
    	sessionFactoryBuilder.addSessionFactoryObservers( new CustomSessionFactoryObserver() );
        
    	// Apply a CDI BeanManager ( for JPA event listeners )
    	//sessionFactoryBuilder.applyBeanManager( emf );
    	//sessionFactoryBuilder.build();
    	
      return factory;
    } */
    
 
   /* @Bean
    public HibernateJpaSessionFactoryBean  sessionFactory() {
     return new LocalSessionFactoryBuilder(dataSource())
     .addAnnotatedClasses(Person.class, Account.class)
     .buildSessionFactory();
    }
*/
    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        
        hibernateProperties.setProperty(AvailableSettings.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.connection.autocommit", "false");
        hibernateProperties.put("hibernate.session_factory.interceptor", "com.common.persistance.CustomInterceptor");
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
       /* hibernateProperties.put(
                "hibernate.integrator_provider",
                (IntegratorProvider) () -> Collections.singletonList(
                    new EventListenerIntegrator()
                )
            );*/
        return hibernateProperties;
    }

  //.. JaVers setup ..

    /**
     * Creates JaVers instance with {@link JaversSqlRepository}
     */
    @Bean
    public Javers javers(PlatformTransactionManager txManager) {
        JaversSqlRepository sqlRepository = SqlRepositoryBuilder
                .sqlRepository()
                .withConnectionProvider(jpaConnectionProvider())
                .withDialect(DialectName.MYSQL)
                .build();

        return TransactionalJaversBuilder
                .javers().withTxManager(txManager)
                .withObjectAccessHook(new HibernateUnproxyObjectAccessHook())
                .registerJaversRepository(sqlRepository)
                .build();
    }
    
    @Bean
    public ConnectionProvider jpaConnectionProvider() {
        return new JpaHibernateConnectionProvider();
    }
    
    /**
     * Enables auto-audit aspect for Spring Data repositories. <br/>
     *
     * Use {@link org.javers.spring.annotation.JaversSpringDataAuditable}
     * to annotate CrudRepository, PagingAndSortingRepository or JpaRepository
     * you want to audit.
     */
    @Bean
    public JaversSpringDataJpaAuditableRepositoryAspect javersSpringDataAspect(Javers javers) {
        return new JaversSpringDataJpaAuditableRepositoryAspect(javers, authorProvider(),
            commitPropertiesProvider());
    }
    
    /**
     * Optional for auto-audit aspect. <br/>
     * @see CommitPropertiesProvider
     */
    @Bean
    public CommitPropertiesProvider commitPropertiesProvider() {
        return () -> ImmutableMap.of("key", "ok");
    }
    @Bean
    public AuthorProvider authorProvider() {
        return new SpringSecurityAuthorProvider();
    }
   /* @Autowired
    @Bean(name = "userDao")
    public UserDAO getUserDao() {
    	return new UserDAOImpl();
    }
*/
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl<String>();
    }    
    
    
}