import { useState } from 'react';

const CodeExample = () => {
    const [value, setValue] = useState(0);

    const sayHello = () => {
        console.log('hello there');
        // be careful, we may have infinite loop if we update state value inside the function.
        // setValue(value + 1);
        // Changing value here using setValue triggers re-render.
    };

    // Question: How many times is this function going to render?
    // 1. At initial render
    // 2. Every time at re-render
    sayHello();

    return (
        <div>
            <h1>value : {value}</h1>
            <button className='btn' onClick={() => setValue(value + 1)}>
                click me
            </button>
        </div>
    );
};

export default CodeExample;