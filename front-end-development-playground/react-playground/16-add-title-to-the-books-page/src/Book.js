import React from "react";

export const Book = (props) => {
  const { img, title, author, number } = props;

  return (
    <article className="book">
      <img src={img} alt={title} />
      <h2>{title}</h2>
      <h4>{author} </h4>
      {/* <span className="number">{number + 1}</span> */}
      {/* Using template literals to include hashtag in the display */}
      <span className="number">{`# ${number + 1}`}</span>

      {/* Notice the "relative" span in the css file for "book" */}
    </article>
  );
};
