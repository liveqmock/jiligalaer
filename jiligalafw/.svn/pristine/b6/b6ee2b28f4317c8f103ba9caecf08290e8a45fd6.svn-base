package sy.common.util.cloudstack;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sy.common.util.cloudstack.entity.Capacity;
import sy.common.util.cloudstack.http.RequestMethod;

/**
 * 
 * @author luobin
 * 
 */
public class SystemCapacityRepository extends AbstractServiceSupport<Capacity> {

	public SystemCapacityRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listCapacity";
	}

	@Override
	protected String getTagName() {
		return "capacity";
	}


	public static void main(String[] args) {
		ProviderContext context = new ProviderContext();
		RequestMethod method = new RequestMethod(context);
		Document doc = method.get("http://172.18.0.102:8096/client/api?command=listCapacity");

		NodeList nodels = doc.getElementsByTagName("capacity");
		for(int i=0; i<nodels.getLength(); i++){
			Node node = nodels.item(i);
			NodeList attributes = node.getChildNodes();
			
			for(int j=0; j<attributes.getLength(); j++){
				Node attribute = attributes.item(j);
				if (attribute.hasChildNodes() && attribute.getChildNodes().getLength() > 0) {
					String value = attribute.getFirstChild().getNodeValue();
					System.out.println(attribute.getNodeName() + "：" + value);
				}
			}

		}

	}
}

