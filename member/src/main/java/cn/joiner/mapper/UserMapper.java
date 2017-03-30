package cn.joiner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.joiner.domain.User;
@Mapper
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> selectAll();

	User selectByUsername(String username);

	User selectByEmail(String email);
}