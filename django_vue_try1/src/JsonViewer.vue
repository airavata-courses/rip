<template>
  <div id='jsonviewer-app'>
  <h1>TESTING</h1>
    <button v-on:click="setJsonData">Get JSON</button>-->
  <hr />
<json-viewer
  :value="jsonData"
  expand-depth=2
  copyable
  boxed>

</json-viewer>
    </div>
</template>

<script>
import Vue from 'vue'
import JsonViewer from './lib'
Vue.use(JsonViewer)
  export default {
    name: 'jsonviewer-app',
    data()
    {
      return{
      jsonData: ''
      }
    },

    methods: {
      setJsonData(){
        this.jsonData = JSON.parse(this.$store.state.jsonFiles);
        console.log(this.jsonData);
      }
    }
  }


</script>
