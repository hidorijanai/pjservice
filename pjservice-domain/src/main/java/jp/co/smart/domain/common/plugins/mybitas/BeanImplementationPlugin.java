package jp.co.smart.domain.common.plugins.mybitas;

import java.util.List;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * エンティティにインタフェースを実装させる
 * @author bakuskjp
 *
 */
public class BeanImplementationPlugin extends PluginAdapter {

	private FullyQualifiedJavaType bean;

	public BeanImplementationPlugin() {
        bean = new FullyQualifiedJavaType("java.io.Serializable");
    }

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        implementBean(
                topLevelClass,
                introspectedTable.getFullyQualifiedTable());
        return true;
    }

    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        implementBean(
                topLevelClass,
                introspectedTable.getFullyQualifiedTable());
        return true;
    }

    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        implementBean(
                topLevelClass,
                introspectedTable.getFullyQualifiedTable());
        return true;
    }

    protected void implementBean(TopLevelClass topLevelClass,
            FullyQualifiedTable table) {
        topLevelClass.addImportedType(bean);
        topLevelClass.addSuperInterface(bean);
    }
}
