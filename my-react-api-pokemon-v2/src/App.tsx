
import './App.css'
import Navbar from "./component/Navbar.tsx";
import Home from "./component/Home.tsx";
import {BrowserRouter , Routes , Route} from "react-router-dom";
import ShowPokemon from "./component/ShowPokemon.tsx";
import PageNotFound from "./component/PageNotFound.tsx";
// import Test from "./component/Test.tsx";

function App() {
  return (
    <>
        <Navbar/>
        <BrowserRouter>
            <Routes>
                <Route path="/" element = {<Home/>}/>
                <Route path={"/home"} element={<Home/>}/>
                <Route path={"/pokemon/:id"} element={<ShowPokemon/>}/>
                <Route path={"/*"} element={<PageNotFound/>}/>
            </Routes>
        </BrowserRouter>
    </>
  )
}

export default App
