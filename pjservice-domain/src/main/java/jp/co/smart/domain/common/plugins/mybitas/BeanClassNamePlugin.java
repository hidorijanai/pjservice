package jp.co.smart.domain.common.plugins.mybitas;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * エンティティのクラス名を変更する
 *
 * @author bakuskjp
 *
 */
public class BeanClassNamePlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
    public void initialized(IntrospectedTable table) {
        super.initialized(table);

        String name = table.getBaseRecordType();
        table.setBaseRecordType(name + "Dto");
    }
}
