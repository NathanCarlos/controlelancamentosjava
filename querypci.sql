create database ATIVIDADEAVALIATIVA;

GO
use ATIVIDADEAVALIATIVA;

GO
create table lancamento(
id_lanc bigint primary key identity not null,
desc_lanc varchar(255),
valor_lanc float,
data_lanc date,
dt_criacao date
);

select * from lancamento

drop database ATIVIDADEAVALIATIVA;
