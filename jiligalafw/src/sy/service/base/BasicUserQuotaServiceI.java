package sy.service.base;

import sy.domain.vo.base.BasicUserQuotaVo;
import sy.service.shared.BasicServiceI;

/**
 * 用户数量、信用额度设置service接口
 * @author luobin
 *
 */
public interface BasicUserQuotaServiceI extends BasicServiceI<BasicUserQuotaVo> {

	/**
	 * 获取管理员设置的用户配置信息
	 * @return
	 */
	public BasicUserQuotaVo getUserQuotaInfo();
	
	/**
	 * 获取测试用户数量
	 * @return
	 */
	public int getTestUserNumber();
	
	/**
	 * 获取测试用户额度
	 * @return
	 */
	public Double getTestCredit();
	
	/**
	 * 获取正式用户信用额度
	 * @return
	 */
	public Double getFormalCredit();
	
}
