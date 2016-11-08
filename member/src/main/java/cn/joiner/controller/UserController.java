package cn.joiner.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.github.pagehelper.PageInfo;

import cn.joiner.domain.User;
import cn.joiner.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 查询所有用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/get_all")
	public List<User> getAll() {
		return userService.getAll();
 	}
	
	
	@ResponseBody
	@RequestMapping("/get_all_by_page")
	public PageInfo<User> getAllByPage(@RequestParam(name="pageNum",defaultValue="1")int pageNum,@RequestParam(name="pageSize",defaultValue="10")int pageSize) {
		return userService.getAllByPage(pageNum,pageSize);
 	}

	
}
