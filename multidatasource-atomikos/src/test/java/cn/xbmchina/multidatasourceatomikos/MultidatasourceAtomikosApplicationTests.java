package cn.xbmchina.multidatasourceatomikos;

import cn.xbmchina.multidatasourceatomikos.domain.SysUser;
import cn.xbmchina.multidatasourceatomikos.domain.User;
import cn.xbmchina.multidatasourceatomikos.service.SysUserService;
import cn.xbmchina.multidatasourceatomikos.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MultidatasourceAtomikosApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private UserService userService;

	@Test
	public void test() {
		List<SysUser> sysUsers = sysUserService.listUser();
		System.out.println("sysUsers:" + sysUsers.size());

//		List<User> users = userService.listUser();
//		System.out.println("users:" + users.size());
	}

	@Test
	public void transaction() {
		SysUser sysUser = new SysUser();
		sysUser.setUserId(1);
		sysUser.setUserName("name-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getSecond());
		sysUserService.update(sysUser);

		User user = new User();
		user.setUserId(6);
		user.setUserName("name-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getSecond());
		userService.update(user);
	}

}
