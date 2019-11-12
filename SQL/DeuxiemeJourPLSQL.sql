DECLARE
	CURSOR c1 IS
	SELECT
		nom,
		pere_id
	FROM
		animal
	WHERE
		pere_id IS NOT NULL;

	nomAnimal   animal.nom%TYPE;
	pereId      animal.pere_id%TYPE;
	nomPere     animal.nom%TYPE;
BEGIN
		/*OPEN c1;
    FETCH c1 INTO
        nomAnimal,
        pereId;*/
	FOR c1_ligne IN c1 LOOP
		pereId := C1_ligne.pere_id;
		SELECT
			nom
		INTO nomPere
		FROM
			Animal
		WHERE
			id = pereId;
--    dbms_output.put_line(nomAnimal||' '||pereId);

		dbms_output.put_line(c1_ligne.nom
		                     || ' fils de '
		                     || nomPere);
	END LOOP;

    -- CLOSE c1;
END;
/

DECLARE
	CURSOR c1 IS
    -- SELECT * from Animal an left OUTER join Adoption ad on an.id = ad.ANIMAL_ID where lower(an.NOM) like 'ch%' and ad.CLIENT_ID is null ;
	SELECT
		id,
		nom
	FROM
		animal;

	clientId     client.id%TYPE :=6;
	nbAdoption   INT;
BEGIN
	FOR c1_ligne IN c1 LOOP
		IF substr(lower(c1_ligne.nom), 0, 2) = 'ch' THEN
			SELECT
				COUNT(*) INTO nbAdoption	FROM adoption
			WHERE
				animal_id = c1_ligne.id;
				dbms_output.put_line(c1_ligne.nom);
			IF nbAdoption = 0 THEN
				INSERT INTO adoption VALUES (
					clientId,
					c1_ligne.id,
					sysdate,
					sysdate,
					100,
					1
				);
			END IF;
		END IF;
	END LOOP;
END;
/

DECLARE
  vnom varchar(50);
BEGIN
  select nom into vnom from client;
	EXCEPTION 
		WHEN too_many_rows then 
		dbms_output.put_line('Trop de lignes a afficher');
		when no_data_found then 
		dbms_output.put_line('Aucun résultat');
		when others then
		dbms_output.put_line('Mais quas tu fait ??? ');
END;
/

CREATE OR REPLACE FUNCTION recherche_client(nom_in in varchar2, prenom_in in varchar2)
RETURN number IS
idClient client.id%Type;
BEGIN
	select id into idClient from client
	WHERE lower(prenom) = lower(prenom_in) and lower(nom)=lower(nom_in);
	return idClient;
	EXCEPTION 
		WHEN too_many_rows then 
		dbms_output.put_line('Trop de lignes a afficher');
		when no_data_found then 
		dbms_output.put_line('Aucun résultat');
		when others then
		dbms_output.put_line('Mais quas tu fait ??? ');
END;
/

create or replace FUNCTION recherche_maman(nom_in in varchar2)
RETURN varchar2 IS
Cursor cAn is select nom from animal
	WHERE id=(select mere_id from animal where  lower(nom) = lower(nom_in));
nom_mere animal.nom%Type;
BEGIN
	open cAn;
	fetch cAn into nom_mere;
	if cAn%NOTFOUND then
		nom_mere := 'Mêre inconnue';
	end if;
	close cAn;
	return nom_mere;
END;
/

CREATE TABLE audit_espece (
		id int primary key,
		nom_old varchar(50),
		nom_new varchar(50));

UPDATE espece set nom_courant ='toto' where  id =6;

		
CREATE OR REPLACE TRIGGER after_up_espece AFTER UPDATE ON espece
FOR EACH ROW
DECLARE
BEGIN
 insert into audit_espece values(1, :old.nom_courant, :new.nom_courant);
END;
/

