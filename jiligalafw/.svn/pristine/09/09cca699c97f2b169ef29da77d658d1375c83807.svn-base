package sy.ext.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.PropertyNotFoundException;
import org.hibernate.property.ChainedPropertyAccessor;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.property.Setter;
import org.hibernate.transform.AliasedTupleSubsetResultTransformer;

/**
 * 
 * @author lidongbo
 * 
 */
public class DynamicAliasToBeanResultTransformer extends
		AliasedTupleSubsetResultTransformer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8696522395573134383L;
	private final Class<?> resultClass;
	private Setter[] setters;
	private boolean isInitialized;
	
	public DynamicAliasToBeanResultTransformer(Class<?> resultClass) {
		if (resultClass == null) {
			throw new IllegalArgumentException("resultClass cannot be null");
		}
		this.resultClass = resultClass;
		isInitialized = false;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isTransformedValueATupleElement(String[] aliases,
			int tupleLength) {
		return false;
	}

	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object result;

		try {
			
			if(aliases.length > 0
					&& !isInitialized){
				initialize(aliases);
			}

			result = resultClass.newInstance();

			for (int i = 0; i < aliases.length; i++) {
				if (setters[i] != null) {
					setters[i].set(result, tuple[i], null);
				}
			}
		} catch (InstantiationException e) {
			throw new HibernateException("Could not instantiate resultclass: "
					+ resultClass.getName());
		} catch (IllegalAccessException e) {
			throw new HibernateException("Could not instantiate resultclass: "
					+ resultClass.getName());
		}

		return result;
	}

	private void initialize(String[] aliases) {
		PropertyAccessor propertyAccessor = new ChainedPropertyAccessor(
				new PropertyAccessor[] {
						PropertyAccessorFactory.getPropertyAccessor(
								resultClass, null),
						PropertyAccessorFactory.getPropertyAccessor("field") });
		isInitialized = true;
		setters = new Setter[aliases.length];
		for (int i = 0; i < aliases.length; i++) {
			String alias = aliases[i];
			if (alias != null) {
				try {
					setters[i] = propertyAccessor.getSetter(resultClass, alias);
				} catch (PropertyNotFoundException e) {
					continue;
				}
			}
		}
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		DynamicAliasToBeanResultTransformer that = (DynamicAliasToBeanResultTransformer) o;

		if (!resultClass.equals(that.resultClass)) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int result = resultClass.hashCode();
		return result;
	}
}