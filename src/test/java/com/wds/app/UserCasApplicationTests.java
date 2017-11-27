package com.wds.app;

import com.baomidou.mybatisplus.plugins.Page;
import com.wds.app.user.entity.UserHaha;
import com.wds.app.user.entity.UserInfo;
import com.wds.app.user.service.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCasApplicationTests {

	@Autowired
	private IUserInfoService userInfoService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMybatisPage(){
		UserInfo userInfo = new UserInfo();
//		List<UserInfo> userInfos = userInfo.selectPage(new Page<UserInfo>(1, 10), new EntityWrapper<UserInfo>().eq("name", "wds")).getRecords();
		List<UserInfo> userInfos = userInfo.selectAll();
		userInfos.forEach(temUserInfo -> {
			System.out.println(temUserInfo.getEmail());
		});
	}

	@Test
	public void testMapperPage(){
		Page<UserInfo> userInfos = userInfoService.getUserInfosByPage(new Page<UserInfo>(1, 2));
		userInfos.getRecords().forEach(userInfo -> {
			System.out.println(userInfo);
		});
	}

	@Test
	public void testUR(){
		Page<UserInfo> page = userInfoService.getUserInfoWithUserRolesByPage(new Page<>(1, 3));
		page.getRecords().forEach(userInfo -> {
			userInfo.getUserRoles().forEach(userRole -> {
				System.out.println(userRole);
			});
		});
	}

	@Test
	public void testTimeTest(){
		UserHaha userHaha = new UserHaha();
		List<UserHaha> timeTests = userHaha.selectAll();
		timeTests.forEach(s -> {
			System.out.println(s.getId() + "  " + s.getCreateTime());
		});
	}

}
