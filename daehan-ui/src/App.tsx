import { useEffect, useState } from "react";
import "./App.css";
import axios from "axios";
import { Button } from "./components/ui/button";

// function App() {
//   const [count, setCount] = useState(0);
//   // const [hello, setHello] = useState('');
//   //
//   //   useEffect(() => {
//   //       axios.get('/api/test')
//   //           .then((res) => {
//   //               setHello(res.data);
//   //           })
//   //   }, []);
//   return (
//     <>
//       <div>
//         <a href="https://vitejs.dev" target="_blank">
//           <img src={viteLogo} className="logo" alt="Vite logo" />
//         </a>
//         <a href="https://react.dev" target="_blank">
//           <img src={reactLogo} className="logo react" alt="React logo" />
//         </a>
//       </div>
//       <h1>Vite + React</h1>
//       <div className="card">
//         <button onClick={() => setCount((count) => count + 1)}>
//           count is {count}
//         </button>
//         <p>
//           Edit <code>src/App.tsx</code> and save to test HMR
//         </p>
//       </div>
//       <p className="read-the-docs">
//         Click on the Vite and React logos to learn more
//       </p>
//         {/*<div className="App">*/}
//         {/*    백엔드 데이터 : {hello}*/}
//         {/*</div>*/}
//     </>
//   )
// }

function App() {
  const [hello, setHello] = useState("");

  useEffect(() => {
    axios
      .get("/api/test")
      .then((response) => setHello(response.data))
      .catch((error) => console.log(error));
  }, []);

  return (
    <div>
      백엔드 데이터 =&gt; {hello}
      <div>
        <Button>Click me</Button>
      </div>
    </div>
  );
}

export default App;
