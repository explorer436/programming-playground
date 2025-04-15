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