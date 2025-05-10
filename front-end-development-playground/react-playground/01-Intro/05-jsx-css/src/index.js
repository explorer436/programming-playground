import React from "react";
import ReactDOM from "react-dom/client";

import "./index.css";

function BookList() {
  return (
    <section className="booklist">
      <Book />
      <Book />
      <Book />
      <Book />
    </section>
  );
}

const Book = () => {
  return (
    <article className="book">
      <Image />
      <Title />
      <Author />
    </article>
  );
};

// right click on the image in the website and select "copy image address"
const Image = () => <img src="./images/91ulu+khYLL._AC_UL600_SR600,400_.jpg" />;
const Title = () => <h2>The Frozen River: A GMA Book Club Pick: A Novel</h2>;

/* const Author = () => {
  return (
    <h4 style={{ color: "#617d98", fontSize: "0.75rem", marginTop: "0.5rem" }}>
      Ariel Lawhon
    </h4>
  );
}; */

const Author = () => {
  const inlineHeadingStyles = {
    color: "#617d98",
    fontSize: "0.75rem",
    marginTop: "0.5rem",
  };
  return <h4 style={inlineHeadingStyles}>Ariel Lawhon </h4>;
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
