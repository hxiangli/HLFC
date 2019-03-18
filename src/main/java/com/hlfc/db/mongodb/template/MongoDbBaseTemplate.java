package com.hlfc.db.mongodb.template;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;
import com.hlfc.db.mongodb.template.bean.BeanEntity;
import com.mongodb.WriteResult;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * MongoDbBaseTemplate基本模板
 * 
 * @author llp@linewell.com
 * 
 * @since 2012-08-30
 */
public abstract class MongoDbBaseTemplate {
	

	/**
	 * 更新时默认去除的属性
	 * modified by ssy，在更新的时候应该排除更新创建时间与创建人
	 */
	protected static final String[] DEFAULT_EXCLUDE = {"unid"};
	
	/**
	 * 默认主键
	 */
	public static final String DEFAULT_FIELD_UNID="_id";
	
	/**
	 * 数据同步标识，add by jly 2017-11-10
	 */
	public static final String SYNC_FLAG="syncFlag";
	
	/**
	 * 连接池
	 */
	private Datastore datastore ;
	
	/**
	 * 对象的bean数据类型
	 */
	protected Class<?> beanClass;
	
	/**
	 * 当前用户的unid
	 */
	private String userUnid;
	
	/**
	 * 设置数据来源类型
	 */
	protected void setBeanClass(Class<?> objClass){
		beanClass=objClass;
	}
	
	
	/**
	 * 设置当前操作的用户unid
	 * @param userUnid the userUnid to set
	 */
	protected void setUserUnid(String userUnid) {
		this.userUnid = userUnid;
	}

	/**
	 * 通用保存
	 * @param objBean 保存对象
	 * @return
	 */
	protected boolean commonSave(BeanEntity objBean){
		
		Key<BeanEntity> keyBaseEntity = this.datastore.save(objBean);
		
		// 2014-08-28 mdy by xhuatang
		// 保存成功与否的判断
		if(null == keyBaseEntity || null == keyBaseEntity.getId()){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 保存并返回unid
	 * @param objBean 保存对象
	 * @return
	 */
	protected String Save(BeanEntity objBean){
		Key<BeanEntity> keyBaseEntity = this.datastore.save(objBean);
		String unid = objBean.getUnid();
		// 2014-08-28 mdy by xhuatang
		// 保存成功与否的判断
		if(null == keyBaseEntity || null == keyBaseEntity.getId()){
			return null;
		}else{
			return unid;
		}
	}
	

	/**
	 * 保存
	 * @param objBean 保存对象
	 * @return
	 */
	protected boolean save(BeanEntity objBean){
		Key<BeanEntity> keyBaseEntity = this.datastore.save(objBean);
		
		// 2014-08-28 mdy by xhuatang
		// 保存成功与否的判断
		if(null == keyBaseEntity || null == keyBaseEntity.getId()){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 通用删除，要求必须已经设置好beanClass
	 * @param unid 主键值
	 * @return 删除成功true
	 */
	protected boolean commonDelete(String unid){
		return commonDelete(unid,beanClass);
	}
	
	/**
	 * 通用删除
	 * @param unid     主键值
	 * @param objClass 要删除对象
	 * @return  删除成功true
	 */
	protected <T> boolean commonDelete(String unid,Class<T> objClass){
	
		if(StringUtils.isEmpty(unid)){
			return false;
		}

		Query<T> query = this.datastore.createQuery(objClass);
		query.field(DEFAULT_FIELD_UNID).equal(unid);
		WriteResult writeResult = this.datastore.delete(query);
		
		// 2014-08-28 mdy by xhuatang
		// 如果没有进行删除的操作，则返回false
		if(writeResult.getN() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 通用删除
	 * @param query  删除的条件
	 * @return 删除成功true
	 */
	protected <T> boolean commonDelete(Query<T> query){
		
		WriteResult writeResult = this.datastore.delete(query);
		// 如果没有进行删除的操作，则返回false
		if(writeResult.getN() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 通用更新
	 * @param <T>  继承自BeanEntity的bean类
	 * @param objBean bean对象
	 * @param excludeNames  排除对象
	 * @return
	 */
	protected <T extends BeanEntity> boolean commonUpdate(T objBean,String[] excludeNames){
		return this.commonUpdate(objBean, excludeNames, null);
	}
	/**
	 * 通用更新
	 * @param <T>  						继承自BeanEntity的bean类
	 * @param objBean 					bean对象
	 * @param excludeNames  			排除对象
	 * @param UpdateOperations<T> ops 	更新对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends BeanEntity> boolean commonUpdate(T objBean,String[] excludeNames,UpdateOperations<T> ops){

		Query<T> query =(Query<T>)datastore.createQuery(objBean.getClass());
		query.field(DEFAULT_FIELD_UNID).equal(objBean.getUnid());
		
		if(ops==null){
			ops = (UpdateOperations<T>)datastore.createUpdateOperations(objBean.getClass());
		}
		if(null!=excludeNames&&excludeNames.length>0) {
			excludeNames = (String[]) ArrayUtils.addAll(DEFAULT_EXCLUDE, excludeNames);
		}else {
			excludeNames=DEFAULT_EXCLUDE;
		}

			//去除子表的更新
			CcipMorphiaUtil.updateOps(ops, objBean,excludeNames);
		int count = this.datastore.update(query, ops).getUpdatedCount();
		return (count>0);
	}
	
	/**
	 * 通用更新
	 * @param Query<T> query  		            更新条件
	 * @param UpdateOperations<T> ops 	更新对象
	 * @return
	 */
	protected <T extends BeanEntity> boolean commonUpdate(Query<T> query,UpdateOperations<T> ops){
		int count = this.datastore.update(query, ops).getUpdatedCount();
		return (count>0);
	}
	/**
	 * 通用获取对象方法
	 * @param <T>   对象类型
	 * @param unid  对象标识
	 * @param objClass  对象类
	 * @return   返回获取的对象
	 * @throws Exception 
	 */
	protected <T> T commonGet(String unid,Class<T> objClass) {
		
		if(StringUtils.isEmpty(unid)){
			return null;
		}
		Query<T> query=datastore.createQuery(objClass);
		query.field(DEFAULT_FIELD_UNID).equal(unid);
		
		return query.get();
		
	}

	/**
	 * 通用获取对象方法
	 * @param <T>   对象类型
	 * @param unid  对象标识
	 * @param objClass  对象类
	 * @return   返回获取的对象
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	protected <T> T commonGet(String unid){
		return (T)commonGet(unid,beanClass);
	}
	
	/**
	 * 通用更新
	 * @param <T>  继承自BeanEntity的bean类
	 * @param objBean bean对象
	 * @return
	 */
	protected <T extends BeanEntity> boolean commonUpdate(T objBean){
		
		return commonUpdate(objBean,null);
	}

	/**
	 * 获取Datastore对象
	 * @return Datastore
	 */
	protected Datastore getDatastore() {
		return this.datastore;
	}
	
	/**
	 * 设置Datastore对象
	 * @param datastore Datastore对象
	 */
	protected void setDatastore(Datastore datastore){
		this.datastore = datastore;
	}
	
//	protected abstract void reConnect();


}
