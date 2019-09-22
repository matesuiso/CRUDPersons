<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>CRUD Persons</title>

    <style>
        table {
          font-family: arial, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }

        td, th {
          border: 1px solid #dddddd;
          text-align: left;
          padding: 8px;
        }

        tr:nth-child(even) {
          background-color: #dddddd;
        }
        div {
          padding-bottom: 30px;
        }
    </style>

  </head>
  <body>

    <div id="body1">
      <h1>{{tituloTexto}}</h1>

      <button type="button" @click="nuevo"></button>

      <div class="first">
        <input type="text" v-model="valFind" v-on:keyup.enter="buscar">

        <select name="Options" v-model="selected">
          <option value="nombre">Nombre</option>
          <option value="dni">DNI</option>
          <option value="pasaporte">PASAPORTE</option>
          <option value="cedula">CEDULA</option>
        </select>
        <button type="button" @click="buscar">Buscar</button>
      </div>

      <table>
          <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Numero Identificacion</th>
            <th>Tipo Identificacion</th>
            <th>Fecha de Nacimiento</th>
            <th>Acciones</th>
          </tr>
          <tr v-for="person of persons">
            <td>{{person.perId}}</td>
            <td>{{person.perNombre}}</td>
            <td>{{person.perApellido}}</td>
            <td>{{person.perNumeroDocumento}}</td>
            <td>{{person.perTipoDocumento}}</td>
            <td>{{person.perFechaNacimiento}}</td>
            <td> <button @click="editar">Editar</button> <button @click="eliminar(person.perId)">Eliminar</button> </td>
          </tr>
        </table>

    </div>

  </body>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <script src="01.js"></script>
</html>
