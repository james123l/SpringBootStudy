package springbootdemo.demo.importannotation.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/*
* 自定义import组件选择器
* */
public class MyImportSelector implements ImportSelector {
    //AnnotationMetadata ： 当前标注@import注解的类的所有注解信息
    @Override   //返回要导入的类的全类名
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //return new String[0]{ 所有的要导入的类名};
        return new String[0];
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return ImportSelector.super.getExclusionFilter();
    }
}
