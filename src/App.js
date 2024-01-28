import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./page/Navbar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./page/Home";
import Adduser from "./component/Adduser";
import Edituser from "./component/Edituser";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/add-user" element={<Adduser />} />
          <Route exact path="/edit-user/:id" element={<Edituser />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
