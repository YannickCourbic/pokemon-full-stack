
interface statType {
    title:string,
    stat:number,
    maxStat:number,
    color:string,
    height:string
}
function Stat({title , stat, maxStat, color , height} : statType) {
    return (
        <div className={"container"}>
            <span style={{fontWeight: 700 , fontSize: "10px" ,textAlign:"left" , marginLeft:"15px"}}>{title}</span>
            <div className={"d-flex flex-row container justify-content-center align-items-center"}>
                    <div className={`bg-${color}`} style={{height: height+"px" , width: `${(stat/maxStat) * 100}%`, borderTopLeftRadius: "15px" , borderBottomLeftRadius: "15px"}}></div>
                    <div style={{height:height+"px", width: `${100 - ((stat/maxStat) * 100)}%`, background: "#5553" , borderTopRightRadius: "15px" , borderBottomRightRadius: "15px"}}></div>
            </div>
        </div>

    );
}

export default Stat;