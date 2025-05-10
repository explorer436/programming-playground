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
const Image = () => (
  <img src="https://images-na.ssl-images-amazon.com/images/I/91I1KDnK1kL._AC_UL600_SR600,400_.jpg" />
);
const Title = () => (
  <h2>
    The Let Them Theory: A Life-Changing Tool That Millions of People Can't Stop
    Talking About
  </h2>
);
const Author = () => {
  return <h4>Mel Robbins</h4>;
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
