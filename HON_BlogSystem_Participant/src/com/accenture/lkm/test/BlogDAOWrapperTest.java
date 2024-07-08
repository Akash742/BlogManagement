package com.accenture.lkm.test;


import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.bean.BlogBean;
import com.accenture.lkm.dao.BlogDAOWrapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/root-config.xml"})
@Transactional
public class BlogDAOWrapperTest {
	
  @Autowired
  private BlogDAOWrapper blogDAOWrapper;
		
  
  /**
     To-Do Item 1.14 : This method tests the addBlog functionality in BlogDAOWrapper by adding a dummy blog entry to the database.
   
     TODO: Implement the testAddBlog method:
      - It should create a new instance of BlogBean and set its properties (title, content, email, themes) with dummy data.
      - It should invoke the addblog method of blogDAOWrapper, passing the BlogBean object.
      - It should verify that a new blog entry has been successfully inserted into the database table.
 */
   
  @Test
  public void testAddBlog() throws Exception {
	     BlogBean bean = null;
	     
	     bean.setBlogId(1);
	     bean.setEmail("demo@gmail.com");
	     bean.setThemes("Demo Theme");
	     bean.setTitle("Demo Title");
	     bean.setContent("Demo Content");
	     
	     Assertions.assertEquals(1, blogDAOWrapper.addblog(bean));
    }
  /**
     To-Do Item 1.15 : This method tests the findPostsByEmail function of BlogDAOWrapper to retrieve a list of blog posts for the entered email address..
   
     TODO: Implement the findPostsByEmail method:
      - It should specify the email address for which to retrieve blog posts.
      - It should invoke the findPostsByEmail method of blogDAOWrapper, passing the email address.
      - It should verify that the result (list of BlogBean objects) is not null, indicating successful retrieval of blog posts.
 */
	@Test
	public void testFindPostsByEmail() throws Exception {
		String email = "demo@gmail.com";
		List<BlogBean> postList = blogDAOWrapper.findPostsByEmail(email);
		
		Assertions.assertNotNull(postList, "Post List is Not Null");
	}

  /**
     To-Do Item 1.16 : This method tests the findPostsByEmail functionality in BlogDAOWrapper, verifying the count of blog posts associated with the provided email.
	
	 TODO: Implement the countPostsByEmail method:
	   - It should Specify the email address for which to count the number of blog posts.
       - It should call the countPostsByEmail method of blogDAOWrapper, passing the email address.
       - It should verify that the result (count of blog posts) is greater than or equal to 0, ensuring a non-negative count.
  */
  @Test
  public void testCountPostsByEmail() {
	  	String email = "demo@gmail.com";
		long countPost = blogDAOWrapper.countPostsByEmail(email);
		
		Assertions.assertEquals(5, countPost);
  } 
}
	



	


