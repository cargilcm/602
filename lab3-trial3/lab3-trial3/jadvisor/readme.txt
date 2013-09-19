JAdvisor - a Java class scheduler and course planner for students.
jadvisor.sourceforge.net

LICENSE

Copyright (C) 2001-2002 Curtis Rawls

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

USAGE

To run:

	Windows:
	Click on jadvisor.jar file (in /bin)
		or
	Run jadvisor.bat
	
	Linux:
	Run jadvisor.sh
	
	Command Line:
	cd bin
	java jadvisor/advisorui/Advisor [filename]

	From the JAR file:
	java -jar jadvisor.jar [filename]

To compile:
	cd src
	javac -d ../bin jadvisor/advisorui/Advisor.java

To make a JAR file:
	cd bin
	jar cmvf mainClass jadvisor.jar jadvisor icons

SCHOOL ADAPTERS

JAdvisor uses SchoolAdapters to customize itself for a student's
school.  Currently NC State University is the only implemented
SchoolAdapter for a specific college.  To customize JAdvisor for
your own school, just implement the provided SchoolAdapter interface.
For help writing your own SchoolAdapter, check out the NCSU adapter 
for example code and post to the JAdvisor forums with your questions.
Once your SchoolAdapter is done, let us know so other students at your
school can take advantage of JAdvisor!