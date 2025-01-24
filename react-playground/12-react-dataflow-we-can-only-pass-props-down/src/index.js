import React from "react";
import ReactDOM from "react-dom/client";

import "./index.css";

const books = [
  {
    author: "Jordan Moore",
    title: "Interesting Facts For Curious Minds",
    img: "./images/91ulu+khYLL._AC_UL600_SR600,400_.jpg",
    id: 1,
  },
  {
    author: "James Clear",
    title: "Atomic Habits",
    img: "https://images-na.ssl-images-amazon.com/images/I/81wgcld4wxL._AC_UL900_SR900,600_.jpg",
    id: 2,
  },
];

function BookList() {
  const someValue = "shakeAndBake";
  const displayValue = () => {
    console.log(someValue);
  };
  return (
    <section className="booklist">
      {books.map((book) => {
        return <Book {...book} key={book.id} displayValue={displayValue} />;
      })}
    </section>
  );
}

// To pass anything from BookList to Book component, we have to use props.
// There are alternatives to this: Context API, redux, other state libraries
// But, this is the native approach.
// If the data we are dealing with is large and complex, this will get very ugly and annoying very fast.
// Prop drilling:
The practice of 

const Book = (props) => {
  const { img, title, author, displayValue } = props;

  const displayTitle = () => {
    console.log(title);
  };

  return (
    <article className="book">
      <img src={img} alt={title} />
      <h2>{title}</h2>
      <button onClick={displayValue}>display value</button>
      <h4>{author} </h4>
    </article>
  );
};

/* In the UI, launch inspect element, open console, and click on "display title" for each of the books.
Depending on where we click, the "displayTitle" will log the title for that specific book.
This is automatically done in React - whereas in Vanilla JS, this is very difficult to do. */

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
