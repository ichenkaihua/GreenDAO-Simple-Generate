package com.dreamliner.ckh.greendao;

import com.github.ichenkaihua.greendao.annotation.EntityInject;
import com.github.ichenkaihua.greendao.annotation.GenerateConfig;
import com.github.ichenkaihua.greendao.annotation.SchemaConfig;
import com.github.ichenkaihua.greendao.pojo.GenerateInfo;
import com.github.ichenkaihua.greendao.pojo.SchemaInfo;
import com.github.ichenkaihua.greendao.service.GenerateService;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

//GenerateConfig.outDir: 输出文件夹路径，必须存在这个路径，为避免出错，建议路径分隔符用 /
//这个路径可以是绝对路径，/home/chenkaihua/workspace/QueryScore/src/main/java
//也可以是相对路径，比如在同一个workspace的android项目名为 MyAndroidProject,则可以写成 ../MyAndroidProject/src
//特别注意的是，如果是android studio项目，应该这样写 app/src/main/java
// GenerateConfig.SchemaConfig.defaultJavaPackage 生成的entity的所在包，如果没有包名或包名不完全，则greendao会自动创建
//GenerateConfig.SchemaConfig.defaultJavaPackageDao 生成的dao类所在包，如果没有包名或包名不完全，则greendao会自动创建
@GenerateConfig(outDir = "/home/chenkaihua/workspace/QueryScore/src/main/java",
		schemaConfig = @SchemaConfig(defaultJavaPackage = "com.dreamlienr.queryscore.entity",
				defaultJavaPackageDao = "com.dreamlienr.queryscore.dao"))
public class Main {

	// 通过EntityInject注解，可以定义Entity的名字
	public void createUserEntity(@EntityInject("User") Entity user) {
		user.addIdProperty();
		user.addStringProperty("name");
		user.setSkipGeneration(true);

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

	// Main方法
	public static void main(String[] args) {
		// 传入带有类注解的Main.class类，GreenDao-Simple-Generate将会扫描类注解，配置输出路径，输出包名
		// 然后扫描这个类下的所有（public protected甚至private）方法
		// 如果方法参数有Schema、GenerateInfo、SchemaInfo、@EntityInject注解，则系统会注入相应对象
		// 最后调用这个方法
		new GenerateService(Main.class).generate();
	}

}
