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
	 * ������ʽ��ɾ�Ĳ�  CRUD ����(Create)����ȡ��ѯ(Retrieve)������(Update)��ɾ��(Delete)
	 */
	public static void testMybatis() throws Exception{
		Reader reader = Resources.getResourceAsReader("Mybatis.xml");  //���������ļ�  ��Ӳ�̶����ڴ� �����Ƿ����л�
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);  //ʹ�������ļ� ����sessionFactory(�ӿ�)
		SqlSession session = sessionFactory.openSession();  //�൱��connection   ���session
		
		
		
		System.out.println("======��ѯ����======");
		String statement = "com.cmz.mapper.StudentMapper.queryStudentById";  //������仰ȥmapper�в��Ӧ�� namespace��id
		Student student = session.selectOne(statement,201601);   //ȷ��sql���Ĳ��������в�ѯ           ��ΪMapper�б�ʶ�˷������� ���Բ���ǿת
		System.out.println(student.toString());
		System.out.println("======��ѯ����======");
		String statement1 = "com.cmz.mapper.StudentMapper.queryAllStudent";
		List<Student> list = session.selectList(statement1);
		for(Student cur:list) {
			System.out.println(cur.toString());
		}
//		System.out.println("======����ѧ��======");
//		int sid = 101;
//		int sage = 101;
//		String sname="mybatis_insert";
//		String saddress="mybatis";
//		String statement2="com.cmz.mapper.StudentMapper.addStudent";
//		Student addStudent = new Student(sid,sage,sname,saddress);
//		int count = session.insert(statement2,addStudent);
//		session.commit();  //ע����� commit ��������������jdbc�������� ��Ҫ�ֶ�����
		
//		System.out.println("======ɾ��ѧ��======");
//		int sid=101;
//		String statement2="com.cmz.mapper.StudentMapper.deleteStudentById";
//		session.delete(statement2,sid);
//		session.commit();
		
//		System.out.print("======�޸�ѧ��======");
//		Student updateStudent = new Student(10,11,"my_update","my");
//		String statement3 = "com.cmz.mapper.StudentMapper.updateStudent";
//		int count = session.update(statement3,updateStudent);
//		session.commit();
		
//		System.out.println("======������ѯ======");
//		String name = "��";
//		String statement4 = "com.cmz.mapper.StudentMapper.queryStudentByName";
//		List<Student> nameList = session.selectList(statement4, name);
//		session.commit();
//		for(Student cur:nameList) {
//			System.out.println(cur.toString());
//		}
		
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);//��ʼʹ��
		
		System.out.println("======��̬�����ѯ����======");
		student = studentMapper.queryStudentById(201602);
		System.out.println(student.toString());
		
//		System.out.println("======�����б��ѯ======");  //�Ѳ����� teacher �����Ѿ��ı�
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
//		System.out.println("======array��ѯ======");
//		int [] array = {201601,201602};
//		list = studentMapper.queryStudentInArray(array);
//		for(Student cur:list) {
//			System.out.println(cur.toString());
//		}
//		
//		System.out.println("======list��ѯ����======");
//		List<Integer> para = new ArrayList<>();
//		para.add(201601);
//		para.add(201602);
//		list = studentMapper.queryStudentInCollection(para);
//		for(Student cur:list) {
//			System.out.println(cur.toString());
//		}
		
		System.out.println("======�������======");
		Student studentWithScore = studentMapper.queryStudentWithScoreFormById(201601);
		System.out.println(studentWithScore.toStringWithScore());
	}
}
