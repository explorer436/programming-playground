import { useEffect, useState } from 'react';

const CleanupFunction = () => {

    const [toggle, setToggle] = useState(false);

    return (
        <div>
            <button className='btn' onClick={() => setToggle(!toggle)}>
                toggle component
            </button>
            {toggle && <RandomComponent />}
        </div>
    );
};

const RandomComponent = () => {

    // The initial render for this Component happens every time it is rendered.
    // With every toggle in CleanupFunction, RandomComponent mounts or un-mounts.
    // With every mount, this useEffect runs and the code inside it runs.

    useEffect(() => {
        // console.log('hmm, this is interesting');
        const intID = setInterval(() => {
            console.log('hello from interval');
        }, 1000);
        // 1 second.
        // does not stop, keeps going - it keeps printing the log statement
        // every time we render component new interval gets created

        // This is the clean-up function.
        // It does the opposite of whatever the problematic code does.
        // The purpose is to stop useEffect from running in the background.
        // When this Component is toggled off, the "setInverval" will stop running.
        // We run it when the Component unmounts.
        return () => {
            clearInterval(intID);
            console.log('clearInterval');
        };
    }, []);

    return <h1>hello there</h1>;
};

export default CleanupFunction;