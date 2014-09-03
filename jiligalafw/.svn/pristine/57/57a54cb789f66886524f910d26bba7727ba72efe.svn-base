package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Event;

/**
 * 
 * @author lidongbo
 * 
 */
public class EventRepository extends AbstractServiceSupport<Event> {

	public EventRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listEvents";
	}

	@Override
	protected String getTagName() {
		return "event";
	}

}
