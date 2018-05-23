package com.skyblue.mapper;

import com.skyblue.entity.Organize;

import java.util.List;

/**
 * 记录组织机构管理信息
 * 
 * @author TremBear
 * @email qq1424479171@qq.com
 * @date 2017-11-06 17:39:31
 */
public interface OrganizeDao extends BaseDao<Organize> {

    List<Organize> getList();

    List<Organize> queryByParentId(String orgId);

    Organize queryByOrgCode(String orgCode);
}
