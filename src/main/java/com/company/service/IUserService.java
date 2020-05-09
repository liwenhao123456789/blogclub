package com.company.service;

import java.util.List;

import com.company.bean.User;
import com.company.vo.UserVO;

/**
 * @author Johnny
 * @category 用户的业务逻辑层
 */
public interface IUserService {

	/**
	 * 根据用户id和密码，查询出用户对象
	 * @param id
	 * @param pass
	 * @return
	 */
	public User find(String id, String pass);
	
	/**
	 * 根据用户name和密码，查询出用户对象
	 * @param id
	 * @param pass
	 * @return
	 */
	public User findByName(String name, String pass);

	/**
	 * 添加用户，（注册）
	 * @param user
	 * @return
	 */
	public boolean add(User user);

	/**
	 * 查询出来所有的人员集合，除了管理员以外
	 */
	public List<UserVO> findUserList();
	
	/**
	 * 根据用户id删除用户对象
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
	
	/**
	 * 根据用户id查询出用户对象
	 * @param id
	 * @return
	 */
	public User find(String id);
	
	/**
	 * 更新用户性息
	 * @param user
	 * @return
	 */
	public boolean update(User user);
	
	/**
	 * 根据用户名称查找
	 * @param name
	 * @return 如果为真：说明可以
	 */
	public boolean findByUserName(String name);
}
