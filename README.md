#GreeDAO-Simple-Generate
GreenDAOSimpleGenerate运用少量java注解简化Greendao的生成难度

####感谢
GreenDAO是一个轻量级快速开发的ORM解决方案，提供java对象与sqlite数据库之间的映射，请前往[greenDAO](https://github.com/greenrobot/greenDAO) 了解更多




####引入
目前项目已经发布到maven仓库中心

>maven环境  (eclipse ide--> 新建maven工程-->编辑pom.xml文件，添加如下依赖)

	<dependency>
	    <groupId>com.github.ichenkaihua</groupId>
	    <artifactId>greendao-generate</artifactId>
	    <version>0.0.3</version>
	</dependency>

>gradle 环境 (android studio --> new Module --> java module-->编辑build.gradle, 如下配置)

	dependencies {
	    compile fileTree(dir: 'libs', include: ['*.jar'])
	    compile 'com.github.ichenkaihua:greendao-generate:0.0.3'
	
	}
	
	repositories {
	     mavenCentral()
	}


####注解生成GreenDao
  
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
	
		//可以注入多个Entity
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



执行后,可以看到如下输出

![image](https://raw.githubusercontent.com/ichenkaihua/GreenDAO-Simple-Generate/master/screenshot/greendao-generat-export.png "image")


####发布日志
>0.0.1-SNAPSHOT -(2015-08-07)
>>1.支持到 de.greenrobot:greendao:1.3.7版本<br>
>>2.精简无用注解<br>


>0.0.2 release (2015-08-09)
>>1.上传至maven仓库中心<br>
>>2.修改包名为com.github<br>

>0.03 release (2015-08-10)
>>1.更新支持greendao-generator2.0<br>
>>2.增加注解属性@schemaConfig.outDirEntity<br>
>>3.修复defaultJavaPackgeDao注解属性无效问题<br>
>>4.修复defaultJavaPackgeTest主机属性无效问题<br>


**详细介绍**:[我的博客](http://www.chenkaihua.com/greendaosimplegenerate%E5%8F%91%E5%B8%83%E5%88%B0github%E5%95%A6.html) 

qq: 954822984 <br>
email: admin@chenkaihua.com <br>
blog:[陈开华的博客](http://www.chenkaihua.com) 




