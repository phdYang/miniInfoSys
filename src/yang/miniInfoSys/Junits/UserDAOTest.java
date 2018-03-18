package yang.miniInfoSys.Junits;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import yang.miniInfoSys.DAO.UserDAO;
import yang.miniInfoSys.model.User;

public class UserDAOTest {

	@Test
	public void testFindAllUser() {
		try {
			List<User> list = new UserDAO().findAllUser();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLogin() {
		try {
			System.out.println(new UserDAO().login("zy", "1234567"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSaveUser() {
		User u = new User("ff","qwer","2","12313131");
		try {
			System.out.println(new UserDAO().saveUser(u));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
