#vamos a insertar un par de registros del personal de la universidad..
```
db.personal.insertOne({"nombre":"lucas mufato", "edad":28, cargo: "docente", area:"computacion", "materias":[11078]})
```

```
db.personal.insertMany([
  {"nombre": "juan perez", edad: 38, cargo: "limpieza"},
  {"nombre": "julian lopez", edad: 45, cargo: "seguridad", arma: true}
])
```
teniendo 3 personas en la BD.. vamos a seleccionar a alguno.. cualquiera..
```
db.personal.find()
```
El metodo find puede recibir como parametro el json contra el cual matchear
```
db.personal.find( {} )
```

```
db.personal.find( {"nombre":"lucas mufato"} )
```
puedo buscar por otro tipo de dato.
```
db.personal.find( {"edad":28} )
```
puedo usar filtros
```
db.personal.find( {"edad": {$gt: 30} } )
```
Para realizar un AND solo concatenamos otro atributo en el JSON de comparacion:
```
db.personal.find( {"edad": {$gt: 30}, cargo:"limpieza" } )
```
Para hacer el OR lo que vamos a hacer es indicarle una lista de valores, de los cuales uno debe ser verdadero:
```
db.personal.find( { $or:[ {edad:{$lt: 30}},{cargo: "seguridad"} ]  } )
```
# agregamos a cherencio con algunos datos embebidos
```
db.personal.insertOne( {nombre: "guillermo cherencio", titular: { codigo:11078, contenidos:["triggers", "noSQL", "JPA"] }})
```
Podemos buscar por datos embebidos directamente
```
db.personal.find( {"titular.codigo": 11078}  )
```

y hasta acceder a la lista contenida en el dato embebio:
```
db.personal.find( {"titular.contenidos.0": "triggers" }  )
```
