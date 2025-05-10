import React from "react";
import ReactDOM from "react-dom/client";

import "./index.css";
import { books } from "./books";
import { Book } from "./Book";

function BookList() {
  return (
    <>
      <h1>best sellers book list</h1>
      <section className="booklist">
        {books.map((book, index) => {
          return <Book {...book} key={book.id} number={index} />;
        })}
      </section>
    </>
  );
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
