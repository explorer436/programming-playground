import { useState } from 'react';

const CodeExample = () => {

    // With useState, everytime a value changes, the page is re-rendered.
    const [value, setValue] = useState(0);

    // This function runs both on initial render and re-renders.
    // If we change the "value" in this function, React tries to re-render and then the value has to be changed again... an infinite loop.
    const sayHello = () => {
        console.log('hello there');
        // be careful, we may have infinite loop if we update state value inside the function.
        // setValue(value + 1);
        // Changing value here using setValue triggers re-render.
    };

    /*
    react-dom_client.js?v=093dcca2:4364 Uncaught Error: Too many re-renders. React limits the number of renders to prevent an infinite loop.
    at renderWithHooksAgain (react-dom_client.js?v=093dcca2:4364:19)
    at renderWithHooks (react-dom_client.js?v=093dcca2:4306:67)
    at updateFunctionComponent (react-dom_client.js?v=093dcca2:5970:21)
    at beginWork (react-dom_client.js?v=093dcca2:7046:20)
    at runWithFiberInDEV (react-dom_client.js?v=093dcca2:724:18)
    at performUnitOfWork (react-dom_client.js?v=093dcca2:10829:98)
    at workLoopSync (react-dom_client.js?v=093dcca2:10690:43)
    at renderRootSync (react-dom_client.js?v=093dcca2:10673:13)
    at performWorkOnRoot (react-dom_client.js?v=093dcca2:10321:46)
    at performWorkOnRootViaSchedulerTask (react-dom_client.js?v=093dcca2:11434:9)
    */

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