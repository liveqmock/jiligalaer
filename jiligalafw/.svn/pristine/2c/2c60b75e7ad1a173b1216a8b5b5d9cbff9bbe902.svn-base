package sy.service.base;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.domain.model.base.BasicUserQuota;
import sy.domain.vo.base.BasicUserQuotaVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 用户数量、信用额度设置service实现
 * @author luobin
 * 
 */
@Service("basicUserQuotaService")
public class BasicUserQuotaService extends BaseServiceTemplate<BasicUserQuota, BasicUserQuotaVo> implements BasicUserQuotaServiceI{

	/**
	 * 获取管理员设置的用户配置信息
	 */
	public BasicUserQuotaVo getUserQuotaInfo(){
		List<BasicUserQuotaVo> list = this.find(BasicUserQuotaVo.class, "from BasicUserQuota");
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return new BasicUserQuotaVo();
		}
	}
	
	
	/**
	 * 获取测试用户数量
	 */
	public int getTestUserNumber(){
		BasicUserQuotaVo vo = this.getUserQuotaInfo();
		if(vo != null && vo.getTestUserNum() != null){
			return vo.getTestUserNum().intValue();
		}else{
			return -1;
		}
	}
	
	/**
	 * 获取测试用户额度
	 */
	public Double getTestCredit(){
		BasicUserQuotaVo vo = this.getUserQuotaInfo();
		if(vo != null && vo.getTestUserNum() != null){
			return vo.getTestCredit();
		}else{
			return new Double(0);
		}
	}
	
	/**
	 * 获取正式用户信用额度
	 */
	public Double getFormalCredit(){
		BasicUserQuotaVo vo = this.getUserQuotaInfo();
		if(vo != null && vo.getTestUserNum() != null){
			return vo.getFormalCredit();
		}else{
			return new Double(0);
		}
	}
	
}
