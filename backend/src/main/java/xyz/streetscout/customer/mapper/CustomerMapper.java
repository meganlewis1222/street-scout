package xyz.streetscout.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.entity.Customer;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerProfile toProfile(Customer customer);
}
