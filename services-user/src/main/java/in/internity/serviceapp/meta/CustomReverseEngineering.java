package in.internity.serviceapp.meta;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.mapping.MetaAttribute;

public class CustomReverseEngineering extends DelegatingReverseEngineeringStrategy {

	public CustomReverseEngineering(ReverseEngineeringStrategy delegate) {
		super(delegate);
	}

	@Override
	public Map<String, MetaAttribute> tableToMetaAttributes(TableIdentifier tableIdentifier) {

		Map<String, MetaAttribute> metaAttributes = super.tableToMetaAttributes(tableIdentifier);
		
		if(metaAttributes == null) {
			metaAttributes = new HashMap<>();
		}
		
		final MetaAttribute javaDocsAttribute = new MetaAttribute("class-description");
		final String description = "Hibernate Entity for table " + tableIdentifier.getName()
        +"\n" + "\n" + "@author Internity";
		
		javaDocsAttribute.addValue(description);
		metaAttributes.put("class-description", javaDocsAttribute);
		return metaAttributes;
	}
}
