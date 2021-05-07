package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entities.Address;
import com.cg.exceptions.AddressNotFoundException;
import com.cg.repo.AddressRepository;

@Service
@Transactional


public class AddressServiceImpl implements AddressService {
	
	@Autowired(required = true)
	AddressRepository addRepo;

	Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);


	@Override
	public Address addAddress(Address add) {
		logger.info("Address addAddress()");

		if(add == null)
			throw new AddressNotFoundException("Address Not Found");

		else{
			addRepo.save(add);

			return add;
		}
	}

	@Override
	public Address updateAddress(Address add) {
		logger.info("Address updateAddress()");
		if(add == null)
			throw new AddressNotFoundException("Address Not Found");
		else {
			addRepo.save(add);
			return add;
		}
	}

	@Override
	public Address removeAddress(int addId) {
		logger.info("Address removeAddress()");
		Optional<Address> add = addRepo.findById(addId);
		if(!add.isPresent())
			throw new AddressNotFoundException("Address Not Found");
		else {
			addRepo.deleteById(addId);
			return add.get();
		}
	}


	@Override
	public List<Address> viewAllAddress() {
		logger.info("Address viewAllAddress()");

		List<Address> list = addRepo.findAll();
		if(list.isEmpty())
			throw new AddressNotFoundException("Address Not Found");
		else
			return list;
	}


	@Override
	public Address viewAddress(int addId) {
		logger.info("Address viewAddress()");
		Optional<Address> viewAdd = addRepo.findById(addId);
		if(!viewAdd.isPresent())
			throw new AddressNotFoundException("Address Not Found");
		else {
			return viewAdd.get();
		}
	}

}
