import PokeBall from "../assets/Poké_Ball_icon.svg";
function Navbar() {
    return (
            <nav className="navbar navbar-dark navbar-expand-lg shadow-sm bg-dark fixed-top" >
                <div className="container-fluid" >
                    <a className="navbar-brand d-flex gap-1 align-items-center justify-content-center" href="#" >
                        <img src={PokeBall} alt="" width={"30px"}/>
                        API Pokémon
                    </a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                {/*<Link to={"/"} className={"nav-link active"} >Home</Link>*/}
                                <a className="nav-link active" aria-current="page" href="/test">Home</a>
                            </li>
                            {/*<li className="nav-item">*/}
                            {/*    <a className="nav-link" href="#">Link</a>*/}
                            {/*</li>*/}
                        </ul>
                    </div>

                </div>
            </nav>

    );
}

export default Navbar;