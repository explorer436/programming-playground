import React, {useState} from 'react';

function DynamicForm({formData}) {

    const [formValues, setFormValues] = useState({});

    const handleChange = (event) => {
        const {name, value, type, checked} = event.target;
        setFormValues(prevValues => ({
            ...prevValues,
            [name]: type === 'checkbox' ? checked : type === 'radio' ? value : value,
        }));
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log("Form values:", formValues);
    }

    return (
        <form onSubmit={handleSubmit}>
            {formData.map((categoryData, index) => (
                <div key={index} style={{border: '1px solid #ccc', padding: '10px', marginBottom: '10px', justifyContent: 'space-between'}}>
                    <h2>{categoryData.category}</h2>
                    {categoryData.fields.map((field) => (
                        <div key={field.name} style={{display: 'flex', justifyContent: 'space-between', marginBottom: '5px'}}>
                            <label htmlFor={field.name}>{field.name}</label>
                            {
                                field.type === 'text' || field.type === 'email' ? (
                                    <input
                                        type={field.type}
                                        id={field.name}
                                        name={field.name}
                                        value={formValues[field.name] || ''}
                                        onChange={handleChange}
                                    />
                                ) : field.type === 'checkbox' ? (
                                    <input
                                        type={field.type}
                                        id={field.name}
                                        name={field.name}
                                        value={formValues[field.name] || false}
                                        onChange={handleChange}/>
                                ) : field.type === 'select' ? (
                                    <select
                                        id={field.name}
                                        name={field.name}
                                        value={formValues[field.name] || ''}
                                        onChange={handleChange}>
                                        <option value="">Select...</option>
                                        {field.options.map((option, index) => (
                                            <option key={option} value={option}>{option}</option>
                                        ))}
                                    </select>
                                ) : null
                            }
                        </div>
                    ))}
                </div>
            ))}
            <button type={"submit"}>Submit</button>
        </form>
    )
}


export default DynamicForm;