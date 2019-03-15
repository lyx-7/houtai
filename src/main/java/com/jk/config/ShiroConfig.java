package com.jk.config;

import org.apache.shiro.mgt.SecurityManager;
import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 业精于勤荒于嬉,行成于思毁于随
 *
 * @Date 2019/2/28 13:43
 * @Created by wuzhuang
 */
@Configuration
public class ShiroConfig {

    /**
     * @Bean 把方法返回的对象交给spring进行管理 和xml中bean标签作用等价
     * <p>
     * id默认为方法的名字
     */
    @Bean
    public ShiroDialect shiroDialect() {

        return new ShiroDialect();
    }

    @Bean
    public SecurityManager securityManager() {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        securityManager.setRealm(myShiroRealm());

        return securityManager;

    }

    @Bean
    public MyRealm myShiroRealm() {
        MyRealm myShiroRealm = new MyRealm();
        return myShiroRealm;

    }


    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        System.out.println("ShiroConfiguration.shirFilter()");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        // map的值为anon shiro不会进行拦截
        filterChainDefinitionMap.put("/toLogin", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/index", "anon");

        //shiro会认为只是一个注销的接口
        filterChainDefinitionMap.put("/logout", "logout");


        //拦截除上面以外的所有接口
        filterChainDefinitionMap.put("/**", "authc");


        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //shiro拦截请求后如果发现没有登录 会自动跳转到登录接口
        shiroFilterFactoryBean.setLoginUrl("/login");//设置登录的界面
        // 当检测到没有登录时会自动跳转到登录界面
        // 登录成功后要跳转的链接
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/weishouquan");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator shiroAutoProxyCreator =
                new DefaultAdvisorAutoProxyCreator();
        shiroAutoProxyCreator.setProxyTargetClass(true);
        return shiroAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
