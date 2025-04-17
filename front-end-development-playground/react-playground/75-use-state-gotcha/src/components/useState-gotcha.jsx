import {useState} from "react";

const UseStateGotcha = () => {

    const [value, setValue] = useState(0);

    /*const handleClick = () => {
        setValue(value + 1);
        //  be careful it's the old value
        console.log(value);
        //  so if you have any functionality
        // that relies on the latest value
        // it will be wrong !!!
    };*/

    const handleClick = () => {

        // If we look at the console, we will notice that it is not updated in real time.
        // If we click the button 5 times in a single second, setValue uses the same value "0" for all those clicks.
        // Finally, the returned value will be "1" (0 + 1) instead of "5"
        /*setTimeout(() => {
            console.log('value before change: ', value);
          console.log('clicked the button');
          setValue(value + 1);
        }, 3000);*/

        // How do we fix it?

        // If we click the button 5 times in a single second, setValue uses the previous value for each of those clicks.
        setTimeout(() => {
            console.log('value before change: ', value);
            console.log('clicked the button');
            setValue((currentState) => {
                return currentState + 1;
            });
        }, 3000);
    };

    return (
        <div>
            <h1>{value}</h1>
            <button className="btn" onClick={handleClick}>
                increase
            </button>
        </div>
    );

};

export default UseStateGotcha;
