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






insert into sample values (null,'RSM64726-11',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD134-14',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD169-11',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');	
insert into sample values (null,'STD171-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD173-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD175-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD177-13',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD177-14',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD179-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD181-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD183-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD39-1109',null,null,null,null,null,null,null,null,null,null,null,null,null,'NTC_DNA');
insert into sample values (null,'STD39-1110',null,null,null,null,null,null,null,null,null,null,null,null,null,'NTC_RNA');




insert into sample values (null,'STD135-14',null,null,null,null,null,null,null,null,null,null,null,null,null,'NTC_RNA');
insert into sample values (null,'STD172-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD-174-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD176-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');
insert into sample values (null,'STD180-3',null,null,null,null,null,null,null,null,null,null,null,null,null,'Control');



insert into sample (lims_sample_id,sample_type)
	values 
	('RSM64953-18','Control'),
	('RSM64953-14','Control'),
	('RSM64953-16','Control'),
	('RSM64956-7','Control'),
	('STD301-11','Control'),
	('STD119-55','Control'),
	('STD61-133','Control'),
	('STD188-25','Control');

	












insert into control_sample_variants_reference (sample_id,target_name,chromosome,position,ref_allele,alt_allele,gene,cdna_change,protein_change,expected_al,expected_al_start,expected_al_end)
values
(1,'SP_148.9816','chr3',178936091,'G','A','PIK3CA','c.1633G>A','p.E545K',0.00,0.00,0.01),
(2,'OCP1_RB1_12','chr13',48934151,'AG','A','RB1','c.610delG','p.E204fs*10',1.00,0.95,1.00),
(2,'TP53_1.46429','chr17',7576855,'G','A','TP53','c.991C>T','p.Q331*',1.00,0.95,1.00),
(3,'SMARCA4_30.26076','chr19',11152007,'G','T','SMARCA4','c.4195G>T','p.E1399*',1.00,0.95,1.00),
(4,'TP53_7.361197_and_TP53_7.148281_overlap','chr17',7577538,'C','T','TP53','c.743G>A','p.R248Q',1.00,0.95,1.00),
(5,'SP_148.9816','chr3',178936091,'G','A','PIK3CA','c.1633G>A','p.E545K',0.50,0.40,0.60),
(6,'CHP2_RB1_10','chr13',49039164,'G','T','RB1','c.2242G>T','p.E748*',1.00,0.95,1.00),
(7,'TP53_10.1.366103','chr17',7578177,'C','A','TP53','c.672G>T','p.E224D',0.03,0.01,0.04),
(8,'TP53_10.1.366103','chr17',7578177,'C','A','TP53','c.672G>T','p.E224D',1.00,0.95,1.00),
(9,'OCP1_STK11_9','chr19',1220595,'G','A','STK11','c.613G>A','p.A205T ',0.50,0.40,0.60),
(10,'OCP1_ATM_39','chr11',108137925,'C','T','ATM','c.2494C>T','p.R832C ',0.50,0.40,0.60),
(11,'SP_150.100237','chr3',178952085,'A','G','PIK3CA','c.3140A>G','P.H1047R',0.50,0.40,0.60);


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

