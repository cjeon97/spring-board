package config;

import java.beans.PropertyVetoException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import service.MemberService;

@Configuration
@MapperScan("repository.mapper") //매퍼 검색하기
public class JavaConfigContext {
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setDriverClass("oracle.jdbc.OracleDriver");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUser("c##springuser");
		dataSource.setPassword("1234");
		
		dataSource.setMaxPoolSize(100);
		dataSource.setMaxIdleTime(600);
		dataSource.setIdleConnectionTestPeriod(300);

		return dataSource;
	}
	
	@Bean
	public TransactionManager getTransactionManager() throws PropertyVetoException {
		
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		
		transactionManager.setDataSource(dataSource());
		
		return transactionManager;
	}

	@Bean 
	SqlSessionFactoryBean getSqlSessionFactory() throws PropertyVetoException {
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setConfigLocation(context.getResource("classpath:config/mybatis-config.xml"));
		sqlSessionFactory.setMapperLocations(context.getResource("classpath:config/sqlmapper-member.xml"));
		return sqlSessionFactory;
	}
	
	@Bean
	SqlSessionTemplate getSqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(getSqlSessionFactory().getObject());
		return sqlSessionTemplate;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService();
	}
	
}