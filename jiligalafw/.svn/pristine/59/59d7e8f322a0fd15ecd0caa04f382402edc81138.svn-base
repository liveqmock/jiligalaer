package sy.common.util.cloudstack;

import sy.common.util.cloudstack.entity.Volume;

/**
 *
 * @author lidongbo
 *
 */
public class VolumeRepository extends AbstractServiceSupport<Volume>{

	public VolumeRepository(ProviderContext provider) {
		super(provider);
	}

	@Override
	protected String getListCommand() {
		return "listVolumes";
	}

	@Override
	protected String getTagName() {
		return "volume";
	}

	@Asynchronous
	protected String getCreateCommand() {
		return "createVolume";
	}

	public void delete(String volumeid) {
		super.delete("id", volumeid, "deleteVolume",false);
	}
}
