
INSERT INTO `freshers_hiring`.`exams`(`exam_name`, `LABEL`) VALUES ('SSC', 'SSC');
INSERT INTO `freshers_hiring`.`exams`(`exam_name`, `LABEL`) VALUES ('HSC', 'HSC');
INSERT INTO `freshers_hiring`.`exams`(`exam_name`, `LABEL`) VALUES ('BEorBTECH', 'BE or B.Tech');
INSERT INTO `freshers_hiring`.`exams`(`exam_name`, `LABEL`) VALUES ('MTECH', 'M.Tech');
INSERT INTO `freshers_hiring`.`exams`(`exam_name`, `LABEL`) VALUES ('PHD', 'Phd');

INSERT INTO `freshers_hiring`.`competitive_exams`(`exam_name`) VALUES ('GATE');
INSERT INTO `freshers_hiring`.`competitive_exams`(`exam_name`) VALUES ('CET');
INSERT INTO `freshers_hiring`.`competitive_exams`(`exam_name`) VALUES ('COMEDK');
INSERT INTO `freshers_hiring`.`competitive_exams`(`exam_name`) VALUES ('JEE Main');
INSERT INTO `freshers_hiring`.`competitive_exams`(`exam_name`) VALUES ('JEE');
	
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('SSC', 'SSC', 1.0);

INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('HSC', 'SSC', 0.4);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('HSC', 'HSC', 0.6);

INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('BEorBTECH', 'SSC', 0.2);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('BEorBTECH', 'HSC', 0.2);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('BEorBTECH', 'BEorBTECH', 0.4);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('BEorBTECH', 'JEE', 0.2);

INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('MTECH', 'SSC', 0.2);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('MTECH', 'HSC', 0.2);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('MTECH', 'BEorBTECH', 0.4);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('MTECH', 'MTECH', 0.1);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('MTECH', 'GATE', 0.1);

INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('PHD', 'SSC', 0.1);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('PHD', 'HSC', 0.1);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('PHD', 'BEorBTECH', 0.2);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('PHD', 'MTECH', 0.2);
INSERT INTO `freshers_hiring`.`qualification_weightage`(`HIEGHTEST_QUALIFICATION`, `QUALIFICATION`,`WEIGHTAGE`) 
VALUES('PHD', 'PHD', 0.4);

 

INSERT INTO PERCENTAGE_RULES(`POINTS`, `RULE`) VALUES(4, 'percentage<60');
INSERT INTO PERCENTAGE_RULES(`POINTS`, `RULE`) VALUES(6, 'percentage>=60 && percentage<75');
INSERT INTO PERCENTAGE_RULES(`POINTS`, `RULE`) VALUES(8, 'percentage>=75 && percentage<90');
INSERT INTO PERCENTAGE_RULES(`POINTS`, `RULE`) VALUES(10, 'percentage>90');

