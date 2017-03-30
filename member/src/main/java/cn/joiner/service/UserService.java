package cn.joiner.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.joiner.domain.User;

public interface UserService {

	List<User> getAll();
	/**
	 * 分页查询所有用户
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<User> getAllByPage(int pageNum, int pageSize);
    /**
     * 登录逻辑，根据email或username查询
     * @param username
     * @param password
     * @return
     */
	User getByUserNameAndPassword(String username, String password);
    /**
     * 查询email是否已经注册
     * @param email
     * @return
     */
	boolean selectByEmail(String email);
	/**
	 * 插入一条用户
	 * @param user
	 * @return
	 */
	boolean insertSelective(User user);

}
