import { useState } from "react";

const UseStateBasics = () => {
  // console.log(useState());
  // console.log(useState('jo koy'));
  // const value = useState()[0];
  // const handler = useState()[1];
  // console.log(value, handler);

  // Pass in the default value
  // The default value can be an int, string, array, object, etc.
  // We are using array destructuring here from an array returned from useState
  const [count, setCount] = useState(0);

  const handleClick = () => {
    // console.log(count)
    setCount(count + 1);
    // be careful, we can set any value
    // setCount('pants');
  };

  return (
    <div>
      <h4>You clicked {count} times</h4>
      <button className="btn" onClick={handleClick}>
        Click me
      </button>
    </div>
  );
};

export default UseStateBasics;
