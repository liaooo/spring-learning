package com.liao.example.profile;

import com.liao.example.profile.bean.DemoBean;
import com.liao.example.profile.config.ProfileConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringJUnit4ClassRunner 在JUnit环境下提供Spring TestContext 功能
 * @ContextConfiguration 加载配置ApplicationContext classes加载配置类
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
@ActiveProfiles("dev")
public class DemoBeanTest {

    @Autowired
    private DemoBean demoBean;

    @Test
    public void test() {
        String expectValue = "from dev bean";
        String beanValue = demoBean.getContent();
        Assert.assertEquals(expectValue, beanValue);
    }
}
