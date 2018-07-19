/**
 * 
 */
package com.jike.usermanage.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jike.usermanage.exception.UserNotFound;
import com.jike.usermanage.model.User;

import com.jike.usermanage.service.UserService;


/**
 * @author liukaibo
 *
 */
public class Client {
	
	public static void printUser(User user) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("id=" + user.getId());
		stringBuilder.append("name=" + user.getName());
		stringBuilder.append("Phone=" + user.getPhone());
		stringBuilder.append("Address=" + user.getAddress());
		System.out.println(stringBuilder.toString());
	}
	
	public static void testList(UserService userService) {
		List<User> users = userService.getUsers();
		for	(int i = 0; i < users.size(); i++) {
			printUser(users.get(i));
		}
	}
	
	public static void testUpdate(UserService userService) throws UserNotFound {
		User user = new User();
		user.setId(6);
		user.setAddress("北京路121号");
//		user.setPhone("13688880808");
		userService.updateUser(user);
		testList(userService);
	}
	
	public static void testAdd(UserService userService) {
		User user = new User();
		user.setAddress("天河路120号");
		user.setName("小徐");
		user.setPhone("13688880708");
		userService.addUser(user);
		testList(userService);
	}
	
	public static void testDelete(UserService userService) throws UserNotFound {
		userService.deleteUser(6);
		testList(userService);
	}



	/**
	 * @param args
	 * @throws UserNotFound 
	 */
	public static void main(String[] args) throws UserNotFound {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ac.getBean("userService");
//		testList(userService);
//		testUpdate(userService);
//		testAdd(userService);
		testDelete(userService);
	}
}
