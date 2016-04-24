spring结合jdbc的几种做法
1.引入jar包 commons-dhcp.jar commons-dbutils.jar  commons-pool-1.5.6.jar
2.在applicationContext.xml文件中配置
	 <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    	<property name="locations">
    		<value>classpath:jdbc.properties</value>
    	</property>
    </bean>
    
	 <bean id="dataSource" destroy-method="close" class="org.apache.commons.dbcp.BasicDataSource">
	 	<property name="driverClassName" value="${jdbc.driverClassName}"></property>
	 	<property name="url" value="${jdbc.url}"></property>
	 	<property name="username" value="${jdbc.username}"></property>
	 	<property name="password" value="${jdbc.password}"></property>
	 </bean>
	有两种方法  
		第一种是直接给dataSource赋值 
		第二种是通过读取配置文件的方式用${}来获取org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
3.实现操作的几种做法
	1.编写jdbcTemplate类  设置DataSource属性 提供get set方法
	创建update方法将sql传入
		public void update(String sql){
			Connection connection;
			try {
				connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	2.让目标类直接继承JdbcDaoSupport
		public void update(){
			this.getJdbcTemplate().execute("update person set pname='123456' where pid=5");
		}
	3.让目标类继承JdbcTemplate  定义DataSource属性并提供构造函数传值
		public PersonDao2(DataSource dataSource){
			super(dataSource);
		}
		public void update(){
			this.execute("update person set pname='789456' where pid=6");
		}
	4.将JdbcTemplate作为目标类的一个属性 通过set方法注入值
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void update(){
		this.jdbcTemplate.execute("update person set pname='7894555556' where pid=7");
	}
	
4.spring结结合jdbc查询
	1.编写一个类PersonRowMapper  实现RowMapper接口  mapRow重写这个方法
	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		Person person = new Person();
		person.setPid(arg0.getLong("pid"));
		person.setPname(arg0.getString("pname"));
		person.setPsex(arg0.getString("psex"));
		return person;
	}
	在任意一个类中
	public void qurey(){
		List<Person> list = this.getJdbcTemplate().query("select * from person", new PersonRowMapper());
		for (Person person : list) {
			System.out.println(person.getPname());
		}
	}
	测试即可