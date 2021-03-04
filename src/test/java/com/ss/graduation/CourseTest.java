package com.ss.graduation;

import com.ss.graduation.mapper.CourseMapper;
import com.ss.graduation.model.Course;
import net.minidev.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.*;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ss
 * @Date: 2021/03/04/12:05
 * @Description:
 */
@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class CourseTest {

    @Autowired
    private CourseMapper courseMapper;




    @Test
    public  void tableHandler() throws Exception {
        String path = "D://course.txt";
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = null;
        String ls = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String str = sb.toString();

        Stack<String> trStack = new Stack<>();
        Stack<String> tdStack = new Stack<>();
        int j = 0;
        Course course = new Course();
        for(int i =0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='<'){
                String tmp = str.substring(i+1,i+3);
                if(tmp.equals("tr")){
                    trStack.push("<tr>");
                    i+=2;
                    j=0;
                    course = new Course();
                }else if(tmp.equals("td")){
                    tdStack.push("<td>");
                    i+=2;
                }
                tmp = str.substring(i+1,i+4);
                if(tmp.equals("/tr")){
                    trStack.pop();
                    i+=4;
                    System.out.println(course.toString());
                    courseMapper.insert(course);
                }else if(tmp.equals("/td")){
                    tdStack.pop();
                    i+=4;
                }
            }else if(c=='>'){
                if (!tdStack.empty()&&tdStack.peek().equals("<td>")){
                    StringBuilder stringBuilder = new StringBuilder();
                    for(int k = i+1;k<str.length();k++){
                        char x = str.charAt(k);
                        if(x=='<'){
                            break;
                        }
                        stringBuilder.append(x);
                    }
                    setCourse(course,j,stringBuilder.toString());
                    j++;
                }
            }
        }



    }


    public static void setCourse(Course course,int j,String ans){
        switch (j) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                course.setCourseNumber(ans);
                break;
            case 3:
                course.setName(ans);
                break;
            case 4:
                break;
            case 5:
                course.setCredit(Double.parseDouble(ans));
                break;
            case 6:
                course.setTotalClassHours(Integer.parseInt(ans));
                break;
            case 7:
                course.setAssessmentMethod(ans.equals("考查") ? 1 : 2);
                break;
            case 8:
                course.setCourseAttributes(ans.equals("必修") ? 0 : ans.equals("选修") ? 1 : 2);
                break;
            case 9:
                break;
        }
    }


}