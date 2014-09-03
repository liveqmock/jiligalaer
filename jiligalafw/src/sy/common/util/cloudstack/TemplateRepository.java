package sy.common.util.cloudstack;

import java.util.List;

import sy.common.util.cloudstack.entity.Template;

/**
 * 
 * @author lidongbo
 * 
 */
public class TemplateRepository extends AbstractServiceSupport<Template> {

	private static final String LIST_TEMPLATES = "listTemplates";

	public TemplateRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return LIST_TEMPLATES;
	}

	@Override
	protected String getTagName() {
		return "template";
	}

	public List<Template> list(CSQuqeyContext context) {
		context.addParameter(new Param("templatefilter", "featured"));//executable
		return super.list(context);
	}

	public static void main(String[] args) {
		ProviderContext context = new ProviderContext();
		TemplateRepository service = new TemplateRepository(context);
		
		CSQuqeyContext qc = new CSQuqeyContext(new Param("listall", "true"));
		List<Template> result = service.list(qc);
		System.out.println(result);
		System.out.println(result.size());

	}
}
