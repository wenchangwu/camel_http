package shiro.dao.imp;

import org.springframework.stereotype.Repository;

import shiro.dao.RoleDao;
import shiro.model.Role;
import jpa.dao.BaseDaoImpl;

@Repository(value="roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {


}
