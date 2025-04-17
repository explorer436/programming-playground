export default function App() {

    const bullets = ['Item 1', 'Item 2', 'Item 3', 'Item 4'];

    const handleMouseEvent = (e) => {
        e.persist();
        e.target.style.backgroundColor = "orange";
        setTimeout(() => {
                e.target.style.backgroundColor = "";
            }, 1000
        );
    };

    return (
        <div className="App">
            <h3>onMouseOut Event:</h3>
            <ul className="menu" onMouseOut={handleMouseEvent}>
                {bullets.map((item) => (
                    <li className="menu-item">{item}</li>
                ))}
            </ul>

            <h3>onMouseLeave Event:</h3>
            <ul className="menu" onMouseLeave={handleMouseEvent}>
                {bullets.map((item) => (
                    <li className="menu-item">{item}</li>
                ))}
            </ul>
        </div>
    );
}
