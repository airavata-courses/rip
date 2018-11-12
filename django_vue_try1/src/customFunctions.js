
function check(val)
{
  var wav = [];
  var y = [];
  var result=[];


  var i;
  for (i = 0; i < val.length; i++) {
      wav.push(val[i].WaveLength);
      y.push(val[i].Y);
  }
  result.push(wav);
  result.push(y);


  return result;
}

export { check }



