package com.cmz.mapper;
import com.cmz.entity.*;
import java.util.*;
public interface StudentMapper {
//	 <select id="queryStudentById" resultType="student" parameterType="int">
//	 	select * from Student where sid = #{id}
//	 </select>
	 public Student queryStudentById(int para);

//	 <select id="queryAllStudent" resultType="student" >
//	 	select * from Student 
//	 </select>
	 public List<Student> queryAllStudent();
	 
//	 <select id="addStudent" parameterType="student" >
//	 	insert into student(sid,sage,sname,saddress,isHavePicture) values (#{sid},#{sage},#{sname},#{saddress},#{isHavePicture})
//	 </select>
	 public void addStudent(Student para);
	 
//	 <select id="deleteStudentById" parameterType="int">
//	 	delete from student where sid = #{id}
//	 </select>	 
	 public void deleteStudentById(int para);
	 
//	 <select id="updateStudent" parameterType="student">
//	 	update student set sid=#{sid},sage=#{sage},sname=#{sname},saddress=#{saddress} where sid=#{sid}
//	 </select>
	 public void updateStudent(Student para);
	 
//	 <!-- 姓名模糊查询 -->
//	 <select id="queryStudentByName" resultType="student" parameterType="string">
//	 	select * from Student where sname like '%${value}%'
//	 </select>
	 public List<Student>queryStudentByName(String para);
	 
//	 <select id="queryStudentInObject" parameterType="com.cmz.entity.Teacher"  resultType="student">
//	  	select * from student 
//		<where> 
//		<if test="students!=null and students.size>0">
//			<!-- 注意 open第一个字符是空格 不然会连到一起 -->
//			<foreach collection="students" open=" and sid in("  close=")"  item="curId" separator=",">
//				#{curId}
//			</foreach>
//		</if> 
//	  	</where>
//	  </select>
	 public List<Student> queryStudentInObject (Teacher teacher);

//	<select id="queryStudentInArray" parameterType="int[]"  resultType="student">
//		select * from student 
//		<where> 
//		<!-- 这个参数不是传过来的数组名(根本没传过来) 反射得不到参数名 -->
//		<if test="array!=null and array.length>0">
//			<!-- 注意 open第一个字符是空格 不然会连到一起 -->
//			<foreach collection="array" open=" and sid in("  close=")"  item="curId" separator=",">
//				#{curId}
//			</foreach>
//		</if> 
//		</where>
//	</select>
	 public List<Student> queryStudentInArray(int[] para);

//	<select id="queryStudentInCollection" parameterType="list"  resultType="student">
//		select * from student 
//		<where> 
//			<!-- 这个参数不是传过来的数组名(根本没传过来) 反射得不到参数名 -->
//			<if test="list!=null and list.size>0">
//				<!-- 注意 open第一个字符是空格 不然会连到一起 -->
//				<foreach collection="list" open=" and sid in("  close=")"  item="curId" separator=",">
//					#{curId}
//				</foreach>
//			</if> 
//		</where>
//	</select>
	 public List<Student> queryStudentInCollection(List<Integer> list);
	 
	 public Student queryStudentWithScoreFormById(int para);
	 
	 public List<Student> queryStudentByPage(HashMap<String,Integer> map);
}
