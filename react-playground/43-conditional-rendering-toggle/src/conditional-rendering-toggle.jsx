import { useState } from 'react';

const ConditionalRenderingToggle = () => {

    const [showAlert, setShowAlert] = useState(false);

    return (
        <div>
            <button className='btn' onClick={() => setShowAlert(!showAlert)}>
                toggle alert
            </button>
            {showAlert && <Alert />}
        </div>
    );

};

const Alert = () => {
    return <div className='alert alert-danger'>hello world</div>;
};
export default ConditionalRenderingToggle;