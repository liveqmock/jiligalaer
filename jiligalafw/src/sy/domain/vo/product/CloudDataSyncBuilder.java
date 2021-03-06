package sy.domain.vo.product;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import sy.common.util.cloudstack.CloudBean;
import sy.common.util.generics.GenericsUtils;
import sy.domain.vo.shared.BaseVo;

/**
 * 
 * @author lidongbo
 * 
 */
public abstract class CloudDataSyncBuilder<T extends CloudBean> extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4343677556137919934L;

	protected Class<T> cloudBeanClzz;

	@SuppressWarnings("unchecked")
	public CloudDataSyncBuilder() {
		cloudBeanClzz = GenericsUtils.getSuperClassGenricType(getClass(), 0);
	}

	public BaseVo build(T bean) {
		if (bean != null) {
			initVoFromCloudBean(bean);
		}
		return this;
	}

	public Class<T> getCloudBeanClass() {
		return cloudBeanClzz;
	}

	private String id;

	/**
	 * 接口ID
	 */
	private String interfaceId;

	/**
	 * 同步时间
	 */
	private Date syncTime;

	/**
	 * 状态
	 */
	private Integer dataState;
	
	private Date syncCreatedTime;

	@SuppressWarnings("unchecked")
	protected void initVoFromCloudBean(T bean) {
		Field[] voFields = getClass().getDeclaredFields();
		for (Field voField : voFields) {
			try {
				Field cloudFiled = cloudBeanClzz.getDeclaredField(voField
						.getName().toLowerCase());
				cloudFiled.setAccessible(true);
				voField.setAccessible(true);
				
				Object voValue = voField.get(this);
				Object cloudValue = cloudFiled.get(bean);
				
				if(voValue instanceof List
						&& cloudValue instanceof List
						&& voField.isAnnotationPresent(CloudDataSyncBuilderClass.class)){
					
					List<Object> voValueList = (List<Object>)voValue;
					List<CloudBean> cloudValueList = (List<CloudBean>)cloudValue;
					for (CloudBean object : cloudValueList) {
						CloudDataSyncBuilderClass builderClassAnn = voField.getAnnotation(CloudDataSyncBuilderClass.class);
						Class<CloudDataSyncBuilder<CloudBean>> builderClass = (Class<CloudDataSyncBuilder<CloudBean>>) builderClassAnn.beanClass();
						voValueList.add(builderClass.newInstance().build(object));
					}
				}else{
					if(String.class.isAssignableFrom(voField.getType())){
						if (cloudValue != null) {
							voField.set(this, String.valueOf(cloudValue));
						}
					}else{
						voField.set(this, cloudValue);
					}
				}
			} catch (Exception e) {
			}
		}
		id = null;
		syncTime = new Date();
		dataState = 1;
		interfaceId = bean.getId();
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public Integer getDataState() {
		return dataState;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSyncCreatedTime() {
		return syncCreatedTime;
	}

	public void setSyncCreatedTime(Date syncCreatedTime) {
		this.syncCreatedTime = syncCreatedTime;
	}
	
	
}
