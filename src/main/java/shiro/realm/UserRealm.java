package shiro.realm;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import shiro.model.User;
import shiro.service.UserService;

public class UserRealm extends AuthorizingRealm {

	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalcollection) {
		String username=(String)principalcollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		Set<String> roles=userService.getRolesByUserName(username);
		authorizationInfo.setRoles(roles);
		Set<String> permissions=userService.getPermissionByUserName(username);
		authorizationInfo.setStringPermissions(permissions);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationtoken)
			throws AuthenticationException {
		String username=(String)authenticationtoken.getPrincipal();
		User user=userService.fetchUserByUsername(username);
		System.out.println(user);
		if(user==null){
			throw new UnknownAccountException();
		}
		if(Boolean.TRUE.equals(user.isLocked())){
			throw new LockedAccountException();
		}
		
		 //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
	}

}
