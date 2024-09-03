package com.myproject.transactions.mapper;

import com.myproject.transactions.dto.CreateUserDTO;
import com.myproject.transactions.dto.ResponseUserDTO;
import com.myproject.transactions.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    ResponseUserDTO fromEntityToResponseDTO(UserEntity userEntity);

}
