package springbootdemo.demo.componentfilter;

import javassist.bytecode.stackmap.TypeData;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyComponentTypeFilter implements TypeFilter {

    /*
    * MetadataReader 扫描当前类的信息
    * MetadataReaderFactory 扫描任何类的信息
    * */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源路径等信息
        Resource resource = metadataReader.getResource();
        //获取类名
        String className = classMetadata.getClassName();
        if(className.contains("er")) return true;
        return false;
    }
}
