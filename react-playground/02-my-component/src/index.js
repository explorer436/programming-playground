import React from "react";
import ReactDOM from "react-dom/client";

/* const Greeting = () => {
  return <h2>My First Component</h2>;
}; */

/* const Greeting = () => {
  return React.createElement("h2", {}, "hello world");
}; */

/* const Greeting = () => {
  return React.createElement(
    "div",
    {},
    React.createElement("h2", {}, "hello world")
  );
}; */

function Greeting() {
  return (
    <>
      <div className="someValue">
        <h3>hello people</h3>
        <ul>
          <li>
            <a href="#">hello world</a>
          </li>
        </ul>
      </div>
      <h2>hello world</h2>
      <input type="text" name="" id="" />
    </>
  );
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<Greeting />);
