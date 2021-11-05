insert into anotherentity(external_pk, something)
VALUES
('externalPk1', 'something1'),
('externalPk2', 'something1'),
('externalPk3', 'something1'),
('externalPk4', 'something1'),
('externalPk5', 'something1'),
('externalPk6', 'something1'),
('externalPk7', 'something1');

insert into myentity(foo, bar, my_foreign_key)
values 
('foo1', 'bar1', 'externalPk1'),
('foo2', 'bar1', 'externalPk2'),
('foo1', 'bar2', 'externalPk3'),
('foo2', 'bar2', 'externalPk4'),
('foo3', 'bar1', 'externalPk5'),
('foo1', 'bar3', 'externalPk6'),
('foo3', 'bar2', 'externalPk7');