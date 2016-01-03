(有一定了解)一、什么是国际化
(练习一遍)二、国际化处理需要的类
	1、资源包：
		基名_语言_国家.properties
		
		基名相同的多个properties文件才属于一个资源包。
		语言：ISO有规定。zh  en   http://www.loc.gov/standards/iso639-2/englangn.html。 
		国家:ISO有规定。CN HK MO TW  US UK  http://www.iso.ch/iso/en/prods-services/iso3166ma/02iso-3166-code-lists/list-en1.html。 
		
		msg_en_US.properties
		msg_zh_CN.properties
		msg.properties  如果根据区域信息没有找到对应的资源文件，找这个，这是默认的资源包
		
		

	Locale
	文本：ResourceBundle 
	-------------------------------------------------------------
	日期时间：DateFormat
	Date---->String:格式化输出。format
	 
	
	String---->Date:解析字符串。parse
	
	数字货币：NumberFormat
	
	Number---->String:格式化输出。format
	
	String---->Number:解析字符串。parse
	
	
	批量格式化：MessageFormat
三、简单介绍国际化的JSTL标签库
*****四、过滤器概述(灰常重要)
	1、过滤器就是一个保安。
	2、可以对请求和响应进行拦截。
	
五、编写过滤的步骤
	1、编写一个类，实现javax.servlet.Filter接口，这样的类一般称之为过滤器类
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FilterDemo1拦截了");
		chain.doFilter(request, response);//放行
	}
	2、在web.xml中进行配置，要拦截哪些资源。
	<filter>
		<filter-name>FilterDemo1</filter-name>
		<filter-class>cn.itcast.filter.FilterDemo1</filter-class>
	  </filter>
	  <filter-mapping>
		<filter-name>FilterDemo1</filter-name>
		<url-pattern>/*</url-pattern>
	  </filter-mapping>
	  
六、过滤器的执行过程
	多个过滤器的拦截顺序是按照web.xml中filter-mapping元素的出现顺序进行拦截的。
	
	过滤器只会被初始化一次，应用被加载时就完成了初始化。
	
七、过滤器简单案例：3个
八、过滤器的高级配置
	<filter-mapping>
		<filter-name>FilterDemo3</filter-name>
		<url-pattern>/*</url-pattern>
		<dispatcher>REQUEST</dispatcher> 默认情况。如果写了另外一种情况，默认的就没有了
		<dispatcher>FORWARD</dispatcher>
		<dispatcher>INCLUDE</dispatcher>
		<dispatcher>ERROR</dispatcher>
	  </filter-mapping>
九、巩固包装设计模式
十、过滤器高级案例：
	全站Gzip压缩（相当有难度）