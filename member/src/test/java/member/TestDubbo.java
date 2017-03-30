package member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;


public class TestDubbo {

	
	public static void main(String[] args) {
		HashMap<String, Object> map1=new HashMap<String, Object>();
		map1.put("seqid", "1001");
		map1.put("traceid", "aaaaaaaaaaaaaaaaaaaaaa");
		HashMap<String, Object> map2=new HashMap<String, Object>();
		map2.put("seqid", "1002");
		map2.put("traceid", "aaaaaaaaaaaaaaaaaaaaaa");
		HashMap<String, Object> map3=new HashMap<String, Object>();
		map3.put("seqid", "1001003");
		map3.put("traceid", "aaaaaaaaaaaaaaaaaaaaaa");
		HashMap<String, Object> map4=new HashMap<String, Object>();
		map4.put("seqid", "1001003");
		map4.put("traceid", "aaaaaaaaaaaaaaaaaaaaaa");
		HashMap<String, Object> map5=new HashMap<String, Object>();
		map5.put("seqid","");
		map5.put("traceid", "aaaaaaaaaaaaaaaaaaaaaa");
		ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		Collections.sort(list, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> m1, Map<String,Object> m2) {
				String str1=(String) m1.get("seqid");
				String str2=(String) m2.get("seqid");
				return str1.compareTo(str2);
			}
		});
		
		System.out.println(list.toString());
	}
	
	public static <T> T getDubboService(String interfStr,String zookeeperUrl,String appName) throws ClassNotFoundException{
		ApplicationConfig application=new ApplicationConfig();
		application.setName(appName);
		RegistryConfig registryConfig =new RegistryConfig ();		
		registryConfig.setAddress(zookeeperUrl);
		Class<?> interf=Class.forName(interfStr);
		ReferenceConfig<T> rc=new ReferenceConfig<T>();
		rc.setApplication(application);
		rc.setInterface(interf);
		return rc.get();
		
	}
}
