import * as axios from 'axios';

const BASE_URL = 'http://127.0.0.1:3001';

function upload(formData) {
  const url = `${BASE_URL}/upload/`;//upload,getfiles

  //***************** use this for uploading **************
  //console.dir(formData);
  return axios.post(url, formData)
      // get data
      .then(x => x.data)
      // add url field
      .then(x => x.map(img => Object.assign({},
          img, { url: `${BASE_URL}/images/${img.url}` })));

  //************* use this for getting wavelength ***********
  // console.dir(formData);
  // let a =  axios.post(url, formData)
  //
  // console.dir(a);

  //return a
  //return "Success"
}
export { upload }




function download(formData) {
  const url = `${BASE_URL}/getfiles/`;//upload,getfiles
  // this.st = st;

  //***************** use this for uploading **************
  // console.dir(formData);
  // return axios.post(url, formData)
  //     // get data
  //     .then(x => x.data)
  //     // add url field
  //     .then(x => x.map(img => Object.assign({},
  //         img, { url: `${BASE_URL}/images/${img.url}` })));

  //************* use this for getting wavelength ***********
  //console.dir(formData);
  let a=  axios.post(url,formData);
  //  .then(x => x.data)
  // console.log("bla ble blu");
  // console.log(a);
  console.dir(a);
  return a;
  //return "Fetched"
}
export { download }
