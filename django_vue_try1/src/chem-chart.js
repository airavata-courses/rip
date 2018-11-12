// import {Line} from 'vue-chartjs'
//
// export default {
//   extends: Line,
//   mounted () {
//     this.renderChart({
//       labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
//       datasets: [
//         {
//           label: 'Data One',
//           backgroundColor: '#FC2525',
//           data: [40, 39, 10, 40, 39, 80, 40]
//         },{
//           label: 'Data Two',
//           backgroundColor: '#05CBE1',
//           data: [60, 55, 32, 10, 2, 12, 53]
//         }
//       ]
//     }, {responsive: true, maintainAspectRatio: false})
//
//   }
// }
export const planetChartData = {
  type: 'line',
  data: {
    labels: ['Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune'],
    datasets: [
      { // one line graph
        label: 'Wavelength',
        data: [0, 0, 1, 2, 67, 62, 27, 14],
        backgroundColor: [
          'rgba(54,73,93,.5)', // Blue
          'rgba(54,73,93,.5)',
          'rgba(54,73,93,.5)',
          'rgba(54,73,93,.5)',
          'rgba(54,73,93,.5)',
          'rgba(54,73,93,.5)',
          'rgba(54,73,93,.5)',
          'rgba(54,73,93,.5)'
        ],
        borderColor: [
          '#36495d',
          '#36495d',
          '#36495d',
          '#36495d',
          '#36495d',
          '#36495d',
          '#36495d',
          '#36495d',
        ],
        borderWidth: 3
      }
    ]
  },
  options: {
    responsive: true,
    lineTension: 1,
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true,
          padding: 25,
        }
      }]
    }
  }
}

export default planetChartData;
