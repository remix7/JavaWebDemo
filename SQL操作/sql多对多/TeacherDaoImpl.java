package cc.cynara.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cc.cynara.domain.Student;
import cc.cynara.domain.Teacher;
import cc.cynara.util.DBCPUtil;

public class TeacherDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDatasource());
	public void addTeacher(Teacher t) throws Exception{
		//保存老师的基本信息
		qr.update("insert into teacher(id,name,money) values(?,?,?)", t.getId(),t.getName(),t.getMoney());
		//判断老师是否有学生
		List<Student> stus = t.getStus();
		//判断学生是否在student表中如果在 就吧添加  不在就添加
		if(stus!=null&&stus.size()>0){
			for(Student s:stus){
				//判断学生是否已在数据库中
				Object num = qr.query("select 1 from student where id=?", new ScalarHandler(1), s.getId());
				if(num==null){
					qr.update("insert into student(id,name,grade) values(?,?,?)", s.getId(),s.getName(),s.getGrade());
					
				}
				//在第三方表中建立老师学生的关系
				qr.update("insert into teacher_student(t_id,s_id) values(?,?)",t.getId(),s.getId());
			}
		}
		
	}
	public Teacher findTeacher(Integer id) throws Exception{
		//查询老师的基本信息
		Teacher t = qr.query("select * from teacher where id=?", new BeanHandler<Teacher>(Teacher.class), id);
		if(t!=null){
			//根据老师的ID查询学生的基本信息
			//子查询
//			String sql = "select * from student where id in(select s_id from teacher_student where t_id=?)";
			//隐士内连接
//			String sql = "select s.* from student s,teacher_student ts where s.id=ts.s_id and ts.t_id=?";
			//显示内连接
			String sql = "select s.* from student s inner join teacher_student ts on s.id=ts.s_id where ts.t_id=?";
			List<Student> stus = qr.query(sql, new BeanListHandler<Student>(Student.class), id);
			t.setStus(stus);
		}
		return t;
	}
}
