package com.dfec.redisshiroswagger.Service.ServiceImp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfec.redisshiroswagger.Service.ILoginService;
import com.dfec.redisshiroswagger.domain.Permission;
import com.dfec.redisshiroswagger.domain.Role;
import com.dfec.redisshiroswagger.domain.User;
import com.dfec.redisshiroswagger.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname LoginService
 * @Date 2020/7/21 10:25
 * @Copyright DFEC
 **/
@Service
public class LoginService extends ServiceImpl<BaseMapper<User>,User> implements ILoginService {
    @Autowired
    private IRoleRepository roleRepository;

    //添加用户
    public boolean addUser(User user){
       return super.save(user);
    }
    //添加角色
    public int addRole(Map<String, Object> map){
        User user = super.getBaseMapper().selectById(Long.parseLong((String) map.get("userID")));
        Role role = new Role();
        role.setRoleName(map.get("roleName").toString());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setRole(role);
        permission1.setPermission("create");//分配权限
        Permission permission2 = new Permission();
        permission2.setRole(role);
        permission2.setPermission("update");//分配权限
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
       return roleRepository.insert(role);
    }


    @Override
    public User findByName(String name) {
        return super.getOne(new QueryWrapper<User>().eq("name",name));
    }
}
