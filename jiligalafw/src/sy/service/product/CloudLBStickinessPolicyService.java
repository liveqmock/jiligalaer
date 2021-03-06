package sy.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CloudBean;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.LBStickinessPolicyRepository;
import sy.common.util.cloudstack.Param;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.entity.LBStickinessPolicy;
import sy.common.util.cloudstack.entity.StickinessMethod;
import sy.common.util.cloudstack.entity.StickinessMethodType;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudLBStickinessPolicy;
import sy.domain.vo.product.CloudLBStickinessPolicyVo;
import sy.domain.vo.product.CloudLoadbalancerruleVo;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudLBStickinessPolicyService")
public class CloudLBStickinessPolicyService
		extends
		SynchronizeDataService<CloudLBStickinessPolicy, CloudLBStickinessPolicyVo>
		implements CloudLBStickinessPolicyServiceI {

	@Autowired
	private CloudLoadbalancerruleServiceI cloudLoadbalancerruleService;

	public <T extends CloudBean> List<CloudLBStickinessPolicyVo> getDatesFromInterface(Param ... params)
			throws ValidatorException {
		List<CloudLBStickinessPolicyVo> result = new ArrayList<CloudLBStickinessPolicyVo>();
		List<CloudLoadbalancerruleVo> rules = cloudLoadbalancerruleService
				.getDatesFromInterface();
		for (CloudLoadbalancerruleVo rule : rules) {
			result.addAll(super.getDatesFromInterface(new Param("lbruleid",
					rule.getInterfaceId())));
		}
		return result;
	}

	public void setStickinessPolicy(CloudLBStickinessPolicyVo voParam) throws ValidatorException,CloudException {
	
		ProviderContext context = new ProviderContext();
		LBStickinessPolicyRepository service = new LBStickinessPolicyRepository(context);
		
		String lbruleid = voParam.getLbruleid();
		String name = voParam.getName();
		StickinessMethod method = StickinessMethodType.getInstance(voParam.getMethodname());

		LBStickinessPolicy result = service.setStickinessPolicy(lbruleid, name, method, voParam);
		CloudLBStickinessPolicyVo vo = createVo(result);
		if(vo == null){
			update("Update CloudLBStickinessPolicy Set dataState = 0 Where lbruleid = ?", lbruleid);
		}else{
			save(vo);
		}
	}
	
	public CloudLBStickinessPolicyVo getStickinessByRuleId(String ruleId) throws ValidatorException,CloudException {
		return this.findUnique("from CloudLBStickinessPolicy where dataState='1' and lbruleid=?", ruleId);
	}
	
	public CloudLoadbalancerruleServiceI getCloudLoadbalancerruleService() {
		return cloudLoadbalancerruleService;
	}

	public void setCloudLoadbalancerruleService(
			CloudLoadbalancerruleServiceI cloudLoadbalancerruleService) {
		this.cloudLoadbalancerruleService = cloudLoadbalancerruleService;
	}
}
