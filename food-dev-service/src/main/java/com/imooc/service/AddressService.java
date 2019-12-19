package com.imooc.service;

import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.AddressBO;

import java.util.List;

public interface AddressService {


    /**
     * 根据用户id查询用户的收获地址
     * @param userId
     * @return
     */
    List<UserAddress> queryAll(String userId);

    /**
     * 用户新增地址
     * @param addressBO
     */
    void addNewUserAddress(AddressBO addressBO);

    void updateUserAddress(AddressBO addressBO);

    /**
     * 根据用户id和地址id删除用户地址信息
     * @param userId
     * @param addressId
     */
    void deleteUserAddress(String userId,String addressId);

    /**
     * 修改为默认地址
     * @param userId
     * @param addressId
     */
    void updateUserAddressToBeDefault(String userId,String addressId);

    /**
     * 根据用户id和地址id查询查询具体的用户地址对象
     * @param userId
     * @param addressId
     * @return
     */
    UserAddress queryUserAddress(String userId,String addressId);
}
