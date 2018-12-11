<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
   -webkit-font-smoothing: antialiased;
   -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>

<template>
  <div id="app">
    <div class="container">
      <!--UPLOAD-->
      <form enctype="multipart/form-data" novalidate v-if="isInitial || isSaving">
        <h1>Upload Files</h1>
        <div class="dropbox">
          <input type="file" multiple :name="uploadFieldName" :disabled="isSaving" @change="filesChange($event.target.name, $event.target.files);filex=$event.target.path,fileCount = $event.target.files.length"
            accept="image/*" class="input-file">
            <p v-if="isInitial">
              Drag your file(s) here to begin<br> or click to browse
            </p>
            <p v-if="isSaving">
              Uploading {{ fileCount }} files...
            </p>
        </div>
      </form>

      <!--&lt;!&ndash;SUCCESS&ndash;&gt;-->
      <!--<div v-if="isSuccess">-->
        <!--<h2>Uploaded {{ uploadedFiles.length }} file(s) successfully.</h2>-->
        <!--<p>-->
          <!--<a href="javascript:void(0)" @click="reset()">Upload again</a>-->
        <!--</p>-->
        <!--<ul class="list-unstyled">-->
          <!--<li v-for="item in uploadedFiles">-->
            <!--<img :src="item.url" class="img-responsive img-thumbnail" :alt="item.originalName">-->
            <!--<a href="javascript:void(0)" id="downloadfiles" @click="printname(item.url)" download>test here </a>-->
          <!--</li>-->
        <!--</ul>-->
      <!--</div>-->

        <!--<canvas id="plan-chart"></canvas>-->
        <div v-if="isFailed">
          <h2>Metadata Upload Successful! </h2>
         <p>
          <a href="javascript:void(0)" @click="reset()">Try again</a>
          </p>
          <!--<a href="javascript:void(0)" @click="createChart()">Generate Graph</a>-->
        <br>
           <!--<a href="App1.vue" onclick="window.open('file:///D:/Science_Gateway/VueJs-django-CSVUploads/django_vue_try1/src/file_selector/index.html'); return fals e">CLICK ME</a>-->
           <!--<a href="App1.vue">CLICK ME</a>-->
          <p>
           <router-link to="/selectfiles">Get the entire FileList!</router-link>
           <router-view>Click me!</router-view>
          </p>
        </div>

    </div>
  </div>
</template>


<script>
  // swap as you need
  //import { upload } from './file-upload.fake.service'; // fake service
  import { upload } from './file-upload.service';   // real service
  import { download } from './file-upload.service';
  import { wait } from './utils';
  import './App1';
  import { Bar, Line } from '../node_modules/vue-chartjs';
  // import planetChartData from './chem-chart.js';
  import Chart from 'chart.js';

  const STATUS_INITIAL = 0, STATUS_SAVING = 1, STATUS_SUCCESS = 2, STATUS_FAILED = 3;
  // var template = require('./file_selector/index.html')
  export default {

    extends:Line,
    name: 'app',

    data() {
      return {
        planetChartData: '',
        uploadedFiles: [],
        uploadError: null,
        currentStatus: null,
        uploadFieldName: 'photos',
        url: 'www.google.com'

      }
    },

    computed: {
      isInitial() {
        return this.currentStatus === STATUS_INITIAL;
      },
      isSaving() {
        return this.currentStatus === STATUS_SAVING;
      },
      isSuccess() {
        return this.currentStatus === STATUS_SUCCESS;
      },
      isFailed() {
        return this.currentStatus === STATUS_FAILED;
      }
    },

    methods: {
       generateManyGraphs()
       {
        console.log("test");
        window.open('file:///D:/Science_Gateway/VueJs-django-CSVUploads/django_vue_try1/src/file_selector/index.html');
       },
      createChart(chartId,chartData) {
       console.log("create Chart");
       console.log(chartId);
       var ctx = document.getElementById("plan-chart");
       // var chartData = planetChartData;
     const myChart = new Chart(ctx, {
      type: chartData.type,
      data: chartData.data,
      options: chartData.options,
    });
  },

    //   generate_graphs(formData) {
    //     // this.formData = formData;
    //     console.log("bla bla bla");
    //
    //     let a = (download(formData)
    //       .then(wait(1500))
    //                 .then(x => x.data
    //                 ));
    //        console.log("printing x");
    //       console.log(this.x);
    //     let res = null;
    //     a.then(function (val) {
    //     console.log("inside promise"+ val);
    //     let result=check(val);
    //     console.dir(result);
    //     var ctx = document.getElementById("plan-chart");
    //    var chartData = check;
    //    console.log(chartData.data.datasets[0].data);
    //    chartData.data.datasets[0].data = result[1];
    //    chartData.data.labels = result[0];
    //
    //  const myChart = new Chart(ctx, {
    //   type: chartData.type,
    //   data: chartData.data,
    //   options: chartData.options,
    // });
    //
    //   });
    //
    //   },
      reset() {
        // reset form to initial state
        this.currentStatus = STATUS_INITIAL;
        this.uploadedFiles = [];
        this.uploadError = null;
      },

      save(formData) {
        // upload data to the server
        this.currentStatus = STATUS_SAVING;

        // generate_graphs();

        let a = (upload(formData)

          .then(wait(1500)) // .then(x => x.data)); //use this for getting wavelength

        //************use these for uploading***************
          .then(x => {
           this.uploadedFiles = [].concat(x);
           this.currentStatus = STATUS_SUCCESS;
          })
          .catch(err => {
           this.uploadError = err.response;
            this.currentStatus = STATUS_FAILED;
          }));
      },
      printname(name)
    {

    console.log("inside printname" + name);
    },
      filesChange(fieldName, fileList) {
        // handle file changes
        const formData = new FormData();

        if (!fileList.length) return;
        console.log(fileList);

        for(var i = 0; i < fileList.length ; i ++){
          console.log(fileList[i].name);
        }


        // append the files to FormData
        Array
          .from(Array(fileList.length).keys())
          .map(x => {
            formData.append(fieldName, fileList[x], fileList[x].name);

          });

        // save it

        this.save(formData);
        // this.generate_graphs(formData);

      }
    },
    mounted() {
      this.reset();
      // console.log(this.planetChartData);
      console.log("mounted");

      // this.createChart('plan-chart',null);

  },
  }


</script>

<style lang="scss">
  .dropbox {
    outline: 2px dashed grey; /* the dash box */
    outline-offset: -10px;
    background: lightcyan;
    color: dimgray;
    padding: 10px 10px;
    min-height: 200px; /* minimum height */
    position: relative;
    cursor: pointer;
  }

  .input-file {
    opacity: 0; /* invisible but it's there! */
    width: 100%;
    height: 200px;
    position: absolute;
    cursor: pointer;
  }

  .dropbox:hover {
    background: lightblue; /* when mouse over to the drop zone, change color */
  }

  .dropbox p {
    font-size: 1.2em;
    text-align: center;
    padding: 50px 0;
  }

  #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #3c3e57;
  margin-top: 60px;
}
.container {
  max-width: 800px;
  margin:  0 auto;
}

</style>

