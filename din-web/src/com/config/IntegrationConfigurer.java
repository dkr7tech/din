package com.config;

import java.util.Properties;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.din.integration.JMSServiceReceiver;
import com.din.integration.JMSServiceSender;
import com.din.integration.JmsProvider;

@Configuration

@EnableTransactionManagement
@PropertySource({ "classpath:/com/config/prop/persistence-mysql.properties" })
@ComponentScan({ "com.db", "com.service.user" })
@EnableJms
public class IntegrationConfigurer {

	@Autowired
	private Environment env;
	// @Value("${broker-url}")
	private String brokerUrl;
	

	/*
	 * @Bean not required after hirbernate 5.5 public FactoryBean<SessionFactory>
	 * sessionFactory() { //HibernateJpaSessionFactoryBean factory = new
	 * HibernateJpaSessionFactoryBean();
	 * //factory.setEntityManagerFactory(entityManagerFactory().getObject());
	 * HibernateJpaSessionFactoryBean factory = new
	 * HibernateJpaSessionFactoryBean();
	 * factory.setEntityManagerFactory(entityManagerFactory().getObject());
	 * 
	 * 
	 * /*SessionFactory sessionFactory= emf.unwrap(SessionFactory.class);
	 * sessionFactory.withOptions().interceptor(new CustomInterceptor());
	 */

	/*
	 * BootstrapServiceRegistry bootstrapServiceRegistry = new
	 * BootstrapServiceRegistryBuilder() .applyClassLoader()
	 * .applyIntegrator(EventListenerIntegrator.INSTANCE) .applyStrategySelector()
	 * .build(); Properties properties = new Properties();
	 * properties.putAll(emf.getProperties()); StandardServiceRegistryBuilder
	 * standardServiceRegistryBuilder = new
	 * StandardServiceRegistryBuilder(bootstrapServiceRegistry);
	 * 
	 * standardServiceRegistryBuilder.applySettings(properties);
	 * 
	 * MetadataSources metadataSources = new
	 * MetadataSources(standardServiceRegistryBuilder.build());
	 * SessionFactoryBuilder sessionFactoryBuilder =
	 * metadataSources.buildMetadata().getSessionFactoryBuilder(); Supply a
	 * SessionFactory-level Interceptor sessionFactoryBuilder.applyInterceptor( new
	 * CustomSessionFactoryInterceptor() );
	 * 
	 * Add a custom observer sessionFactoryBuilder.addSessionFactoryObservers( new
	 * CustomSessionFactoryObserver() );
	 * 
	 * // Apply a CDI BeanManager ( for JPA event listeners )
	 * //sessionFactoryBuilder.applyBeanManager( emf );
	 * //sessionFactoryBuilder.build();
	 * 
	 * return factory; }
	 */

	/*
	 * @Bean public HibernateJpaSessionFactoryBean sessionFactory() { return new
	 * LocalSessionFactoryBuilder(dataSource()) .addAnnotatedClasses(Person.class,
	 * Account.class) .buildSessionFactory(); }
	 */
	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty(AvailableSettings.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.connection.autocommit", "false");
		//hibernateProperties.put("hibernate.session_factory.interceptor", "com.common.persistance.CustomInterceptor");
		// hibernateProperties.setProperty("hibernate.globally_quoted_identifiers",
		// "true");
		/*
		 * hibernateProperties.put( "hibernate.integrator_provider",
		 * (IntegratorProvider) () -> Collections.singletonList( new
		 * EventListenerIntegrator() ) );
		 */
		return hibernateProperties;
	}

	

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(env.getProperty("broker-url"));
		
		//activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.websystique.springmvc"));
		return activeMQConnectionFactory;
	}
	/*
	 * @Bean public JmsListenerContainerFactory<?> myFactory(ConnectionFactory
	 * connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
	 * DefaultJmsListenerContainerFactory factory = new
	 * DefaultJmsListenerContainerFactory(); // This provides all boot's default to
	 * this factory, including the message converter configurer.configure(factory,
	 * connectionFactory); // You could still override some of Boot's default if
	 * necessary. return factory; }
	 */

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		//factory.setDestinationResolver(destinationResolver());
		//factory.setSessionTransacted(true);
		factory.setConcurrency("3-10");
		return factory;
	}

	/*@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		return factory;
	}*/

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	/*
	 * @Bean public CachingConnectionFactory cachingConnectionFactory() { return new
	 * CachingConnectionFactory( senderActiveMQConnectionFactory()); }
	 */

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFactory());
	}

	@Bean
	public JMSServiceReceiver serviceReceiver() {
		return new JMSServiceReceiver();
	}

	@Bean
	public JMSServiceSender jmsServiceSender() {
		return new JMSServiceSender();
	}
	
	@Bean
	public JmsProvider jmsProvider() {
		return new JmsProvider();
	}

}