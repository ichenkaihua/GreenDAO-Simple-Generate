#GreeDAO-Simple-Generate
GreenDAOSimpleGenerate运用少量java注解简化Greendao的生成难度

####感谢
GreenDAO是一个轻量级快速开发的ORM解决方案，提供java对象与sqlite数据库之间的映射，请前往[greenDAO](https://github.com/greenrobot/greenDAO) 了解更多




#### 引入
目前项目已经发布到maven仓库中心

* maven环境  (eclipse ide--> 新建maven工程-->编辑pom.xml文件，添加如下依赖)
```xml
<dependency>
	    <groupId>com.github.ichenkaihua</groupId>
	    <artifactId>greendao-generate</artifactId>
	    <version>0.0.3</version>
	</dependency>
```
* gradle 环境 (android studio --> new Module --> java module-->编辑build.gradle, 如下配置)
```groovy
	dependencies {
	    compile fileTree(dir: 'libs', include: ['*.jar'])
	    compile 'com.github.ichenkaihua:greendao-generate:0.0.3'
	}
	repositories {
	     mavenCentral()
	}
```


#### 注解生成GreenDao

```java
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
	@GenerateConfig(outDir = "/home/chenkaihua/workspace/QueryScore/src/main/java", schemaConfig = @SchemaConfig(defaultJavaPackage = "com.dreamlienr.queryscore.entity", defaultJavaPackageDao = "com.dreamlienr.queryscore.dao"))
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


	// Main方法
	public static void main(String[] args) {
		// 传入带有类注解的Main.class类，GreenDao-Simple-Generate将会扫描类注解，配置输出路径，输出包名
		// 然后扫描这个类下的所有（public protected甚至private）方法
		// 如果方法参数有Schema、GenerateInfo、SchemaInfo、@EntityInject注解，则系统会注入相应对象
		// 最后调用这个方法
		new GenerateService(Main.class).generate();
	}

}
```

执行后,可以看到生成了下面这些JAVA文件
```groovy
// UserDao ，对User增删改查
com.dreamlienr.queryscore.dao.UserDao
// StudentDao,对Student增删改查
com.dreamlienr.queryscore.dao.StudentDao
// Student实体类，纯javaBean 
com.dreamlienr.queryscore.entity.Student
 // OrderDao ,对Order增删改查
com.dreamlienr.queryscore.dao.OrderDao
  
com.dreamlienr.queryscore.entity.Order
 
com.dreamlienr.queryscore.dao.PhotoDao
 
com.dreamlienr.queryscore.entity.Photo
 
com.dreamlienr.queryscore.dao.DogDao
 
com.dreamlienr.queryscore.entity.Dog
 
com.dreamlienr.queryscore.dao.CatDao
 
com.dreamlienr.queryscore.entity.Cat
 // 总接口，从这里获取DaoSettion
com.dreamlienr.queryscore.dao.DaoMaster
 // 提供获取DAO接口
com.dreamlienr.queryscore.dao.DaoSession
```
#### 发布日志
##### 0.0.4 release---(2016-1-5)

*  支持到 `de.greenrobot:greendao:2.1.0`版本
* 完善注释

[更多日志](changelog.md)

**详细介绍**:[我的博客](http://www.chenkaihua.com/2016/01/04/greendao-simple-generator-basic-usage) 

qq: 954822984 <br>
email: admin@chenkaihua.com <br>
blog:[陈开华的博客](http://www.chenkaihua.com) 




