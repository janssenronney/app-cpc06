CREATE TABLE tbl_fornecedor (
    id_fornecedor INTEGER PRIMARY KEY,
    cod_fornecedor VARCHAR(6) UNIQUE ,
    forn_nome VARCHAR(50) UNIQUE ,
    cont_despesa INTEGER,
    UNIQUE (id_fornecedor, cod_fornecedor)
);

CREATE TABLE tbl_contrato (
    id_contrato INTEGER PRIMARY KEY UNIQUE,
    id_n_fornecedor VARCHAR(60),
    num_parcelas INTEGER,
    dt_inicio DATE,
    taxa_contrato REAL,
    vlr_contrato REAL,
    ctto_objeto VARCHAR(10)
);

CREATE TABLE tbl_calculo (
    id_calculo INTEGER PRIMARY KEY,
    id_contrato INTEGER,
    num_parcelas INTEGER,
    vlr_presente REAL,
    calc_depreciacao REAL
);

CREATE TABLE tbl_lancamento (
    id_lancamento INTEGER PRIMARY KEY UNIQUE,
    id_fornecedor INTEGER,
    id_contrato INTEGER,
    lnc_valorpres REAL,
    lnc_cc INTEGER,
    lnc_juros REAL,
    cont_despesa INTEGER,
    lnc_depreciacao REAL,
    vlr_despesa REAL,
    dt_lancamento DATE
);

CREATE TABLE tbl_analise (
    id_analise INTEGER PRIMARY KEY UNIQUE,
    id_fornecedor INTEGER,
    nome_fornecedor VARCHAR(50),
    benef_econ BOOLEAN,
    praz_min BOOLEAN,
    trans_poss_oper BOOLEAN
);

ALTER TABLE tbl_calculo ADD CONSTRAINT FK_tbl_calculo_2
    FOREIGN KEY (id_contrato)
        REFERENCES tbl_contrato (id_contrato);

ALTER TABLE tbl_lancamento ADD CONSTRAINT FK_tbl_lancamento_3
    FOREIGN KEY (id_fornecedor)
        REFERENCES tbl_fornecedor (id_fornecedor);

ALTER TABLE tbl_lancamento ADD CONSTRAINT FK_tbl_lancamento_4
    FOREIGN KEY (id_contrato)
        REFERENCES tbl_contrato (id_contrato);

ALTER TABLE tbl_analise ADD CONSTRAINT FK_tbl_analise_3
    FOREIGN KEY (id_fornecedor)
        REFERENCES tbl_fornecedor (id_fornecedor);