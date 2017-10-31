<-------Query C/1---------->

The average, the minimum, the maximum, and the standard deviation of the number of applications per trip.

select avg(t.application.size), min(t.application.size), max(t.application.size), sqrt(sum(t.application.size*t.application.size)/count(t.application.size)-(avg(t.application.size)*avg(t.application.size))) from Trip t;

Esta consulta accede a la tabla Trip de nuestra base de datos, devolviendo la media, el mínimo, el máximo y la desviación estándar del tamaño del número de aplicaciones de los trips. Para esto, accedemos a la propiedad application de los Trip y vemos su tamaño.

1 object selected
[2.0, 2, 2, 0.0]

<-------Query C/2---------->

The average, the minimum, the maximum, and the standard deviation of the number of trips managed per manager.

select avg(m.trip.size), min(m.trip.size), max(m.trip.size), sqrt(sum(m.trip.size*m.trip.size)/count(m.trip.size)-(avg(m.trip.size)*avg(m.trip.size))) from Manager m;

Esta consulta accede a la tabla Manager de nuestra base de datos, devolviendo la media, el mínimo, el máximo y la desviación estándar del tamaño del número de trip de los Manager. Para esto, accedemos a la propiedad trip de los Manager y vemos su tamaño.

1 object selected
[1.0, 0, 2, 1.0]

<-------Query C/3---------->

The average, the minimum, the maximum, and the standard deviation of the price of the trips.

select avg(t.price), min(t.price), max(t.price), sqrt(sum(t.price*t.price)/count(t.price) - (avg(t.price) * avg(t.price))) from Trip t;

Esta consulta accede a la tabla Trip de nuestra base de datos, devolviendo la media, el mínimo, el máximo y la desviación estándar del tamaño del precio de los trip. Para esto, accedemos a la propiedad price de los Trip para ver su precio.

1 object selected
[440.0, 80.0, 800.0, 360.0]

<-------Query C/4---------->

The average, the minimum, the maximum, and the standard deviation of the number trips guided per ranger.

select avg(r.trip.size),min(r.trip.size),max(r.trip.size), sqrt(sum(r.trip.size*r.trip.size)/count(r.trip.size)-(avg(r.trip.size)*avg(r.trip.size))) from Ranger r;

Esta consulta accede a la tabla Ranger de nuestra base de datos, devolviendo la media, el mínimo, el máximo y la desviación estándar del tamaño del numero de trip de los Ranger. Para esto, accedemos a la propiedad trip de los Ranger y vemos su tamaño.

1 object selected
[1.0, 1, 1, 0.0]

<-------Query C/5---------->

The ratio of applications with status ''PENDING''.

select cast(count(a) as float)/(select count(a) from Application a) from Application a where a.status='PENDING';

Calcula el ratio entre el número de Application con status PENDING (accediendo a la tabla Application y contando aquellas cuyo status sea PENDING) y el número total de Application (accediendo a la tabla Application y contando en este caso todas las entradas de la misma). Realizamos un cast para poder devolver números decimales.

1 object selected
0.5

<-------Query C/6---------->

The ratio of applications with status ''DUE''.

select cast(count(a) as float)/(select count(a) from Application a) from Application a where a.status='DUE';

Calcula el ratio entre el número de Application con status DUE (accediendo a la tabla Application y contando aquellas cuyo status sea DUE) y el número total de Application (accediendo a la tabla Application y contando en este caso todas las entradas de la misma). Realizamos un cast para poder devolver números decimales.

1 object selected
0.25

<-------Query C/7---------->

The ratio of applications with status ''ACCEPTED''.

select cast(count(a) as float)/(select count(a) from Application a) from Application a where a.status='ACCEPTED';

Calcula el ratio entre el número de Application con status ACCEPTED (accediendo a la tabla Application y contando aquellas cuyo status sea ACCEPTED) y el número total de Application (accediendo a la tabla Application y contando en este caso todas las entradas de la misma). Realizamos un cast para poder devolver números decimales.

1 object selected
0.25

<-------Query C/8---------->

The ratio of applications with status ''CANCELLED''.

select cast(count(a) as float)/(select count(a) from Application a) from Application a where a.status='CANCELLED';

Calcula el ratio entre el número de Application con status CANCELLED (accediendo a la tabla Application y contando aquellas cuyo status sea CANCELLED) y el número total de Application (accediendo a la tabla Application y contando en este caso todas las entradas de la misma). Realizamos un cast para poder devolver números decimales.

1 object selected
0.0

<-------Query C/9---------->

The ratio of trips that have been cancelled versus the total number of trips that have been organised.

select cast(count(t) as float) /(select count(t) from Trip t)  from Trip t where t.reason is not null;

Calcula el ratio entre el número de Trip que han sido cancelados (accediendo a la tabla Trip y entrando a los que tengan el atributo reason no nulo) y el número total de Trip (accediendo a la tabla Trip y contando en este caso todas las entradas de la misma). Realizamos un cast para poder devolver números decimales.

1 object selected
0.5

<-------Query C/10---------->

The listing of trips that have got at least 10% more applications than the average, ordered by number of applications

select t from Trip t group by t having t.application.size > (select avg(t2.application.size)*1.1 from Trip t2) order by t.application.size;

Esta consulta devuelve una lista de Trip. Para ello, debemos agrupar por Trip y seleccionar con la ayuda de having aquellos Trip que tienen un número de application que es al menos un diez por ciento mayor que la media de los application de los Trip (creando una consulta anidada para hacer la media de los application de los Trip). Establecemos por último el orden con la ayuda de order by. Para todo esto, hemos accedido a la propiedad application de los Trip y a su tamaño.

0 objects selected

<-------Query C/11---------->

A table with the number of times that each legal texts been referenced.

select count(t) from Trip t where t.legalText is not null;

En esta consulta accedemos a la tabla Trip, y contamos todos los Trip que tengan un legalText que no sea nulo.

1 object selected
2

<-------Query B/1---------->

The minimum, the maximum, the average, and the standard deviation of the number of notes per trip.

select avg(t.note.size), min(t.note.size), max(t.note.size), sqrt(sum(t.note.size*t.note.size)/count(t.note.size)-(avg(t.note.size)*avg(t.note.size))) from Trip t;

Accede a la tabla Trip de nuestra base de datos, devolviendo el mínimo, el máximo, la media y su desviación estándar del número de note de los Trip. Para esto, accedemos a la propiedad note de los Trip y vemos su tamaño.

1 object selected
[1.0, 0, 2, 1.0]

<-------Query B/2---------->

The minimum, the maximum, the average, and the standard deviation of the number of audit records per trip.

select avg(t.audit.size), min(t.audit.size), max(t.audit.size), sqrt(sum(t.audit.size*t.audit.size)/count(t.audit.size)-(avg(t.audit.size)*avg(t.audit.size))) from Trip t;

Acccede a la tabla Trip de nuestra base de datos, devolviendo el mínimo, el máximo, la media y su desviación estándar del número de audit de los Trip. Para esto, accedemos a la propiedad audit de los Trip y vemos su tamaño.

1 object selected
[1.0, 0, 2, 1.0]

<-------Query B/3---------->

The ratio of trips with an audit record.

select count(t)/((select count(t2) from Trip t2)+0.0) from Trip t where t.audit.size=1;

Calcula el ratio entre el número Trip que tienen un audit (accediendo a la tabla Trip y contando aquellos que tengan un audit) y el número total de Trip (accediendo a la tabla Trip y contando en este caso todas las entradas de la misma). Hemos sumado 0.0 para poder devolver números decimales, es una alternativa al uso de cast.

1 object selected
0.0

<-------Query B/4---------->

The ratio of rangers who have registered their curricula.

select cast(count(r) as float)/(select count(rt) from Ranger rt) from Ranger r where r.curriculum is not null;

Calcula el ratio entre el número Ranger que tienen un curriculum (accediendo a la tabla Ranger y contando aquellos cuyo curriculum sea distinta a nulo) y el número total de Ranger (accediendo a la tabla Ranger y contando en este caso todas las entradas de la misma). Hemos hecho un cast para poder devolver números decimales.

1 object selected
1.0

<-------Query B/5---------->

The ratio of rangers whose curriculums been endorsed.

select count(c)/((select count(c2) from Curriculum c2)+0.0) from Curriculum c where c.endorserRecord.size>0;

Calcula el ratio entre el número de Ranger que tienen un curriculum con endorserRecord (accediendo a la tabla Curriculum y contando aquellos que tengan algún endorserRecord) y el número total de Curriculum (accediendo a la tabla Curriculum y contando en este caso todas las entradas de la misma). Hemos sumado 0.0 para poder devolver números decimales, es una alternativa al uso de cast.

1 object selected
0.5

<-------Query B/6---------->

The ratio of suspicious managers.

select count(m)/((select count(m2) from Manager m2)+0.0) from Manager m where m.suspicious=true;

Calcula el ratio entre el número de Manager suspicious (accediendo a la tabla Manager y contando aquellos que tengan suspicious igual a true) y el número total de Manager (accediendo a la tabla Manager y contando en este caso todas las entradas de la misma). Hemos sumado 0.0 para poder devolver números decimales, es una alternativa al uso de cast. 

1 object selected
0.0

<-------Query B/7---------->

The ratio of suspicious rangers.

select cast(count(r) as float)/(select count(r) from Ranger r) from Ranger r where r.suspicious=true;

Calcula el ratio entre el número de Ranger suspicious (accediendo a la tabla Ranger y contando aquellos que tengan suspicious igual a true) y el número total de Ranger (accediendo a la tabla Ranger y contando en este caso todas las entradas de la misma). Hemos hecho un cast para poder devolver números decimales.

1 object selected
0.5