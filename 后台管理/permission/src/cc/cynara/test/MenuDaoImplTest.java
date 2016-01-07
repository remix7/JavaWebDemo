package cc.cynara.test;

import java.util.List;
import java.util.UUID;

import com.sun.xml.internal.fastinfoset.algorithm.UUIDEncodingAlgorithm;

import junit.framework.TestCase;
import cc.cynara.dao.MenuDao;
import cc.cynara.dao.impl.MenuDaoImpl;
import cc.cynara.domain.Menu;

public class MenuDaoImplTest extends TestCase {
	private MenuDao md = new MenuDaoImpl();
	public void testFindAllMenu() {
		List<Menu> m = md.FindAllMenu();
		for(Menu m1:m){
			System.out.println(m1);
		}
	}

	public void testAddMenu() {
		Menu m = new Menu();
		m.setId(UUID.randomUUID().toString());
		m.setName("lias");
		m.setUri("/servlet/1.jsp");
		m.setDescription("nihao");
		System.out.println(m);
		md.addMenu(m);
	}

	public void testDeleteMenu() {
		md.deleteMenu("1");
	}

	public void testFindMenuById() {
		System.out.println(md.findMenuById("2"));
	}

	public void testUpdateMenu() {
		Menu m = new Menu();
		m.setId("2");
		m.setName("你好");
		m.setUri("/demo/123");
		m.setDescription("更改后");
		md.updateMenu(m);
	}

}
