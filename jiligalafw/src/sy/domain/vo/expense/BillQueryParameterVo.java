package sy.domain.vo.expense;

import java.util.Date;

import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.shared.BaseVo;

/**
 * 账单查询条件 包装
 * @author xhchen
 *
 */
public class BillQueryParameterVo extends BaseVo{
	
	private BasicUserVo basicUserVo;
	private String expDateStart;
	private String expDateEnd;
	
	
	public BasicUserVo getBasicUserVo() {
		return basicUserVo;
	}
	public void setBasicUserVo(BasicUserVo basicUserVo) {
		this.basicUserVo = basicUserVo;
	}
	public String getExpDateStart() {
		return expDateStart;
	}
	public void setExpDateStart(String expDateStart) {
		this.expDateStart = expDateStart;
	}
	public String getExpDateEnd() {
		return expDateEnd;
	}
	public void setExpDateEnd(String expDateEnd) {
		this.expDateEnd = expDateEnd;
	}
	
}
