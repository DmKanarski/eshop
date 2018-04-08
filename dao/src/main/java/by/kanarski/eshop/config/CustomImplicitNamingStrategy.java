package by.kanarski.eshop.config;

import com.github.fluent.hibernate.cfg.strategy.hibernate4.Hibernate4NamingStrategy;
import com.github.fluent.hibernate.cfg.strategy.hibernate5.adapter.ImprovedNamingStrategyHibernate5;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitEntityNameSource;
import org.hibernate.boot.model.naming.ImplicitForeignKeyNameSource;
import org.hibernate.boot.spi.MetadataBuildingContext;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

// TODO: 25.06.2017 Может чего причесать-добавить
@Slf4j
public class CustomImplicitNamingStrategy extends ImprovedNamingStrategyHibernate5 {

    private static final Hibernate4NamingStrategy hibernate4NamingStrategy = new Hibernate4NamingStrategy();

    private final Map<String, String> prefixMap = new HashMap<String, String>() {
        {
            put("catalog", "c");
            put("handbook", "h");
            put("journal", "j");
            put("registry", "r");
            put("many_to_many", "nn");
        }
    };

    @Override
    public Identifier determinePrimaryTableName(ImplicitEntityNameSource source) {
        final String entityClassName = source.getEntityNaming().getClassName();
        final Pattern pattern = Pattern.compile("\\.(\\w+)\\.(\\w+)$");
        final Matcher matcher = pattern.matcher(entityClassName);
        matcher.find();
        final String tableTypeName = matcher.group(1);
        final String prefix = prefixMap.get(tableTypeName);
        final String tableName = hibernate4NamingStrategy.classToTableName(entityClassName);
        final String fullTableName = prefix.concat("_").concat(tableName);
        return toIdentifier(fullTableName, source.getBuildingContext());
    }

    @Override
    public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource source) {
        if (source == null || source.getReferencedTableName() == null) {
            return super.determineForeignKeyName(source);
        } else {
            return toIdentifier(source.getReferencedTableName().getText(), source.getBuildingContext());
        }
    }

    private static Identifier toIdentifier(String stringForm,
                                           MetadataBuildingContext buildingContext) {
        // buildingContext can be null during a unit testing
        return buildingContext == null ? Identifier.toIdentifier(stringForm)
                : buildingContext.getMetadataCollector().getDatabase().getJdbcEnvironment()
                .getIdentifierHelper().toIdentifier(stringForm);
    }

}
