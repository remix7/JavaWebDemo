package cc.cynara.dbassist.handler;

import java.sql.ResultSet;

public interface ResultSetHandler {
	
	Object handler(ResultSet rs);

}
