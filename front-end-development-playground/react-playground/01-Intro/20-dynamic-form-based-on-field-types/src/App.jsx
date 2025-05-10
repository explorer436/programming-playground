import './App.css'

import DynamicForm from './dynamicForm';

const formData = [
    {
        category: "Personal Information",
        fields: [
            {name: "firstName", label: "First Name", type: "text"},
            {name: "lastName", label: "Last Name", type: "text"},
            {name: "email", label: "Email", type: "email"}
        ]
    },
    {
        category: "Address",
        fields: [
            {name: "street", label: "Street Address", type: "text"},
            {name: "city", label: "City", type: "text"},
            {name: "zipCode", label: "Zip Code", type: "text"},
        ]
    },
    {
        category: "Preferences",
        fields: [
            {name: "newsletter", label: "Subscribe to Newsletter", type: "checkbox"},
            {name: "theme", label: "Preferred Theme", type: "select", options: ["Light", "Dark"]}
        ]
    }
];

function App() {
    return (
        <div className="App">
            <h1>Dynamic Form</h1>
            <DynamicForm formData={formData}/>
        </div>

    )
}

export default App;