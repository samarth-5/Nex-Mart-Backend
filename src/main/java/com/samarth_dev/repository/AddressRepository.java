package com.samarth_dev.repository;

import com.samarth_dev.modal.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
