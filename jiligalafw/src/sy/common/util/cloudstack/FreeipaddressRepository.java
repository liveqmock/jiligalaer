package sy.common.util.cloudstack;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sy.common.util.cloudstack.entity.FreeuserIpaddressByZoneid;
import sy.common.util.cloudstack.http.RequestMethod;

/**
 * 
 * @author luobin
 * 
 */
public class FreeipaddressRepository extends AbstractServiceSupport<FreeuserIpaddressByZoneid> {

	public FreeipaddressRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listFreeUserIPAddressByZoneId";
	}

	@Override
	protected String getTagName() {
		return "freeuseripaddressbyzoneid";
	}

	
	public static void main(String[] args) {
//		CSQuqeyContext qc = new CSQuqeyContext(new Param("zoneid", "2dadd763-273b-4681-8bb2-9bb1063bb073"));
//		String url = method.buildUrl("listFreeUserIPAddressByZoneId", qc.getParametersAsArray());
		ProviderContext context = new ProviderContext();
		RequestMethod method = new RequestMethod(context);
		Document doc = method.get("http://172.18.0.102:8096/client/api?command=listFreeUserIPAddressByZoneId&zoneid=2dadd763-273b-4681-8bb2-9bb1063bb073");
		
//		NodeList nodeList = doc.getElementsByTagName("publicipaddress");
//		System.out.println(nodeList.getLength());
//		for(int i=0; i<nodeList.getLength(); i++){
//			Node attribute = nodeList.item(i);
//			String value = attribute.getFirstChild().getNodeValue();
//			System.out.println(value);
//		}
		
		NodeList nodels = doc.getElementsByTagName("freeuseripaddressbyzoneid");
		for(int i=0; i<1; i++){
			
			Node node = nodels.item(i);
			NodeList attributes = node.getChildNodes();
			System.out.println(node.getNodeName());
			System.out.println(node.getNodeValue());
			
			for(int j=0; j<attributes.getLength(); j++){
				Node attribute = attributes.item(j);
				System.out.println(attribute.getNodeName());
				if (attribute.hasChildNodes() && attribute.getChildNodes().getLength() > 0) {
					String value = attribute.getFirstChild().getNodeValue();
					System.out.println(value);
				}
			}

		}

	}
}
