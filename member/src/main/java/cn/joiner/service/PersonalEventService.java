package cn.joiner.service;

import com.github.pagehelper.PageInfo;

import cn.joiner.domain.PersonalEvent;

public interface PersonalEventService {
	
	/**
	 * 添加一个个人事件信息
	 * @param personEvent
	 * @return
	 */
	public boolean insertSelective(PersonalEvent personEvent);
	
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public boolean deleteById(long id);
	
	/**
	 * 分页条件查询
	 */
	public PageInfo<PersonalEvent> queryByCondition(PersonalEvent personEvent,int pageNum,int pageSize);
	
	
	/**
	 * 修改，根据主键
	 */
	public boolean updateByPrimaryKey(PersonalEvent personEvent);
	


	
	
}
