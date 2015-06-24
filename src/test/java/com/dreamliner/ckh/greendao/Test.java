/**   

 * Copyright © 2015 Dreamliner Studio. All rights reserved.
 
 * 

 * @Title: Test.java
 
 * @Prject: GreenDao2.0
 
 * @Package: com.dreamliner.ckh.greendao
 
 * @author: chenkaihua  
 
 * @date: 2015年6月24日 下午6:03:39
 
 * @version: V1.0  
 
 */

package com.dreamliner.ckh.greendao;

import com.dreamliner.greendao.annotation.EntityInject;
import com.dreamliner.greendao.annotation.GenerateConfig;
import com.dreamliner.greendao.annotation.SchemaConfig;
import com.dreamliner.greendao.pojo.GenerateInfo;
import com.dreamliner.greendao.pojo.SchemaInfo;
import com.dreamliner.greendao.service.GenerateService;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * 
 * @ClassName Test
 * @author chenkaihua
 * @date 2015年6月24日下午6:03:39
 * @email admin@chenkaihua.com
 */
@GenerateConfig(outDir = "../QueryScore/src/main/java", schemaConfig = @SchemaConfig(defaultJavaPackage = "com.dreamlienr.queryscore.dao"))
public class Test {

	public void generateUser(@EntityInject("User") Entity user,
			GenerateInfo generateInfo, Schema schema, SchemaInfo schemaInfo) {
		user.addIdProperty();
		user.addStringProperty("name");
		Entity dog = schema.addEntity("Dog");
		dog.addIdProperty();
		dog.addStringProperty("name");
		
		
		
		
	}
	
	private void generateFriend(@EntityInject("Friend") Entity friend){
		friend.addIdProperty();
		friend.addStringProperty("name");
		
	}
	

	public void testgenerate() {
		GenerateService generateService = new GenerateService(Test.class);
		generateService.generate();

	}

}
