#GreeDAO-Simple-Generate
GreenDAOSimpleGenerate运用java注解和反射简化似Greendao更简单生成

####配置
>目前项目jar包还没有上传至仓库中心，因此提供jar包，[jar包下载](https://github.com/ichenkaihua/GreenDAO-Simple-Generate/tree/master/extra-jar/greendao-generate-0.0.2-SNAPSHOT.jar)  <br>
>本项目依赖greendao-generate项目


####如何生成

  
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

![image](GreenDAO-Simple-Generate/raw/master/screenshot/greendao-generat-export.png  "image")


