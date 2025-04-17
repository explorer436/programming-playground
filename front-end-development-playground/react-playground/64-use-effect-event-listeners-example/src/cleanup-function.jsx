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
    useEffect(() => {
        // console.log('hmm, this is interesting');
        const someFunc = () => {
            // some logic here
        };
        // In the browser, open inspector view.
        // Go to Elements -> Event Listeners
        // Under "scroll", we will see many events if we do not have the clean-up return statement below.
        window.addEventListener('scroll', someFunc);

        // If we don't have this return statement,
        return () => window.removeEventListener('scroll', someFunc);
    }, []);

    return <h1>hello there</h1>;
};

export default CleanupFunction;