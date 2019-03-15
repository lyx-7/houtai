package com.jk.config;

import com.jk.bean.Staff;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        WebUtils.getAndClearSavedRequest(request);//清理了session中保存的请求信息
        WebUtils.redirectToSavedRequest(request, response, getSuccessUrl());
        return false;
    }

    /**
     * 每次登录都会到这里来，这里用来处理 不注销之前已登录用户下，再次登录
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginRequest(request, response))
        {
            if (isLoginSubmission(request, response))
            {
                //本次用户登陆账号
                String username = this.getUsername(request);

                Subject subject = this.getSubject(request, response);
                //之前登陆的用户
                Staff staff = (Staff) subject.getPrincipal();
                //再次登录时，直接先注销登录，
                subject.logout();
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }


}
