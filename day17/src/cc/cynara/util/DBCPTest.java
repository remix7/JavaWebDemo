package cc.cynara.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cc.cynara.domain.Account;

public class DBCPTest {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDatasource());
	
	@Test//���һ����¼
	public void testAdd() throws Exception{
		qr.update("insert into t4(id,name,birthday) values(?,?,?)", 1,"����",new Date());
	}
	@Test//���һ����¼
	public void testAdd1() throws Exception{
		qr.update("insert into t4(id,name,birthday) values(?,?,?)", 2,"����","1994-11-19");
	}
	@Test//�޸�һ����¼
	public void testUpdate() throws Exception{
		qr.update("update t4 set birthday='1994-02-17' where id=?",1);
	}
	@Test//����Blob
	public void testInsert() throws Exception{
		InputStream in = new FileInputStream("src/a.JPG");
		byte[] b = new byte[in.available()];
		in.read(b);
		in.close();
		Blob blob = new SerialBlob(b);
		qr.update("insert into t5(id,source) values(?,?)",1,blob);
	}
	@Test//��ѯ
	public void testSelect() throws Exception{
		Account a = qr.query("select * from account where id=?",new BeanHandler<Account>(Account.class),1);
		System.out.println(a);
	}
	@Test//��ѯȫ��
	public void testSelectAll() throws Exception{
		List<Account> c = qr.query("select * from account",new BeanListHandler<Account>(Account.class));
		for(Account lc:c){
			System.out.println(lc);
		}
	}
}
