package com.skyblue.mapper;

import com.skyblue.entity.SysUser;
import skyblue.mapper.BaseDao;

import java.util.List;

/**
 * @author TremBear
 * @email 1424479171@qq.com
 * @date 2018-05-24 14:37
 */

public interface SysUserDao extends BaseDao<SysUser>{
    List<String> queryAllPerms(Long userId);
    SysUser queryByUserName(String username);
}
