package cn.joiner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.joiner.domain.User;
import cn.joiner.mapper.UserMapper;
import cn.joiner.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	

	@Override
	public List<User> getAll() {
 		return userMapper.selectAll();
	}



	@Override
	public PageInfo<User> getAllByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList = userMapper.selectAll();
		PageInfo<User> pageInfo=new PageInfo<User>(userList);
		return pageInfo;
	}



	

}
