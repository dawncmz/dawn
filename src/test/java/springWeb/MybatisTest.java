package springWeb;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cmz.entity.Student;
import com.cmz.mapper.StudentMapper;
import com.cmz.service.IStudentService;
import com.cmz.serviceImpl.StudentService;

public class MybatisTest {
	public static void testAop() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		IStudentService studentService = (StudentService)context.getBean("studentService");
		Student student = new Student();
		studentService.addStudent(student);
	}
	/*
	 * 基本方式增删改查  CRUD 增加(Create)、读取查询(Retrieve)、更新(Update)和删除(Delete)
	 */
	public static void testMybatis() throws Exception{
		Reader reader = Resources.getResourceAsReader("Mybatis.xml");  //加载配置文件  从硬盘读到内存 本质是反序列化
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);  //使用配置文件 加载sessionFactory(接口)
		SqlSession session = sessionFactory.openSession();  //相当于connection   获得session
		
		
		
		System.out.println("======查询单个======");
		String statement = "com.cmz.mapper.StudentMapper.queryStudentById";  //根据这句话去mapper中查对应的 namespace和id
		Student student = session.selectOne(statement,201601);   //确定sql语句的参数并进行查询           因为Mapper中标识了返回类型 所以不用强转
		System.out.println(student.toString());
		System.out.println("======查询所有======");
		String statement1 = "com.cmz.mapper.StudentMapper.queryAllStudent";
		List<Student> list = session.selectList(statement1);
		for(Student cur:list) {
			System.out.println(cur.toString());
		}
//		System.out.println("======增加学生======");
//		int sid = 101;
//		int sage = 101;
//		String sname="mybatis_insert";
//		String saddress="mybatis";
//		String statement2="com.cmz.mapper.StudentMapper.addStudent";
//		Student addStudent = new Student(sid,sage,sname,saddress);
//		int count = session.insert(statement2,addStudent);
//		session.commit();  //注意这个 commit 我们在配置中用jdbc管理事务 需要手动管理
		
//		System.out.println("======删除学生======");
//		int sid=101;
//		String statement2="com.cmz.mapper.StudentMapper.deleteStudentById";
//		session.delete(statement2,sid);
//		session.commit();
		
//		System.out.print("======修改学生======");
//		Student updateStudent = new Student(10,11,"my_update","my");
//		String statement3 = "com.cmz.mapper.StudentMapper.updateStudent";
//		int count = session.update(statement3,updateStudent);
//		session.commit();
		
//		System.out.println("======姓名查询======");
//		String name = "周";
//		String statement4 = "com.cmz.mapper.StudentMapper.queryStudentByName";
//		List<Student> nameList = session.selectList(statement4, name);
//		session.commit();
//		for(Student cur:nameList) {
//			System.out.println(cur.toString());
//		}
		
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);//开始使用
		
		System.out.println("======动态代理查询单个======");
		student = studentMapper.queryStudentById(201602);
		System.out.println(student.toString());
		
//		System.out.println("======属性列表查询======");  //已不可用 teacher 属性已经改变
//		Teacher teacher = new Teacher();
//		List<Integer> sList = new ArrayList<>();
//		sList.add(201601);
//		sList.add(201602);
//		teacher.setStudents(sList);
//		list = studentMapper.queryStudentInObject(teacher);
//		for(Student cur:list) {
//			System.out.println(cur.toString());
//		}
//		
//		System.out.println("======array查询======");
//		int [] array = {201601,201602};
//		list = studentMapper.queryStudentInArray(array);
//		for(Student cur:list) {
//			System.out.println(cur.toString());
//		}
//		
//		System.out.println("======list查询测试======");
//		List<Integer> para = new ArrayList<>();
//		para.add(201601);
//		para.add(201602);
//		list = studentMapper.queryStudentInCollection(para);
//		for(Student cur:list) {
//			System.out.println(cur.toString());
//		}
		
		System.out.println("======外键测试======");
		Student studentWithScore = studentMapper.queryStudentWithScoreFormById(201601);
		System.out.println(studentWithScore.toStringWithScore());
	}
}
