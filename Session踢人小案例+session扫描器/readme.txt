һ���ļ��ϴ���ԭ��
	1���ļ��ϴ���ǰ�᣺
		a��form����method������post
		b��form����enctype������multipart/form-data��������POST����ʽ���������ĵ��������ͣ�
			ע�⣺������enctype��multipart/form-data,��ͳ�Ļ�ȡ��������ķ���ʧЧ��
			
			�������ģ���MIMEЭ����������ģ������Ƕಿ����ɵģ�
			-----------------------------7dd32c39803b2
			Content-Disposition: form-data; name="username"

			wzhting
			-----------------------------7dd32c39803b2
			Content-Disposition: form-data; name="f1"; filename="C:\Documents and Settings\wzhting\桌面\a.txt"
			Content-Type: text/plain

			aaaaaaaaaaaaaaaaaa
			-----------------------------7dd32c39803b2
			Content-Disposition: form-data; name="f2"; filename="C:\Documents and Settings\wzhting\桌面\b.txt"
			Content-Type: text/plain

			bbbbbbbbbbbbbbbbbbb
			-----------------------------7dd32c39803b2--

			
		c��form���ṩinput��type��file���͵��ļ��ϴ���
		
�������õ��������ʵ���ļ��ϴ�
	1��commons-fileupload�����
		jar��commons-fileupload.jar  commons-io.jar
	2���������ӿ�
		DiskFileItemFactory:���û���
			public void setSizeThreshold(int?sizeThreshold) �����û�������С��Ĭ����10Kb��
					���ϴ����ļ������˻�������С��fileupload�����ʹ����ʱ�ļ������ϴ��ļ�
			public void setRepository(java.io.File repository)��������ʱ�ļ��Ĵ��Ŀ¼��Ĭ����ϵͳ����ʱ�ļ����Ŀ¼��
					
		ServletFileUpload:�����ϴ��ࣨ��Ҫ���ã�����������������ݣ�
			boolean isMultipartContent(HttpServletRequest?request)���ж��û��ı���enctype�Ƿ���multipart/form-data���͵ġ�
			List parseRequest(HttpServletRequest request)���������������е�����
			setFileSizeMax(4*1024*1024);//���õ����ϴ��ļ��Ĵ�С
			upload.setSizeMax(6*1024*1024);//�������ļ���С
		FileItem:������е�һ��������
			boolean isFormField():�Ƿ�����ͨ�ֶ�
			String getFieldName����ȡ��ͨ�ֶε��ֶ���
			String getString():��ȡ��ͨ�ֶε�ֵ
			
			InputStream getInputStream():��ȡ�ϴ��ֶε�������
			String getName():��ȡ�ϴ����ļ���
			
�����ļ��ϴ���Ҫע���9������
	1����α�֤�������İ�ȫ
		�ѱ����ϴ��ļ���Ŀ¼�ŵ�WEB-INFĿ¼�С�
	2��������������
		2.1��ͨ�ֶε������������
			String value = FileItem.getString("UTF-8");
		2.2�ϴ����ļ���������
			����취��request.setCharacterEncoding("UTF-8");
	3�������ļ������ǵ�����
			System.currentMillions()+"_"+a.txt(�ֹ�)
			
			UUID+"_"+a.txt:��֤�ļ���Ψһ
	4����Ŀ¼�洢�ϴ����ļ�
		��ʽһ����ǰ���ڽ���һ���ļ��У���ǰ�ϴ����ļ����ŵ����ļ����С�
		��ʽ���������ļ�����hash���ɢĿ¼���洢��
			int hashCode = fileName.hashCode();
			
				1001 1010 1101 0010 1101 1100 1101 1010
hashCode&0xf;   0000 0000 0000 0000 0000 0000 0000 1111 &
				---------------------------------------------
				0000 0000 0000 0000 0000 0000 0000 1010   ȡhashCode�ĺ�4λ
													0000~1111������0~15��16��
				
				1001 1010 1101 0010 1101 1100 1101 1010
(hashCode&0xf0)	0000 0000 0000 0000 0000 0000 1111 0000  &
				--------------------------------------------
				0000 0000 0000 0000 0000 0000 1101 0000  >>4
				--------------------------------------------
				0000 0000 0000 0000 0000 0000 0000 1101
													0000~1111������0~15��16��
	5�������û��ϴ����ļ�����
		ͨ���ж��ļ�����չ���������ǲ���ȡ�ġ�
		ͨ���ж���Mime���Ͳſ��ס�FileItem.getContentType();
	6����������û��ϴ��ļ��Ĵ�С
		6.1�����ļ���С���ơ������˴�С�Ѻ���ʾ
			ץ�쳣������ʾ��org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException
		6.2���ļ���С���ơ������˴�С�Ѻ���ʾ
			ץ�쳣������ʾ��org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException
	7����ʱ�ļ�������
		commons-fileupload�������ɾ�������������ʱ�ļ���
		
		FileItem.delete()����ɾ����ʱ�ļ�����һ��Ҫ�ڹر���֮��
	8������ļ��ϴ�ʱ��û���ϴ����ݵ�����
		if(fileName==null||"".equals(fileName.trim())){
			continue;
		}
	9���ϴ����ȼ��
		��ServletFileUploadע��һ�����ȼ��������ɣ����ϴ����ȴ��ݸ�ҳ��ȥ��ʾ
		//pBytesRead����ǰ�Զ�ȡ�����ֽ���
		//pContentLength���ļ��ĳ���
		//pItems:�ڼ���
		public void update(long pBytesRead, long pContentLength,
				int pItems) {
			System.out.println("�Ѷ�ȡ��"+pBytesRead+",�ļ���С��"+pContentLength+",�ڼ��"+pItems);
		}
�ġ�����������
	1���¼�Դ�������¼��Ķ���
	2������������һ���ӿڣ������¼�Դ��Ҫ�����Ķ���
	3���¼����¼�����һ������Ϊ�����������Ĳ������ڵģ�����װ�˷����¼��Ķ���
	
�塢�۲������ģʽ
����Servlet���ṩ�ļ�������8����
	�˸����������ࣺ
	6.1����ServletContext��HttpSession��ServletRequest����Ĵ��������ٵļ�������
		ServletContextListener:����ServletContext����Ĵ��������١�
		
		HttpSessionListener:����HttpSession����Ĵ��������١�
					��������һ�ε���request.getSession()ʱ��
						  ���٣�1����������invalidate()����
								2����ʱ
								
		ServletRequestListener:����ServletRequest����Ĵ��������١�
					
	6.2����ServletContext��HttpSession��ServletRequest��������仯�������ģ��滻�ģ�ɾ���ģ��ļ�������
		ServletContextAttributeListener:
		HttpSessionAttributeListener:
		ServletRequestAttributeListener:
	6.3��֪�ͼ�������˭ʵ������Щ�ӿڣ�˭���ܸ�֪�Լ�����ô���ˡ����ּ���������Ҫע�ᡣ
		HttpSessionActivationListener����֪�Լ���ʱ����HttpSession����ۻ��ͻ
		HttpSessionBindingListener����֪�Լ���ʱ��HttpSession������ˣ��������У��ͽ���ˡ�
		
	
	��д���裺
		1����дһ����ʵ��ĳ���������ӿ�
		2����web.xml��ע�������
			<listener>
				<listener-class>cn.itcast.listener.ServletContextDemoListener</listener-class>
			</listener>
�ߡ���������Ĵ��������ٵļ�����
�ˡ��Զ���HttpSessionɨ����
	Timer
	TimerTash
�š����������仯�ļ�����
	
		
ʮ����֪�ͼ�����
ʮһ��ͳ�������û��������ˡ�
