package member;

import java.io.IOException;

import com.alibaba.dubbo.common.json.JSON;

public class TestTranietn {

	public TestTranietn() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) throws IOException {
		Log log = new Log("tranceid1","1001","order","00100","INFO");
		String json = JSON.json(log);
		System.out.println(json);
	}
}
