import React from "react";
import ReactDOM from "react-dom/client";

import "./index.css";

// Using a simple list for props

const books = [
  {
    author: "Jordan Moore",
    title: "Interesting Facts For Curious Minds",
    img: "./images/91ulu+khYLL._AC_UL600_SR600,400_.jpg",
  },
  {
    author: "James Clear",
    title: "Atomic Habits",
    img: "https://images-na.ssl-images-amazon.com/images/I/81wgcld4wxL._AC_UL900_SR900,600_.jpg",
  },
];

function BookList() {
  return (
    <section className="booklist">
      {books.map((book) => {
        console.log(book);
        const { img, title, author } = book;
        return <Book img={img} title={title} author={author} />;
      })}
    </section>
  );
}

/* Each child in a list should have a unique "key" prop.

Check the render method of `BookList`. See https://react.dev/link/warning-keys for more information. Component Stack: 
    BookList unknown:0
<anonymous code>:1:145535
    overrideMethod <anonymous code>:1
    React 4
    BookList index.js:22
    React 10
    performWorkUntilDeadline scheduler.development.js:44
    (Async: EventHandlerNonNull)
    js scheduler.development.js:219
    js scheduler.development.js:364
    factory react refresh:6
    Webpack 20 */

const Book = (props) => {
  const { img, title, author } = props;

  return (
    <article className="book">
      <img src={img} alt={title} />
      <h2>{title}</h2>
      <h4>{author} </h4>
    </article>
  );
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
