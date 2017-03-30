package cn.joiner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.joiner.domain.PersonalEvent;
@Mapper
public interface PersonalEventMapper {
    
    int insertSelective(PersonalEvent record);

	boolean deleteByPrimaryKey(long id); 

	int updateByPrimaryKeySelective(PersonalEvent personEvent);
	
	List<PersonalEvent> selectByCondition(PersonalEvent personEvent);
	
}