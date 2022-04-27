package com.letmeng.wms.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.letmeng.wms.sys.common.Constast;
import com.letmeng.wms.sys.common.DataGridView;
import com.letmeng.wms.sys.common.WebUtils;
import com.letmeng.wms.sys.domain.Permission;
import com.letmeng.wms.sys.domain.User;
import com.letmeng.wms.sys.service.PermissionService;
import com.letmeng.wms.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  菜单管理前端控制器
 * </p>
 *
 * @author letmeng
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo) {

        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", Constast.TYPE_MENU);
        queryWrapper.eq("available", Constast.AVAILABLE_TRUE);

        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list = null;
        if (user.getType() == Constast.USER_TYPE_SUPER) {
            //超级用户,提供全部menu
            list = permissionService.list(queryWrapper);
        } else {
            //普通用户,根据用户ID+角色+权限去查询
            list = permissionService.list(queryWrapper);
        }
        return new DataGridView(list);
    }

}
