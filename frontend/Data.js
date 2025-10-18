async function getData() {
  try {
    let res = await axios.get("http://localhost:8081/");

    return res.data;
  } catch (error) {
    console.log(error);
    return "No response";
  }
}

let res = await getData();
let data = [];

if (res != "No response") {
  for (let obj of res) {
    data.push(obj);
  }
}

export { data };
