package com.hakaryzhang;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.function.Predicate;

/*
* 导入选择器，用于实现按需装配第三方类的逻辑
* */
public class WorkerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 实现根据 EnableWorker 注解的 enabled 属性决定是否装配 Worker 配置类
        Map<String, Object> attributes = importingClassMetadata
                .getAnnotationAttributes(EnableWorker.class.getName());
        boolean enabled = (boolean) attributes.get("enabled");
        if (enabled) {
            return new String[]{WorkerConfiguration.class.getName()};   // 返回 WorkerConfiguration.class 的全限定名
        } else {
            return new String[]{};
        }
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return ImportSelector.super.getExclusionFilter();
    }
}
