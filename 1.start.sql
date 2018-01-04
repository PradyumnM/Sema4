insert into chip values (1,'540');
INSERT INTO `panel` VALUES (1,'OCAv3.20170110.designed.bed','/results/uploads/BED/110/hg19/unmerged/detail/OCAv3.20170110.designed.bed',200);
insert into `test` values (1,'O1S','O1S',1);
insert into report_template values(1,'<!DOCTYPE html><html><head><title>Page Title</title></head><body><h1>This is a Heading</h1><p>This is a paragraph.</p></body></html>');

insert into site values (1,'Branford');

INSERT INTO practice VALUES (1,'000009','MSGTL-CT','1 Commerical St','','Branford','CT','06405','203-483-3425','203-483-3449','');
insert into user values(null,'SYSTEM','SYSTEM','SYSTEM','SYSTEM');





insert into instrument_type values (1, 'S5XL', 'S5XL');
insert into instrument_type values(2,'Chef','Chef');
insert into instrument values (1,' Ion Torrent S5 #01 at Branford',1,1,'01');
insert into instrument values(2,'Ion Torrent S5 #02 at Branford',1,1,'02');
insert into instrument values(3,'Ion Torrent S5 #03 at Branford',1,1,'03');
insert into instrument values(4,'Ion Torrent S5 #04 at Branford',1,1,'04');
insert into instrument values(5,'Ion Torrent Chef #01 at Branford',1,2,'01');
insert into instrument values(6,'Ion Torrent Chef #02 at Branford',1,2,'02');
insert into instrument values(7,'Ion Torrent Chef #03 at Branford',1,2,'03');
insert into instrument values(8,'Ion Torrent Chef #04 at Branford',1,2,'04');


insert into run_combination values (1,1,1,1);
insert into run_combination values (2,1,1,2);
insert into run_combination values (3,1,1,3);
insert into run_combination values (4,1,1,4);
insert into run_combination values (5,1,1,5);
insert into run_combination values (6,1,1,6);
insert into run_combination values (7,1,1,7);
insert into run_combination values (8,1,1,8);

insert into genecategory values (1,'All Coding Exons Sequenced');
insert into genecategory values(2,'Hotspot Regions Sequenced');
insert into genecategory values (3,'Rearrangements/Fusions Queried');
insert into genecategory values(4,'Copy Number Abnnormalities Queried');
