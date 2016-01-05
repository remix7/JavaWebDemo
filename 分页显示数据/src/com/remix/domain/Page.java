package com.remix.domain;

import java.util.List;

//�������������ҳ�йص�
public class Page {
	private List records;
	private int pagesize = 10;//ÿҳ��ʾ������
	private int pagenum;//��ǰҳ��
	private int totalpage;//��ҳ��
	private int startIndex;//ÿҳ��ʼ�ļ�¼
	private int totalrecords;//�ܼ�¼��
	//��ʾҳ��
	private int startpage;
	private int endpage;
	//��ѯʱʹ�õ���URL
	private String servletUrl;	
	
	public Page(int pagenum,int totalrecords){
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;
		//����ÿҳ��ʼ������
		startIndex = (pagenum-1)*pagesize;
		//������ҳ��
		totalpage = totalrecords%pagesize==0?totalrecords/pagesize:(totalrecords/pagesize+1);
		
		//��ʾҳ��
		if(totalpage<=9){
			startpage = 1;
			endpage = totalpage;
		}else{
			startpage = pagenum-4;
			endpage = pagenum+4;
			if(startpage<1){
				startpage=1;
				endpage = 9;
			}
			if(endpage>totalpage){
				endpage=totalpage;
				startpage = totalpage-8;
			}
		}
	}
	
	
	
	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	
	
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}



	public String getServletUrl() {
		return servletUrl;
	}



	public void setServletUrl(String servletUrl) {
		this.servletUrl = servletUrl;
	}
	
}
