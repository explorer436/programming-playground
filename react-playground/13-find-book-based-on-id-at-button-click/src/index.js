import React from "react";
import ReactDOM from "react-dom/client";

import "./index.css";

/*
Objective:
- create getBook function in booklist
- accepts id as an argument and finds the book
- pass the function down to Book Component and invoke on the button click
- in the Book Component destructure id and function
- invoke the function when user clicks the button, pass the id
- the goal : you should see the same book in the console
*/

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
  const getBook = (id) => {
    const book = books.find((book) => book.id === id);
    console.log(book);
  };

  return (
    <section className="booklist">
      {books.map((book) => {
        return <Book {...book} key={book.id} getBook={getBook} />;
      })}
    </section>
  );
}

/*
To pass anything from BookList to Book component, we have to use props.
There are alternatives to this: Context API, redux, other state libraries
But, this is the native approach.
If the data we are dealing with is large and complex, this will get very ugly and annoying very fast.

Prop drilling:
The practice of passing props down lots and lots of Components.  
*/

const Book = (props) => {
  const { img, title, author, getBook, id } = props;

  const displayTitle = () => {
    console.log(title);
  };

  /*
  This does't work.
  Notice that the getBook is executed on the initial page load itself - not when the button is clicked.
  The issue is, we are not invoking getBook at the button click. We are invoking it at page load.
  */
  /*return (
    <article className="book">
      <img src={img} alt={title} />
      <h2>{title}</h2>
      <button onClick={getBook(id)}>get book</button>
      <h4>{author} </h4>
    </article>
  );*/

  // Option 1 to fix the issue - Use a wrapper function
  /*const getSingleBook = () => {
    getBook(id);
  };
  return (
    <article className="book">
      <img src={img} alt={title} />
      <h2>{title}</h2>
      <button onClick={getSingleBook}>get book</button>
      <h4>{author} </h4>
    </article>
  );*/

  // Option 2 to fix the issue - Wrap in the anonymous arrow function
  return (
    <article className="book">
      <img src={img} alt={title} />
      <h2>{title}</h2>
      <button onClick={() => getBook(id)}>get book</button>
      <h4>{author} </h4>
    </article>
  );

  // The idea behind both of these fixes is,
  // we need to pass in a reference to the getBook function - to the button.
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
