package com.hlfc.db.mongodb.template.bean;

import com.google.code.morphia.annotations.Id;

import java.io.Serializable;

/**
 * 常用实体对象属性定义
 * 
 * @author llp@linewell.com 
 * 
 * @since 2012-08-29
 *
 */
public abstract class BeanEntity implements Serializable,Cloneable{
	
	// 系列化唯一ID
	private static final long serialVersionUID = 1808373775832899870L;

	/**
	 * 主键unid
	 */
	@Id
	private String unid;
	
	/**
	 * 获取unid
	 * @return
	 */
	public String getUnid() {
		return unid;
	}

	/**
	 * 设置unid,不用设置，系统会默认生成
	 * @param unid
	 */
	public void setUnid(String unid) {
		this.unid = unid;
	}	
	
}
