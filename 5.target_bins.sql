insert into target_bins values (1,'Targets <100X',0,100,1);
insert into target_bins values (2,'Targets 100X-200X',100,200,1);
insert into target_bins values (3,'Targets 200X-500X',200,500,1);
insert into target_bins values (4,'Targets <100X',0,100,2);
insert into target_bins values (5,'Targets 100X-200X',100,200,2);
insert into target_bins values (6,'Targets 200X-500X',200,500,2);

insert into target_bins values (7,'Targets <100X',0,100,3);
insert into target_bins values (8,'Targets 100X-200X',100,200,3);
insert into target_bins values (9,'Targets 200X-500X',200,500,3);


insert into target_bins values (10,'Targets <100X',0,100,4);
insert into target_bins values (11,'Targets 100X-200X',100,200,4);
insert into target_bins values (12,'Targets 200X-500X',200,500,4);

insert into target_bins values (13,'Targets <100X',0,100,5);
insert into target_bins values (14,'Targets 100X-200X',100,200,5);
insert into target_bins values (15,'Targets 200X-500X',200,500,5);


insert into target_bins values (16,'Targets <100X',0,100,6);
insert into target_bins values (17,'Targets 100X-200X',100,200,6);
insert into target_bins values (18,'Targets 200X-500X',200,500,6);

insert into target_bins values (19,'Targets <100X',0,100,7);
insert into target_bins values (20,'Targets 100X-200X',100,200,7);
insert into target_bins values (21,'Targets 200X-500X',200,500,7);

insert into target_bins values (22,'Targets <100X',0,100,8);
insert into target_bins values (23,'Targets 100X-200X',100,200,8);
insert into target_bins values (24,'Targets 200X-500X',200,500,8);

insert into bench_configurations(site_id,panel_id,folder_name,pipeline_name) 
	values
(1,1,'Clinical production - Solid - Branford','OCAv3_clinical_production_RC001_pipe');








alter TABLE user AUTO_INCREMENT=1;

insert into user values(null,'SYSTEM','SYSTEM','SYSTEM','SYSTEM');
insert into user values(null,"feras.hantash@sema4genomics.com","Feras ","Hantash","feras.hantash@sema4genomics.com");
insert into user values(null,"Jane.Houldsworth@sema4genomics.com","Jane ","Houldsworth","Jane.Houldsworth@sema4genomics.com");
insert into user values(null,"sertac.kip@sema4genomics.com","Nefize ","Sertac Kip","sertac.kip@sema4genomics.com");
insert into user values(null,"Michael.Rossi@sema4genomics.com","Michael ","Rossi","Michael.Rossi@sema4genomics.com");
insert into user values(null,"todd.arnold@sema4genomics.com","Todd ","Arnold","todd.arnold@sema4genomics.com");
insert into user values(null,"lisa.edelmann@sema4genomics.com","Lisa ","Edelmann","lisa.edelmann@sema4genomics.com");
insert into user values(null,"tony@sema4genomics.com","Tony ","Prentice","tony@sema4genomics.com");
insert into user values(null,"mohit.pasricha@sema4genomics.com","Mohit ","Pasricha","mohit.pasricha@sema4genomics.com");
insert into user values(null,"raparti@sema4genomics.com","Raparti ","Swayambhu","raparti@sema4genomics.com");
insert into user values(null,"jing.li@sema4genomics.com","Jing ","Li","jing.li@sema4genomics.com");
insert into user values(null,"bharath.jeganathan@sema4genomics.com","Bharath ","Jeganathan","bharath.jeganathan@sema4genomics.com");
insert into user values(null,"arjun.sahasranam@sema4genomics.com","Arjun ","Sahasranam","arjun.sahasranam@sema4genomics.com");
insert into user values(null,"sravan.perumandla@sema4genomics.com","Sravan ","Perumandla","sravan.perumandla@sema4genomics.com");
insert into user values(null,"rishav.verma@sema4genomics.com","Rishav ","Verma","rishav.verma@sema4genomics.com");
insert into user values(null,"andrew.uzilov@sema4genomics.com","Andrew ","Uzilov","andrew.uzilov@sema4genomics.com");
insert into user values(null,"hong.lu@sema4genomics.com","Hong ","Lu","hong.lu@sema4genomics.com");
insert into user values(null,"chetanya.pandya@sema4genomics.com","Chetanya ","Pandya","chetanya.pandya@sema4genomics.com");
insert into user values(null,"aye.moe@sema4genomics.com","Aye ","Moe","aye.moe@sema4genomics.com");
insert into user values(null,"kai.ying@sema4genomics.com","Kai ","Ying","kai.ying@sema4genomics.com");

insert into file_ref (id,file_name,type,url,modified_by) values
	(1,'RSM64730-11','VCF','/variantcaller/4900/19/Out_RSM64730-11.vcf',1),
	(2,'RSM64731-11','VCF','/variantcaller/4900/20/Out_RSM64731-11.vcf',1),
	(3,'RSM64732-11','VCF','/variantcaller/4900/21/Out_RSM64732-11.vcf',1),
	(4,'RSM64719-11','VCF','/variantcaller/4900/22/Out_RSM64719-11.vcf',1),
	(5,'RSM64720-11','VCF','/variantcaller/4900/23/Out_RSM64720-11.vcf',1);
