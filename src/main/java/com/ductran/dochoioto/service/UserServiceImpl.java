package com.ductran.dochoioto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ductran.dochoioto.entity.Users;
import com.ductran.dochoioto.model.UserModel;
import com.ductran.dochoioto.repository.UserRepository;

@Service
public class UserServiceImpl extends GenericService implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserModel> findAll() {
		List<Users> list = userRepository.findAll();
		List<UserModel> listModel = new ArrayList<UserModel>();
		for (Users users : list) {
			UserModel userModel = new UserModel(users);
			listModel.add(userModel);
		}
		return listModel;
	}

	@Override
	public List<UserModel> findById(String id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findOneById(String id) {
		Users users = userRepository.findOneById(id);
		UserModel userModel = new UserModel(users);
		return userModel;
	}
	@Override
	public boolean add(UserModel obj) {
		Users users= new Users(obj);
		users.setUserStatus(true);
		return userRepository.add(users);
	}

	@Override
	public boolean edit(UserModel obj) {
		Users users= new Users(obj);
		return userRepository.edit(users);
	}

	@Override
	public boolean delete(String id) {
		return userRepository.delete(id);
	}

	@Override
	public String autoID() {
		return setID(userRepository.autoId());
	}

}
