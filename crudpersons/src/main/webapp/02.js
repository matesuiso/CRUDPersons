const app = new Vue({
  el: '#body2',
  data: {
    perId: ''
  },
  methods: {
    beforeRouteEnter(to, from, next) {
      if (Object.keys(to.perId).length !== 0) {
        next(vm => {
          vm.perId = to.query.perId;
        })
      }
      next();
    }

  }
})
