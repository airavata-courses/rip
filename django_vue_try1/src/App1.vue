<style></style>

<template>
      <div id ='getfiles-app'>
            <div class="row">
                <div class="col-md-8">
                  <p>
                    <button v-on:click="getFiles()">Load the List</button>
                  </p>
                   <!--<a href="javascript:void(0)" id="downloadfiles" @click="getFiles()">List </a>-->
                    <h2>List</h2>
                    <ul class="list-group">
                            <li v-for="(file, index) in files" :key="index" class="list-group-item">
                                <input type="checkbox" v-bind:id="file" v-bind:value="file" v-model="checkedFiles">
                                <label v-bind:for="file">{{ index }}: {{ file }}</label>
                            </li>
                    </ul>
                </div>
                <br>
                <h1><span>Checked files: {{ checkedFiles }}</span></h1>
                <button v-on:click="getCoordinates">Generate Graph</button>-->
                <router-link to="/gen_graph">Gen_graph</router-link>
                <router-view>Click me!</router-view>
                <router-link to="/jsonViewer">View JSON Files</router-link>
                <router-view>Click me!</router-view>

            </div>
      </div>
</template>

<script>
  import './generate_graphs';
  export default {
    name: 'getfiles-app',

    data() {
      return {
      files: [],
      list: 'empty',
      checkedFiles: []
    }
    },
    computed: {
      users() {
        return this.$store.state.jsonFiles;
      }
    },

    methods: {
        async getFiles()
        {
            let content = await fetch('http://127.0.0.1:3001/get_all_files');
            let text = await content.text();
            let parsedText = JSON.parse(text);
            let CompleteList = []
          for(var i =0;i<parsedText.length;i++)
          {
            CompleteList.push(parsedText[i].substring(1,parsedText[i].length-1))
          }
          this.files = CompleteList;
        },

        async getCoordinates()
        {
            let toSend = ""
            for(var i = 0; i<this.checkedFiles.length;i++)
            {
                toSend+=this.checkedFiles[i]+"--";
            }
            let content = await fetch("http://127.0.0.1:3001/get_selected_files?files="+toSend);
            let text = await content.text();
            this.$store.state.jsonFiles = text;





            // let content = await fetch('http://127.0.0.1:3001/get_selected_files',{
            //     method: "POST",
            //     headers: {
            //         'Accept': 'application/json',
            //         'Content-Type': 'application/json',
            //         'Access-Control-Allow-Origin':'*',
            //
            //           },
            //     body: JSON.stringify(arr),
            //     // mode: 'cors',
            //
            // });
            // let text = await content.text();





            // let content = await fetch('https://localhost:44321/api/values',{
            //     method: "POST",
            //     headers: new Headers({'content-type': 'application/json'}),
            //     body: JSON.stringify(toSend),
            //     mode: 'cors'
            // });
            // let text = await content.text();
            // console.log("List of files are",text);
        }
    }
  }

</script>
