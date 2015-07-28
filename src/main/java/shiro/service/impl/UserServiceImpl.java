package shiro.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shiro.dao.UserDao;
import shiro.model.Permission;
import shiro.model.Role;
import shiro.model.User;
import shiro.service.PasswordHelper;
import shiro.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Resource
	private PasswordHelper passwordHelper;

	@Override
	@Transactional(readOnly = false)
	public void createUser(User user) {
		passwordHelper.encryptPassword(user);
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public User fetchUser(int id) {
		return userDao.fetchObjectById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	@Transactional(readOnly = false)
	public Set<String> getRolesByUserName(String username) {
		User user = this.fetchUserByUsername(username);
		Set<String> roles = new HashSet<String>();
		Set<Role> temp = user.getRoles();
		for (Iterator<Role> iterator = temp.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			roles.add(role.getRole());
		}
		return roles;
	}

	@Override
	@Transactional(readOnly = false)
	public Set<String> getPermissionByUserName(String username) {
		User user = this.fetchUserByUsername(username);
		Set<String> permissions = new HashSet<String>();
		Set<Role> temp = user.getRoles();
		for (Iterator<Role> iterator = temp.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			Set<Permission> tmp = role.getPermissions();
			for (Iterator<Permission> iterator2 = tmp.iterator(); iterator2.hasNext();) {
				Permission permission = (Permission) iterator2.next();
				permissions.add(permission.getPermission());
			}
		}
		return permissions;
	}

	@Override
	@Transactional(readOnly = false)
	public User fetchUserByUsername(String username) {
		return userDao.fetchUserByUsername(username);
	}

}
