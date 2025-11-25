package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// <context:component-scan base-package="com.sist.*"/>
@Configuration
@ComponentScan(basePackages = "com.sist.*")
@MapperScan(basePackages = "com.sist.mapper")
public class DatabaseConfig {
	/*
	 *  <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
			p:driverClassName="oracle.jdbc.driver.OracleDriver"
			p:url="jdbc:oracle:thin:@localhost:1521:XE"
			p:username="hr"
			p:password="happy"
			p:maxActive="30"
			p:maxIdle="10"
			p:maxWait="-1"
		/>
	*/
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(30);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		
		return ds;
	}
	/*
	 * <!-- DataSource => MyBatis 로 전송 -->
		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
			p:dataSource-ref="dataSource"
		/>
	*/
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		
		return ssf.getObject();
	}
	/*
		    <bean id="dataSource" 
	          class="net.sf.log4jdbc.Log4jdbcProxyDataSource"> 
		      <constructor-arg ref="ds" /> 
		      <property name="logFormatter"> 
		        <bean class="net.sf.log4jdbc.tools.Log4JdbcCustomFormatter"> 
		        <property name="loggingType" value="MULTI_LINE" /> 
		        <property name="sqlPrefix" value="SQL : "/> 
		        </bean> 
		      </property> 
		    </bean>

	
		<!-- Mapper 구현 요청 -->
		<mybatis-spring:scan base-package="com.sist.mapper"
			factory-ref="ssf"
		/>	
	 */
}
