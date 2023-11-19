interface paginationType {
    handleClickNext():void,
    handleClickPre ():void,
    page:number
}
function Pagination({handleClickNext , handleClickPre , page}:paginationType) {
    return (
        <nav aria-label="..." className={"d-flex justify-content-center"}>
            <ul className="pagination">
                <li className={!(page <= 1 )? "page-item" : "page-item disabled"}>
                    <a className="page-link" onClick={() => handleClickPre()}>Previous</a>
                </li>
                <li className="page-item"><a className="page-link" href="#">{page-1}</a></li>
                <li className="page-item active" aria-current="page">
                    <a className="page-link" >{page}</a>
                </li>
                <li className="page-item"><a className="page-link" href="#">{page+1}</a></li>
                <li className="page-item">
                    <a className="page-link" onClick={() => handleClickNext()}>Next</a>
                </li>
            </ul>
        </nav>
    );
}

export default Pagination;