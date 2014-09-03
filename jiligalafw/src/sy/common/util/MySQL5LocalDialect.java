package sy.common.util;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MySQL5LocalDialect extends MySQL5Dialect {
	public MySQL5LocalDialect() {
		super();
		registerFunction("convert", new SQLFunctionTemplate(StandardBasicTypes.STRING, "convert(?1 using ?2)"));
		registerFunction("group_concat", new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
	}
}