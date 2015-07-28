package shiro.dao.imp;

import org.springframework.stereotype.Repository;

import shiro.dao.PermissionDao;
import shiro.model.Permission;
import jpa.dao.BaseDaoImpl;

@Repository(value="permissionDao")
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao {


}
