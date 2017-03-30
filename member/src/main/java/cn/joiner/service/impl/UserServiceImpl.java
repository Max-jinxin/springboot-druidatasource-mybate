package cn.joiner.service.impl;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.joiner.domain.User;
import cn.joiner.logging.LogConstant;
import cn.joiner.mapper.UserMapper;
import cn.joiner.service.UserService;
import cn.joiner.utils.MD5Utils;

@Service
public class UserServiceImpl implements UserService{
	
	private final static Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	
	

	@Override
	public List<User> getAll() {
 		return userMapper.selectAll();
	}



	@Override
	public PageInfo<User> getAllByPage(int pageNum, int pageSize) {
		LOGGER.info(LogConstant.START);
		LOGGER.info(LogConstant.INPUT_PARAMS,"pageNum="+pageNum,"pageSize"+pageSize);
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList = userMapper.selectAll();
		PageInfo<User> pageInfo=new PageInfo<User>(userList);
		LOGGER.info(LogConstant.OUPUT_RESULT,pageInfo);
		LOGGER.info(LogConstant.END);
		return pageInfo;
	}



	@Override
	public User getByUserNameAndPassword(String username, String password) {
		LOGGER.info(LogConstant.START);
		LOGGER.info(LogConstant.INPUT_PARAMS,"username="+username,"password"+password);
		User user=null;
		user=userMapper.selectByUsername(username);
		if(user==null){
			user=userMapper.selectByEmail(username);
		}
		if(user!=null){
			if(MD5Utils.md5(password).equals(user.getPassword())){
				LOGGER.info(LogConstant.OUPUT_RESULT,user);
				return user;
			}
		}
		LOGGER.info(LogConstant.OUPUT_RESULT,"null");
		LOGGER.info(LogConstant.END);
		return null;
	}



	@Override
	public boolean selectByEmail(String email) {
		LOGGER.info(LogConstant.START);
		LOGGER.info(LogConstant.INPUT_PARAMS,"email="+email);
		User user=null;
		boolean boo=false;
		user=userMapper.selectByEmail(email);
		if(user!=null)
			boo=true;
		LOGGER.info(LogConstant.OUPUT_RESULT,boo);
		LOGGER.info(LogConstant.END);	
		return boo;
	}



	@Override
	public boolean insertSelective(User user) {
		LOGGER.info(LogConstant.START);
		LOGGER.info(LogConstant.INPUT_PARAMS,user);
		boolean boo=false;
		user.setPassword(MD5Utils.md5(user.getPassword()));
		int selective = userMapper.insertSelective(user);
		if(selective==1)
			boo=true;
		LOGGER.info(LogConstant.OUPUT_RESULT,boo);
		LOGGER.info(LogConstant.END);	
		return boo;

	}



	

}
