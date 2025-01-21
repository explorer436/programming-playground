import React from "react";
import ReactDOM from "react-dom/client";

import "./index.css";

// Using a simple list for props

// Fix the key prop warning by adding random "id"s.
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
  return (
    <section className="booklist">
      {books.map((book) => {
        console.log(book);
        const { img, title, author, id } = book;
        // the id has to be on the object we are returning.
        return <Book key={id} img={img} title={title} author={author} />;
      })}
    </section>
  );
}

/* 
// Technically, we can get away with using the indexes of the array as "id"s instead of explictly defining and using "id"s.
// But this is not advisable.
// This will only work with lists that will never change.
// If there is some way to remove some of the items from the list, this will not work.
// Effectively, there is a high chance that you will get a bug down the road.
function BookList() {
  return (
    <section className="booklist">
      {books.map((book, index) => {
        console.log(book);
        const { img, title, author } = book;
        // the id has to be on the object we are returning.
        return <Book key={index} img={img} title={title} author={author} />;
      })}
    </section>
  );
} 
*/

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
