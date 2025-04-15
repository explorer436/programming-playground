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
  return (
    <section className="booklist">
      <EventExamples />
      {books.map((book) => {
        // The spread operator deconstructs the object, making each property available as an individual prop.
        return <Book key={book.id} {...book} />;
      })}
    </section>
  );
}

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

const handleFormChange = () => {
  console.log("handle form change");
};
const handleButtonClick = () => {
  alert("handle button click");
};

const EventExamples = () => {
  return (
    <section>
      <form>
        <h2>Typical form</h2>
        <input
          type="text"
          name="example"
          onChange={handleFormChange}
          style={{ margin: "1rem 0" }}
        />
      </form>
      <button onClick={handleButtonClick}>click me</button>
    </section>
  );
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
