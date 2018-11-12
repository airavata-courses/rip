
<!--&lt;!&ndash;<template>&ndash;&gt;-->
  <!--&lt;!&ndash;<div id="app1">&ndash;&gt;-->
    <!--&lt;!&ndash;<canvas id="chemistry-chart"></canvas>&ndash;&gt;-->
  <!--&lt;!&ndash;</div>&ndash;&gt;-->

  <!--&lt;!&ndash;<div class="columns medium-3" v-for="result in results">&ndash;&gt;-->
  <!--&lt;!&ndash;<div class="card">&ndash;&gt;-->
    <!--&lt;!&ndash;<div class="card-divider">&ndash;&gt;-->
      <!--&lt;!&ndash;{{ results }}&ndash;&gt;-->
    <!--&lt;!&ndash;</div>&ndash;&gt;-->
    <!--&lt;!&ndash;<div class="card-section">&ndash;&gt;-->
      <!--&lt;!&ndash;<p>{{ results }}.</p>&ndash;&gt;-->
    <!--&lt;!&ndash;</div>&ndash;&gt;-->
  <!--&lt;!&ndash;</div>&ndash;&gt;-->
<!--&lt;!&ndash;</div>&ndash;&gt;-->
  <!--&lt;!&ndash;<script src="https://unpkg.com/axios/dist/axios.min.js"></script>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;&lt;!&ndash; ./index.html &ndash;&gt;&ndash;&gt;-->


<!--&lt;!&ndash;<script>&ndash;&gt;-->
    <!--&lt;!&ndash;import Chart from 'chart.js';&ndash;&gt;-->
    <!--&lt;!&ndash;export default {&ndash;&gt;-->
      <!--&lt;!&ndash;name: "App1",&ndash;&gt;-->
  <!--&lt;!&ndash;data: {&ndash;&gt;-->
    <!--&lt;!&ndash;results: []&ndash;&gt;-->
  <!--&lt;!&ndash;},&ndash;&gt;-->
  <!--&lt;!&ndash;mounted() {&ndash;&gt;-->
    <!--&lt;!&ndash;axios.get("https://api.nytimes.com/svc/topstories/v2/home.json?api-key=your_api_key")&ndash;&gt;-->
    <!--&lt;!&ndash;.then(response => {this.results = response.data.results})&ndash;&gt;-->
  <!--&lt;!&ndash;}&ndash;&gt;-->
  <!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;//     methods: {&ndash;&gt;-->
<!--&lt;!&ndash;//   createChart(chartId, chartData) {&ndash;&gt;-->
<!--&lt;!&ndash;//     const ctx = document.getElementById(chartId);&ndash;&gt;-->
<!--&lt;!&ndash;//     const myChart = new Chart(ctx, {&ndash;&gt;-->
<!--&lt;!&ndash;//       type: chartData.type,&ndash;&gt;-->
<!--&lt;!&ndash;//       data: chartData.data,&ndash;&gt;-->
<!--&lt;!&ndash;//       options: chartData.options,&ndash;&gt;-->
<!--&lt;!&ndash;//     });&ndash;&gt;-->
<!--&lt;!&ndash;//   }&ndash;&gt;-->
<!--&lt;!&ndash;// }&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->

<!--&lt;!&ndash;</style>&ndash;&gt;-->


<!--<template>-->
  <!--<div id="app1">-->
    <!--&lt;!&ndash;<canvas id="chemistry-chart"></canvas>&ndash;&gt;-->


  <!--<div class="columns medium-3">-->
  <!--<div class="card">-->
    <!--<div class="card-divider">-->
      <!--<ul>-->
      <!--<li  v-for="result in results">-->
      <!--{{ result }}-->
      <!--</li>-->
        <!--</ul>-->
    <!--</div>-->
    <!--<div class="card-section">-->
      <!--<p>{{ result }}.</p>-->
    <!--</div>-->
  <!--</div>-->
<!--</div>-->
  <!--</div>-->
<!--</template>-->

<!--&lt;!&ndash; ./index.html &ndash;&gt;-->




<!--<script>-->
    <!--import axios from '../node_modules/axios'-->
    <!--import Chart from 'chart.js';-->

    <!--export default {-->
      <!--name: "app",-->
  <!--data: {-->
    <!--results: []-->
  <!--},-->
  <!--mounted() {-->
    <!--axios.get("149.165.156.103:8888/getjsonfile")-->
    <!--.then(response => {this.results = response.data.results})-->
  <!--}-->
  <!--}-->

<!--//     methods: {-->
<!--//   createChart(chartId, chartData) {-->
<!--//     const ctx = document.getElementById(chartId);-->
<!--//     const myChart = new Chart(ctx, {-->
<!--//       type: chartData.type,-->
<!--//       data: chartData.data,-->
<!--//       options: chartData.options,-->
<!--//     });-->
<!--//   }-->
<!--// }-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->
