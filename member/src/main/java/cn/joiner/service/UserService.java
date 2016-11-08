package cn.joiner.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.joiner.domain.User;

public interface UserService {

	List<User> getAll();

	PageInfo<User> getAllByPage(int pageNum, int pageSize);

}
