package cn.joiner.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.joiner.domain.PersonalEvent;
import cn.joiner.domain.User;
import cn.joiner.service.PersonalEventService;
import cn.joiner.vo.CommonResult;

@Controller
@RequestMapping("/personal_event")
public class PersonalEventController {
	
	@Autowired
	private PersonalEventService personEventService;
	/**
	 * 添加
	 * @param personEvent
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public  CommonResult addPersonalEvent(PersonalEvent personEvent,HttpServletRequest request){
		boolean success=false;
		try {
			success=personEventService.insertSelective(personEvent);
			if(success){
				return CommonResult.ok("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(500, "服务器异常:"+e.getMessage(), null);	
		}
		return CommonResult.ok("failure");
		
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("delete/{id}")
	@ResponseBody
	public  CommonResult deletePersonalEvent(@PathVariable("id")int id,HttpServletRequest request){
		boolean success=false;
		try {
			success=personEventService.deleteById(id);
			if(success){
				return CommonResult.ok("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(500, "服务器异常:"+e.getMessage(), null);	
		}
		return CommonResult.ok("failure");
		
	}
	
	@RequestMapping("update")
	@ResponseBody
	public  CommonResult updatePersonalEvent(PersonalEvent personEvent,HttpServletRequest request){
		boolean success=false;
		try {
			success=personEventService.updateByPrimaryKey(personEvent);
			if(success){
				return CommonResult.ok("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.build(500, "服务器异常:"+e.getMessage(), null);	
		}
		return CommonResult.ok("failure");
		
	}
	
	@ResponseBody
	@RequestMapping("/get_event_by_page")
	public PageInfo<PersonalEvent> getPersonalEventByPage(@RequestParam(name="pageNum",defaultValue="1")int pageNum,@RequestParam(name="pageSize",defaultValue="10")int pageSize,PersonalEvent personalEvent) {
		return personEventService.queryByCondition(personalEvent, pageNum, pageSize);
	}

}
