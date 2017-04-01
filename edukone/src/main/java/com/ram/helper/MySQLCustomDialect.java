package com.ram.helper;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.BooleanType;

public class MySQLCustomDialect extends MySQL5Dialect {
	public MySQLCustomDialect() {
		super();
		registerFunction("matches", new SQLFunctionTemplate(BooleanType.INSTANCE, "MATCH(?1) AGAINST (?2)"));
	}
}