package com.accenture.lkm.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.bean.BlogBean;
import com.accenture.lkm.entity.BlogEntity;

@Repository
@Transactional("txManager")
public class BlogDAOWrapper {
	
@Autowired	
private BlogDAO  blogDAO;
	
	/** 
	  To-Do Item 1.3: This method should add a new blog entry to the database.
	
	  TODO: Implement the addblog method:
	   -It should convert the BlogBean object to a BlogEntity.
	   -It should save the BlogEntity to the database.
	   -It should return the blogId(unique identifier) of the newly added blog entry.
	*/
	public int addblog(BlogBean blog) throws Exception {
		int n = 0;
		
		try {
			BlogEntity entity = convertBeanToEntity(blog);
			blogDAO.save(entity);
			n = entity.getBlogId();
		}
		catch(Exception e)
		{
			throw e;
		}
		return n;
	}

	/**
	   To-Do Item 1.4: This method should retrieve a list of blog posts for the entered email address.Posts should be retrieved in alphabetical order of Title.
	   
	   TODO: Implement the findPostsByEmail method:
	     - It should use the blogDAO reference to call its findPostsByEmail method, retrieving blog posts based on the provided email address.
	     - It should convert each retrieved BlogEntity object to a BlogBean object.
	     - It should add the converted BlogBean objects to a list.
	     - It should return a list of BlogBean objects representing the blog posts.
     */

	public List<BlogBean> findPostsByEmail(String email) throws Exception {
		
		List<BlogBean> beanList = new ArrayList<>();
		
		try {
			List<BlogEntity> entityList = (List<BlogEntity>) blogDAO.findAll();
			
			for(BlogEntity entity : entityList)
			{
				if(entity.getEmail().equals(email))
				{
					BlogBean bean1 = convertEntityToBean(entity);
					beanList.add(bean1);
				}
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return beanList;
	}

   /** 
      To-Do Item 1.5: This method retrieve the count of blog posts associated with the provided email address.

      TODO: Implement the countPostsByEmail method:
        - It should use the blogDAO reference to call its countPostsByEmail method to retrieve the count of blog posts for the provided email.
        - It should return the count of blog posts as a long value.
   
  */
	public long countPostsByEmail(String email) {
		Long count = blogDAO.countPostsByEmail(email);
		
		return count;
	}
   
  
   /**
      To-Do Item 1.6: This method should return map of below mentioned themes.
     
      TODO:	
       -Populate  the map with below key-value entries:
		1.Key: Daily Journal  Value: Daily Journal
		2.Key: Cheer Up       Value: Cheer Up
		3.Key: Goal           Value: Goal

    */
	public Map<String, String> populateTheme() {
		Map<String, String> map = new HashMap<>();
		map.put("Daily Journal", "Daily Journal");
		map.put("Cheer Up", "Cheer Up");
		map.put("Goal", "Goal");
		
		return map;
	}

   public static BlogEntity convertBeanToEntity(BlogBean bean){
		BlogEntity blogEntityBean = new BlogEntity();
		BeanUtils.copyProperties(bean,blogEntityBean);
		return blogEntityBean;
	}
	
   public static BlogBean convertEntityToBean(BlogEntity entity){
		BlogBean blogBean = new BlogBean();
		BeanUtils.copyProperties(entity, blogBean);
		return blogBean;
	}

}
