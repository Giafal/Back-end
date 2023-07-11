CREATE TABLE clienti (
	NumeroCliente SERIAL PRIMARY KEY,
	Nome VARCHAR NOT NULL,
	Cognome VARCHAR NOT NULL,
	DataNascita DATE NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
);

CREATE TABLE fatture (
	NumeroFattura SERIAL PRIMARY KEY,
	Tipologia VARCHAR NOT NULL,
	Importo INTEGER NOT NULL,
	Iva INTEGER NOT NULL,
	IdCliente INTEGER NOT NULL,
	DataFattura DATE NOT NULL,
	NumeroFornitore INTEGER NOT NULL
	
);

CREATE TABLE prodotti (
	IdProdotto SERIAL PRIMARY KEY,
	Descrizione VARCHAR NOT NULL,
	InProduzione BOOLEAN NOT NULL,
	InCommercio BOOLEAN NOT NULL,
	DataAttivazione DATE NOT NULL,
	DataDisattivazione DATE NOT NULL
);

CREATE TABLE fornitori (
	NumeroFornitore SERIAL PRIMARY KEY,
	Denominazione VARCHAR NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
);

ALTER TABLE fatture ADD CONSTRAINT idCliente_FK FOREIGN KEY (IdCliente) REFERENCES clienti (NumeroCliente);
ALTER TABLE fatture ADD CONSTRAINT numeroFornitore_FK FOREIGN KEY (NumeroFornitore) REFERENCES fornitori (NumeroFornitore);

--Primo Esercizio
INSERT INTO clienti (Nome, Cognome, DataNascita, RegioneResidenza) VALUES ('Gianluca', 'Falcone', '1987-06-01', 'Puglia');
INSERT INTO clienti (Nome, Cognome, DataNascita, RegioneResidenza) VALUES ('Andrea', 'Bardi', '1982-05-20', 'Emilia Romagna');
SELECT nome, cognome FROM clienti WHERE EXTRACT(YEAR FROM DataNascita) = 1982;

--Secondo Esercizio
INSERT INTO fornitori (Denominazione, RegioneResidenza) VALUES ('Vigu', 'Puglia');
INSERT INTO fatture (Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore) VALUES ('A', 100, 20, 1, '2023-07-10', 1);
INSERT INTO fatture (Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore) VALUES ('B', 50, 10, 2, '2023-07-10', 1);
SELECT NumeroFattura FROM fatture WHERE Iva = 20;

--Terzo Esercizio
SELECT COUNT(*) AS numero_fatture FROM fatture WHERE EXTRACT(YEAR FROM DataFattura) = 2023;
SELECT SUM(Importo) AS totale_importi FROM fatture GROUP BY EXTRACT(YEAR FROM DataFattura) = 2023;

--Quarto Esercizio
INSERT INTO prodotti (Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione) VALUES ('Iphone', true, false, '2017-05-05', '2023-05-05');
INSERT INTO prodotti (Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione) VALUES ('Samsung', false, false, '2017-05-05', '2023-05-05');
SELECT * FROM prodotti WHERE EXTRACT(YEAR FROM DataAttivazione) = 2017 AND (InProduzione = true) OR (InCommercio = true);

--Quinto Esercizio
SELECT COUNT(*) AS numero_fatture FROM fatture WHERE EXTRACT(YEAR FROM DataFattura) = 2023 GROUP BY Iva = 20;
