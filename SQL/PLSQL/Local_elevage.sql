SELECT * from Animal an left OUTER join Adoption ad on an.id = ad.ANIMAL_ID where lower(an.NOM) like 'ch%';
select * from adoption where animal_id=6;

select * from adoption where client_id=6;

select RECHERCHE_CLIENT('dupont','jean') from dual;

select user from dual;

select recherche_maman(nom) from animal;