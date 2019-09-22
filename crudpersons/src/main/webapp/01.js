const app = new Vue({
  el: '#body1',
  data: {
    tituloTexto: 'Listado de Personas',
    persons: [],
    valFind: '',
    selected: 'nombre'
  },
  methods: {
    nuevo () {

    },
    eliminar () {

    },
    editar () {

    },
    buscar () {
      auxList = [];

      axios.get('http://localhost:8080/crudpersons/webapi/persons/findName?perNombre='+ this.valFind +'&filter='+ this.selected, {
        responseType: 'application/json'
      })
        .then(function(res) {
          if(res.status == 200) {
            for (var i = 0; i < res.data.length; i++) {
              auxList.push(res.data[i]);
            }
          }
        })
        .catch(function(err) {
          //console.log(err);
          // Not yet
        })
        this.persons = auxList;
    }
  },
  mounted() {
    this.buscar();
  }
})
