/**   

 * Copyright © 2015 Dreamliner Studio. All rights reserved.
 
 * 

 * @Title: Main.java
 
 * @Prject: GreenDao2.0
 
 * @Package: com.dreamliner.ckh.greendao
 
 * @author: chenkaihua  
 
 * @date: 2015年6月25日 下午4:40:21
 
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

@GenerateConfig(outDir = "/home/chenkaihua/workspace/QueryScore/src/main/java", 
schemaConfig = @SchemaConfig(defaultJavaPackage = "com.dreamlienr.queryscore.dao"))
public class Main {
	// 通过EntityInject注解，可以定义Entity的名字
	public void createUserEntity(@EntityInject("User") Entity user) {
		user.addIdProperty();
		user.addStringProperty("name");

	}

	// 还可以定义Entity其他属性
	void createStudentEntity(
			@EntityInject(value = "Student", implementsSerializable = true, tableName = "MY_STUDENT") Entity student) {
		student.addIdProperty();
		student.addStringProperty("name");

	}

	// 可以注入多个Entity
	private void createMulitEntity(@EntityInject("Order") Entity order,
			@EntityInject("Photo") Entity photo) {
		order.addIdProperty();
		order.addStringProperty("name");
		photo.addIdProperty();
		photo.addStringProperty("path");
	}

	// 当然，你也可以注入de.greenrobot.daogenerator.Schema。
	// 也可以注入 GenerateInfo，GenerateInfo对象就是@GenerateConfig的注解信息
	// 还可以注入SchemaInfo ,SchemaInfo就是@SchemaConfig的信息
	void createMuiltEntityBySchema(Schema schema, GenerateInfo generateInfo,
			SchemaInfo schemaInfo) {

		System.out.println("Generate Info :" + generateInfo);
		System.out.println("Schema Info :" + schemaInfo);
		Entity dog = schema.addEntity("Dog");
		dog.addIdProperty();
		dog.addStringProperty("name");

		Entity cat = schema.addEntity("Cat");
		cat.addIdProperty();
		cat.addStringProperty("name");
		
	}

	public static void main(String[] args) {
		new GenerateService(Main.class).generate();
	}

}
