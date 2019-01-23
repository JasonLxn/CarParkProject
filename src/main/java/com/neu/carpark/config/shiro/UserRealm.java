package com.neu.carpark.config.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.neu.carpark.entity.Alluser;
import com.neu.carpark.entity.Role;
import com.neu.carpark.config.shiro.ShiroUtils;
import com.neu.carpark.service.AlluserService;
import com.neu.carpark.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private AlluserService alluserService;
	@Autowired
	private RoleService roleService;

    
    /**
     * 授权(验证权限时调用)
	 * 本系统暂无具体权限分配，故置空
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

		String account = authcToken.getPrincipal().toString();
		Alluser user =  alluserService.selectOne(new EntityWrapper<Alluser>().eq("all_account",account));

		if (user == null) {
			throw new UnknownAccountException("用户名或密码错误！");
		}
		if (!user.getAllState().equals("1")) {
			throw new LockedAccountException("账号状态异常,请联系管理员！");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getAllPwd(), ByteSource.Util.bytes(user.getAllSalt()), getName());
		return info;
	}

	//告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}