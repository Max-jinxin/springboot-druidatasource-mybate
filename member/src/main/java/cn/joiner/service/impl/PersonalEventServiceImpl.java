package cn.joiner.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.joiner.domain.PersonalEvent;
import cn.joiner.mapper.PersonalEventMapper;
import cn.joiner.service.PersonalEventService;

@Service
public class PersonalEventServiceImpl implements PersonalEventService{
	private final static Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private PersonalEventMapper mapper;
	@Override
	public boolean insertSelective(PersonalEvent personEvent) {
		int selective = mapper.insertSelective(personEvent);
		return selective>0?true:false;
	}
	@Override
	public boolean deleteById(long id) {
		boolean flag=mapper.deleteByPrimaryKey(id);
		return flag;
	}
	@Override
	public PageInfo<PersonalEvent> queryByCondition(PersonalEvent personEvent,
			int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<PersonalEvent> list = mapper.selectByCondition(personEvent);
		PageInfo<PersonalEvent> pageInfo=new PageInfo<PersonalEvent>(list);
		return pageInfo;
	}
	@Override
	public boolean updateByPrimaryKey(PersonalEvent personEvent) {
		int update=0;
		update=mapper.updateByPrimaryKeySelective(personEvent);
		return update>0?true:false;
	}
	

}
