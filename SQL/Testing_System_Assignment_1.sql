DROP DATABASE IF EXISTS Managements;
CREATE DATABASE IF NOT EXISTS Managements;
USE managements;

CREATE TABLE Department (
DepartmentID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
DepartmentName VARCHAR(50) NOT NULL
);
CREATE TABLE Position_table 
(
PositionID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
PositionName ENUM('DEV','Test','Scrum Master','PM')
);
CREATE TABLE Account_table
(
AccountID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Email VARCHAR(100) NOT NULL,
Username VARCHAR(100) NOT NULL,
FullName VARCHAR(100) NOT NULL,
DepartmentID INT UNSIGNED,
PositionID INT UNSIGNED,
FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
FOREIGN KEY(PositionID) REFERENCES Position_table (PositionID),
CreateDate DATE NOT NULL
);
CREATE TABLE Group_table
(
GroupID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
GroupName varchar(100) NOT NULL,
CreatorID varchar(100) NOT NULL,
CreateDate DATE NOT NULL
); 
CREATE TABLE  Group_Account
(
GroupID INT UNSIGNED NOT NULL,
AccountID INT UNSIGNED NOT NULL,
JoinDate DATE,
PRIMARY KEY(JoinDate),
fOREIGN KEY (GroupID) REFERENCES Group_table(GroupID),
foreign key (AccountID) REFERENCES Account_table(AccountID)
);
CREATE TABLE TypeQuestion
(
TypeID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
TypeName ENUM('Essay' ,'Multiple_Choice')
);
CREATE TABLE  CategoryQuestion
(
CategoryID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY ,
CategoryName ENUM('Java' , 'NET' , 'SQL','Ruby','C' )
);
CREATE TABLE Question
(
QuestionID INT  UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
Content VARCHAR(100) NOT NULL,
CategoryID INT UNSIGNED NOT NULL,
TypeID INT UNSIGNED NOT NULL,
CreatorID INT UNSIGNED NOT NULL,
CreateDate DATE NOT NULL,
FOREIGN KEY ( CategoryID) REFERENCES CategoryQuestion(CategoryID),
FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID)
);
CREATE TABLE Answer
(
AnswerID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
Content VARCHAR(100) NOT NULL,
QuestionID INT UNSIGNED NOT NULL,
isCorrect ENUM('TRUE','FALSE'),
FOREIGN KEY ( QuestionID) REFERENCES Question ( QuestionID)
);
CREATE TABLE Exam
(
ExamID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
Code_ INT NOT NULL,
Title VARCHAR(255) NOT NULL,
CategoryID INT UNSIGNED NOT NULL,
Duration INT NOT NULL,
CreatorID INT UNSIGNED NOT NULL,
CreateDate DATE NOT NULL,
FOREIGN KEY ( CategoryID) REFERENCES CategoryQuestion(CategoryID)
);
CREATE TABLE ExamQuestion
(
ExamID INT UNSIGNED NOT NULL ,
QuestionID INT UNSIGNED NOT NULL
);
INSERT INTO Department(DepartmentName) VALUES
('Sale'),
('Maketing'),
('Security'),
('manager'),
('Accounting');
SELECT * FROM Department;
INSERT INTO Position_table(PositionName) VALUES
('DEV'),
('Test'),
('Scrum Master'),
('PM'),
('DEV');
SELECT * FROM Position_table;
INSERT INTO Account_table(Email,Username,FullName,DepartmentID,PositionID,CreateDate) VALUES
('nguyentrungkien07112001@gmail.com','kien','nguyen trung kien',3,2,'2015-01-01'),
('lethingan12072001@gmail.com'      , 'ngan','le thi ngan'     ,4,3,'2016-02-02'),
('tranvancuong01012000@gmail.com'   , 'cuong', 'tran van cuong',1,4,'2017-05-24'),
('hoangquangphuc123456789@gmail.com','phuc','hoang quang phuc' ,5,1,'2015-05-06'),
('nguyenminhtuuan98765432@gmail.com','tuan','nguyen minh tuan' ,4,2,'2020-01-01');
SELECT * FROM  Account_table;
INSERT INTO Group_table(GroupName,CreatorID,CreateDate) VALUES
('group 1',5,'2020-09-09'),
('group 2',3,'2020-08-08'),
('group 3',1,'2020-07-07'),
('group 4',2,'2020-06-06'),
('group 5',4,'2020-05-05');
SELECT * FROM Group_table;

INSERT INTO Group_Account(GroupID,AccountID,JoinDate) VALUES
(5,3,'2020-09-09'),
(3,4,'2020-08-08'),
(1,2,'2020-07-07'),
(2,5,'2020-06-06'),
(4,1,'2020-05-05');
SELECT * FROM Group_Account;
INSERT INTO TypeQuestion(TypeName) VALUES
('Essay' ),
('Multiple_Choice'),
('Essay' ),
('Multiple_Choice'),
('Essay' );
SELECT * FROM TypeQuestion;

INSERT INTO CategoryQuestion(CategoryName) VALUES
('Java') ,
( 'NET') ,
( 'SQL'),
('C'),
('Ruby' );
SELECT * FROM  CategoryQuestion;

INSERT INTO Question(Content, CategoryID, TypeID, CreatorID, CreateDate) VALUES
('What is Java?', 1, 2, 4, '2020-12-26'),
('What is .NET?', 2, 1, 5, '2020-12-26'),
('What is SQL?', 3, 2, 2, '2020-12-26'),
('What is Postman?', 4, 2, 1, '2020-12-26'),
('What is Ruby?', 5, 1, 3, '2020-12-26');
SELECT * FROM Question;
INSERT INTO Answer(Content, QuestionID, isCorrect) VALUES
('Java is...', 1, 'True'),
('.NET is...', 2, 'False'),
('SQL is...', 3, 'True'),
('Postman is...', 4, 'False'),
('Ruby is...', 5, 'False');
SELECT * FROM Answer;
INSERT INTO Exam(Code_, Title, CategoryID, Duration, CreatorID, CreateDate) VALUES
(111, 'CAU HOI A?', 2, 180, 4, '2020-12-27'),
(112, 'CAU HOI B?', 1, 180, 5, '2020-12-27'),
(113, 'CAU HOI C', 2, 180, 2, '2020-12-27'),
(114, 'CAU HOI D', 4, 180, 2, '2020-12-27'),
(115, 'CAU HOI E', 1, 180, 3, '2020-12-27');

SELECT * FROM Exam;
INSERT INTO ExamQuestion(ExamID, QuestionID) VALUES
(1, 5),
(2, 4),
(3, 3),
(4, 2),
(5, 1);
SELECT * FROM ExamQuestion;










 





