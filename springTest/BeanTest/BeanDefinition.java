package BeanTest;

/**
 * bean 定义类，配置文件中 bean 定义对应的实体
 */
public class BeanDefinition {

    private String beanName;

    private Class beanClass;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
//省略getter、setter
}

