DROP DATABASE IF EXISTS testing_final_exam;
CREATE DATABASE IF NOT EXISTS testing_final_exam;
USE testing_final_exam;
DROP TABLE IF exists employee,
					 manager,
					 project;
CREATE TABLE employee
(
EmployeeID INT AUTO_INCREMENT,
Email VARCHAR(100),
FullName VARCHAR(100),
`Password` VARCHAR(50),
ProjectID INT,
ProSkill VARCHAR(30), 
PRIMARY KEY (EmployeeID)
);
CREATE TABLE manager
(
ManagerID INT AUTO_INCREMENT,
Email VARCHAR(100),
FullName VARCHAR(100),
`Password` VARCHAR(50),
ExpInYear TINYINT,
PRIMARY KEY (ManagerID)
);
CREATE TABLE project
(
ProjectID INT AUTO_INCREMENT,
TeamSize TINYINT,
ManagerID INT,
PRIMARY KEY(ProjectID),
FOREIGN KEY (ManagerID) REFERENCES manager (ManagerID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE employee_project
(
ProjectID INT,
EmployeeID INT,
FOREIGN KEY (ProjectID) REFERENCES project(ProjectID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (EmployeeID) REFERENCES employee (EmployeeID) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO employee(Email, FullName, `Password`, ProjectID, ProSkill) VALUES
('david123@gmail.com', 'David Johnson', 'david123', 1, 'dev'),
('john123@gmail.com', 'John Drake', 'john123', 2, 'dev'),
('adam123@gmail.com', 'Adam Brook', 'adam123', 1, 'test'),
('nathan123@gmail.com', 'Nathan Cookman', 'nathan123', 2, 'test'),
('stephen123@gmail.com', 'Stephen Josep', 'stephen123', 1, 'sql');
INSERT INTO manager(Email, FullName, `Password`, ExpInYear) VALUES
('kimmich123@gmail.com', 'Joshua Kimmich', 'kimmich123', 4),
('boateng123@gmail.com', 'Jeron Boateng', 'boateng123', 5);
INSERT INTO project(TeamSize, ManagerID) VALUES
(3, 1),
(2, 2);
INSERT INTO employee_project(ProjectID, EmployeeID) VALUES
(1, 1),
(1, 3),
(1, 5),
(2, 2),
(2, 4);
ALTER TABLE employee ADD FOREIGN KEY (ProjectID) REFERENCES project(ProjectID) ON DELETE CASCADE ON UPDATE CASCADE;
                     