import { createContext, useContext, useState } from 'react';

const GlobalContext = createContext();

export const useGlobalContext = () => useContext(GlobalContext);

// const AppContext = ({ children }) => {
// props from App - since App is wrapped inside AppContext in main.jsx
const AppContext = (props) => {

    const [name, setName] = useState('peter');

    return (
        <GlobalContext.Provider value={{ name, setName }}>
            {/*{children}*/}
            {props.children}
        </GlobalContext.Provider>
    );
};

export default AppContext;