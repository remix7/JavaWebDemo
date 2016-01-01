package cc.cynara.dbassist.test;

import org.junit.Test;

import cc.cynara.dbassist.DBAssist;
import cc.cynara.util.DBCPUtils;

public class DBAssistTest {
	private DBAssist da = new DBAssist(DBCPUtils.getDataSourc());
	
	@Test
	public void testAdd(){
		da.update("insert into t3(id,name) values(?,?)", new Object[]{1,"nihaoa"});
	}
	@Test
	public void testUpdate(){
		da.update("update t3 set name = 'wobuhao' where id=?", new Object[]{1});
	}
}
