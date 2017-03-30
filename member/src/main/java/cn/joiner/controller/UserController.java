package cn.joiner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.joiner.domain.User;
import cn.joiner.service.UserService;
import cn.joiner.utils.Validate;
import cn.joiner.vo.CommonResult;

import com.github.pagehelper.PageInfo;
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
	/**
	 * 登录逻辑
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public CommonResult login(String username,String password,HttpServletRequest request){
		boolean success=false;
		try {
			User user=userService.getByUserNameAndPassword(username,password);
			if(user!=null){
				success=true;
			}
			if(success){
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
				return CommonResult.ok("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(500, "服务器异常:"+e.getMessage(), null);	
		}
		return CommonResult.ok("failure");

	}
	/**
	 * 注册逻辑
	 * @param email
	 * @param password1
	 * @param password2
	 * @return
	 */
	@ResponseBody
	@RequestMapping("register")
	public CommonResult register(String email,String password1,String password2){
		boolean success=false;
		if(!Validate.mail(email))
			return CommonResult.build(500, "邮箱格式不正确！", null);
		//判断密码是否一致
		if(!(StringUtils.isNotBlank(password1)&&StringUtils.isNotBlank(password2)&&password1.equals(password2))){
			return CommonResult.build(500, "两次输入密码不一致！", null);
		}
		if(!Validate.password(password1))
			return CommonResult.build(500, "密码输入不符合规范！", null);
		//注册动作
		try {
			User user=new User();
			user.setPassword(password1);
			user.setEmail(email);
			success=userService.insertSelective(user);
			if(success)
				return CommonResult.ok("success");
			return CommonResult.ok("failure");
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			return CommonResult.build(500, "该邮箱已经被注册", null);
		}catch (Exception e2) {
			e2.printStackTrace();
		}
		return CommonResult.build(500, "服务器异常", null);
	}
	/**
	 * 校验邮箱是否已经被注册
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping("check_email")
	public CommonResult checkEmail(String email){
		boolean success=false;
		if(!Validate.mail(email))
			return CommonResult.build(500, "邮箱格式不正确！", null);
		try {
			boolean exist=userService.selectByEmail(email);
			success=exist;
			if(!success){
				return CommonResult.ok("success");
			}
			return CommonResult.ok("failure");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonResult.build(500, "服务器异常", null);
	}
	/**
	 * 获取登录用户的session信息，没有登录的用户信息为空
	 * @param request
	 * @return
	 */
	@RequestMapping("get_session")
	@ResponseBody
	public User getSessionInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if(user!=null)
			return user;
		return null;
		
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public CommonResult logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(null!=session)
		session.removeAttribute("loginUser");
		return CommonResult.ok();
		
	}


}
