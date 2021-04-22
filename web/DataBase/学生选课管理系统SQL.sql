drop DATABASE if exists sc;
create DATABASE sc;
use sc;

drop table if exists sct;
drop table if exists student;
drop table if exists course;
drop table if exists teacher;
drop table if exists department;
drop table if exists manager;


-- 学生信息表(id：100开始)
create table student(
	sno int auto_increment primary key ,
	sname nvarchar(8),
	ssex nchar(1) check(ssex='男' or ssex='女'),
	sage int check(sage>=14 and sage<=24),
	sdept nvarchar(30)
)ENGINE=InnoDB AUTO_INCREMENT 100 DEFAULT CHARSET=utf8;

-- 课程信息表(id：200开始)
create table course(
	cno int auto_increment  primary key,
	cname nvarchar(50),
	cpno char(6),
	ccredit smallint(2)
)ENGINE=InnoDB AUTO_INCREMENT 200 DEFAULT CHARSET=utf8;

-- 教师信息表(id：300开始)
create table teacher(
	tno int auto_increment primary key,	
  tname nvarchar(8),
  tsex nchar(1) check(tsex='男' or tsex='女'),
  tage int(4) check(tage<=70 and tage>24),
  teb nvarchar(10) check(teb='学士' or teb='硕士' or teb='博士'),    
  tpt nvarchar(10) check(tpt='助教' or tpt='讲师' or tpt='副教授'or tpt='教授'), 
  cno1 char(20) not null,				
  cno2 char(20),				
  cno3 char(20)				
)ENGINE=InnoDB AUTO_INCREMENT 300 DEFAULT CHARSET=utf8;

-- 学院信息表(id：400开始)
create table department(
	dno int auto_increment primary key,
	dname nvarchar(30),
	dmanagerno  char(8)
)ENGINE=InnoDB AUTO_INCREMENT 400 DEFAULT CHARSET=utf8;

-- 选课信息表(id：500开始)
create table sct(
	sct_no int auto_increment primary key,
	sno int not null, 
	cno int not null,
	tno int not null,
	grade int(4),
	FOREIGN KEY(sno) REFERENCES student(sno),
	FOREIGN KEY(cno) REFERENCES course(cno),
	FOREIGN KEY(tno) REFERENCES teacher(tno)
)ENGINE=InnoDB AUTO_INCREMENT 500 DEFAULT CHARSET=utf8;

-- 管理者登录表
create table Manager(
	id int auto_increment primary key,
	username char(20) not null,
	password char(20) not null,
	type char(5) not null
);


-- 插入各个表的数据
-- 学生表
insert into student values(null,'蔡徐坤','男',22,'篮球系');
insert into student values(null,'吴亦凡','男',20,'rap系');
insert into student values(null,'张艺兴','男',19,'舞蹈');
insert into student values(null,'鹿晗','男',23,'音乐系');
insert into student values(null,'范冰冰','女',18,'金融系');
insert into student values(null,'王冰冰','女',20,'新闻系');
insert into student values(null,'黎明','男',23,'计算机');
insert into student values(null,'刘德华','男',24,'英语系');
insert into student values(null,'周润发','男',18,'财经系');
insert into student values(null,'小明','男',22,'体育系');
insert into student values(null,'小红','女',21,'体育系');

-- 课程表
insert into course values(null,'计算机组成原理',1,1);
insert into course values(null,'STM32实验课程',2,2);
insert into course values(null,'Java语言设计',3,2);
insert into course values(null,'C++课程设计',4,3);
insert into course values(null,'数据库管理',5,2);
insert into course values(null,'高等数学',6,2);
insert into course values(null,'离散数学',7,4);
insert into course values(null,'数值分析',8,2);
insert into course values(null,'概率论',9,1);
insert into course values(null,'数据库系统设计',10,3);
insert into course values(null,'JavaWeb开发',11,2);
insert into course values(null,'Spring高级编程',12,3);

-- 教师信息表
insert into teacher values(null,'姚明','男',41,'博士','副教授','篮球','足球','抢篮板');
insert into teacher values(null,'郑智','男',39,'博士','教授','足球','短跑','');
insert into teacher values(null,'牛顿','男',51,'博士','教授','物理','化学','生物');
insert into teacher values(null,'鲁迅','男',61,'博士','教授','狂人日记','朝花夕拾','孔乙己');
insert into teacher values(null,'周树人','男',66,'硕士','讲师','国学文化','白话文','');
insert into teacher values(null,'图灵','男',56,'硕士','副教授','计算机','单片机设计','');
insert into teacher values(null,'乔布斯','男',62,'博士','副教授','IOS系统','','');
insert into teacher values(null,'莱布里茨','男',69,'博士','教授','数学','概率论','数学分析');

-- 学院信息表
insert into department values(null,'计算机学院','比尔盖茨');
insert into department values(null,'外国语学院','伏拉夫');
insert into department values(null,'音乐学院','韩红');
insert into department values(null,'数学学院','莱布里茨');
insert into department values(null,'文学院','周作人');
insert into department values(null,'物理学院','牛顿');
insert into department values(null,'太极学院','马保国');
insert into department values(null,'马克思学院','马克思');

-- 选课信息表
insert into sct values(null,100,200,300,99);
insert into sct values(null,101,202,302,60);
insert into sct values(null,102,204,303,98);
insert into sct values(null,103,206,301,65);

-- 用户信息
insert into manager values(null,'trump','123456','2');
insert into manager values(null,'admin','admin','2');




