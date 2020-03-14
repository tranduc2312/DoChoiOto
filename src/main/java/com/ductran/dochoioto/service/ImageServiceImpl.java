package com.ductran.dochoioto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ductran.dochoioto.entity.Images;
import com.ductran.dochoioto.entity.Products;
import com.ductran.dochoioto.model.ImageModel;
import com.ductran.dochoioto.repository.ImageRepository;

@Service
public class ImageServiceImpl extends GenericService implements ImageService{
	@Autowired
	ImageRepository dao;
	@Override
	public List<ImageModel> findAll() {
		List<Images> listImages = dao.findAll();
		List<ImageModel> listModel = new ArrayList<ImageModel>();
		for (Images image : listImages) {
			ImageModel model = new ImageModel(image);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public List<ImageModel> findById(String id, int limit) {
		List<Images> listImages = dao.findById(id, limit);
		List<ImageModel> listModel = new ArrayList<ImageModel>();
			for (Images image : listImages) {
				ImageModel model = new ImageModel(image);
				listModel.add(model);
			}
		
		return listModel;
	}

	@Override
	public ImageModel findOneById(String id) {
		ImageModel model = new ImageModel(dao.findOneById(id));
		return model;
	}

	@Override
	public boolean add(ImageModel obj) {
		Images image = new Images(obj);
		image.setProduct(new Products(obj.getProduct().getProductId()));
		image.setImageStatus(true);
		return dao.add(image);
	}

	@Override
	public boolean edit(ImageModel obj) {
		Images image = new Images(obj);
		return dao.edit(image);
	}

	@Override
	public boolean delete(String id) {
		return dao.delete(id);
	}

	@Override
	public String autoID() {
		return setID(dao.autoId());
	}

}
