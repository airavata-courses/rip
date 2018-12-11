<template>
  <canvas id="plan-chart">{{planetChartData}}</canvas>

<!--<h1>{{planetChartData}}</h1>-->
</template>

<script>
  import planetChartData from './chem-chart.js';
  // import Chart from 'chart.js';
    export default {
        extends:Line,
        name: "generate_graphs",

        data(){
        return {
          planetChartData: planetChartData,
  }
    }

    methods: {


      createChart(chartId,chartData) {
       console.log("create Chart");
       console.log(chartId);
       var ctx = document.getElementById("plan-chart");
       var chartData = planetChartData;
     const myChart = new Chart(ctx, {
      type: chartData.type,
      data: chartData.data,
      options: chartData.options,
    });

  },


    }
    console.log("Graphs will be entered here!")





</script>

<style scoped>

</style>
