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

const handleFormInput = (e) => {
  console.log(e);
  // e.target - element
  console.log(`Input Name : ${e.target.name}`);
  console.log(`Input Value : ${e.target.value}`);
  console.log("handle form input");
};

const handleButtonClick = () => {
  alert("handle button click");
};

const handleFormSubmission = (e) => {
  e.preventDefault();
  console.log("form submitted");
};

/* const EventExamples = () => {
  return (
    <section>
      <form onSubmit={handleFormSubmission}>
        <h2>Typical form</h2>
        <input
          type="text"
          name="example"
          onChange={handleFormInput}
          style={{ margin: "1rem 0" }}
        />
        // This will submit the form.
        <button type="submit">submit</button>
        <div>
          // This will not submit the form.
          <button type="button" onClick={handleButtonClick}>
            click me
          </button>
        </div>
      </form>
    </section>
  );
}; */

// This is pretty much the same as above. The only difference is, we are using "onClick" on the submit button instead of using "onSubmit" on the form.

/* const EventExamples = () => {
  return (
    <section>
      <form>
        <h2>Typical form</h2>
        <input
          type="text"
          name="example"
          onChange={handleFormInput}
          style={{ margin: "1rem 0" }}
        />
        // This will submit the form.
        <button type="submit" onClick={handleFormSubmission}>
          submit
        </button>
        <div>
          // This will not submit the form.
          <button type="button" onClick={handleButtonClick}>
            click me
          </button>
        </div>
      </form>
    </section>
  );
}; */

// This is pretty much the same as above. The only difference is, we are using an "anonymous functions" in
// "onClick" on the "submit" button instead of using the function "handleFormSubmission" and
// "onClick" on the "click me" button instead of using the function "handleButtonClick"

const EventExamples = () => {
  return (
    <section>
      <form>
        <h2>Typical form</h2>
        <input
          type="text"
          name="example"
          onChange={handleFormInput}
          style={{ margin: "1rem 0" }}
        />
        {/* This will submit the form. */}
        <button
          type="submit"
          onClick={(e) => {
            e.preventDefault();
            console.log("form submitted");
          }}
        >
          submit
        </button>
        <div>
          {/* This will not submit the form. */}
          <button
            type="button"
            onClick={() => {
              alert("handle button click");
            }}
          >
            click me
          </button>
        </div>
      </form>
    </section>
  );
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<BookList />);
