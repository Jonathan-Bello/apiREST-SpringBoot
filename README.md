# Unidad 2 Ejercicio Final

Desarrollo de un conjunto de servicios web los cuales son:

## Equipo

- Jonathan Alexis Bello López
- Angel Cesar Gasca Martinez

## Objetivos

- obtener el número de recursos
- buscar un recurso a través de uno de sus atributos
- obtener la lista de recursos
- registrar un nuevo recurso
- modificar un recurso
- eliminar un recurso

---

## Endpoints realizados

### getCount

- Path: /monstruos/count
- Descripción: Devuelve la cantidad de mounstro registrados
- Método HTTP: GET
- Formato de solicitud: nada en especial
- Formato de respuesta:
  - Tipo: String
  - Ejemplo:

    ```string
    La cantidad de recursos en la base de datos es : 2
    ```

### getAll

- Path: /monstruos
- Descripción: Devuelve todos los mounstro registrados
- Método HTTP: GET
- Formato de solicitud: nada en especial
- Formato de respuesta:
  - Tipo: JSON
  - Ejemplo:

    ```json
    {
        "id" : 1,
        "nombre" : "tigrex",
        "especie" : "wyvern volador",
        "habitat" : "desierto",
        "debilidades" : "trueno"
    },
    {
        "id" : 2,
        "nombre" : "deviljho",
        "especie" : "wyvern bruto",
        "habitat" : "todos",
        "debilidades" : "draco"
    }
    ```

### getByID

- Path: /monstruos/{id}
- Descripción: Devuelve los datos de un mosuntro según su id
- Método HTTP: GET
- Formato de solicitud: /monstruos/1
  - UriParam: id
  - Body: vacio
- Formato de respuesta:
  - Tipo: JSON
  - Ejemplo:

    ```json
    {
        "id" : 1,
        "nombre" : "tigrex",
        "especie" : "wyvern volador",
        "habitat" : "desierto",
        "debilidades" : "trueno"
    }
    ```

### Create

- Path: /monstruos
- Descripción: Crea un monstruo en nuestra base de datos
- Método HTTP: POST
- Formato de solicitud: /monstruos
  - UriParam: vacio
  - Body:

    ```json
    {
        "nombre" : "tigrex",
        "especie" : "wyvern volador",
        "habitat" : "desierto",
        "debilidades" : "trueno"
    }
    ```

- Formato de respuesta:
  - Tipo: JSON
  - Ejemplo:

    ```string
    El monstruos fue insertado correctamente
    ```

### Update

- Path: /monstruos/{id}
- Descripción: Actualiza un mounstro de la base de datos según su id
- Método HTTP: PUT
- Formato de solicitud: /monstruos/1
  - UriParam: id
  - Body:

    ```json
    {
        "nombre" : "rathalos",
        "especie" : "wyvern volador",
        "habitat" : "meseta",
        "debilidades" : "trueno"
    }
    ```

- Formato de respuesta:
  - Tipo: JSON
  - Ejemplo:

    ```string
    El monstruos fue actualizado correctamente
    ```

### Delete

- Path: /monstruos
- Descripción: Elimina un mounstro de la base de datos según su id
- Método HTTP: DELETE
- Formato de solicitud: /monstruos/1
  - UriParam: id
  - Body: vacio
- Formato de respuesta:
  - Tipo: JSON
  - Ejemplo:

    ```string
    El monstruos fue eliminado con exito
    ```
