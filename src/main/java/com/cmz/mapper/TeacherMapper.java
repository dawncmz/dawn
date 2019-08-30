package com.cmz.mapper;
import com.cmz.entity.*;
import java.util.*;

public interface TeacherMapper {
/*	 <select id="queryTeacherById" resultType="Teacher" parameterType="int">
	 	select * from Teacher where tid = #{id}
	 </select>*/
	 public Teacher queryTeacherById(int para);
	 
/*	 <select id="queryAllTeacher" resultType="Teacher" >
	 	select * from Teacher 
	 </select>*/
	 public List<Teacher> queryAllTeacher();
	 
/*	 <select id="addTeacher" parameterType="Teacher" >
	 	insert into Teacher(tid,tage,tname,object) values (#{tid},#{tage},#{tname},#{object})
	 </select>*/
	 public  Teacher addTeacher(Teacher para);
	 	
//	 <select id="deleteTeacherById" parameterType="int">
//	 	delete from Teacher where tid = #{id}
//	 </select>	 
	 public void deleteTeacherById(int para);
//	 <select id="updateTeacher" parameterType="Teacher">
//	 	update Teacher set tid=#{tid},tage=#{tage},tname=#{tname},object=#{object} where tid=#{tid}
//	 </select>
	 public void updateTeacher(Teacher teacher);
//	 <!-- 姓名模糊查询 -->
//	 <select id="queryTeacherByName" resultType="Teacher" parameterType="string">
//	 	select * from Teacher where tname like '%${value}%'
//	 </select>
	 public List<Teacher> queryTeacherByName(String para);
//	 <select id="queryTeacherInObject" parameterType="com.cmz.entity.Teacher"  resultType="Teacher">
//	  	select * from Teacher 
//		<where> 
//		<if test="Teachers!=null and Teachers.size>0">
//			<!-- 注意 open第一个字符是空格 不然会连到一起 -->
//			<foreach collection="Teachers" open=" and tid in("  close=")"  item="curId" separator=",">
//				#{curId}
//			</foreach>
//		</if> 
//	  	</where>
//	  </select>
	 
//	  <select id="queryTeacherWithComments" resultMap="TeacherWithComments" parameterType="int">
//	  	select s.*,c.* from Teacher s inner join scoreform c on s.sfid=c.tid where s.tid=#{tid}
//	  </select>
	 
//	  <select id="queryTeacherWithStudents" resultMap="TeacherWithStudents" parameterType="int">
//	  	select s.*,t.* from teacher t inner join student s on t.tid=s.ph_teacher_id or t.tid=s.sc_teacher_id where t.tid=#{tid}
//	  </select>
	  public Teacher queryTeacherWithStudents(int para);
}
