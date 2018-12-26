package com.imooc.books.bean;

import java.util.HashMap;
import java.util.Map;


public class Msg {
	/**
	 * 状态码 0 - 未知 100-成功 200-失败
	 */
	private int code;

	/**
	 * 提示信息
	 */
	private String msg;

	/**
	 * 服务器要返回给浏览器的数据
	 */
	private Map<String, Object> data;

	/**
	 * 这是一个统一前后台交互的接口，那么他不应该被随意构造，只允许客户使用提供的success和fail方法构造他，起到初始化code的作用
	 */
	private Msg() {
		data = new HashMap<String, Object>();
	}

	/**
	 * 对外的静态方法,用于生成操作成功的对象
	 * 
	 * @return 操作成功的对象
	 */
	public static Msg success() {
		Msg result = new Msg();
		result.setCode(100);
		return result;
	}

	/**
	 * 对外的静态方法,用于生成操作失败的对象
	 * 
	 * @return 操作失败的对象
	 */
	public static Msg fail() {
		Msg result = new Msg();
		result.setCode(200);
		return result;
	}

	public Msg add(String key, Object value) {
		this.getData().put(key, value);
		return this;
	}

	public int getCode() {
		return code;
	}

	public Msg setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Msg setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public Msg setData(Map<String, Object> data) {
		this.data = data;
		return this;
	}

}
