(��һ���˽�)һ��ʲô�ǹ��ʻ�
(��ϰһ��)�������ʻ�������Ҫ����
	1����Դ����
		����_����_����.properties
		
		������ͬ�Ķ��properties�ļ�������һ����Դ����
		���ԣ�ISO�й涨��zh  en   http://www.loc.gov/standards/iso639-2/englangn.html�� 
		����:ISO�й涨��CN HK MO TW  US UK  http://www.iso.ch/iso/en/prods-services/iso3166ma/02iso-3166-code-lists/list-en1.html�� 
		
		msg_en_US.properties
		msg_zh_CN.properties
		msg.properties  �������������Ϣû���ҵ���Ӧ����Դ�ļ��������������Ĭ�ϵ���Դ��
		
		

	Locale
	�ı���ResourceBundle 
	-------------------------------------------------------------
	����ʱ�䣺DateFormat
	Date---->String:��ʽ�������format
	 
	
	String---->Date:�����ַ�����parse
	
	���ֻ��ң�NumberFormat
	
	Number---->String:��ʽ�������format
	
	String---->Number:�����ַ�����parse
	
	
	������ʽ����MessageFormat
�����򵥽��ܹ��ʻ���JSTL��ǩ��
*****�ġ�����������(�ҳ���Ҫ)
	1������������һ��������
	2�����Զ��������Ӧ�������ء�
	
�塢��д���˵Ĳ���
	1����дһ���࣬ʵ��javax.servlet.Filter�ӿڣ���������һ���֮Ϊ��������
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FilterDemo1������");
		chain.doFilter(request, response);//����
	}
	2����web.xml�н������ã�Ҫ������Щ��Դ��
	<filter>
		<filter-name>FilterDemo1</filter-name>
		<filter-class>cn.itcast.filter.FilterDemo1</filter-class>
	  </filter>
	  <filter-mapping>
		<filter-name>FilterDemo1</filter-name>
		<url-pattern>/*</url-pattern>
	  </filter-mapping>
	  
������������ִ�й���
	���������������˳���ǰ���web.xml��filter-mappingԪ�صĳ���˳��������صġ�
	
	������ֻ�ᱻ��ʼ��һ�Σ�Ӧ�ñ�����ʱ������˳�ʼ����
	
�ߡ��������򵥰�����3��
�ˡ��������ĸ߼�����
	<filter-mapping>
		<filter-name>FilterDemo3</filter-name>
		<url-pattern>/*</url-pattern>
		<dispatcher>REQUEST</dispatcher> Ĭ����������д������һ�������Ĭ�ϵľ�û����
		<dispatcher>FORWARD</dispatcher>
		<dispatcher>INCLUDE</dispatcher>
		<dispatcher>ERROR</dispatcher>
	  </filter-mapping>
�š����̰�װ���ģʽ
ʮ���������߼�������
	ȫվGzipѹ�����൱���Ѷȣ�