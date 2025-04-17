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
  const title = "The Frozen River: A GMA Book Club Pick: A Novel";
  const author = "Ariel Lawhon";
  return (
    <article className="book">
      <img
        src="./images/91ulu+khYLL._AC_UL600_SR600,400_.jpg"
        alt="The Frozen River"
      />
      <h2>{title}</h2>
      <h4>{author.toUpperCase()} </h4>
    </article>
  );
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
