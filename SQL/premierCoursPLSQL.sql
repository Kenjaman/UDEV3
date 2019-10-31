DECLARE
    message VARCHAR(200);
    maville cpville.ville%TYPE := 'Bergerac';
    ligne_ville cpville%rowtype;
    dernier_id bidon.ID%TYPE;
BEGIN

    SELECT * INTO ligne_ville FROM cpville WHERE ID=1;
    message := ligne_ville.code ||' - '|| ligne_ville.ville;

    SELECT MAX(ID) INTO dernier_id FROM bidon;
    IF dernier_id IS NULL THEN
        dernier_id := 1;
    ELSIF dernier_id>= 10 AND dernier_id<=20 THEN
        message := 'Attention limité';
        dernier_id:=dernier_id+1;
    ELSE 
         dernier_id:=dernier_id+1;
    END IF;
    INSERT INTO bidon VALUES(dernier_id,message);
       dbms_output.put_line(message);
    
    COMMIT;
END;  

/ 

DECLARE
    nb1 NUMBER;
    nb2 INT;
    resultat FLOAT;
BEGIN
    nb1:='&nb1';
    nb2:='&nb2';
    IF(nb2-nb1) = nb1 THEN 
        resultat := nb1*nb2;
    ELSIF nb2>nb1 THEN
        resultat := nb1+nb2;
    ELSE
        IF nb2!=0 THEN
            resultat := nb1/nb2;
        ELSE
            dbms_output.put_line('div par 0 impossible');
        END IF;
    END IF;
    dbms_output.put_line(resultat);
END;
/

DECLARE
    nb NUMBER := 1;
BEGIN
    LOOP
    nb := nb+1;
    EXIT WHEN (nb>10);
    dbms_output.put_line(nb);        
    END LOOP;
END;

/

DECLARE
    factoriel NUMBER := 1;
BEGIN
    FOR I IN 1..9
    LOOP
        factoriel := factoriel*I;
    END LOOP;
    
     dbms_output.put_line('factoriel de 9 = ' || factoriel);        
END;

/

DECLARE 
    CURSOR c1 IS SELECT ID FROM bidon;
    monid bidon.ID%TYPE;
BEGIN
    OPEN c1;  
    FETCH c1 INTO monid;
    WHILE c1%found
    LOOP
        dbms_output.put_line('nombre de ligne C1 :'||c1%rowcount);
        dbms_output.put_line(monid);        
        FETCH c1 INTO monid;
    END LOOP;
    CLOSE c1;
    
END;
/