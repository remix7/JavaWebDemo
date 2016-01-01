package cc.cynara.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cc.cynara.domain.IdCard;
import cc.cynara.domain.Person;
import cc.cynara.util.DBCPUtil;

public class PersonDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDatasource());
	
	public void addPerson(Person p) throws Exception{
		//保存人的信息
		qr.update("insert into person(id,name) values(?,?)", p.getId(),p.getName());
		//如果有身份证，保存身份证的信息
		IdCard card = p.getIdcard();
		if(card!=null){
			qr.update("insert into idcard(id,num) values(?,?)", p.getId(),card.getNum());
		}
	}
	//要查IDcard的内容  因为IDcard是少的一方
	public Person findPerson(Integer id) throws Exception{
		Person p = qr.query("select * from person where id=?",new BeanHandler<Person>(Person.class), id);
		if(p!=null){
			IdCard idCard = qr.query("select * from idcard where id=?", new BeanHandler<IdCard>(IdCard.class), id);
			p.setIdcard(idCard);
		}
		return p;
	}
}
