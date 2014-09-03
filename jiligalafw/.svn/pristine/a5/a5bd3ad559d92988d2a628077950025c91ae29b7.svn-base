//package sy.domain.vo.product;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.validation.ValidationException;
//
//import sy.common.util.cloudstack.CloudBean;
//import sy.common.util.cloudstack.entity.Diskoffering;
//import sy.common.util.cloudstack.entity.Networkoffering;
//import sy.common.util.cloudstack.entity.Publicipaddress;
//import sy.common.util.cloudstack.entity.Serviceoffering;
//import sy.common.util.cloudstack.entity.Template;
//import sy.common.util.cloudstack.entity.Virtualmachine;
//import sy.common.util.cloudstack.entity.Zone;
//
///**
// * 
// * @author lidongbo
// * 
// */
//public class CloudDataSyncCloudBeanFactory {
//
//	private static Map<Class<? extends CloudDataSyncBuilder<? extends CloudBean>>, Class<? extends CloudBean>> mappings = new HashMap<Class<? extends CloudDataSyncBuilder<? extends CloudBean>>, Class<? extends CloudBean>>();
//
//	static {
//		mappings.put(CloudMdmCPUSolnVo.class, Serviceoffering.class);
//		mappings.put(CloudMdmDiskSolnVo.class, Diskoffering.class);
//		mappings.put(CloudMdmIPVo.class, Publicipaddress.class);
//		mappings.put(CloudMdmNetworkSolnVo.class, Networkoffering.class);
//		mappings.put(CloudMdmTemplateVo.class, Template.class);
//		mappings.put(CloudMdmVmVo.class, Virtualmachine.class);
//		mappings.put(CloudMdmZoneVo.class, Zone.class);
//	}
//
//	public static CloudDataSyncBuilder<? extends CloudBean> create(
//			Class<? extends CloudDataSyncBuilder<? extends CloudBean>> clzz) {
//		Class<? extends CloudBean> cloudBean = mappings
//				.get(clzz);
//		if (cloudBean != null) {
//			try {
//				return builderClazz.newInstance();
//			} catch (Exception e) {
//				throw new ValidationException(e);
//			}
//		}
//		return null;
//	}
//
//}
