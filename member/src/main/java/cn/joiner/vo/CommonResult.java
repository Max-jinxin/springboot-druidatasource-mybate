package cn.joiner.vo;


public class CommonResult {
	
	 // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public CommonResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CommonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

	public CommonResult(Object data) {
		 this.status = 200;
	      this.msg = "OK";
	      this.data = data;
	}

	public static CommonResult build(Integer status, String msg, Object data) {
        return new CommonResult(status, msg, data);
    }
	
	public static CommonResult ok() {
        return new CommonResult(null);
    }
	
	public static CommonResult ok(String msg) {
        return new CommonResult(200,msg,null);
    }
	
	
	
    
    
}
