import {useState} from "react";


function ExperiencesComponent() {

    const [experiences, setExperiences] = useState([
        {title: '', company: '', startDate: '', endDate: ''},
    ]);

    const handleInputChange = (index, field, value) => {
        const newExperiences = [...experiences];
        newExperiences[index][field] = value;
        setExperiences(newExperiences);
    }

    const handleAddExperience = () => {
        setExperiences([...experiences,
            {title: '', company: '', startDate: '', endDate: ''}]);
    }

    const handleRemoveExperience = (index) => {
        const newExperiences = [...experiences];
        newExperiences.splice(index, 1);
        setExperiences(newExperiences);
    }

    return (
        <div>
            {experiences.map((experience, index) => (
                <div key={index}>

                    <label>Title:</label>
                    <input
                    type="text"
                    value={experience.title}
                    onChange={(e) => handleInputChange(index, 'title', e.target.value)}
                    />

                    <label>Company:</label>
                    <input
                        type="text"
                        value={experience.company}
                        onChange={(e) => handleInputChange(index, 'company', e.target.value)}
                    />

                    <label>StartDate:</label>
                    <input
                        type="text"
                        value={experience.startDate}
                        onChange={(e) => handleInputChange(index, 'startDate', e.target.value)}
                    />

                    <label>EndDate:</label>
                    <input
                        type="text"
                        value={experience.endDate}
                        onChange={(e) => handleInputChange(index, 'endDate', e.target.value)}
                    />

                    <button onClick={() => handleRemoveExperience(index)}>Remove Experience</button>
                </div>
            ))}

            <button onClick={handleAddExperience}>Add Experience</button>
        </div>
    );
}

export default ExperiencesComponent;