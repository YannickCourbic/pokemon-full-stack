import {useNavigate} from "react-router-dom";
function PageNotFound() {
    const history = useNavigate();

    return (
        <>
        <div className={"container-fluid error404"}
        >

        </div>
        <button
            style={{position:"absolute", top:"50%" , left:"50%"}}
            onClick={() => history("/home")}
            className={"btn btn-primary text-light buttonNotFound"}
        >Retour
        </button>
        </>
    );
}

export default PageNotFound;