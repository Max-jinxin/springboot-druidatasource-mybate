package member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.alibaba.dubbo.common.json.JSON;

public class TestSeqid {

	@Test
	public void testSeqid() throws IOException{
			List<Log> list=new ArrayList<Log>();
			//订单--》渠道前置-->支付
			//订单--》会员
			//顺序 订单--》渠道前置--》支付-》会员
			
			//1
			list.add(new Log("tranceid1","1001","order","00100","INFO"));
			list.add(new Log("tranceid1","1002","order","00200","INFO"));
			//2
			list.add(new Log("tranceid1","1002001","channel","00210","INFO"));
			list.add(new Log("tranceid1","1002002","channel","00220","INFO"));
			
			//3
			list.add(new Log("tranceid1","1002002001","pay","00221","INFO"));
			list.add(new Log("tranceid1","1002002002","pay","00223","INFO"));
			list.add(new Log("tranceid1","1002002003","pay","00224","INFO"));
			//3
			list.add(new Log("tranceid1","1002002004","pay","00225","INFO"));
			list.add(new Log("tranceid1","1002002005","pay","00228","INFO"));
			
			
			//2
			list.add(new Log("tranceid1","1002003","channel","00230","INFO"));
			list.add(new Log("tranceid1","1002004","channel","00240","INFO"));
			list.add(new Log("tranceid1","1002005","channel","00260","INFO"));
			
			//4
			list.add(new Log("tranceid1","1003","order","00300","INFO"));
			list.add(new Log("tranceid1","1003001","member","00310","ERROR"));
			list.add(new Log("tranceid1","1003002","member","00320","INFO"));
			list.add(new Log("tranceid1","1003003","member","00320","INFO"));
			list.add(new Log("tranceid1","1003004","member","00350","INFO"));
			list.add(new Log("tranceid1","1003005","member","00360","INFO"));
			
			//1
			list.add(new Log("tranceid1","1004","order","00400","INFO"));
			list.add(new Log("tranceid1","1005","order","00500","INFO"));
			
			System.out.println(list.size());
			Map<String,String> map=new TreeMap<String,String>();
			
			//开始遍历
			for (Log log : list) {
				log.setPid(log.getSeqid().substring(0,log.getSeqid().length()-3));
				String seqid = log.getSeqid();
				String key = seqid.substring(0,seqid.length()-3);
				map.put(key, log.getAppName());
			}
			
			String json = JSON.json(list);
			System.out.println(json);
			List<LogGroup> listGroup=new ArrayList<LogGroup>();
			for (String seqType : map.keySet()) {
				LogGroup logGroup=new LogGroup();
				logGroup.setAppName(map.get(seqType));
				String minTime="";
				String maxTime="";
				boolean isFirst=true;
				boolean hasError=false;
				for (Log l : list) {
					String seq=l.getSeqid();
					if(seqType.equals(seq.substring(0,seq.length()-3))){
						if("ERROR".equals(l.getLevel()))
							hasError=true;
						if(isFirst){
							minTime=l.getDate();
							isFirst=false;
						}
						maxTime=l.getDate();
						logGroup.getList().add(l);
					}
				}
				logGroup.setHaveError(hasError);
				logGroup.setMinTime(minTime);
				logGroup.setMaxTime(maxTime);
				listGroup.add(logGroup);
			}
			
			System.out.println(listGroup);
			
			System.out.println(JSON.json(listGroup));
			
			
		
	}

}
