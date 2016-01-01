package cc.cynara.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cc.cynara.domain.Department;
import cc.cynara.domain.Employee;
import cc.cynara.util.DBCPUtil;

public class DepartmentDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDatasource());
	public void addDepartment(Department d) throws Exception{
		//���沿�ŵĻ�����Ϣ��department��
		qr.update("insert into department(id,name) values(?,?)",d.getId(),d.getName());
		//�ж���û��Ա��
		List<Employee> emps = d.getEmps();
		if(emps!=null&&emps.size()>0){
			//�����  ���浽employee��
			Object[][] params = new Object[emps.size()][];
			for(int i=0;i<params.length;i++){
				Employee e = emps.get(i);
				params[i] = new Object[]{e.getId(),e.getName(),e.getSalary(),d.getId()};
			}
			qr.batch("insert into employee (id,name,salary,dept_id) values(?,?,?,?)", params);
		}
	}
	public Department findDepartment(Integer id) throws Exception{
		//��ѯ���ŵĻ�����Ϣ
		Department d = qr.query("select * from department where id=?", new BeanHandler<Department>(Department.class), id);
		//���Ź�����Ա����ϢҪ������
		if(d!=null){
			List<Employee> emps = qr.query("select * from employee where dept_id=?", new BeanListHandler<Employee>(Employee.class), id);
			d.setEmps(emps);
		}
		return d;
	}
}
