package jadvisor.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import jadvisor.scheduler.Course;
import jadvisor.scheduler.StudentClass;
import jadvisor.scheduler.TimeOfDay;

public class AltClass1 {
	
	String dept="";
	String course="";
	String courseTitle="";
	String credit="";
	static CofC cofc=null;
	public AltClass1(String coursePre, String courseNameNum,String courseTitle,String credit){
		dept=coursePre;
		course=courseNameNum;
		courseTitle=courseTitle;
		credit=credit;
		StudentClass c=getStudentClass();
		System.out.println("alt1:"+c.getDescription());
	}
	
	public StudentClass getStudentClass(){
		String[] tokens = new String[17];
		tokens[0] = dept;	//0 - COURSE PRE
		tokens[1] = course	;	//1 - COURSE NUMBER
		tokens[2] = courseTitle;		//2 - COURSE NAME
		tokens[3] = "002";	//3 - SECTION
		tokens[4] = "216320";	//4 - CALL NUMBER
		tokens[5] = "OPEN";	//5 - OPEN/RESTRICTED
		tokens[6] = credit;		//6 - CREDIT
		tokens[7] = "20";		//7 - CLASS SIZE
		tokens[8] = "10";		//8 - OPEN SEATS AVAILABLE
		tokens[9] = "M"	;	//9 - DAYS
		String altTime1 = "1100-1200"	;	//10 - TIME
		tokens[10] = altTime1	;	//10 - TIME
		tokens[11] = "rudolph";	//11 - TEACHER
		tokens[12] = "harrelson";	//12 - BUILDING
		tokens[13] = "02132";	//13 - ROOM NUMBER
		tokens[14] = "0"	;//14 - RESTR SEATS AVAILABLE
		tokens[15] = "N/A";	//15 - WAIT LIST AVAILABLE
		tokens[16] = "" ; //16- RESTRICTIONS

		boolean [] days = new boolean[cofc.getDaysAbbreviations().length];
		Arrays.fill(days, false);
		for (int i = 0; i < days.length; i++)
			if (tokens[9].indexOf(cofc.getDaysAbbreviations()[i]) != -1)
				days[i] = true;
		
		TimeOfDay[] times = parseTime(tokens[10]);
	    int credit;
		if (tokens[6].equals("var"))
			credit = 0;
		else
			credit = (int)Double.parseDouble(tokens[6]+".0");
System.out.println("made it here");
		StudentClass result = new StudentClass(tokens[3],
			new Course(tokens[0], tokens[1]), tokens[2],	
			days, times[0], times[1], 0, credit);
		List classInfo = new ArrayList();
		classInfo.add(tokens[11]);		//11 - TEACHER
		classInfo.add("Harrelson");		//12 - BUILDING
		result.setInfo(classInfo);
		System.out.println("alt1:"+result);
		return result;
		
	}
	private TimeOfDay[] parseTime (String s) {
		if (s.equals(""))
			return new TimeOfDay[] {new TimeOfDay(12,00), new TimeOfDay(12,00)};
		TimeOfDay[] result = new TimeOfDay[2];
		String[] s1 = new String[2];
		StringTokenizer t = new StringTokenizer(s, "-");
		for (int i = 0; t.hasMoreTokens(); i++)
			s1[i] = t.nextToken();
		
		int starth = Integer.parseInt(s1[0].substring(0,2));
		int startm = Integer.parseInt(s1[0].substring(2,4));
		int endh = Integer.parseInt(s1[1].substring(0,2));
		int endm = Integer.parseInt(s1[1].substring(2,4));
		
		if (s1[1].length() == 6 && starth < 12)
			starth += 12;
		if (s1[1].length() == 6)
			endh += 12;

		result[0] = new TimeOfDay(starth, startm);
		result[1] = new TimeOfDay(endh, endm);
		return result;
	}
}
