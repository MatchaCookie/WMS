package com.letmeng.wms.sys.service.impl;

import com.letmeng.wms.sys.domain.User;
import com.letmeng.wms.sys.mapper.UserMapper;
import com.letmeng.wms.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author letmeng
 * @since 2022-04-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
