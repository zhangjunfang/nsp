package net.newcapec.bus;

import java.io.Serializable;
import java.util.List;

/**
 * 结果集（每个服务层方法必须返回此种形式）
 *
 * @author 黄鑫
 *
 * @param <T>
 */
public class ResultMapper<T> implements Serializable {

	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	private static final long serialVersionUID = 2648122027664900826L;
	private String status = FAILURE;
	private Integer count;
	private List<T> list;
	private T t;
	private String msg;
	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
