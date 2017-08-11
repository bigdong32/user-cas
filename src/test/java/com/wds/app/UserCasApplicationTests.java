package com.wds.app;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
		List<UserInfo> userInfos = userInfo.selectPage(new Page<UserInfo>(1, 10), new EntityWrapper<UserInfo>().eq("name", "wds")).getRecords();
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
}
