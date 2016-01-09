一、文件上传的原理
	1、文件上传的前提：
		a、form表单的method必须是post
		b、form表单的enctype必须是multipart/form-data（决定了POST请求方式，请求正文的数据类型）
			注意：当表单的enctype是multipart/form-data,传统的获取请求参数的方法失效。
			
			请求正文：（MIME协议进行描述的，正文是多部分组成的）
			-----------------------------7dd32c39803b2
			Content-Disposition: form-data; name="username"

			wzhting
			-----------------------------7dd32c39803b2
			Content-Disposition: form-data; name="f1"; filename="C:\Documents and Settings\wzhting\妗岄潰\a.txt"
			Content-Type: text/plain

			aaaaaaaaaaaaaaaaaa
			-----------------------------7dd32c39803b2
			Content-Disposition: form-data; name="f2"; filename="C:\Documents and Settings\wzhting\妗岄潰\b.txt"
			Content-Type: text/plain

			bbbbbbbbbbbbbbbbbbb
			-----------------------------7dd32c39803b2--

			
		c、form中提供input的type是file类型的文件上传域
		
二、利用第三方组件实现文件上传
	1、commons-fileupload组件：
		jar：commons-fileupload.jar  commons-io.jar
	2、核心类或接口
		DiskFileItemFactory:设置环境
			public void setSizeThreshold(int?sizeThreshold) ：设置缓冲区大小。默认是10Kb。
					当上传的文件超出了缓冲区大小，fileupload组件将使用临时文件缓存上传文件
			public void setRepository(java.io.File repository)：设置临时文件的存放目录。默认是系统的临时文件存放目录。
					
		ServletFileUpload:核心上传类（主要作用：解析请求的正文内容）
			boolean isMultipartContent(HttpServletRequest?request)：判断用户的表单的enctype是否是multipart/form-data类型的。
			List parseRequest(HttpServletRequest request)：解析请求正文中的内容
			setFileSizeMax(4*1024*1024);//设置单个上传文件的大小
			upload.setSizeMax(6*1024*1024);//设置总文件大小
		FileItem:代表表单中的一个输入域。
			boolean isFormField():是否是普通字段
			String getFieldName：获取普通字段的字段名
			String getString():获取普通字段的值
			
			InputStream getInputStream():获取上传字段的输入流
			String getName():获取上传的文件名
			
三、文件上传中要注意的9个问题
	1、如何保证服务器的安全
		把保存上传文件的目录放到WEB-INF目录中。
	2、中文乱码问题
		2.1普通字段的中文请求参数
			String value = FileItem.getString("UTF-8");
		2.2上传的文件名是中文
			解决办法：request.setCharacterEncoding("UTF-8");
	3、重名文件被覆盖的问题
			System.currentMillions()+"_"+a.txt(乐观)
			
			UUID+"_"+a.txt:保证文件名唯一
	4、分目录存储上传的文件
		方式一：当前日期建立一个文件夹，当前上传的文件都放到此文件夹中。
		方式二：利用文件名的hash码打散目录来存储。
			int hashCode = fileName.hashCode();
			
				1001 1010 1101 0010 1101 1100 1101 1010
hashCode&0xf;   0000 0000 0000 0000 0000 0000 0000 1111 &
				---------------------------------------------
				0000 0000 0000 0000 0000 0000 0000 1010   取hashCode的后4位
													0000~1111：整数0~15共16个
				
				1001 1010 1101 0010 1101 1100 1101 1010
(hashCode&0xf0)	0000 0000 0000 0000 0000 0000 1111 0000  &
				--------------------------------------------
				0000 0000 0000 0000 0000 0000 1101 0000  >>4
				--------------------------------------------
				0000 0000 0000 0000 0000 0000 0000 1101
													0000~1111：整数0~15共16个
	5、限制用户上传的文件类型
		通过判断文件的扩展名来限制是不可取的。
		通过判断其Mime类型才靠谱。FileItem.getContentType();
	6、如何限制用户上传文件的大小
		6.1单个文件大小限制。超出了大小友好提示
			抓异常进行提示：org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException
		6.2总文件大小限制。超出了大小友好提示
			抓异常进行提示：org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException
	7、临时文件的问题
		commons-fileupload组件不会删除超出缓存的临时文件。
		
		FileItem.delete()方法删除临时文件。但一定要在关闭流之后。
	8、多个文件上传时，没有上传内容的问题
		if(fileName==null||"".equals(fileName.trim())){
			continue;
		}
	9、上传进度检测
		给ServletFileUpload注册一个进度监听器即可，把上传进度传递给页面去显示
		//pBytesRead：当前以读取到的字节数
		//pContentLength：文件的长度
		//pItems:第几项
		public void update(long pBytesRead, long pContentLength,
				int pItems) {
			System.out.println("已读取："+pBytesRead+",文件大小："+pContentLength+",第几项："+pItems);
		}
四、监听器概念
	1、事件源：发生事件的对象。
	2、监听器：是一个接口，监听事件源上要发生的动作
	3、事件：事件对象一般是作为监听器方法的参数存在的，它封装了发生事件的对象
	
五、观察者设计模式
六、Servlet中提供的监听器（8个）
	八个监听器分类：
	6.1监听ServletContext、HttpSession、ServletRequest对象的创建和销毁的监听器。
		ServletContextListener:监听ServletContext对象的创建和销毁。
		
		HttpSessionListener:监听HttpSession对象的创建和销毁。
					创建：第一次调用request.getSession()时。
						  销毁：1、主动调用invalidate()方法
								2、超时
								
		ServletRequestListener:监听ServletRequest对象的创建和销毁。
					
	6.2监听ServletContext、HttpSession、ServletRequest对象中域变化（新来的，替换的，删除的）的监听器。
		ServletContextAttributeListener:
		HttpSessionAttributeListener:
		ServletRequestAttributeListener:
	6.3感知型监听器：谁实现了这些接口，谁就能感知自己被怎么着了。这种监听器不需要注册。
		HttpSessionActivationListener：感知自己何时随着HttpSession对象钝化和活化
		HttpSessionBindingListener：感知自己何时被HttpSession对象绑了（绑在域中）和解绑了。
		
	
	编写步骤：
		1、编写一个类实现某个监听器接口
		2、在web.xml中注册监听器
			<listener>
				<listener-class>cn.itcast.listener.ServletContextDemoListener</listener-class>
			</listener>
七、监听对象的创建和销毁的监听器
八、自定义HttpSession扫描器
	Timer
	TimerTash
九、监听域对象变化的监听器
	
		
十、感知型监听器
十一、统计在线用户，能踢人。
