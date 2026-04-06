
import { ToastContainer } from "react-toastify";
import RoutesIndex from "./routes/RoutesIndex";

function App() {
  return (
    <>
      <RoutesIndex/>
            <ToastContainer
              position="top-right"
              autoClose={3000}
              hideProgressBar={false}
              newestOnTop
              closeOnClick
              pauseOnHover
              theme="colored"
              limit={1}
            />
    </>
  );
}

export default App;
