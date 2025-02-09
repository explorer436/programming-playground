import { useState, useEffect } from 'react';

const UseEffectBasics = () => {
    const [value, setValue] = useState(0);

    const sayHello = () => {
        console.log('hello there');
    };

    sayHello();

    // useEffect(() => {
    //   console.log('hello from useEffect');
    // });

    /*
       useEffect is a hook in React that allows you to perform side effects in function components.
       There is no need for urban dictionary - basically any work outside of the component.
       Some examples of side effects are: subscriptions, fetching data, directly updating the DOM, event listeners, timers, etc.

       1. useEffect hook
       1. accepts two arguments (second optional)
       1. first argument - callback function
       1. second argument - dependency array
       1. by default, it runs on each render (initial and re-render)
       1. callback can't return promise (so can't make it async)
     */

    // Why are we passing the dependency array as the second argument?
    // If the dependency array is empty [], useEffect runs only on initial render.
    // If we remove the second argument, useEffect runs on re-renders too.
    useEffect(() => {
        console.log('hello from useEffect');
    }, []);

    return (
        <div>
            <h1>value : {value}</h1>
            <button className='btn' onClick={() => setValue(value + 1)}>
                click me
            </button>
        </div>
    );
};

export default UseEffectBasics;